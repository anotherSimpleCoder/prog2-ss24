#include "task4.h"

double calculate_pi(int terms) {
    double pi = 0;

    for(int k = 0; k <= terms; k++) {
        pi += (pow(-1.0, k) / (double)(2* k + 1));
    }

    return 4*pi;
}

long long factorial(int n) {
    long long res = 1;

    for(int i = 1; i <= n; i++) {
        res *= i;
    }

    return round(res);
}

double calculate_e(int terms) {
    double e = 0;

    for(int k = 0; k <= terms; k++) {
        e += 1.0/(double)(factorial(k));
    }

    return e;
}

void calculate_constants() {
    int iterations = 0;
    printf("Please enter the amount of iterations: ");
    scanf("%d", &iterations);

    printf("pi calculated with %lld iterations: %.5f\n", iterations, calculate_pi(iterations));
    printf("e calculated with %lld iterations: %.5f\n", iterations, calculate_e(iterations));
}