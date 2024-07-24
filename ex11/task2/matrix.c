#include "matrix.h"

int getIndex(int row, int column, int cols) {
	return (row * cols) + column;
}

void printMatrix(int matrix[], int rows, int cols) {
	for (int row = 0; row < rows; row++) {
		for (int column = 0; column < cols; column++) {
			int index = getIndex(row, column, cols);
			printf("%d ", matrix[index]);
		}
		printf("\n");
	}
}

int findMaxInCol(int matrix[], int rows, int cols, int col) {
	int max = matrix[col];

	for (int row = 0; row < rows; row++) {
		int index = getIndex(row, col, cols);
		int value = matrix[index];

		if (value > max) {
			max = value;
		}
	}

	return max;
}

int findMinInRow(int* matrix, int rows, int cols, int row) {
	int min = matrix[row * rows];

	for (int column = 0; column < cols; column++) {
		int index = getIndex(row, column, cols);
		int value = matrix[index];

		if (value < min) {
			min = value;
		}
	}

	return min;
}

void swapRows(int* matrix, int rows, int cols, int row1, int row2) {
	for (int column = 0; column < cols; column++) {
		int row1Value = matrix[getIndex(row1, column, cols)];
		matrix[getIndex(row1, column, cols)] = matrix[getIndex(row2, column, cols)];
		matrix[getIndex(row2, column, cols)] = row1Value;
	}
}


void transposeMatrix(int* matrix, int rows, int cols) {
	int* transposed = (int*)(malloc(sizeof(int) * (rows * cols)));
	int transposedIndex = 0;

	if (transposed == NULL) {
		printf("Error allocating transposed matrix!\n");
		return;
	}

	for (int column = 0; column < cols; column++) {
		for (int row = 0; row < rows; row++) {
			int index = getIndex(row, column, cols);
			transposed[transposedIndex] = matrix[index];
			transposedIndex++;
		}
	}

	for (int row = 0; row < rows; row++) {
		for (int column = 0; column < cols; column++) {
			int index = getIndex(row, column, cols);
			matrix[index] = transposed[index];
		}
	}
}

void multiplyByScalar(int* matrix, int rows, int cols, int scalar) {
	for (int row = 0; row < rows; row++) {
		for (int column = 0; column < cols; column++) {
			int index = getIndex(row, column, cols);
			matrix[index] *= scalar;
		}
	}
}

void sum(int* m1, int* m2, int* res, int rows, int cols) {
	for (int row = 0; row < rows; row++) {
		for (int column = 0; column < cols; column++) {
			int index = getIndex(row, column, cols);
			res[index] = m1[index] + m2[index];
		}
	}
}

int vectorScalarProduct(int* vec1, int* vec2, int dim) {
	int res = 0;

	for (int component = 0; component < dim; component++) {
		res += vec1[component] * vec2[component];
	}

	return res;
}

void mult(int* m1, int* m2, int* res, int m1_rows, int m1_cols, int m2_rows, int m2_cols) {
	if (m1_cols != m2_rows) {
		printf("Incompatible matrices!\n");
		return;
	}

	transposeMatrix(m1, m1_rows, m1_cols);
	int resIndex = 0;

	for (int m1_row = 0; m1_row < m1_rows; m1_row++) {
		for (int m2_row = 0; m2_row < m2_rows; m2_row++) {
			int index = (m1_row * m1_rows) + m2_row;
			res[resIndex] = vectorScalarProduct(m1 + m1_row, m2 + m2_row, m1_rows);
		}
	}
}

