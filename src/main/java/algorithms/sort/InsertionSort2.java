package algorithms.sort;


public class InsertionSort2 {

    public static void insertionSortPart2(int[] arr){       
        
        int NUM = arr.length;
        
        for(int j=1;j<NUM;j++){
        	 boolean flag = false;
        	 
              //assuming this as unsorted value
             int val = arr[j];
            
            for(int i=j-1;i>=0;i--){
                if(arr[i]>=val){
                  //move a[i] down
                  arr[i+1]=arr[i];
                } else{
                	//insert after a[i]
                    arr[i+1]=val;
                    flag = true;
                    printArray(arr);
                     break;
                }     
             }
            if(!flag){
             arr[0]=val;
             printArray(arr);
            }
        }
    }  
    
    public static void main(String[] args) {

       int[] arr = new int[]  {9,8,6,7,3,5,4,1,2};

       insertionSortPart2(arr);    
       printArray(arr);             
    }    
    private static void printArray(int[] arr) {
      for(int n: arr){
         System.out.print(n+" ");
      }
        System.out.println("");
   }
}