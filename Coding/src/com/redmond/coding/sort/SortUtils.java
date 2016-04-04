package com.redmond.coding.sort;

import java.util.Random;

import com.redmond.coding.GeneralUtils;

public class SortUtils {

	public static int[] generateRandomArray(int len, int max) {
		int[] res = new int[len];

		Random rand = new Random(System.currentTimeMillis());
		for (int i = 0; i < len; i++) {
			res[i] = rand.nextInt(max + 1);
		}

		return res;
	}

	public static void run(Sort sort, int[] array, int repeat) {
		int[] copy = new int[array.length];
		for (int i = 0; i < repeat; i++) {
			System.arraycopy(array, 0, copy, 0, array.length);
			sort.sort(copy);
		}
		
		check(sort, copy);
	}

	public static long benchmark(Sort sort, int[] array, int repeat) {
		long t0 = System.currentTimeMillis();
		run(sort, array, repeat);
		long t1 = System.currentTimeMillis();
		
		return t1 - t0;
	}
	
	public static void check(Sort sort, int[] array) {
		for (int i = 0;i<array.length-1;i++) {
			if (array[i] > array[i+1]) {
				System.out.println(sort.getClass() + " error, index = " + i + ", array = " + GeneralUtils.toString(array));
			}
		}
	}

	public static void main(String arg[]) {

		int c = 10;
		int l = 1000;
		int m = 100000;
		int r = 100;

		Sort[] sorts = new Sort[] { new BubbleSort(), new MergeSort2(), new MergeSort(), new HeapSort(), new QuickSort(), new BucketSort(m/100, new HeapSort()), new RadixSort() };
		long[] millis = new long[sorts.length];

		for (int i = 0; i < c; i++) {
			int[] array = generateRandomArray(l, m);

			for (int s = 0; s < sorts.length; s++) {
				millis[s] += benchmark(sorts[s], array, r);
			}
		}

		for (int s = 0; s < sorts.length; s++) {
			Sort sort = sorts[s];
			long milli = millis[s];
			long count = c * r;
			float average = milli * 1.0f / count;

			System.out.println("" + sort.getClass() + " used " + milli
					+ " ms for sorting " + c + " arrays(len=" + l + ") " + r
					+ " times. Average time = " + average + " ms.");
		}
	}
}
