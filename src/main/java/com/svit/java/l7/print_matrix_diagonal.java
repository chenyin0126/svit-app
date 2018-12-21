package com.svit.java.l7;

import java.util.ArrayList;
import java.util.List;

public class print_matrix_diagonal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] matrix = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };

		List<List<Integer>> arr = helper(matrix);
		System.out.println(arr);

	}

	public static List<List<Integer>> helper(int[][] matrix) {

		List<List<Integer>> res = new ArrayList<>();

		if (matrix.length == 0) {
			return res;
		}

		int m = matrix.length;
		int n = matrix[0].length;
		int r = 0;
		int c = 0;
		int j = 0;
		int i = 0;
		while (c < n) {
			List<Integer> list = new ArrayList<>();
			int end = c;
			j=c;
			for (i = 0; i <= end && j>=0; i++) {
				list.add(matrix[i][j--]);
			}
			res.add(list);
			c++;
		}
		i = 0;
		j = 0;
		r++;
		while (r < m) {
			List<Integer> list = new ArrayList<>();
			int end = r;
			i=r;
			for (j = n - 1; j >= end && i<m; j--) {
				list.add(matrix[i++][j]);
			}
			res.add(list);
			r++;
		}
		return res;

	}

}
