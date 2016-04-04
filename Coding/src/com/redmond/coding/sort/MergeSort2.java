package com.redmond.coding.sort;

import com.redmond.coding.GeneralUtils;

public class MergeSort2 implements Sort{
	
	private static void Merge(int[] intList, int[] tmpList, int left, int leftEnd, int right, int rightEnd) {
		int l=left; int r=right;
		int s=left;
		while (true) {
			if (intList[l]<=intList[r]) {
				tmpList[s++] = intList[l++];	//Left is smaller or equal, put Left down and move to next Left
				if (l>leftEnd) {
					break;
				}
			} else {
				tmpList[s++] = intList[r++];	//Right is smaller, put Right down and move to next Right
				if (r>rightEnd) {
					break;
				}
			}
		}
		while (l <= leftEnd) {
			tmpList[s++] = intList[l++];
		}
		
		while (r <= rightEnd) {
			tmpList[s++] = intList[r++];
		}
		
		System.arraycopy(tmpList, left, intList, left, (rightEnd-left+1));
	}

	
	
	private static void Sort(int[] intList, int[] tmpList, int start, int end) {
//		int len = end-start;
		if (start == end) 	//the list has been broken down to 1 element
			return;
				
		int middle = (start+end) / 2;
		int start2 = middle + 1;
		Sort(intList, tmpList, start, middle);
		Sort(intList, tmpList, start2, end);
		
		Merge(intList, tmpList, start, middle, start2, end);
		
		
//		
//		for (int i=start; i<=end; i++)
//			intList[i] = tmpList[i];
	}

	public void sort(int[] intList) {
		int len = intList.length;
		int[] tmpList = new int[len];
		Sort(intList, tmpList, 0, len-1);
	}

	public static void main(String[] args) {

		Sort sort = new MergeSort2();
		
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
