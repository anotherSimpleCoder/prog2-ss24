#include <stdio.h>
#include <stdlib.h>

/**
 * Reads an integer input from the user after displaying a message.
 *
 * @param message The message to display before prompting for input.
 * @return The integer input by the user.
 */
int read_int_input(char* message) {
    // If message is NULL, return 1 as an error code (assuming 1 indicates an error)
    if(message == NULL) {
        return 1;
    }
    
    int input;
    
    // Display the message and read the integer input
    printf("%s", message);
    scanf("%d", &input);
    
    return input;
}

/**
 * Renders a pattern resembling an 'X' based on user-defined rows and columns.
 */
void render_x() {
    // Prompt user for number of rows and columns
    int rows = read_int_input("Please enter the amount of rows: ");
    int columns = read_int_input("Please enter the amount of columns: ");
    
    // Loop through each row and column to print the 'X' pattern
    for(int row = 0; row < rows; row++) {
        for(int column = 0; column < columns; column++) {
            int start_cell = row;
            int end_cell = (columns-1) - row;
            
            // Print '*' if current column is at the start or end cell of the current row
            if(column == start_cell || column == end_cell) {
                printf("*");
            } else {
                // Otherwise, print '-'
                printf("-");
            }
        }
        printf("\n"); // Move to the next line after each row is printed
    }    
}

/**
 * The main function that initiates the rendering of the 'X' pattern.
 *
 * @param argc Number of command-line arguments.
 * @param argv Array of command-line arguments.
 * @return 0 upon successful execution.
 */
int main(int argc, char const *argv[]) {
    // Call the function to render the 'X' pattern
    render_x();
    
    return 0; // Return 0 to indicate successful completion of the program
}
