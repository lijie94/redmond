package com.redmond.coding.search;

import com.redmond.coding.GeneralUtils;

public class BMStringSearcher implements Searcher{

    /**
     * Returns the index within this string of the first occurrence of the
     * specified substring. If it is not a substring, return -1.
     * 
     * @param haystack The string to be scanned
     * @param needle The target string to search
     * @return The start index of the substring
     */
    public static int indexOf(char[] haystack, char[] needle) {
        if (needle.length == 0) {
            return 0;
        }
        
        return -1;
    }
    
    public static int[][] getBadCharacterLookupTable(char[] needle) {
    	final int ALPHABET_SIZE = 256;
        int[][] table = new int[ALPHABET_SIZE][needle.length];
        
        for (int i = 0;i<table.length;i++) {
        	for (int j = 0;j<needle.length;j++) {
        		table[i][j] = -1;
        	}
        }
        
        for (int j = 0;j<needle.length;j++) {
    		char ch = needle[j];
    		for (int p = j+1;p<needle.length;p++) {
    			table[ch][p] = j;
    		}
    	}
        
        return table;
    }
    
    public static int[] getGoodSuffixLLookupTable(char[] needle) {
    	int[] table = new int[needle.length];
    	
    	return table;
    }
    
    public static int[] getGoodSuffixHLookupTable(char[] needle) {
    	int[] table = new int[needle.length];
    	
    	return table;
    }
    

	@Override
	public int indexOf(String target, String pattern) {
		char[] haystack = target.toCharArray();
		char[] needle = pattern.toCharArray();
		return indexOf(haystack, needle);
	}	
	
	public static void main(String[] args) {

		{
			char[] needle = new char[]{'a','b','c','d','a','b','c','d','e'};
			int[][] table = getBadCharacterLookupTable(needle);
			for (int i = 0;i<table.length;i++) {
				char ch = (char)i;
				System.out.println("" + ch + " = " + GeneralUtils.toString(table[i]));
			}
		}
		
		Searcher searcher = new BMStringSearcher();
		
		{
			String target = "abcdefghijklmnabcdefg";
			String pattern = "def";
			
			int index = searcher.indexOf(target, pattern);
			System.out.println("index = " + index);
		}
		
		
		{
			String target = "aabbaabbaabbaaabbbaabbb";
			String pattern = "bbb";
			
			int index = searcher.indexOf(target, pattern);
			System.out.println("index = " + index);
		}
		
		{
			String target = "aabbaabbaabbaaabbbaabbb";
			String pattern = "bbbaaa";
			
			int index = searcher.indexOf(target, pattern);
			System.out.println("index = " + index);
		}
	}

}
