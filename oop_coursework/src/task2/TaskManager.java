package task2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class TaskManager extends ArrayList<Task> {

	Scanner cin = new Scanner(System.in);

	// Adds the entered task to the file
	// The task number must be different
	// If the task number is the same, an "Fail" message will be displayed
	public String addTask(Task t) {

		Iterator<Task> iterator = this.iterator();
		while (iterator.hasNext()) {
			if (iterator.next().getID().equals(t.getID())) {
				System.out.println("ID exist");
				return "Fail";
			}
		}
		this.add(t);
		return "Success";
	}

	// Remove the task you want to remove
	// If the task number is not exist, an "Fail" message will be displayed
	public String removeTask(String S) {

		Iterator<Task> iterator = this.iterator();

		while (iterator.hasNext()) {
//			Debug
//			System.out.println(iterator.next().getID());
//			System.out.println(iterator.next().getID());
			if (iterator.next().getID().equals(S)) {
				iterator.remove();
				System.out.println("Remove the task");
				return "Success";
			}
		}
		System.out.println("ID isn't exist");
		return "Fail";

	}

	// Output and print all tasks
	public void printTask() {
		Iterator<Task> iterator = this.iterator();
		while (iterator.hasNext()) {
			Task t = iterator.next();
			System.out.println(t);
			if (t instanceof Remindable) {
				((Remindable) t).RemindUser();
			}
		}
	}

	// Create different types of tasks
	public Task chooseType() {
		System.out.print("Which task do you want to add\n");
		System.out.print("(Enter \"a\",\"b\",\"c\" to use different functions)\n");
		System.out.print("\t\ta.Personal Task\n");
		System.out.print("\t\tb.Work Task\n");
		System.out.print("\t\tc.Team Work Task\n");
		for (;;) {
			String choice = cin.next();
			switch (choice) {
			case "a":
				Task t = PersonalTask.readTaskFromKeyboard();
				return t;
			case "b":
				Task t1 = WorkTask.readTaskFromKeyboard();
				return t1;
			case "c":
				Task t2 = TeamWorkTask.readTaskFromKeyboard();
				return t2;
			default:
				System.out.print("Mistake!\n");
				System.out.print("Please re-enter \"a\" or \"b\" or \"c\"\n");
				break;
			}
		}
	}

	// Store existing tasks to a file
	public void saveFile() {

		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("C:\\Users\\77935\\Desktop\\软件开发\\myTasks.txt"));
			Iterator<Task> iterator = this.iterator();
			while (iterator.hasNext()) {
				iterator.next().saveFile(out);
			}
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// Print out the previously stored tasks
	public void loadFile() {
		try {
			Scanner cin = new Scanner(new File("C:\\Users\\77935\\Desktop\\软件开发\\myTasks.txt"));
			while (cin.hasNext()) {
				String type = cin.nextLine();
				if (type.equals("PersonalTask")) {
					add(new PersonalTask(cin));
				}
				if (type.equals("WorkTask")) {
					add(new WorkTask(cin));
				}
				if (type.equals("TeamWorkTask")) {
					add(new TeamWorkTask(cin));
				}
			}
			this.printTask();
		} catch (FileNotFoundException e) {
			System.err.print("No Task\n");
		}
	}

}
