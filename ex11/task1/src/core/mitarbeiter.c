#include "mitarbeiter.h"

Mitarbeiter* newMitarbeiter(char* name, int age, char* division, float salary) {
	Mitarbeiter* employee = (Mitarbeiter*)(malloc(sizeof(Mitarbeiter)));
	employee->name = name;
	employee->age = age;
	employee->division = division;
	employee->salary = salary;

	return employee;
}