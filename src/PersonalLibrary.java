import java.util.Scanner;

public class PersonalLibrary {
	
	static Scanner input = new Scanner(System.in);	
	static MediaItem[] items = new MediaItem[100];
	static int numberOfItems = 0;	
	
	static void addNewItem(String title, String format) {
		MediaItem item = new MediaItem(title, format);
		items[numberOfItems] = item;
		numberOfItems += 1;
	}
	
	static void markItemOnLoan(String title, String name, String date) {
		boolean found = false;
		for(int i = 0; i < numberOfItems; i++) {
			if(title.equals(items[i].getTitle())) {
				items[i].markOnLoan(name, date);
				found = true;
			}
		}
		if(!found) {
			System.out.println("Error: " + title + " is not your library");
		}
	}
	
	static void markItemReturned(String title) {
		boolean found = false;
		for(int i = 0; i < numberOfItems; i++) {
			if(title.equals(items[i].getTitle())) {
				items[i].markReturned();
				found = true;
			}
		}
		if(!found) {
			System.out.println("Error: " + title + " is not your library");
		}
	}
	
	static void listAllItems() {
		String[] itemsList = new String[numberOfItems];
		String placeholder;
		for(int i = 0; i < numberOfItems; i++) {
			placeholder = "";
			if(items[i].getOnLoan()) {
				placeholder =  " loaned to " + items[i].getBorrower() + " on1 " + items[i].getDateLoaned();
			}			
			itemsList[i] = items[i].getTitle() + " (" + items[i].getFormat() + ")" + placeholder;
		}		
		for(int j = 0; j < itemsList.length; j++) {
			System.out.println(itemsList[j]);
		}
	}
	
	public static int displayMenu() {
		int choice;
		
		System.out.println("Personal Lending Library - Shepherd");
		System.out.println("1. Add new item");
		System.out.println("2. Mark item as on loan");
		System.out.println("3. List all items");
		System.out.println("4. Mark an item as returned");
		System.out.println("5. Quit");
		System.out.print("What would you like to do? ");
		choice = input.nextInt();
		while(choice < 1 || choice > 5) {
			System.out.print("Error: Enter a valid menu choice, please: ");
			choice = input.nextInt();
		}
		input.nextLine();
		return choice;
	}
	
	public static void main(String[] args) {
		
		int choice;
		String title, format, name, date;
		
		choice = displayMenu();
		System.out.println();
		
		while(choice != 5) {
			title = "";
			format = "";
			name = "";
			date = "";
			
			switch(choice) {
				case 1:
					System.out.print("What is the title? ");
					title = input.nextLine();
					System.out.print("What is the format? ");
					format = input.nextLine();
					addNewItem(title, format);
					break;
				case 2:
					System.out.print("Which item (enter the title)? ");
					title = input.nextLine();
					System.out.print("Who are you loaning it to? ");
					name = input.nextLine();
					System.out.print("When did you loan it to them? ");
					date = input.nextLine();
					markItemOnLoan(title, name, date);
					break;
				case 3:
					listAllItems();
					break;
				case 4:
					System.out.print("Which item (enter the title)? ");
					title = input.nextLine();
					markItemReturned(title);
					break;
			}
			
			System.out.println();
			choice = displayMenu();
		}
		
		System.out.print("Goodbye!");
		input.close();
		
	}

}
