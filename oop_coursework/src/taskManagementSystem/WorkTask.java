package taskManagementSystem;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;

public class WorkTask extends Task implements Remindable {
	private String type;

	// Import the ID, name and description information
	// belong to TeamWorkTask
	public WorkTask(String iD, String name, String description) {
		super(iD, name, description);
		type = "WorkTask";
	}

	// Import of input
	// belong to WorkTask
	public WorkTask(Scanner cin) {
		super(cin);
	}

	// Import the ID and name information
	// belong to WorkTask
	public WorkTask(String iD, String name) {
		super(iD, name);
		type = "WorkTask";
	}

	// Get the type information of the task
	public String getType() {
		return type;
	}

	// Stores the information entered as Type
	public void setType(String type) {
		this.type = type;
	}

	//Override of toString
	// When printed, all information about the task is printed
	// belong to WorkTask
	@Override
	public String toString() {
		if (this.getDescription() == null) {
			return "*WorkTask[" + "ID:" + getID() + " " + "Name:" + getName() + " " + "]";
		} else {
			return "*WorkTask[" + "ID:" + getID() + " " + "Name:" + getName() + " " + "Description:" + getDescription()
					+ "]";
		}
	}

	// Add task information to determine
	// Whether there is "description"
	// belong to WorkTask
	public static WorkTask readTaskFromKeyboard() {
		Scanner cin = new Scanner(System.in);
		System.out.println("========================Add========================");
		System.out.print("ID:");
		String ID = cin.next();
		System.out.print("\nName:");
		String name = cin.next();
		do { // loop until user answers either "y" or "n"
			System.out.println("Do you need to add a description for this task(\"y\"/\"n\")");
			String choice = cin.next();
			if (choice.equals("y")) {
				System.out.print("Description:");
				String description = cin.next();
				WorkTask task = new WorkTask(ID, name, description);
				return task;
			} else if (choice.equals("n")) {
				WorkTask task = new WorkTask(ID, name);
				return task;
			} else {
				System.out.println("Mistake!\n Please enter \"y\" or \"n\".");
			}
		} while (true);
	}

	//Override of RemindUser
	@Override
	public void RemindUser() {
		System.out.println("Remind Message!");
	}


	// Store existing tasks to a file
	public void saveFile(BufferedWriter save) {
		try {
			save.write("WorkTask");
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

