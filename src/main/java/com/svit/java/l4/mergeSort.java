package com.svit.java.l4;

public class mergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] A= {3,1,6,7,1,3,4,78,56,12};
		int leng = A.length;
		int[] temp = new int[leng];
		mergeSort(A, 0, leng-1 , temp);
		for(int i=0;i<leng;i++) {
			System.out.println(A[i] );
		}
	}
	
	public static void mergeSort(int[] A, int start, int end, int[] temp) {
		
		if(start>=end) {
			return;
		}
		
		int left = start, right = end;
		int mid = left+(right-left)/2;
		mergeSort(A, start, mid, temp );
		mergeSort(A, mid+1, end, temp);
		merge(A, start, mid, end, temp);
	}
	
	public static void merge(int[] A, int start, int mid, int end, int[] temp ) {
		
		int left = start;
		int right = mid+1;
		int index = start;
		
		while(left<=mid && right<=end ) {
			
			if(A[left]< A[right]) {
				temp[index++] = A[left++];
			}else {
				temp[index++] = A[right++];
			}
		}
		
		while(left<=mid) {
			temp[index++] = A[left++];
		}
		
		while(right<=end) {
			temp[index++] = A[right++];
		}
		
		for(int i=start;i<=end;i++) {
			A[i] = temp[i];
			
		}
		
		
		
		
		
		
		
		
	}
	
	
	

}
