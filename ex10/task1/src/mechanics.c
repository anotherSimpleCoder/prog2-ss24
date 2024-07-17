#include "mechanics.h"

double velocity(double delta_distance, double delta_time) {
    return delta_distance/ delta_time;
}

double acceleration(double delta_veclocity, double delta_time) {
    return delta_veclocity / delta_time;
}

double impulse(double mass, double velocity) {
    return mass * velocity;
}