#pragma once
#include <stdio.h>
#include "employee.h"

/**
 * Enumeration representing the choices available in the main menu.
 */
enum menuChoice {
    ADD_EMPLOYEE = 1,       /**< Choice to add a new employee. */
    DELETE_EMPLOYEE = 2,    /**< Choice to delete an existing employee. */
    EDIT_EMPLOYEE = 3,      /**< Choice to edit details of an existing employee. */
    QUERY_EMPLOYEE = 4,     /**< Choice to query information about an employee. */
    PRINT_ALL_EMPLOYEES = 5,/**< Choice to print details of all employees. */
    EXIT = 6                /**< Choice to exit the application. */
};

/**
 * @brief Displays the main menu and handles user input.
 * 
 * This function presents the main menu to the user and processes the selected
 * option to perform the corresponding action such as adding, deleting, editing,
 * querying, or printing employee details, or exiting the application.
 */
void mainMenu();

/**
 * @brief Displays the delete menu and handles user input.
 * 
 * This function presents the delete menu to the user, allowing them to select
 * an employee to delete. It processes the user input to perform the deletion.
 */
void deleteMenu();

/**
 * @brief Displays the edit menu and handles user input.
 * 
 * This function presents the edit menu to the user, enabling them to select an
 * employee to edit. It processes the user input to modify the employee's details.
 */
void editMenu();

/**
 * @brief Displays the query menu and handles user input.
 * 
 * This function presents the query menu to the user, allowing them to query
 * information about a specific employee. It processes the user input to display
 * the requested employee details.
 */
void queryMenu();
