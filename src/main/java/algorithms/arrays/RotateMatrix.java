package algorithms.arrays;

import java.util.Arrays;

/**
 * Not done Yet
 *
 * Created by vasanthakumarsubramanian on 1/7/17.
 */
public class RotateMatrix {
    static int size=3;;
    static int[][] m=new int[size][size];

    public static void main(String[] args) {

        initMatrix();
//        printMatrix();

        //rotate
        for(int row=0;row<=size/2;row++){
            for(int col=0;col<=size/2;col++) {
                //tl = top left
                //tr = top right
                //bl = bottom left
                //br = bottom right

                int tl = m[col][row];
                int tr = m[size - 1 - col][row];
                int br = m[size - 1 - col][size - 1 - col];
                int bl = m[size - 1 - col][row];

                m[col][size - 1 - col] = tl;
                m[size - 1 - col][size - 1 - col] = tr;
                m[size - 1 - col][col] = br;
                m[col][col] = bl;

                printMatrix();
            }
        }
    }

    static void printMatrix(){
        System.out.println();
        for(int i=0;i<size;i++) {
            System.out.println(Arrays.toString(m[i]));
        }
    }

    static void initMatrix(){
        int init=0;
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                m[i][j]=init;
                init++;
            }
        }
    }
}
