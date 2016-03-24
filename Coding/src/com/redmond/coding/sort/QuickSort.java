package com.redmond.coding.sort;

import java.util.Random;

import com.redmond.coding.GeneralUtils;

public class QuickSort implements Sort {

	public static Random random = new Random(System.currentTimeMillis());

	public static void sort(int[] values, int start, int end) {
		if (start == end) {
			return;
		}
		long p = partition(values, start, end);
		int equalPartitionStart = (int)(p >> 32);
		int bigPartitionPointer = (int)(p & 0xffffffff); 
		if (equalPartitionStart-1 > start) {
			sort(values, start, equalPartitionStart-1);
		}
		if (bigPartitionPointer == start) {
			System.out.println("wrong, start = " +start + ", end = " + end + ", bigPartitionPointer = " + bigPartitionPointer + ", equalPartitionStart= " + equalPartitionStart + ", values = " + GeneralUtils.toString(values) + "");
			throw new IllegalStateException("");
		}
		if (bigPartitionPointer < end) {
			sort(values, bigPartitionPointer, end);
		}
	}
	
	
	public static long partition(int[] values, int start, int end) {
		assert(end > start);
		int len = end - start + 1;

		// 1. find a pivot value and swap it with the last one
		int pivotIndex = random.nextInt(len) + start;
		int pivot = values[pivotIndex];
		if (pivotIndex != end) {
			values[pivotIndex] = values[end];
			values[end] = pivot;
		}
		int bigPartitionPointer = start;
		int equalPartitionStart = end;
		int j = start;

		// 2. split the array
		while (j<equalPartitionStart) {
			if (values[j] < pivot) {
				int tmp = values[bigPartitionPointer];
				values[bigPartitionPointer] = values[j];
				values[j] = tmp;
				bigPartitionPointer++;
				j++;
			} else if (values[j] == pivot) {
				equalPartitionStart --;
				values[j] = values[equalPartitionStart];
				values[equalPartitionStart] = pivot;
			} else {
				j++;
			}
		}

		// 3. move big partition to the end
		if (equalPartitionStart > bigPartitionPointer) {
			int lenOfEqualPartition = end - equalPartitionStart + 1;
			int lenOfBigPartition = equalPartitionStart - bigPartitionPointer;
			int needToMove = Math.min(lenOfEqualPartition, lenOfBigPartition);
			for (int i = 0;i<needToMove;i++) {
				int b = bigPartitionPointer + i;
				int e = end - i;
				values[e] = values[b];
				values[b] = pivot;
			}
			equalPartitionStart = bigPartitionPointer;
			bigPartitionPointer = end - lenOfBigPartition + 1;
		} else if (equalPartitionStart == bigPartitionPointer) {
			bigPartitionPointer = end + 1;
		}
		
//		values[end] = values[bigPartitionPointer];
//		values[bigPartitionPointer] = pivot;
		
		long res = (long)bigPartitionPointer | (((long)equalPartitionStart) << 32);
		return res;
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
		
		{
			int[] test = new int[10000];
			for (int i = 0;i<test.length;i++) {
				test[i] = 100;
			}
			sort.sort(test);
			System.out.println("res = " + GeneralUtils.toString(test));
		}

	}

}
