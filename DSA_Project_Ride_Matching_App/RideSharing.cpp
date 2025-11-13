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
    cout << "========= RIDE SHARING SYSTEM =========\n\n";

    // Driver setup
    vector<Driver> drivers = {
        {"Amit", "Premium", 1, 2, 4.8},
        {"Ravi", "Standard", 3, 5, 4.6},
        {"John", "Pool", 6, 8, 4.9},
        {"Sam", "Standard", 2, 4, 4.4},
        {"Nikhil", "Standard", 8, 9, 4.7},
        {"Divyansh", "Pool", 6, 9, 4.6},
        {"Amsih", "Premium", 6, 9, 4.7},
        {"Akash", "Standard", 8, 10, 4.7},
        {"Amar", "Pool", 22, 77, 4.7},
        {"Abhishek", "Premium", 4, 8, 5.0},
        {"Aditya", "Premium", 11, 15, 4.7},
        {"Yash", "Pool", 1, 2, 3.4},
        {"Mihir", "Standard", 2, 4, 4.1},
        {"Priyanshu", "Premium", 8, 9, 4.2},
        {"Divyakush", "Pool", 5, 9, 4.5},
        {"Priya", "Standard", 5, 7, 4.5}
    };

    double px, py, dx, dy;
    cout << "Enter Pickup Location (x y): ";
    cin >> px >> py;
    cout << "Enter Drop Location (x y): ";
    cin >> dx >> dy;

    string rideType;
    cout << "\nSelect Ride Type (Standard / Premium / Pool): ";
    cin >> rideType;

    // Find nearest driver
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

    // Surge and fare
    zoneData[1] = {10, 5};
    double surge = calculateSurgeMultiplier(1);
    double rideDistance = dist(px, py, dx, dy);
    double fare = calculateFare(rideDistance, best.category, surge);
    double eta = bestDist * 2 + (rand() % 5 + 3);

    cout << "\nETA: " << eta << " mins | Fare: Rs " << fare << " | Surge: " << surge << "x\n";
    cout << "\nConfirm Ride? (y/n): ";
    char confirm;
    cin >> confirm;
    if (confirm != 'y') {
        cout << "\nRide cancelled by passenger.\n";
        return 0;
    }

    cout << "\nRide Confirmed! Driver " << best.name << " is on the way...\n";

    // Simulate random event
    int event = rand() % 3; // 0 = normal, 1 = driver cancels, 2 = passenger cancels

    if (event == 1) {
        cout << "\nDriver " << best.name << " cancelled the ride!\nReassigning...\n";
    } else if (event == 2) {
        cout << "\nPassenger cancelled the ride midway.\nNotifying driver...\n";

        char rebook;
        cout << "\nWould you like to book another ride? (y/n): ";
        cin >> rebook;

        if (rebook == 'y' || rebook == 'Y') {
            double penalty = max(50.0, fare * 0.1);
            cout << "\nPenalty applied: Rs " << penalty << "\n";
            cout << "\nRebooking based on best available driver (rating + ETA)...\n";
        } else {
            cout << "\nNo problem. Ride request closed.\n";
            return 0;
        }
    }

    if (event == 1 || event == 2) {
        // Priority queue based on ETA and rating
        priority_queue<Candidate, vector<Candidate>, greater<Candidate>> pq;
        for (auto &d : drivers) {
            if (d.name != best.name && d.category == rideType) {
                double etaNew = dist(px, py, d.x, d.y) * 2 + (rand() % 3 + 2);
                pq.push({d.name, etaNew, d.rating});
            }
        }

        if (pq.empty()) {
            cout << "\nNo alternate drivers available.\n";
            return 0;
        }

        Candidate newDriver = pq.top();
        pq.pop();

        double newFare = calculateFare(rideDistance, rideType, surge);
        if (event == 2) newFare += max(50.0, fare * 0.1); // include penalty if passenger cancelled

        cout << "\nNew Driver Assigned: " << newDriver.driver
             << " | ETA: " << newDriver.eta << " mins | Rating: " << newDriver.rating
             << "\nUpdated Fare: Rs " << newFare << "\n";

        cout << "\nConfirm this ride? (y/n): ";
        char confirmNew;
        cin >> confirmNew;

        if (confirmNew != 'y' && confirmNew != 'Y') {
            cout << "\nRide cancelled again by passenger.\n";
            return 0;
        }

        cout << "\nRide Confirmed! Driver " << newDriver.driver << " is on the way...\n";
        cout << "\nRide completed successfully!\nTotal fare charged: Rs " << newFare << "\n";
    } else {
        cout << "\nRide completed successfully!\nTotal fare charged: Rs " << fare << "\n";
    }

    cout << "\n========= END OF SIMULATION =========\n";
    return 0;
}
