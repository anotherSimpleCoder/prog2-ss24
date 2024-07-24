#include "employee.h"

int employeeCount = 0;

Mitarbeiter* getMitarbeiter(char* name) {
	Mitarbeiter* employee = NULL;
	
	for (int i = 0; i < employeeCount; i++) {
		employee = employees[i];

		if (strcmp(employee->name, name)) {
			return employee;
		}
	}

	return employee;
}

char* mitarbeiterToString(Mitarbeiter* employee) {
	if(employee == NULL) {
		return "";
	}

	char* buffer = (char*)(calloc(1024, sizeof(char)));

	sprintf(buffer, "Mitarbeiter[name=%s age=%d division=%s salary=%f]",
		employee->name,
		employee->age,
		employee->division,
		employee->salary
	);

	return buffer;
}

void addMitarbeiter() {
	if(employeeCount == 50) {
        printf("Not enough space available to add a new employee\n");
        return;
    }

	char* name = inputString("Please enter the name of the employee: ", 255);
	int age = inputInt("Please enter the age of the employee: ");
	char* division = inputString("Please enter the division of the employee: ", 255);
	float salary = inputFloat("Please enter the salary of the employee: ");

    employees[employeeCount] = newMitarbeiter(name, age, division, salary);
    employeeCount++;

	return;
}

void deleteMitarbeiter(char* name) {
    for(int i = 0; i < employeeCount; i++) {
        if(strcmp(employees[i]->name, name) == 0) {
            employees[i] = employees[employeeCount - 1];
            employeeCount--;
            return;
        }
    }

    printf("Employee not found!\n");
}

void editMitarbeiter(char* name) {
	Mitarbeiter* foundEmployee = getMitarbeiter(name);
	if (foundEmployee == NULL) {
		printf("Invalid employee!\n");
		return;
	}
	
	while (1) {
		printf("==========\n");
		printf("Attributes\n");
		printf("==========\n");
		printf("1) Name\n");
		printf("2) Age\n");
		printf("3) Division\n");
		printf("4) Salary\n");
		printf("\n");

		int choice = inputInt("Please enter the choice: ");
		switch (choice) {
			case NAME: {
				char* name = inputString("Enter the new name of the employee: ", 255);
				foundEmployee->name = name;

				return;
			}

			case AGE: {
				int age = inputInt("Enter the new age of the employee: ");
				foundEmployee->age = age;

				return;
			}

			case DIVISION: {
				char* division = inputString("Enter the new division of the employee: ", 255);
				foundEmployee->division = division;

				return;
			}

			case SALARY: {
				float salary = inputFloat("Enter the new salary of the employee: ");
				foundEmployee->salary = salary;

				return;
			}

			default: {
				printf("Invalid choice\n");
			}
		}
	}
}

void queryMitarbeiter(char* name) {
	Mitarbeiter* employee = getMitarbeiter(name);

	if (employee == NULL) {
		printf("Employee not found!\n");
		return;
	}

	printf("%s\n", mitarbeiterToString(employee));
}

void printAllMitarbeiter() {
	for (int i = 0; i < employeeCount; i++) {
		Mitarbeiter* employee = employees[i];
		printf("%s\n", mitarbeiterToString(employee));
	}
}