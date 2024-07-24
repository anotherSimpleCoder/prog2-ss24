#pragma once
#include <stdlib.h>

/**
 * @brief Structure to represent an employee (Mitarbeiter).
 * 
 * This structure contains information about an employee, including their name,
 * age, division, and salary.
 */
typedef struct {
    char* name;       /**< The name of the employee. */
    int age;          /**< The age of the employee. */
    char* division;   /**< The division in which the employee works. */
    float salary;     /**< The salary of the employee. */
} Mitarbeiter;

/**
 * @brief Creates a new employee (Mitarbeiter).
 * 
 * @param name The name of the employee.
 * @param age The age of the employee.
 * @param division The division in which the employee works.
 * @param salary The salary of the employee.
 * 
 * @return A pointer to the newly created Mitarbeiter structure.
 * 
 * This function allocates memory for a new Mitarbeiter structure and initializes
 * it with the provided name, age, division, and salary.
 */
Mitarbeiter* newMitarbeiter(char* name, int age, char* division, float salary);
