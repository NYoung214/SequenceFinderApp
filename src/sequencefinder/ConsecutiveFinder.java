package sequencefinder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ConsecutiveFinder {
	
	private int maxLen = 0;
	private int maxCount = 0;

	private List<String[]> finalArray = new ArrayList<>();
	
	public void findLIS(String array) {
		String[] numArray = array.split(" ");
		Stack<String> stack = new Stack<String>();
		int i = 0;
		for(String num : numArray) {
			if(stack.empty()) {
				stack.push(num);
				i++;
			}
			else if(Integer.parseInt(stack.peek()) < Integer.parseInt(num)){
				stack.push(num);
				i++;
			}else{
				if(i >= maxLen) {
					maxCount++;					
					if(i > maxLen) {
						maxLen = i;
						maxCount = 1;
					}
					addToList(stack);
				}				
				stack.removeAllElements();
				stack.push(num);
				i = 1;
			}
		}
		if(!stack.empty() && i >= maxLen) {
			maxLen = i;
			addToList(stack);
			stack.removeAllElements();
		}
		printList();
	}
	
	private void addToList(Stack<String> stack) {
		String[] array = new String[stack.size()];
		for(int i = stack.size()-1; i >= 0; i--) {
			array[i] = stack.pop();
		}
		finalArray.add(array);
	}
	
	private void printList() {
		if(maxLen < 2) {
			System.out.println("\nThere is not a consecutively increasing subsequence.");
		}else {
			System.out.println("\nTherer are ("+maxCount+") consecutively increasing subsequences with a length of ("+maxLen+"):");
			int i=0;
			for(String[] array : finalArray) {
				
				if(array.length >= maxLen) {
					System.out.printf("%3d:\t",i+1);
					for(String num : array) {
						System.out.printf("%4s ",num);
					}
					System.out.println();	
					i++;					
				}
			}			
		}
		

	}
	
	
}
