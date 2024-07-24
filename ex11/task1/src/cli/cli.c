#include "cli.h"

void mainMenu() {
	while (1) {
		printf("==========================\n");
		printf("Employee Management System\n");
		printf("==========================\n");
		printf("1) Add employee\n");
		printf("2) Delete employee\n");
		printf("3) Edit employee\n");
		printf("4) Query employee\n");
		printf("5) Print all employees\n");
		printf("6) Exit\n");
		printf("\n");

		int choice = inputInt("Enter your choice: ");
		switch (choice) {
		case ADD_EMPLOYEE: {
			addMitarbeiter();
			break;
		}

		case DELETE_EMPLOYEE: {
			deleteMenu();
			break;
		}

		case EDIT_EMPLOYEE: {
			editMenu();
			break;
		}

		case QUERY_EMPLOYEE: {
			queryMenu();
			break;
		}

		case PRINT_ALL_EMPLOYEES: {
			printAllMitarbeiter();
			break;
		}

		case EXIT: {
			return;
		}

		default: {
			printf("Invalid choice!\n");
		}

		}
	}
}

void deleteMenu() {
	char* name = inputString("Enter the name of the employee to be deleted: ", 255);
	deleteMitarbeiter(name);
}

void editMenu() {
	char* name = inputString("Enter the name of the employee to be edited: ", 255);
	editMitarbeiter(name);
}

void queryMenu() {
	char* name = inputString("Enter the name of the employee: ", 255);
	queryMitarbeiter(name);
}