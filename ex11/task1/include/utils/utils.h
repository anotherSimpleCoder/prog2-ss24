#pragma once

#include <stdio.h>
#include <stdlib.h>

/**
 * @brief Prompts the user for a string input.
 * 
 * @param message The message to display to the user.
 * @param size The maximum size of the input string.
 * 
 * @return A pointer to the input string.
 * 
 * This function displays a message to the user, reads a string input of up to
 * the specified size, and returns the input string.
 */
char* inputString(char* message, int size);

/**
 * @brief Prompts the user for an integer input.
 * 
 * @param message The message to display to the user.
 * 
 * @return The input integer.
 * 
 * This function displays a message to the user, reads an integer input, and
 * returns the input integer.
 */
int inputInt(char* message);

/**
 * @brief Prompts the user for a floating-point number input.
 * 
 * @param message The message to display to the user.
 * 
 * @return The input floating-point number.
 * 
 * This function displays a message to the user, reads a floating-point number
 * input, and returns the input value.
 */
float inputFloat(char* message);
