package sequencefinder;

import java.util.Scanner;

public class ArrayFiller {

	private int len = 99;

	private String finalArray;
	
	public void fillArray() {
		StringBuilder array = new StringBuilder();
		for(int i=0; i<len; i++) {
			array.append((int) (Math.floor(Math.random()*999)+1) + " ");
		}
		finalArray = array.toString().trim();
	}
	
	public void customFillArray() {
		Scanner input = new Scanner(System.in);
		String number = "";
		StringBuilder array = new StringBuilder();
		for(int i=0; i<len; i++) {
			number = input.next();
			if(valueCheck(number)) {
				array.append(Integer.parseInt(number) + " ");
			}else {
				System.out.println("Invalid input, try again");
				i--;
			}
		}
		finalArray = array.toString().trim();
	}
	
	public void printArray() {
		String[] array = finalArray.split(" ");
		int count = 0;
		for(int i=0; i<len;i++,count++) {
			if(count != 0 && count%20==0) {
				System.out.println();
			}
			System.out.printf("[%3s] ", array[i]);
		}
		System.out.println();		
	}
	
	public String menu() {
		int custom;
		int ranNum;
		System.out.println("-------------------------------------------------"
				+ "\n|\tSelect an option below to begin\t\t|"
				+ "\n-------------------------------------------------"
				+ "\n1: Custom:\tChoose up to 99 random or custom numbers"
				+ "\n2: Standard:\t99 random numbers"
				+ "\n3: Quick:\t20 random numbers");
		custom = confirmInput(1);
		switch(custom) {
		case 1:
			System.out.println("How many numbers? ");
			len = confirmInput(2);
			System.out.println("Use randomly generated numbers (y/n)?");
			ranNum = confirmInput(3);
			if(ranNum == 1) {
				fillArray();
			}else {
				System.out.println("Enter "+len+" numbers:");
				customFillArray();
			}
			break;
		case 2:
			len = 99;
			fillArray();
			break;
		case 3:
			len = 20;
			fillArray();
			break;
		}
		printArray();
		return finalArray;
	}
	
	public int confirmInput(int n) {
		Scanner input = new Scanner(System.in);
		String choice = input.nextLine();
		int check;
		while(!valueCheck(choice,n)) {
			System.out.println("Invalid choice.");
			choice = input.nextLine();
		}
		choice = checkChoice(choice,n);		
		check = Integer.parseInt(choice);
		return check;
	}
	
	public boolean valueCheck(String num) {
		try {
			Integer.parseInt(num);
			return true;
		}
		catch(Exception e){
			return false;
		}
	}
	
	public String checkChoice(String choice, int n) {
		if(choice.equals("y") && n == 3) {
			choice = "1";
		}
		if(choice.equals("n") && n == 3) {
			choice = "0";
		}
		return choice;
	}
	
	public boolean valueCheck(String num, int n) {
		try {
			
			if((num.equals("y") || num.equals("n")) && n == 3) {
				return true;
			}
			
			int choice = Integer.parseInt(num);	
			
			switch(n) {

			case 1:
				// return a value of 1, 2, or 3 ONLY				
				if(choice >= 1 || choice <= 3) {
					return true;
				}
				break;
			case 2:
				// return a value between 1 and 99 ONLY
				if(choice > 0 && choice < 100) {
					return true;
				}				
				break;
			}
			return false;
		}catch(Exception e) {
			return false;
		}
	}

}
