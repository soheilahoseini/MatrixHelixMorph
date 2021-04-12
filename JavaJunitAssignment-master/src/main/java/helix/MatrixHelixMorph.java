package helix;

import java.util.Arrays;

public class MatrixHelixMorph {

    /**
     * @param inMatrix
     * @return a matrix that is morphed into a helix version of inMatrix
     */

    public static int[][] helix( int[][] inMatrix) {

        int rows = inMatrix.length;
        int cols = inMatrix[0].length;

        if(Math.abs(rows-cols)>1){
            if(rows>cols){
                cols++;
                for(int i=0;i<rows;i++){
                    inMatrix[cols][i]=0;
                }
            }else {
                rows++;
                for(int i=0;i<cols;i++){
                    inMatrix[rows][i]=0;
                }
            }
        }

        //spiral array
        int spiral[][] = new int[rows][cols];
        //one dimentional array
        int array1D[]=new int[rows * cols] ;

        //convert inMatrix to one dimensional array
        array1D = convert(inMatrix,rows,cols);

        //call method to convert one dimensional array to an spiral matrix
        ToSpiral(rows, cols, array1D, spiral);
        return spiral;
    }

    // method to convert one dimensional array to an spiral matrix
    static void ToSpiral(int endRow, int endCol, int array1D[], int spiral[][]) {
        
        int index = 0;
        int startRow = 0, startCol = 0;
        //start from one corner of matrix
        while (startRow < endRow && startCol < endCol) {
            //from col left to column right
            for (int i = startCol; i < endCol; ++i) {
                spiral[startRow][i] = array1D[index];
                index++;
            }//end for startCol
            startRow++;

            //from row top to row buttom
            for (int i = startRow; i < endRow; ++i) {
                spiral[i][endCol - 1] = array1D[index];
                index++;
            }//end for startRow
            endCol--;

            if (startRow < endRow) {
                //backward from column right
                for (int i = endCol - 1; i >= startCol; --i) {
                    spiral[endRow - 1][i] = array1D[index];
                    index++;
                }//end for endCol
                endRow--;
            }//end if

            if (startCol < endCol) {
                //backward from row buttom
                for (int i = endRow - 1; i >= startRow
                        ; --i) {
                    spiral[i][startCol] = array1D[index];
                    index++;
                }//end for endRow
                startCol++;
            }//end if
        }//end while
    }//end ToSpiral

    //convert inMatrix to one dimensional array
    public static int[] convert(int array2D[][], int rows, int cols) {

        int index = 0;
        int array1D[] = new int[rows * cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                array1D[index] = array2D[i][j];
                index++;
            }
        }
        return array1D;
    }
//
//    static boolean isEqual(int[][]m1,int[][] m2)
//    {
//        boolean flag=true;
//        for (int i = 0; i < m1.length; i++) {
//            for (int j = 0; j < m1[0].length; j++) {
//                System.out.println(m1[i][j]+" "+m2[i][j]);
//                if (m1[i][j] != m2[i][j]) {
//                    flag=false;
////                    break;
//                }
//            }
//        }
//        return flag;
//    }
}