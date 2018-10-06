package container;

import java.io.*;
import java.util.Scanner;

public class driver {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		Scanner fileInput = new Scanner(System.in);
		
		Table hashTable = new Table();
		
		String filePath = "C:\\Users\\ajwea\\eclipse-workspace\\HashTableAxelWard\\src\\container\\testText.txt";
		
		try {
			File file = new File(filePath);
			fileInput = new Scanner(file);
		} catch (Exception e) {
			System.out.println("The file could not be opened");
		}
		
		while(fileInput.hasNextLine()) {
			System.out.println("reading");
			
			int code = fileInput.nextInt();
			String data = fileInput.nextLine().substring(1);
			
			System.out.println(code + " " + data);
			
			hashTable.addData(new Pair(code, data));
			
			System.out.println("Placed");
		}
		
		System.out.println("finished building table\n");
		
		boolean quit = false;
		
		while(!quit) {
			
			printMenu();
			
			int choice = input.nextInt();
			
			switch(choice) {
			case 1:
				break;
			case 2:
				hashTable.print();
				break;
			case 3:
				break;
			case 4:
				quit = true;
				break;
			}
			
		}
		
		
		input.close();
		fileInput.close();
	}
	
	public static void printMenu() {
		System.out.println("Menu\n----");
		System.out.println("1. Search Table");
		System.out.println("2. Print Table");
		System.out.println("3. Delete Data");
		System.out.println("4. Quit\n");
		System.out.print("Input Choice: ");
		
		
		
	}
}
