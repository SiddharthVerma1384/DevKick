#include <iostream>
#include <cmath>
#include <unordered_map>
#include <vector>
#include <queue>
#include <limits>
#include <string>
#include <algorithm>
#include <cstdlib>
#include <ctime>
#include <thread>
#include <chrono>
using namespace std;

/* ------------------- Basic Driver Definition ------------------- */
struct Driver {
    string name;
    string category; // Standard, Premium, Pool
    double x, y;     // current location
    double rating;
};

/* ------------------- K-D Tree for nearest driver ------------------- */
struct KDNode {
    Driver driver;
    KDNode *left, *right;
    KDNode(Driver d) : driver(d), left(nullptr), right(nullptr) {}
};

double dist(double x1, double y1, double x2, double y2) {
    return sqrt(pow(x1 - x2, 2) + pow(y1 - y2, 2));
}

KDNode* insertKD(KDNode* root, Driver d, unsigned depth = 0) {
    if (root == nullptr) return new KDNode(d);
    unsigned cd = depth % 2;
    if ((cd == 0 && d.x < root->driver.x) || (cd == 1 && d.y < root->driver.y))
        root->left = insertKD(root->left, d, depth + 1);
    else
        root->right = insertKD(root->right, d, depth + 1);
    return root;
}

void nearestNeighbor(KDNode* root, double px, double py, Driver &best, double &bestDist,
                     unsigned depth = 0) {
    if (!root) return;
    double d = dist(px, py, root->driver.x, root->driver.y);
    if (d < bestDist) {
        bestDist = d;
        best = root->driver;
    }
    unsigned cd = depth % 2;
    KDNode* next = (cd == 0 && px < root->driver.x) || (cd == 1 && py < root->driver.y)
                       ? root->left
                       : root->right;
    KDNode* other = next == root->left ? root->right : root->left;
    nearestNeighbor(next, px, py, best, bestDist, depth + 1);
    if ((cd == 0 && fabs(px - root->driver.x) < bestDist) ||
        (cd == 1 && fabs(py - root->driver.y) < bestDist))
        nearestNeighbor(other, px, py, best, bestDist, depth + 1);
}

/* ------------------- Fenwick Tree (for demand/supply zones) ------------------- */
struct FenwickTree {
    vector<int> bit;
    int n;
    FenwickTree(int n) {
        this->n = n;
        bit.assign(n + 1, 0);
    }
    void update(int idx, int val) {
        for (; idx <= n; idx += idx & -idx)
            bit[idx] += val;
    }
    int query(int idx) {
        int sum = 0;
        for (; idx > 0; idx -= idx & -idx)
            sum += bit[idx];
        return sum;
    }
    int rangeQuery(int l, int r) { return query(r) - query(l - 1); }
};

/* ------------------- Surge Multiplier ------------------- */
unordered_map<int, pair<int, int>> zoneData;
double calculateSurgeMultiplier(int zoneID) {
    int demand = zoneData[zoneID].first;
    int supply = max(zoneData[zoneID].second, 1);
    double ratio = (double)demand / supply;
    double surge = 1 + 0.5 * ratio;
    return min(surge, 3.0);
}

/* ------------------- Candidate for ETA-based assignment ------------------- */
struct Candidate {
    string driver;
    double eta;
    double rating;
    bool operator>(const Candidate &other) const {
        if (eta == other.eta)
            return rating < other.rating; // prefer higher rating if same ETA
        return eta > other.eta;
    }
};

/* ------------------- Fare Calculation ------------------- */
double calculateFare(double distance, string category, double surge) {
    double baseRate;
    if (category == "Standard")
        baseRate = 10;
    else if (category == "Premium")
        baseRate = 18;
    else
        baseRate = 8;
    return distance * baseRate * surge;
}

/* ------------------- Bellman-Ford Shortest Path ------------------- */
struct Edge {
    int u, v;
    double w;
};

void bellmanFord(int V, vector<Edge> &edges, int src) {
    vector<double> dist(V, 1e9);
    dist[src] = 0;

    for (int i = 1; i < V; i++) {
        for (auto &e : edges) {
            if (dist[e.u] + e.w < dist[e.v])
                dist[e.v] = dist[e.u] + e.w;
        }
    }

    cout << "\nShortest distances from source (driver) to pickup:\n";
    for (int i = 0; i < V; i++) {
        cout << "Node " << i << " = " << dist[i] << "\n";
    }
}

