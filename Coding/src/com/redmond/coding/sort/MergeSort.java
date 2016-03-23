package com.redmond.coding.sort;

import com.redmond.coding.GeneralUtils;

public class MergeSort implements Sort{
	
	public static void merge(int[] values, int[] mem, int start1, int end1,
			int start2, int end2) {
		int p1 = start1, p2 = start2, p = start1;
		while (true) {
			if (values[p1] <= values[p2]) {
				mem[p++] = values[p1++];
				if (p1 > end1) {
					break;
				}
			} else {
				mem[p++] = values[p2++];
				if (p2 > end2) {
					break;
				}
			}
		}

		while (p1 <= end1) {
			mem[p++] = values[p1++];
		}
		while (p2 <= end2) {
			mem[p++] = values[p2++];
		}
		System.arraycopy(mem, start1, values, start1, end2 - start1 + 1);
	}

	public static void sort(int[] values, int[] mem, int start, int end) {
		int length = end - start + 1;
		if (length == 1) {
			return;
		}

		int half = length / 2;
		int start1 = start;
		int end1 = start + half - 1;

		int start2 = end1 + 1;
		int end2 = end;
		sort(values, mem, start1, end1);
		sort(values, mem, start2, end2);

		merge(values, mem, start1, end1, start2, end2);
	}

	public void sort(int[] values) {
		sort(values, new int[values.length], 0, values.length - 1);
	}

	public static void main(String[] args) {

		Sort sort = new MergeSort();
		
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

	}

}
