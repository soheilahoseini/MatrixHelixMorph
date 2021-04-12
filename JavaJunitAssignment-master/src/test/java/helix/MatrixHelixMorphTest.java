package helix;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MatrixHelixMorphTest {


    /** Check if two integer matrices have the same contents
     *
     * @param matrix1
     * @param matrix2
     * @return true if the contents of matrix1 and matrix2 are identical and false otherwise
     *
     *
     */

    public static boolean testEqual(int[][] matrix1, int[][] matrix2) {
        /*
            Basic sanity checking:
                Verify that lengths are equal
         */

        if (matrix1 == null || matrix2 == null) {
            return true;
        }
        if (matrix1.length != matrix2.length) {
            return false;
        }
        if (matrix1[0].length != matrix2[0].length) {
            return false;
        }

        /*
            Test the contents of the matrices
         */
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                if (matrix1[i][j] != matrix2[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

    @Test
    public void test2x2() {
        int[][] inMatrix  = { {1, 2}, {3, 4} };
        int[][] expOutput = { {1, 2}, {4, 3} };
        assertTrue(testEqual(expOutput, MatrixHelixMorph.helix(inMatrix)));
    }

    @Test
    public void test1x1() {
        int[][] inMatrix  = { {1} };
        int[][] expOutput = { {1} };
        assertTrue(testEqual(expOutput, MatrixHelixMorph.helix(inMatrix)));
    }

    @Test
    public void test3x1() {
        int[][] inMatrix  = { {1,0,0},{0,1,0},{0,0,1} };
        int[][] expOutput = { {1,0,0},{0,1,0},{0,0,1} };
        assertTrue(testEqual(expOutput, MatrixHelixMorph.helix(inMatrix)));
    }

    @Test
    public void test3x3() {
        int[][] inMatrix  = { {1,2,3},{4,5,6},{7,8,9} };
        int[][] expOutput = { {1,2,3},{8,9,4},{7,6,5} };
        assertTrue(testEqual(expOutput, MatrixHelixMorph.helix(inMatrix)));
    }

    @Test
    public void test4x5() {
        int[][] inMatrix  = { {7,5,1,4,6},{3,2,9,1,8},{8,3,2,4,1},{10,11,15,19,14} };
        int[][] expOutput = { {7,5,1,4,6},{4,1,10,11,3},{2,14,19,15,2},{3,8,8,1,9} };
        assertTrue(testEqual(expOutput, MatrixHelixMorph.helix(inMatrix)));
    }

    @Test
    public void test3x6() {
        int[][] inMatrix  = { {1,2,3,4,5,6},{7,8,9,10,11,12},{13,14,15,16,17,18} };
        int[][] expOutput = { {1,2,3,4,5,6},{14,15,16,17,18,7},{13,12,11,10,9,8} };
        assertTrue(testEqual(expOutput, MatrixHelixMorph.helix(inMatrix)));
    }


}
