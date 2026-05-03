package task2;

import java.io.BufferedWriter;
import java.util.Scanner;

abstract public class Task {
	private String ID;
	private String name, description;

	// Enter ID, name and description information
	public Task(Scanner cin) {
		ID = cin.nextLine();
		name = cin.nextLine();
		description = cin.nextLine();
	}

	// Enter ID and name information
	public Task(String ID, String name) {
		super();
		this.ID = ID;
		this.name = name;
	}

	// Enter ID, name and description information
	public Task(String ID, String name, String description) {
		super();
		this.ID = ID;
		this.name = name;
		this.description = description;
	}

	// Enter description information
	public void setDescription(String description) {
		this.description = description;
	}

	// Enter ID information
	public void setID(String ID) {
		this.ID = ID;
	}

	// Enter name information
	public void setName(String name) {
		this.name = name;
	}

	// Extract name information
	public String getName() {
		return name;
	}

	// Extract ID information
	public String getID() {
		return ID;
	}

	// Extract description information
	public String getDescription() {
		return description;
	}

	// method ”toString“ of Override
	// When printed, all information about the task is printed
	@Override
	public String toString() {
		return "Task [ID=" + ID + ", name=" + name + ", description:" + description + "]";
	}

	// Read tasks from keyboard
	public static Task readTaskFromKeyboard() {
		Scanner cin = new Scanner(System.in);
		System.out.println("==============Add==============");
		System.out.print("ID:");
		String ID = cin.next();
		System.out.print("\nName:");
		String name = cin.next();
		for (;;) {
			System.out.println("Do you need to add a description for this task(y/n)");
			String choice = cin.next();
			if (choice.equals("y")) {
				System.out.print("Description:");
				String description = cin.next();
				return null;
			} else if (choice.equals("n")) {
				return null;
			} else {
				System.out.println("Mistake! Please enter y or n.");
			}
		}
	}

	// The function is abstracted
	abstract public String getType();

	// The function is abstracted
	abstract public void saveFile(BufferedWriter out);

	// Gets the serial number of the task to remove
	public static String readTaskToRemove() {
		Scanner cin = new Scanner(System.in);
		System.out.println("Which task(ID) you want to remove?");
		String ID = cin.next();
		return ID;
	}

}
