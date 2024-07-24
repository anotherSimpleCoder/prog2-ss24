#pragma once
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "utils.h"
#include "mitarbeiter.h"

#define EMPLOYEES_SIZE 50

/**
 * Enumeration representing the choices available in the edit menu.
 */
enum editMenuChoice {
    NAME = 1,    /**< Choice to edit the employee's name. */
    AGE = 2,     /**< Choice to edit the employee's age. */
    DIVISION = 3,/**< Choice to edit the employee's division. */
    SALARY = 4   /**< Choice to edit the employee's salary. */
};

/** 
 * Array to store employee records.
 */
Mitarbeiter* employees[EMPLOYEES_SIZE];

/**
 * @brief Adds a new employee.
 * 
 * This function prompts the user for details of a new employee and adds it to
 * the employees array if there is space available.
 */
void addMitarbeiter();

/**
 * @brief Deletes an employee by name.
 * 
 * @param name The name of the employee to delete.
 * 
 * This function searches for an employee by name in the employees array and
 * deletes the record if found.
 */
void deleteMitarbeiter(char* name);

/**
 * @brief Edits the details of an employee by name.
 * 
 * @param name The name of the employee to edit.
 * 
 * This function searches for an employee by name in the employees array and
 * allows the user to edit the details of the found employee.
 */
void editMitarbeiter(char* name);

/**
 * @brief Queries information about an employee by name.
 * 
 * @param name The name of the employee to query.
 * 
 * This function searches for an employee by name in the employees array and
 * displays the details of the found employee.
 */
void queryMitarbeiter(char* name);

/**
 * @brief Prints details of all employees.
 * 
 * This function iterates through the employees array and prints the details of
 * all employees currently stored.
 */
void printAllMitarbeiter();
