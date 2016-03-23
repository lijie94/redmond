package com.redmond.coding.sort;

import java.util.Random;

import com.redmond.coding.GeneralUtils;

public class QuickSort implements Sort {

	public static Random random = new Random(System.currentTimeMillis());

	public static void sort(int[] values, int start, int end) {
		int len = end - start + 1;
		if (len <= 1) {
			return;
		}

		// 1. find a pivot value ans swap it with the first one
		int pivotIndex = random.nextInt(len) + start;
		int pivot = values[pivotIndex];
		if (pivotIndex != start) {
			values[pivotIndex] = values[start];
			values[start] = pivot;
		}
		int bigPointer = end;
		int pointer = start + 1;

		// 2. split the array, when we start out, [start, pointer - 1] is the part
		// less or equal than pivot, [pointer, end] is the part bigger than
		// pivot
		while (true) {
			if (values[pointer] > pivot) {
				do {
					if (pointer == bigPointer) {
						bigPointer --;
						break;
					}
					
					int tmp = values[pointer];
					values[pointer] = values[bigPointer];
					values[bigPointer] = tmp;
					bigPointer--;
				} while (values[pointer] > pivot);
			} else {
				pointer++;
			}			
			if (pointer > bigPointer) {
				break;
			}
		}
		if (pointer > end) {
			// swap the first one and the last one
			values[start] = values[end];
			values[end] = pivot;
			pointer--;
		}

		// 3. sort 2 splitted array
		if (pointer - 1 > start) {
			sort(values, start, pointer - 1);
		}
		if (pointer < end) {
			sort(values, pointer, end);
		}
	}

	public void sort(int[] values) {
		sort(values, 0, values.length - 1);
	}

	public static void main(String[] args) {

		Sort sort = new QuickSort();

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
			int[] test = { 1, 300, 4, 6, 7, 100, 2, 10, 5, 10102, 0, 504, 80,
					34, 28 };
			sort.sort(test);
			System.out.println("res = " + GeneralUtils.toString(test));
		}

		{
			int[] test = { 1, 300, 4, 6, 7, 100, 2, 10, 5, 10102, 0, 504, 80,
					34, 28, 50000 };
			sort.sort(test);
			System.out.println("res = " + GeneralUtils.toString(test));
		}

	}

}
