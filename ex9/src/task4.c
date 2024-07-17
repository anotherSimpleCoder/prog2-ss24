#include "task4.h"

double calculate_pi(int terms) {
    double pi = 0;

    for(int k = 0; k <= terms; k++) {
        pi += (pow(-1.0, k) / (double)(2* k + 1));
    }

    return 4*pi;
}


double calculate_e(int terms) {
    double e = 0;
    double factorial = 1.0;

    for(int k = 1; k <= terms; k++) {
        factorial *= k;
        e += 1.0 / factorial;
    }

    return e + 1;
}

void calculate_constants() {
    int iterations = 0;
    printf("Please enter the amount of iterations: ");
    scanf("%d", &iterations);

    printf("pi calculated with %lld iterations: %.5llf\n", iterations, calculate_pi(iterations));
    printf("e calculated with %lld iterations: %.5llf\n", iterations, calculate_e(iterations));
}