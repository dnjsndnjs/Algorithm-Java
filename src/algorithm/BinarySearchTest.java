package algorithm;

import java.io.*;
import java.util.*;

public class BinarySearchTest {
	static int[] ia = {3, 11, 15, 20, 21, 29, 45, 59, 65, 72};
	
	public static void main(String[] args) throws Exception {
		System.out.println(Arrays.toString(ia));
		System.out.println(binarySearch(65));
		System.out.println(binarySearch(3));
		System.out.println(binarySearch(2));
		System.out.println(binarySearch(46));
		System.out.println(binarySearch(72));
		System.out.println("==============");
		System.out.println(binarySearch2(65));
		System.out.println(binarySearch2(3));
		System.out.println(binarySearch2(2));
		System.out.println(binarySearch2(46));
		System.out.println(binarySearch2(72));
		System.out.println("==============");
		System.out.println(Arrays.binarySearch(ia, 65));
		System.out.println(Arrays.binarySearch(ia, 3));
		System.out.println(Arrays.binarySearch(ia, 2));
		System.out.println(Arrays.binarySearch(ia, 4));
		System.out.println(Arrays.binarySearch(ia, 6));
		System.out.println(Arrays.binarySearch(ia, 12));
	}

	static int binarySearch(int key) {
		int start = 0, end = ia.length-1, mid = 0;
		while (start <= end) {
			mid = (start+end)/2;
				 if (ia[mid] == key)  return mid;
			else if (ia[mid] <  key) start = mid+1;
			else					   end = mid-1;
		}
		return -1;
	}
	
	static int binarySearch2(int key) {
		return binarySearch2(key, 0, ia.length-1);
	}
	static int binarySearch2(int key, int start, int end) {
		while (start <= end) {
			int mid = (start+end)/2;
				 if (ia[mid] == key) return mid;
			else if (ia[mid] <  key) return binarySearch2(key, mid+1, end);
			else					 return binarySearch2(key, start, mid-1);
		}
		return -1;
	}
	
}
