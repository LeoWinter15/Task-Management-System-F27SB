package task2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class TestTaskManager {
	static TaskManager managerTest;

	@BeforeAll
	static void setup() {
		managerTest = new TaskManager();
	}

	// Test the "addTask",when it is "Fail"
	@Test
	void TestaddTaskFail() {
		PersonalTask test_1 = new PersonalTask("1125", "name1", "description");
		String test1 = managerTest.addTask(test_1);
		assertEquals("Success", test1);
		WorkTask test_2 = new WorkTask("1125", "name2", "");
		String test2 = managerTest.addTask(test_2);
		assertEquals("Fail", test2);
		TeamWorkTask test_3 = new TeamWorkTask("36036", "name3", "a", "b");
		String test3 = managerTest.addTask(test_3);
		assertEquals("Success", test3);
	}

	// Test the "removeTask",when it is "Fail" or "Success"
	@Test
	void TestremoveTask() {
		String test3 = managerTest.removeTask("12");
		assertEquals("Fail", test3);
		String test4 = managerTest.removeTask("1125");
		assertEquals("Success", test4);

	}

}
