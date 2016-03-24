package com.redmond.coding.sort;

import java.util.ArrayList;
import java.util.List;

import com.redmond.coding.GeneralUtils;

public class RadixSort implements Sort{
	
	public RadixSort() {
		
	}
	
	public int getMax(int[] values) {
		int max = 0;
		for (int value : values) {
			if (value > max) {
				max = value;
			}
		}
		
		return max;
	}
	
	public void sortByDigit(int bit, int[] values) {
		int denominator = 1;
		for (int i = 0;i<bit;i++) {
			denominator *= 10;
		}
		List<List<Integer>> buckets = new ArrayList<List<Integer>>();
		for (int i = 0;i<10;i++) {
			buckets.add(new ArrayList<Integer>());
		}
		
		for (int value : values) {
			int bucket = value / denominator;
			bucket = bucket % 10; 
			List<Integer> mybuckets = buckets.get(bucket);
			mybuckets.add(value);
		}
		
		int i = 0;
		for (List<Integer> bucket : buckets) {
			for (int j = 0;j<bucket.size();j++) {
				values[i++] = bucket.get(j);
			}
		}
	}
	
	public void sort(int[] values) {
		int max = getMax(values);
		int maxBit = 0;
		while (max > 0) {
			max /= 10;
			maxBit ++;
		}
		
		for (int bit = 0;bit<=maxBit;bit++) {
			sortByDigit(bit, values);
		}
	}

	public static void main(String[] args) {
		
		Sort sort = new RadixSort();

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
