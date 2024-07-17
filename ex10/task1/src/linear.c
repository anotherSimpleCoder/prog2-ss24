#include "linear.h"

double distance_of_uniform_linear_motion(double velocity, double time, double start_time) {
    return velocity * (time - start_time);
}

double distance_of_uniformly_accelerated_linear_motion(double velocity, double start_velocity, double acceleration) {
    return ( (velocity * velocity) - (start_velocity * start_velocity) ) / 2*acceleration;
}

double velocity_of_uniformly_accelerated_linear_motion(double acceleration, double time, double start_time, double start_velocity) {
    return ( acceleration * (time - start_time) ) + start_velocity;
}