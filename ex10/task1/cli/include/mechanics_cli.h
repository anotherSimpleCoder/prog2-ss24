#ifndef MECHANICS_CLI_H
#define MECHANICS_CLI_H

#include <stdio.h>
#include "mechanics.h"
#include "utils.h"


void calculate_velocity();
void calculate_acceleration();
void calculate_impulse();
void mechanics_menu();

enum menu_points {
    VELOCITY = 1,
    ACCELERATION = 2,
    IMPULSE = 3,
    EXIT = 4
};

#endif