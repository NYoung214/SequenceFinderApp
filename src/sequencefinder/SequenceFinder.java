package sequencefinder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SequenceFinder {

	private int maxLen = 0;
	private int maxCount = 0;
	
	private List<String> finalArray = new ArrayList<>();
	
	private void printLongest() {
		System.out.println();
		if(maxLen == 0) {
			System.out.println("There is not a non-consecutive increasing subsequence.");
		}else if(maxLen == 1) {
			findUnique();			
		}else {
			System.out.println("There are ("+maxCount+") non-consecutive increasing subsequences with a length of "+maxLen+":");
			int i = 0;
			for(String line : finalArray) {
				if(line.split(" ").length >= maxLen) {
					System.out.printf("%3d:\t",i+1);
					printTest(line);
					i++;
				}
			}
		}


			

	}
	
	public void findLIS(String array) {
		String[] numArray = array.split(" ");
		int len = numArray.length;
		StringBuilder line = new StringBuilder();
		for(int k =0; k<len-1; k++) {				// K LOOP
			
			
			
			for(int i=k+1; i<len; i++) {			// I LOOP
				line.append(numArray[k] + " ");
				if(Integer.parseInt(numArray[i]) > Integer.parseInt(numArray[k])) {
					
					line.append(numArray[i] + " ");
					
					int max = Integer.parseInt(numArray[i]);						
					for(int j=i+1; j<len; j++) {	// J LOOP
						if(max < Integer.parseInt(numArray[j])) {
							line.append(numArray[j] + " ");
							max = Integer.parseInt(numArray[j]);
						}
					}// END J LOOP
				}
				findLongest(line.toString().trim());
				line.delete(0,line.length());				
			}// END I LOOP
		}// END K LOOP
		line.append(numArray[numArray.length-1]);
		findLongest(line.toString().trim());
		printLongest();
	}
	
	private void findLongest(String line) {
		String[] array = line.split(" ");
		int len = array.length;
		if(len >= maxLen) {
			finalArray.add(line);
			maxCount++;
			if(len > maxLen) {
				maxLen = len;
				maxCount = 1;
			}
		}
	}
	
	private void printTest(String line) {
		String[] array = line.split(" ");
		for(String num : array) {
			System.out.printf("%4s ",num);
		}
		System.out.println();
	}
	
	private void findUnique() {
		Set<String> uniqueNums = new HashSet<String>(finalArray);
		System.out.println("There are ("+uniqueNums.size()+") non-consecutive increasing sequences with a length of ("+maxLen+") are:");
		int i = 0;
		for( String num : uniqueNums) {
			System.out.printf("%4d:\t%s\n",i+1,num);
			i++;
		}

	}
}
