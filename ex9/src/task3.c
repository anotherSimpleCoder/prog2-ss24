/*
 * task3.c
 *
 *  Created on: 03.07.2024
 *      Author: abav
 */
#include "task3.h"

int collatz_steps(int n) {
	if(n % 2 == 0) {
		return n/2;
	}

	return (3*n) + 1;
}

void do_collatz() {
	int start_number = 0;
	int quit = 1;

	printf("Enter your start number: ");
	scanf("%d", &start_number);

	int steps = 0;
	printf("Collatz Folge: ");
	while(1) {
		steps++;
		if(start_number == 1) {
			printf("1\n");
			break;
		}

		printf("%d ", start_number);
		start_number = collatz_steps(start_number);
	}

	printf("Amount of steps: %d", steps);
}