/* ------------------- MAIN SYSTEM ------------------- */
int main() {
    srand(time(0));
    cout << "========= RIDE SHARING SYSTEM (Interactive Simulation) =========\n\n";

    // Driver setup
    vector<Driver> drivers = {
        {"Amit", "Premium", 1, 2, 4.8},
        {"Ravi", "Standard", 3, 5, 4.6},
        {"John", "Pool", 6, 8, 4.9},
        {"Sam", "Standard", 2, 4, 4.4},
        {"Nikhil", "Premium", 8, 9, 4.7},
        {"Priya", "Standard", 5, 7, 4.5}
    };

    // KD Tree creation
    KDNode* root = nullptr;
    for (auto &d : drivers)
        root = insertKD(root, d);

    double px, py, dx, dy;
    cout << "Enter Pickup Location (x y): ";
    cin >> px >> py;
    cout << "Enter Drop Location (x y): ";
    cin >> dx >> dy;

    // Ask user which ride type they want
    string rideType;
    cout << "\nSelect Ride Type (Standard / Premium / Pool): ";
    cin >> rideType;

    // Find nearest driver of that type
    Driver best;
    double bestDist = 1e9;
    bool found = false;

    for (auto &d : drivers) {
        if (d.category == rideType) {
            double distance = dist(px, py, d.x, d.y);
            if (distance < bestDist) {
                best = d;
                bestDist = distance;
                found = true;
            }
        }
    }

    if (!found) {
        cout << "\nNo " << rideType << " drivers available nearby!\n";
        return 0;
    }

    cout << "\nNearest Available " << rideType << " Driver: " << best.name
         << " | Rating: " << best.rating
         << " | Distance: " << bestDist << " km\n";

    // Demand-Supply (random for simulation)
    zoneData[1] = {10, 5}; // demand=10, supply=5
    double surge = calculateSurgeMultiplier(1);

    double rideDistance = dist(px, py, dx, dy);
    double fare = calculateFare(rideDistance, best.category, surge);
    double eta = bestDist * 2 + (rand() % 5 + 3);

    cout << "\nEstimated Time of Arrival (ETA): " << eta << " mins";
    cout << "\nEstimated Ride Distance: " << rideDistance << " km";
    cout << "\nSurge Multiplier: " << surge << "x";
    cout << "\nEstimated Fare: Rs " << fare << "\n";

    cout << "\nConfirm Ride? (y/n): ";
    char confirm;
    cin >> confirm;
    if (confirm != 'y') {
        cout << "\nRide cancelled by passenger.\n";
        return 0;
    }

    cout << "\nRide Confirmed! Driver " << best.name << " is on the way...\n";

    // --- Bellman-Ford Simulation (Shortest path from driver to pickup) ---
    cout << "\nComputing shortest route from driver to pickup using Bellman-Ford...\n";
    std::this_thread::sleep_for(std::chrono::seconds(1));

    vector<Edge> edges = {
        {0, 1, 4}, {0, 2, 5}, {1, 2, -3}, {2, 3, 4}
    };
    bellmanFord(4, edges, 0);
    std::this_thread::sleep_for(std::chrono::seconds(1));
    cout << "\nOptimal route calculated. Driver is heading to pickup...\n\n";
    std::this_thread::sleep_for(std::chrono::seconds(2));

    // Random event: simulate cancellation
    int event = rand() % 3; // 0 = normal, 1 = driver cancels, 2 = passenger cancels

    if (event == 1) {
        cout << "\nDriver " << best.name << " cancelled the ride!\n";
        cout << "Reassigning you the next best driver...\n";

        priority_queue<Candidate, vector<Candidate>, greater<Candidate>> pq;
        for (auto &d : drivers) {
            if (d.name != best.name) {
                double etaNew = dist(px, py, d.x, d.y) * 2 + (rand() % 3 + 2);
                pq.push({d.name, etaNew, d.rating});
            }
        }
        Candidate newDriver = pq.top();
        pq.pop();

        cout << "New Driver Assigned: " << newDriver.driver
             << " | ETA: " << newDriver.eta << " mins | Rating: " << newDriver.rating << "\n";
    }
    else if (event == 2) {
        cout << "\nPassenger cancelled the ride midway.\n";
        cout << "Notifying driver " << best.name << "...\n";
    }
    else {
        cout << "\nRide completed successfully!\n";
        cout << "Total fare charged: Rs " << fare << "\n";
    }

    cout << "\n========= END OF SIMULATION =========\n";
    return 0;
}
