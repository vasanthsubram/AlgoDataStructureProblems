package algorithms.arrays;

import junit.framework.Test;
import utils.TestUtils;

/*
Same as ZeroMatrix but not using additional storage for storing locations of zeros
 */
public class ZeroMatrix2 {
    static int M=5, N=4;
    static int[][] source =new int[M][N];

    public static void main(String args[]){
        initMatrix();
        source[1][3]=0;
        source[3][1]=0;
        TestUtils.printMatrix(source);

        findZeros();

        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                if(source[i][j]==-1) {
                    zeroRow(i);
                    zeroColumn(j);
                }
            }
        }
        System.out.println();
        TestUtils.printMatrix(source);
    }

    static void findZeros(){
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                if(source[i][j]==0) {
                    source[i][j]=-1;
                }
            }
        }
    }
    static void zeroRow(int row){
        for(int i=0;i<N;i++){
            source[row][i]=0;
        }
    }
    static void zeroColumn(int col){
        for(int i=0;i<M;i++){
            source[i][col]=0;
        }
    }
    static void initMatrix(){
        int init=0;
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                source[i][j]=init;
                init++;
            }
        }
    }


}
