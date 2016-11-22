package algorithms.sort.merge;

import java.util.Arrays;

public class PracticeMergeSort {

	public static void main(String[] args) {
		int[] a={2,6,4,9,5,0};
		int[] aux=new int[a.length];
		sort(a,aux,0,a.length-1);
		System.out.println(Arrays.toString(a));
	}
	static void sort(int[] a,int[] aux,int lo, int hi){
		if(lo>=hi){
			return;
		}
		int mid=lo+((hi-lo)/2);
		sort(a,aux,lo, mid);
		sort(a,aux,mid+1,hi);
		merge(a,aux,lo,hi,mid);
	}
	static void merge(int[] a,int[] aux,int lo,int hi,int mid){
		for(int x=lo;x<=hi;x++){
			aux[x]=a[x];
		}
		int i=lo;
		int j=mid+1;
		
		for(int k=lo;k<=hi;k++){
			if(i>mid){
				a[k]=aux[j++];
				continue;
			}
			if(j>hi){
				a[k]=aux[i++];
				continue;
			}
			if(aux[i]<aux[j]) {
				a[k]=aux[i++];
			} else{
				a[k]=aux[j++];
			}
		}
		
	}
}
