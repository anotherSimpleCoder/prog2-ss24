#include "task1.h"

void generate_bill() {
	char input[8];
	float price = 0.0;

	printf("Bitte geben Sie den Nettopreis ein: ");
	fflush(stdout);

	scanf("%7s", input);
	sscanf(input, "%f", &price);

	printf("Nettopreis\t\t Euro %.2f\n", price);
	printf("+ 20% MwSt\t\t Euro %.2f\n", price * 0.2);
	printf("=====================================\n");
	printf("Bruttopreis\t\t Euro %.2f\n", price * 1.2);
}
