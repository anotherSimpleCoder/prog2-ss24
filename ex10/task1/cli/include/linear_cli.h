#ifndef LINEAR_CLI_H
#define LINEAR_CLI_H

#include <stdio.h>
#include "linear.h"
#include "utils.h"

void linear_motions_menu();
void calculate_distance_of_uniform_linear_motion();
void calculate_distance_of_uniformly_accelerated_linear_motion();
void calculate_velocity_of_uniformly_accelerated_linear_motion();

enum linear_menu_points {
    DISTANCE_UNIFORM_LINEAR_MOTION = 1,
    DISTANCE_UNIFORM_ACCELERATED_LINEAR_MOTION = 2,
    VELOCITY_UNIFORM_ACCELERATED_LINEAR_MOTION = 3,
    LINEAR_EXIT = 4
};

#endif