package com.example;

public class Matrix <T extends Number> {
    private int columns;
    private int rows;
    private T[][] matrix;

    public Matrix(int rows, int columns) {
        this.columns = columns;
        this.rows = rows;
        this.matrix = (T[][])new Number[rows][columns];
    }

    public void set(T value, int i, int j) throws IllegalArgumentException {
        if(i >= rows || j >= columns || i < 0 || j < 0) {
            throw new IllegalArgumentException();
        }

        this.matrix[i][j] = value;
    }

    public T get(int i, int j) throws IllegalArgumentException {
        if(i >= rows || j >= columns || i < 0 || j < 0) {
            throw new IllegalArgumentException();
        }

        return this.matrix[i][j];
    }


    public Matrix<? extends Number> add(Matrix<? extends Number> b) throws IllegalArgumentException {
        if(this.rows != b.getRows() || this.columns != b.getColumns()) {
            throw new IllegalArgumentException();
        }

        Matrix<Double> res = new Matrix<>(rows, columns);
        for(int i = 0; i < this.rows; i++) {
            for(int j = 0; j < this.columns; j++) {
                double sum = this.get(i,j).doubleValue() + b.get(i, j).doubleValue();
                res.set(sum, i, j);
            }
        }

        return res;
    }

    public Matrix<? extends Number> scale(T scale) {
        Matrix<Double> res = new Matrix<>(this.rows, this.columns);
        
        for(int i = 0; i < this.rows; i++) {
            for(int j = 0; j < this.columns; j++) {
                double product = this.get(i,j).doubleValue() * scale.doubleValue();
                res.set(product, i, j);
            }
        }

        return res;
    }

    public void print() {
        for(int i = 0; i < this.rows; i++) {
            for(int j = 0; j < this.columns; j++) {
                System.out.println(this.get(i, j));
            }
            System.out.println();
        }
    }

    public int getColumns() {
        return columns;
    }

    public int getRows() {
        return rows;
    }
}
