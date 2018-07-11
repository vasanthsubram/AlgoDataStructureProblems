package algorithms.arrays;

import java.util.Arrays;


public class RotateMatrix {
    static int size=4;
    static int[][] source =new int[size][size];

    public static void main(String[] args) {
        initMatrix();
        printMatrix(source);
        int[][] result=clockwise();
        System.out.println();
        System.out.println("clockwise");
        printMatrix(result);
        int[][] result2=anticlockwise();
        System.out.println();
        System.out.println("anti-clockwise");
        printMatrix(result2);
    }

    static int[][] anticlockwise(){
        int[][] result=new int[size][size];
        for(int row=0;row<size;row++){
            for(int col=0;col<size;col++) {
                result[size-col-1][row]= source[row][col];
            }
        }
        return result;
    }

    static int[][] clockwise(){
        int[][] result=new int[size][size];
        for(int row=0;row<size;row++){
            for(int col=0;col<size;col++) {
                result[col][size-row-1]= source[row][col];
            }
        }
        return result;
    }


    static void printMatrix(int[][] matrix){
        for(int i=0;i<size;i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    static void initMatrix(){
        int init=0;
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                source[i][j]=init;
                init++;
            }
        }
    }
}
