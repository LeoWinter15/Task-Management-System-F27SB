package taskManagementSystem;

import java.util.*;

public class Run {

	// Main method, print menu
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		TaskManager taskManager = new TaskManager();
		boolean leave = true;
		taskManager.loadFile();
		System.out.print("======================Welcome======================\n");
		System.out.print("Enter \"a\",\"b\",\"c\",\"d\",\"e\" to use different functions\n");
		System.out.println("You can utilize this system for task management,\n"
				+"allowing you to view, add, and remove tasks.\n"
				+"Simply input the corresponding letter for the action you wish to perform.");
		for (;;) {
			System.out.print("=======================Menu========================\n");
			System.out.print("\t ->a.Add\n");
			System.out.print("\t ->b.Remove\n");
			System.out.print("\t ->c.Size\n");
			System.out.print("\t ->d.Print\n");
			System.out.print("\t ->e.Exit\n");
			String select = cin.next();
			switch (select) {
			case "a":
				taskManager.addTask(taskManager.chooseType());
				break;
			case "b":
				taskManager.removeTask(Task.readTaskToRemove());
				break;
			case "c":
				System.out.print("It has " + taskManager.size() + " task in the manager.\n");
				break;
			case "d":
				taskManager.printTask();
				break;
			case "e":
				leave = false;
				System.out.print("Quit the Manager.\n");
				taskManager.saveFile();
				cin.close();
				break;
			default:
				System.out.print("This request is not in the list, please select again.\n");
				break;
			}
			if (leave == false)
				break;
		}
	}
}


