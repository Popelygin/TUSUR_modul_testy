package online_tusur.unit_online_tusur;


import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;


public class StudentTestNGZ6 
{
	private String firstNameActual;
	private String lastNameActual;	
	private int ageActual;
	private String firstNameExpected;
	private String lastNameExpected;	
	private int ageExpected;

	
	@Factory(dataProvider="data")
	public StudentTestNGZ6(String firstNameActual, String lastNameActual, int ageActual,
			String firstNameExpected, String lastNameExpected, int ageExpected)
	{
		// Считывание данных из @DataProvider(name="data").
		this.firstNameActual = firstNameActual;
		this.lastNameActual = lastNameActual;
		this.ageActual = ageActual;
		
		this.firstNameExpected = firstNameExpected;
		this.lastNameExpected = lastNameExpected;
		this.ageExpected = ageExpected;
	}

	
	@DataProvider(name="data")
	public static Object[][] dataMethod() {
		return new Object[][]
				{
					{ "Александр", "иванов", 55, "Александр", "Иванов", 18 },
					{ "владимир", "Петров", 34, "Владимир", "Петров", 34 },
					{ "Алексей", "алексеев", 18, "Алексей", "Алексеев", 18 }
				};
	}

	
	/*
	 * Динамический тест для геттера getFirstName() класса Student.
	 */
	@Test(priority=1)
	public void dynamicTestStudentGetterGetFirstName() 
	{
		String firstName = firstNameActual;
		String lastName = lastNameActual;
		int age = ageActual;
		
		Student student = new Student(firstName, lastName, age);		
		
		assertEquals(student.getFirstName(), firstNameExpected);
		
		System.out.println("Тест dynamicTestStudentGetterGetFirstName: [" + 
				firstName + "; " + lastName + "; " + Integer.toString(age) + "]");
	}
	
	
	/*
	 * Динамический тест для геттера getLastName() класса Student.
	 */
	@Test(priority=10)
	public void dynamicTestStudentGetterGetLastName() 
	{
		String firstName = firstNameActual;
		String lastName = lastNameActual;
		int age = ageActual;
		
		Student student = new Student(firstName, lastName, age);

		assertEquals(student.getLastName(), lastNameExpected);
		
		System.out.println("Тест dynamicTestStudentGetterGetLastName: [" + 
				firstName + "; " + lastName + "; " + Integer.toString(age) + "]");
	}
	
	
	/*
	 * Динамический тест для геттера getAge() класса Student.
	 */
	@Test(priority=100)
	public void dynamicTestStudentGetterGetAge() 
	{
		String firstName = firstNameActual;
		String lastName = lastNameActual;
		int age = ageActual;
		
		Student student = new Student(firstName, lastName, age);

		assertEquals(student.getAge(), ageExpected);
		
		System.out.println("Тест dynamicTestStudentGetterGetAge: [" + 
				firstName + "; " + lastName + "; " + Integer.toString(age) + "]");
	}
}
