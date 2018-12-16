package com.svit.java.l4;

public class quickSort {

	public static void main(String[] args) {
		int[] A = {2,6,1,0,89,87,43,21};
		quickSort(A, 0, A.length-1);
		
		for(int i=0;i<A.length;i++) {
			System.out.println(A[i]);
		}

	}
	
	public static void quickSort(int[] A, int start, int end) {
		
		if(start>=end) {
			return;
		}
		
		int index = start+(end-start)/2;
		int pivot = A[index];
		int left = start;
		int right = end;
		while(left<=right) {
			
			while(left<=right && A[left]<pivot ) {
				left++;
			}
			
			while(left<=right && A[right]>pivot) {
				right--;
			}
			
			if(left<=right) {
				
				int temp= A[left];
				A[left] = A[right];
				A[right] = temp;
				left++;
				right--;
			}
		}
		
		quickSort(A, start, right);
		quickSort(A, left, end);
	}
}
