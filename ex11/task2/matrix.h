#pragma once
#include <stdio.h>
#include <stdlib.h>

/**
 * @brief Prints a matrix to the console.
 * 
 * @param matrix Pointer to the first element of the matrix.
 * @param rows The number of rows in the matrix.
 * @param cols The number of columns in the matrix.
 * 
 * This function prints the elements of the matrix in a formatted way.
 */
void printMatrix(int matrix[], int rows, int cols);

/**
 * @brief Finds the maximum value in a specified column of a matrix.
 * 
 * @param matrix Pointer to the first element of the matrix.
 * @param rows The number of rows in the matrix.
 * @param cols The number of columns in the matrix.
 * @param col The column index to search.
 * 
 * @return The maximum value found in the specified column.
 * 
 * This function searches the specified column of the matrix and returns the
 * maximum value found.
 */
int findMaxInCol(int matrix[], int rows, int cols, int col);

/**
 * @brief Finds the minimum value in a specified row of a matrix.
 * 
 * @param matrix Pointer to the first element of the matrix.
 * @param rows The number of rows in the matrix.
 * @param cols The number of columns in the matrix.
 * @param row The row index to search.
 * 
 * @return The minimum value found in the specified row.
 * 
 * This function searches the specified row of the matrix and returns the
 * minimum value found.
 */
int findMinInRow(int* matrix, int rows, int cols, int row);

/**
 * @brief Swaps two rows in a matrix.
 * 
 * @param matrix Pointer to the first element of the matrix.
 * @param rows The number of rows in the matrix.
 * @param cols The number of columns in the matrix.
 * @param row1 The index of the first row to swap.
 * @param row2 The index of the second row to swap.
 * 
 * This function swaps the elements of the two specified rows in the matrix.
 */
void swapRows(int* matrix, int rows, int cols, int row1, int row2);

/**
 * @brief Transposes a matrix.
 * 
 * @param matrix Pointer to the first element of the matrix.
 * @param rows The number of rows in the matrix.
 * @param cols The number of columns in the matrix.
 * 
 * This function transposes the matrix, swapping rows with columns.
 */
void transposeMatrix(int* matrix, int rows, int cols);

/**
 * @brief Multiplies each element of a matrix by a scalar value.
 * 
 * @param matrix Pointer to the first element of the matrix.
 * @param rows The number of rows in the matrix.
 * @param cols The number of columns in the matrix.
 * @param scalar The scalar value to multiply by.
 * 
 * This function multiplies each element of the matrix by the specified scalar value.
 */
void multiplyByScalar(int* matrix, int rows, int cols, int scalar);

/**
 * @brief Sums two matrices element-wise.
 * 
 * @param m1 Pointer to the first element of the first matrix.
 * @param m2 Pointer to the first element of the second matrix.
 * @param res Pointer to the first element of the result matrix.
 * @param rows The number of rows in the matrices.
 * @param cols The number of columns in the matrices.
 * 
 * This function sums two matrices element-wise and stores the result in the
 * result matrix.
 */
void sum(int* m1, int* m2, int* res, int rows, int cols);

/**
 * @brief Multiplies two matrices.
 * 
 * @param m1 Pointer to the first element of the first matrix.
 * @param m2 Pointer to the first element of the second matrix.
 * @param res Pointer to the first element of the result matrix.
 * @param m1_rows The number of rows in the first matrix.
 * @param m1_cols The number of columns in the first matrix.
 * @param m2_rows The number of rows in the second matrix.
 * @param m2_cols The number of columns in the second matrix.
 * 
 * This function multiplies the first matrix by the second matrix and stores
 * the result in the result matrix. The number of columns in the first matrix
 * must equal the number of rows in the second matrix.
 */
void mult(int* m1, int* m2, int* res, int m1_rows, int m1_cols, int m2_rows, int m2_cols);
