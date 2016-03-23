package com.redmond.coding.sort;

import com.redmond.coding.GeneralUtils;

public class BubbleSort implements Sort{
	
	public void sort(int[] values) {
		for (int j = values.length; j >= 2; j--) {
			for (int i = 0; i < (j-1); i++) {
				if (values[i] > values[i+1]) {
					int tmp = values[i];
					values[i] = values[i+1];
					values[i+1] = tmp;
				}
			}
		}
	}

	public static void main(String[] args) {
		
		Sort sort = new BubbleSort();

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
