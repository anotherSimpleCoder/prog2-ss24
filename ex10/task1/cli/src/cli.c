#include "cli.h"

void main_menu() {
    while(1) {
        printf("============\n");
        printf("Test program\n");
        printf("============\n");
        printf("\n");
        printf("1) Mechanics functions\n");
        printf("2) Linear motion functions\n");
        printf("3) Exit\n");
        printf("\n");

        int choice = read_int_input("Please enter your choice: ");
        switch(choice) {
            case 1: {
                mechanics_menu();
                break;
            }

            case 2: {
                linear_motions_menu();
                break;
            }

            case 3: {
                return;
            }

            default: {
                printf("Invalid choice!\n");
            }
        }
    }
    
}



