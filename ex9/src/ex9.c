#include "task1.h"
#include "task2.h"
#include "task3.h"
#include "task4.h"

#include <string.h>

int choice_to_menu_choice(char* arg) {
	if(!strcmp(arg, "bill")) {
		generate_bill();
	} else if(!strcmp(arg, "fib")) {
		measure_fibonacci();
	} else if(!strcmp(arg, "col")) {
		do_collatz();
	} else if(!strcmp(arg, "const")) {
		calculate_constants();
	}
}

int main(int argc, char** argv) {
	if(argc != 2) {
		printf("Missing operation!\n");
		return 1;
	}

	choice_to_menu_choice(argv[1]);

	return 0;
}
