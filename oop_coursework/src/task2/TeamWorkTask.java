package task2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;

public class TeamWorkTask extends WorkTask implements Remindable {
	private String teamname;
	private String type;

	// Import of input
	// belong to TeamWorkTask
	public TeamWorkTask(Scanner cin) {
		super(cin);
		teamname = cin.nextLine();
	}

	// Import the ID, name and description information and "teamname"
	// belong to TeamWorkTask
	public TeamWorkTask(String iD, String name, String description, String teamname) {
		super(iD, name, description);
		this.teamname = teamname;
		type = "TeamWorkTask";
		// TODO Auto-generated constructor stub
	}

	// Import the ID, name and description information
	// belong to TeamWorkTask
	public TeamWorkTask(String iD, String name, String teamname) {
		super(iD, name);
		this.teamname = teamname;
		type = "TeamWorkTask";
		// TODO Auto-generated constructor stub
	}

	// Get the teamname information of the task
	// belong to TeamWorkTask
	public String getTeamname() {
		return teamname;
	}

	// Stores the information entered as teamname
	// belong to TeamWorkTask
	public void setTeamname(String teamname) {
		this.teamname = teamname;
	}

	// Get the type information of the task
	public String getType() {
		return type;
	}

	// Stores the information entered as Type
	public void setType(String type) {
		this.type = type;
	}

	// Add task information to determine
	// Whether there is "description"
	// belong to TeamWorkTask
	public static TeamWorkTask readTaskFromKeyboard() {
		Scanner cin = new Scanner(System.in);
		System.out.print("========================Add========================");
		
		System.out.print("\nID:");
		String ID = cin.next();
		System.out.print("\nName:");
		String name = cin.next();
		for (;;) {
			System.out.println("Do you need to add a description for this task(y/n)");
			String choice = cin.next();
			if (choice.equals("y")) {
				System.out.print("Description:");
				String description = cin.next();
				System.out.print("Team Name:");
				String teamName = cin.next();
				TeamWorkTask task = new TeamWorkTask(ID, name, description, teamName);
				return task;
			} else if (choice.equals("n")) {
				System.out.print("Team Name:");
				String teamName = cin.next();
				TeamWorkTask task = new TeamWorkTask(ID, name, teamName);
				return task;
			} else {
				System.out.println("Mistake! Please enter \"y\" or \"n\".");
			}
		}
	}

	// method ”toString“ of Override
	// When printed, all information about the task is printed
	// belong to TeamWorkTask
	@Override
	public String toString() {
		if (this.getDescription() == null) {
			return "TeamWorkTask [ID=" + getID() + " name=" + getName() + " Team:" + teamname + "]";
		} else {
			return "TeamWorkTask [ID=" + getID() + " name=" + getName() + "  description:" + getDescription() + " Team:"
					+ teamname + "]";
		}
	}

	//Override of RemindUser
	@Override
	public void RemindUser() {
		System.out.println("Remind: "+getName()+" of "+teamname);
	}

	// Store existing tasks to a file
	public void saveFile(BufferedWriter save) {
		try {
			save.write("TeamWorkTask");
			save.newLine();
			save.write(getID());
			save.newLine();
			save.write(getName());
			save.newLine();
			if (this.getDescription() != null) {
				save.write(getDescription());
			}
			save.newLine();
			save.write(teamname);
			save.newLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
