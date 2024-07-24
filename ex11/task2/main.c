#include <stdio.h>
#include <stdlib.h>
#include "matrix.h"

void test(int* matrix, int rows, int cols);

int main(int argc, char const *argv[])
{
    int testMatrix[12] = {
        0, 1, 2, 3, 
        4, 5, 6, 7, 
        8, 9, 10, 11};
    int cols = 4;
    int rows = 3;

    test(testMatrix, rows, cols);
    return 0;
}


void test(int* matrix, int rows, int cols) {
    printf("============\n");
    printf("printMatrix:\n");
    printf("============\n");
    printf("\n");
    printMatrix(matrix, rows, cols);
    printf("\n");

    printf("=========================\n");
    printf("findMaxInCol at col 0: %d\n", findMaxInCol(matrix, rows, cols, 0));
    printf("=========================\n");
    printf("\n");
    
    printf("=========================\n");
    printf("findMinInRow at row 1: %d\n", findMinInRow(matrix, rows, cols, 1));
    printf("=========================\n");
    printf("\n");

    printf("=================\n");
    printf("Swap rows 1 and 2\n");
    printf("=================\n");
    swapRows(matrix, rows, cols, 1, 2);
    printMatrix(matrix, rows, cols);
    printf("\n");

    printf("================\n");
    printf("Transpose Matrix\n");
    printf("================\n");
    transposeMatrix(matrix, rows, cols);
    printMatrix(matrix, cols, rows);
    printf("\n");

    printf("=============================\n");
    printf("Matrix mutliplied by scalar 2\n");
    printf("=============================\n");
    multiplyByScalar(matrix, cols, rows, 2);
    printMatrix(matrix, cols, rows);
    printf("\n");

    printf("=========================\n");
    printf("Sum of matrix with itself\n");
    printf("=========================\n");
    int* resultMatrix = (int*)(calloc(rows*cols, sizeof(int)));
    sum(matrix, matrix, resultMatrix, cols, rows);
    printMatrix(resultMatrix, cols, rows);
    printf("\n");

    printf("=================================\n");
    printf("Matrix multiplication with itself\n");
    printf("=================================\n");
    mult(matrix, matrix, resultMatrix, cols, rows, cols, rows);
    printMatrix(resultMatrix, cols, rows);
    printf("\n");

    free(resultMatrix);
}