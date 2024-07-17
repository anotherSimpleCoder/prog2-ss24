#include "utils.h"

double read_double_input(char* message) {
    if(message == NULL) {
        return 1;
    }
    double input;

    printf("%s", message);
    scanf("%f", &input);

    return input;
}

int read_int_input(char* message) {
        if(message == NULL) {
        return 1;
    }
    int input;

    printf("%s", message);
    scanf("%d", &input);

    return input;
}