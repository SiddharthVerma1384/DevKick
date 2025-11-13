#include <iostream>
#include <cmath>
#include <vector>
#include <string>
#include <queue>
#include <limits>
#include <cstdlib>
#include <ctime>
#include <algorithm>
using namespace std;

/* ----------------------- DRIVER STRUCT ----------------------- */
struct Driver {
    string name;
    string category;      // Standard, Premium, Pool
    double x, y;          // current location
    double rating;

    Driver(string n, string c, double px, double py, double r)
        : name(n), category(c), x(px), y(py), rating(r) {}
};

/* ----------------------- DISTANCE FUNCTION ----------------------- */
double distance(double x1, double y1, double x2, double y2) {
    return sqrt((x1 - x2)*(x1 - x2) + (y1 - y2)*(y1 - y2));
}

/* ----------------------- PRIORITY QUEUE COMPARATOR ----------------------- */
// Higher rating FIRST, if equal -> closer distance FIRST
struct CompareDriver {
    bool operator()(const pair<Driver*, double>& a,
                    const pair<Driver*, double>& b) {
        if (a.first->rating == b.first->rating)
            return a.second > b.second;
        return a.first->rating < b.first->rating;
    }
};

/* ----------------------- DRIVER DATABASE ----------------------- */
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

/* ----------------------- FIND NEAREST DRIVER USING PQ ----------------------- */
Driver* getNearestDriver(double px, double py, string type) {
    priority_queue<
        pair<Driver*, double>,
        vector<pair<Driver*, double>>,
        CompareDriver
    > pq;

    for (auto &d : drivers) {
        if (d.category == type) {
            double dist = distance(px, py, d.x, d.y);
            pq.push({ &d, dist });
        }
    }

    if (pq.empty()) return nullptr;
    return pq.top().first;
}

/* ----------------------- REMOVE A DRIVER FROM ACTIVE LIST ----------------------- */
void removeDriver(string name) {
    drivers.erase(
        remove_if(drivers.begin(), drivers.end(),
            [&](Driver &d){ return d.name == name; }),
        drivers.end()
    );
}

/* ----------------------- ETA & FARE CALCULATION ----------------------- */
double calculateETA(double dist, string type) {
    double speed = 0;
    if (type == "Standard") speed = 40;
    if (type == "Premium")  speed = 50;
    if (type == "Pool")     speed = 20;

    return (dist / speed) * 60;  // mins
}

double calculateFare(double dist, string type, double surge) {
    double base = 0;
    if (type == "Standard") base = 12;
    if (type == "Premium")  base = 18;
    if (type == "Pool")     base = 8;

    return dist * base * surge;
}

/* ----------------------- RANDOM CANCELLATION EVENT ----------------------- */
bool driverCancels() {
    return (rand() % 100) < 40; // 40% chance
}

/* ----------------------- MAIN SIMULATION ----------------------- */
int main() {
    srand(time(0));

    cout << "========= RIDE SHARING SYSTEM =========\n\n";

    double px, py, dx, dy;
    cout << "Enter Pickup Location (x y): ";
    cin >> px >> py;

    cout << "Enter Drop Location (x y): ";
    cin >> dx >> dy;

    string rideType;
    cout << "\nSelect Ride Type (Standard / Premium / Pool): ";
    cin >> rideType;

    /* -------- INITIAL DRIVER SELECTION -------- */
    Driver* driver = getNearestDriver(px, py, rideType);

    if (!driver) {
        cout << "\nNo " << rideType << " drivers available!\n";
        return 0;
    }

    double dist = distance(px, py, driver->x, driver->y);
    double tripDist = distance(px, py, dx, dy);

    double surge = (rand() % 2 == 0 ? 1.0 : 2.0); // random surge

    double eta = calculateETA(dist, rideType);
    double fare = calculateFare(tripDist, rideType, surge);

    cout << "\nNearest Available " << rideType << " Driver: "
         << driver->name << " | Rating: " << driver->rating
         << " | Distance: " << dist << " km\n";

    cout << "\nETA: " << eta << " mins | Fare: Rs " << fare
         << " | Surge: " << surge << "x\n\n";

    cout << "Confirm Ride? (y/n): ";
    char ch;
    cin >> ch;

    if (ch != 'y') {
        cout << "\nRide Cancelled by User.\n";
        return 0;
    }

    cout << "\nRide Confirmed! Driver " << driver->name << " is on the way...\n\n";

    /* -------- DRIVER CANCELLATION SIMULATION -------- */
    if (driverCancels()) {
        cout << "Driver " << driver->name << " cancelled the ride!\nReassigning...\n\n";

        string cancelledName = driver->name;
        removeDriver(cancelledName);

        Driver* newDriver = getNearestDriver(px, py, rideType);

        if (!newDriver) {
            cout << "\nNo other drivers available. Ride cancelled.\n";
            return 0;
        }

        double newDist = distance(px, py, newDriver->x, newDriver->y);
        double newEta = calculateETA(newDist, rideType);

        cout << "New Driver Assigned: " << newDriver->name
             << " | ETA: " << newEta
             << " mins | Rating: " << newDriver->rating << "\n";

        cout << "Updated Fare: Rs " << fare << "\n\n";

        cout << "Confirm this ride? (y/n): ";
        cin >> ch;

        if (ch != 'y') {
            cout << "\nRide Cancelled by User.\n";
            return 0;
        }

        cout << "\nRide Confirmed! Driver " << newDriver->name << " is on the way...\n\n";
        driver = newDriver;
    }

    /* -------- COMPLETE THE RIDE -------- */
    cout << "Ride completed successfully!\n";
    cout << "Total fare charged: Rs " << fare << "\n\n";

    cout << "========= END OF SIMULATION =========\n";
    return 0;
}
