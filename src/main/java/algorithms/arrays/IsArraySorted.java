package algorithms.arrays;

/**
 * Created by vasanthakumarsubramanian on 1/13/17.
 */
public class IsArraySorted {
    public static void main(String[] args) {
//        int[] input =new int[]{2,5,1,9,30,6,34,23};
        int[] input=new int[]{1,2,3,4,5,6,7,8};


        for(int i=0;i<input.length-1;i++){
            if(input[i]>input[i+1]){
                System.out.println("not sorted");
                return;
            }
        }
        System.out.println("Sorted");
    }
}
