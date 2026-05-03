package task2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class PersonalTask extends Task {

	private String type;

	// Import of input
	// belong to PersonalTask
	public PersonalTask(Scanner cin) {
		super(cin);
	}

	// Import the ID and name information
	// belong to PersonalTask
	public PersonalTask(String ID, String name) {
		super(ID, name);
		type = "PersonalTask";
		// TODO Auto-generated constructor stub
	}

	// Import the ID, name and description information
	// belong to PersonalTask
	public PersonalTask(String ID, String name, String description) {
		super(ID, name, description);
		type = "PersonalTask";
		// TODO Auto-generated constructor stub
	}

	// Get the type information of the task
	public String getType() {
		return type;
	}

	// Stores the information entered as Type
	public void setType(String type) {
		this.type = type;
	}

	// method ”toString“ of Override
	// When printed, all information about the task is printed
	// belong to PersonalTask
	@Override
	public String toString() {
		if (this.getDescription() == null) {
			return "PersonalTask[" + "ID:" + getID() + " " + "Name:" + getName() + " " + "]";
		} else {

			return "PersonalTask[" + "ID:" + getID() + " " + "Name:" + getName() + " " + "Description:"
					+ getDescription() + "]";
		}
	}

	// Add task information to determine
	// Whether there is "description"
	// belong to PersonalTask
	public static PersonalTask readTaskFromKeyboard() {
		Scanner cin = new Scanner(System.in);
		System.out.println("========================Add========================");
		System.out.print("ID:");
		String ID = cin.next();
		System.out.print("\nName:");
		String name = cin.next();
		for (;;) { // loop until user answers either "y" or "n"
			System.out.println("Do you need to add a description for this task(y/n)");
			String choice = cin.next();
			if (choice.equals("y")) {
				System.out.print("Description:");
				String description = cin.next();
				PersonalTask task = new PersonalTask(ID, name, description);
				return task;
			} else if (choice.equals("n")) {
				PersonalTask task = new PersonalTask(ID, name);
				return task;
			} else {
				System.out.println("Mistake! Please enter y or n.");
			}
		}
	}

	// Store existing tasks to a file
	public void saveFile(BufferedWriter save) {

		try {
			save.write("PersonalTask");
			save.newLine();
			save.write(getID());
			save.newLine();
			save.write(getName());
			save.newLine();
			if (this.getDescription() != null) {
				save.write(getDescription());
			}
			save.newLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
