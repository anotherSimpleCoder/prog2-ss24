import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.Matrix;

public class MatrixTests {
    private Matrix<Integer> testMatrix;
    private Matrix<Integer> testMatrix2;

    @BeforeEach
    private void setUp() {
        this.testMatrix = new Matrix<>(2, 2);
        this.testMatrix2 = new Matrix<>(2, 2);
    }

    @Test
    public void testSetAndGet() {
        int x = 0;

        for(int i = 0; i < testMatrix.getRows(); i++) {
            for(int j = 0; j < testMatrix.getColumns(); j++) {
                testMatrix.set(x, i, j);
                x++;
            }
        }

        x = 0;
        for(int i = 0; i < testMatrix.getRows(); i++) {
            for(int j = 0; j < testMatrix.getColumns(); j++) {
                assertEquals(x, testMatrix.get(i, j));
                x++;
            }
        }
    }

    @Test
    public void testAdd() {
        int x = 0;
        for(int i = 0; i < testMatrix.getRows(); i++) {
            for(int j = 0; j < testMatrix.getColumns(); j++) {
                testMatrix.set(x, i, j);
                testMatrix2.set(x, i, j);
                x++;
            }
        }

        Matrix<? extends Number> sum = testMatrix.add(testMatrix2);
        x = 0;
        for(int i = 0; i < testMatrix.getRows(); i++) {
            for(int j = 0; j < testMatrix.getColumns(); j++) {
                assertEquals((double)x+x, sum.get(i, j));
                x++;
            }
        }
    }

    @Test
    public void testScale() {
        int x = 0;
        for(int i = 0; i < testMatrix.getRows(); i++) {
            for(int j = 0; j < testMatrix.getColumns(); j++) {
                testMatrix.set(x, i, j);
                x++;
            }
        }

        Matrix<? extends Number> scaledMatrix = testMatrix.scale(3);
        x = 0;
        for(int i = 0; i < testMatrix.getRows(); i++) {
            for(int j = 0; j < testMatrix.getColumns(); j++) {
                assertEquals((double)3*x, scaledMatrix.get(i, j));
                x++;
            }
        }
    }
    

}
