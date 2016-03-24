package com.redmond.coding.sort;

import com.redmond.coding.GeneralUtils;

public class HeapSort implements Sort{
	
	public void heapify(int[] values) {
		int len = values.length;
		int start = (len-2) / 2;
		int end = len - 1;
		
		while (start >= 0) {
			siftDown(values, start, end);			
			start --;
		}
	}
	
	public void siftDown(int[] values, int start, int end) {
		int root = start;
		
		while (root < end) {
			int left = root * 2 + 1;
			if (left > end) {
				break;
			}
			int right = root * 2 + 2;
			boolean smallerThanLeft = values[root] < values[left];
			boolean smallerThanRight = right > end ? false : (values[root] < values[right]);
			if (!smallerThanLeft && !smallerThanRight) {
				break;
			}
			if (smallerThanLeft && smallerThanRight) {
				smallerThanRight = values[left] < values[right];
			}
			int tmp = values[root];
			if (smallerThanRight) {
				values[root] = values[right];
				values[right] = tmp;
				root = right;
			} else {
				values[root] = values[left];
				values[left] = tmp;
				root = left;
			}
		}
		
		// System.out.println("siftDown start = " + start + ", end = " + end + ", res = " + GeneralUtils.toString(values));
	}

	public void sort(int[] values) {
		heapify(values);
		
		int pointer = values.length - 1;
		while (true) {
			// swap the first one and point
			int tmp = values[0];
			values[0] = values[pointer];
			values[pointer] = tmp;
			
			pointer --;
			if (pointer <= 0) {
				break;
			}
			siftDown(values, 0, pointer);
		}
	}

	public static void main(String[] args) {

		Sort sort = new HeapSort();
		
		{
			int[] test = { 4, 6, 2, 10, 5 };
			sort.sort(test);
			System.out.println("res = " + GeneralUtils.toString(test));			
		}
		
		
		{
			int[] test = { 1, 300, 4, 6, 7, 100, 2, 10, 5, 10102, 0, 504 };
			sort.sort(test);
			System.out.println("res = " + GeneralUtils.toString(test));			
		}
		
		{
			int[] test = { 1, 300, 4, 6, 7, 100, 2, 10, 5, 10102, 0, 504, 80, 34, 28 };
			sort.sort(test);
			System.out.println("res = " + GeneralUtils.toString(test));			
		}
		
		{
			int[] test = { 1, 300, 4, 6, 7, 100, 2, 10, 5, 10102, 0, 504, 80, 34, 28, 50000 };
			sort.sort(test);
			System.out.println("res = " + GeneralUtils.toString(test));			
		}

	}

}
