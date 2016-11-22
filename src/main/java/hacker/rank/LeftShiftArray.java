package hacker.rank;

import java.util.Scanner;

/**
 * Created by vasanth on 11/20/16.
 */
public class LeftShiftArray {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();

        int a[] = new int[n];
        for(int i=0; i < n; i++){
            a[i] = in.nextInt();
        }

        int x[] =new int[k];
        for(int i=0;i<=k-1;i++){
            x[i]=a[i];
        }
        for(int i=0; i <= n-k-1; i++){
            a[i]=a[i+k];
        }
        for(int i=0;i<=k-1;i++){
            a[n-k+i]=x[i];
        }

        for(int i=0; i < n; i++){
            System.out.print(a[i] + " ") ;
        }
    }
}