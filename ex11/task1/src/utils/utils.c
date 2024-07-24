#include "utils.h"

char* inputString(char* message, int size) {
	char* input = (char*)(malloc(size * sizeof(size)));
	if (input == NULL) {
		printf("Error initialzing input string\n");
		return NULL;
	}


	printf("%s", message);
	scanf("%s", input);

	return input;
}


int inputInt(char* message) {
	int input = 0;
	printf("%s", message);
	scanf("%d", &input);

	return input;
}


float inputFloat(char* message) {
	float input = 0;
	printf("%s", message);
	scanf("%f", &input);

	return input;
}