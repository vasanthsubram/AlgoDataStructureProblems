package algorithms.arrays;

import java.util.HashSet;
import java.util.Set;

public class ZeroMatrix {
    static int M=5, N=4;
    static int[][] source =new int[M][N];

    public static void main(String args[]){
        initMatrix();
        source[1][3]=0;
        source[3][1]=0;
        printMatrix(source);
        Set<Integer> zeroRows=new HashSet<>();
        Set<Integer> zeroCols=new HashSet<>();
        findZeros(zeroRows,zeroCols);

        for(Integer i: zeroRows){
            zeroRow(i);
        }
        for(Integer i: zeroCols){
            zeroColumn(i);
        }
        System.out.println();
        printMatrix(source);
    }

    static void findZeros(Set<Integer> zeroRows, Set<Integer> zeroCols){
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                if(source[i][j]==0) {
                    zeroRows.add(i);
                    zeroCols.add(j);
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

    static void printMatrix(int[][] matrix){
        for(int i=0;i<M;i++) {
            for(int j=0;j<N;j++) {
                System.out.print(matrix[i][j]);
                System.out.print("\t");
            }
            System.out.println();
        }
    }
}
