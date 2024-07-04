/*
 * task2.c
 *
 *  Created on: 03.07.2024
 *      Author: abav
 */
#include "task2.h"

int prompt_user_input() {
	int entered_number = 0;
	printf("Geben Sie die zu berechnende Zahl ein: ");
	
	scanf("%d", &entered_number);

	return entered_number;
}

int fiboanacci_iterative(int number_to_calculate) {
	int fibonacci_value_buffer[2] = {1,1};
	for(int buffer_index = 1; buffer_index < number_to_calculate; buffer_index++) {
		int previous_value = fibonacci_value_buffer[0];
		fibonacci_value_buffer[0] = fibonacci_value_buffer[1];
		fibonacci_value_buffer[1] = previous_value + fibonacci_value_buffer[1];
	}

	return fibonacci_value_buffer[1];
}

int fibonacci_recursive(int number_to_calculate) {
	if(number_to_calculate >= 0 && number_to_calculate <= 1) {
		return 1;
	}

	return fibonacci_recursive(number_to_calculate - 1) + fibonacci_recursive(number_to_calculate - 2);
}

void measure_fibonacci() {
	int entered_number = prompt_user_input();
	long start, end = 0;

	start = clock();
	fiboanacci_iterative(entered_number);
	end = clock();

	printf("Fibonacci Iterative: %d ms\n", (end-start));

	start = clock();
	fibonacci_recursive(entered_number);
	end = clock();

	printf("Fibonacci Recursive: %d ms\n", (end-start));
}
