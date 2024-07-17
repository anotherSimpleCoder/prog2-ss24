#include "mechanics_cli.h"

void mechanics_menu() {
    while(1) {
        printf("===================\n");
        printf("Mechanics functions\n");
        printf("===================\n");
        printf("\n");
        printf("1) Velocity\n");
        printf("2) Accelertion\n");
        printf("3) Impulse\n");
        printf("4) Exit\n");
        printf("\n");

        int choice = read_int_input("Please enter your choice: ");
        switch (choice)
        {
            case VELOCITY:{
                calculate_velocity();
                break;
            }

            case ACCELERATION: {
                calculate_acceleration();
                break;
            }

            case IMPULSE: {
                calculate_impulse();
                break;
            }

            case EXIT: {
                return;
            }
            
            default:{
                printf("Invalid choice");
            }
        }
    }
}

void calculate_velocity() {
    double delta_distance = read_double_input("Please enter the distance change: ");
    double delta_time = read_double_input("Please enter the time change: ");

    printf("The velolcity is: %f\n", velocity(delta_distance, delta_time));
}

void calculate_acceleration() {
    double delta_velocity = read_double_input("Please enter the velocity change: ");
    double delta_time = read_double_input("Please enter the time change: ");

    printf("The acceleration is: %f\n", acceleration(delta_velocity, delta_time));
}

void calculate_impulse() {
    double mass = read_double_input("Please enter the mass of your object: ");
    double velocity = read_double_input("Please enter it's velocity: ");

    printf("The impulse is: %f\n", impulse(mass, velocity));
}