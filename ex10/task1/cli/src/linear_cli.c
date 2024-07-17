#include "linear_cli.h"

void linear_motions_menu() {
    while(1) {
        printf("=======================\n");
        printf("Linear motion functions\n");
        printf("=======================\n");
        printf("\n");
        printf("1) Distance of an object in uniform linear motion\n");
        printf("2) Distance of an object in uniformly accelerated linear motion\n");
        printf("3) Velocity of an object in uniformly accelerated linear motion\n");
        printf("4) Exit\n");

        int choice = read_int_input("Please enter your choice: ");
        switch (choice)
        {
            case DISTANCE_UNIFORM_LINEAR_MOTION:{
                calculate_distance_of_uniform_linear_motion();
                break;
            }

            case DISTANCE_UNIFORM_ACCELERATED_LINEAR_MOTION: {
                calculate_distance_of_uniformly_accelerated_linear_motion();
                break;
            }

            case VELOCITY_UNIFORM_ACCELERATED_LINEAR_MOTION: {
                calculate_velocity_of_uniformly_accelerated_linear_motion();
                break;
            }

            case LINEAR_EXIT: {
                return;
            }
            
            default:{
                printf("Invalid choice");
            }
        }
    }
}

void calculate_distance_of_uniform_linear_motion() {
    double velocity = read_double_input("Please enter the velocity: ");
    double start_time = read_double_input("Please enter the start time: ");
    double time = read_double_input("Please enter the time: ");

    printf("The Distance is: %f\n", distance_of_uniform_linear_motion(velocity, time, start_time));
}

void calculate_distance_of_uniformly_accelerated_linear_motion() {
    double velocity = read_double_input("Please enter the velocity: ");
    double start_velocity = read_double_input("Please enter the start velocity: "); 
    double acceleration = read_double_input("Please enter the acceleration: ");

    printf("The Distance is: %f\n", distance_of_uniformly_accelerated_linear_motion(velocity, start_velocity, acceleration));
}

void calculate_velocity_of_uniformly_accelerated_linear_motion() {
    double acceleration = read_double_input("Please enter the acceleration: ");
    double start_time = read_double_input("Please enter the start time: ");
    double time = read_double_input("Please enter the time: ");
    double start_velocity = read_double_input("Please enter the start velocity: ");

    printf("The velocity is: %f\n", velocity_of_uniformly_accelerated_linear_motion(acceleration, time, start_time, start_velocity));
}