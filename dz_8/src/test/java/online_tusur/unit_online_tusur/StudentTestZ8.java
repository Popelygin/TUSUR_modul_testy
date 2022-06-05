package online_tusur.unit_online_tusur;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


public class StudentTestZ8 
{

	@Test
	public void test_student_getsetFirstName()
	{
		Student student = new Student("", "Иванов", 27);
		
		student.setFirstName("Иван");
		
		assertEquals(student.getFirstName(), "Иван");
	}
	
	
	@Test
	public void test_student_getsetLastName()
	{
		Student student = new Student("Иван", "", 27);
		
		student.setLastName("Иванов");
		
		assertEquals(student.getLastName(), "Иванов");
	}
	
	
	@Test
	public void test_student_getsetAge()
	{
		Student student = new Student();
		
		student.setAge(27);
		
		assertEquals(student.getAge(), 27);
	}
	
	
	@Test
	public void test_student_getsetWrongAgeLess()
	{
		Student student = new Student();
		
		student.setAge(1);
		
		assertEquals(student.getAge(), 18);
	}
	
	
	@Test
	public void test_student_getsetWrongAgeMore()
	{
		Student student = new Student();
		
		student.setAge(100500);
		
		assertEquals(student.getAge(), 18);
	}
		
	
	@Test
	public void test_student_getFullName()
	{
		Student student = new Student("Иван", "Иванов", 27);
		
		assertEquals(student.getFullName(), "Иванов Иван");
	}
	
	
	@Test
	public void test_student_avgAge()
	{
		int arr_length = 3;
		Student[] students = new Student[arr_length];
		
		students[0] = new Student("Александр", "Иванов", 55);
		students[1] = new Student("Владимир", "Петров", 34);
		students[2] = new Student("Алексей", "Алексеев", 18);

		int sumAge = 0;
		for (int i = 0; i < students.length; i++) 
		{
			int age = students[i].getAge();
			
			sumAge += age;
		}
		
		int expectedAvgAge = sumAge / students.length;		
		
		assertEquals(Student.avgAge(students), expectedAvgAge);
	}
	
	
	@Test
	public void test_student_minAge()
	{
		int arr_length = 3;
		Student[] students = new Student[arr_length];
		
		students[0] = new Student("Александр", "Иванов", 23);
		students[1] = new Student("Владимир", "Петров", 34);
		students[2] = new Student("Алексей", "Алексеев", 18);

		int expectedMinAge = students[0].getAge();
		for (int i = 1; i < students.length; i++) 
		{
			int age = students[i].getAge();
			
			if (expectedMinAge > age)
				expectedMinAge = age;
		}			
		
		assertEquals(Student.minAge(students), expectedMinAge);
	}
	
	
	@Test
	public void test_student_maxAge()
	{
		int arr_length = 3;
		Student[] students = new Student[arr_length];
		
		students[0] = new Student("Александр", "Иванов", 23);
		students[1] = new Student("Владимир", "Петров", 34);
		students[2] = new Student("Алексей", "Алексеев", 18);

		int expectedMaxAge = students[0].getAge();
		for (int i = 1; i < students.length; i++) 
		{
			int age = students[i].getAge();
			
			if (expectedMaxAge < age)
				expectedMaxAge = age;
		}			
		
		assertEquals(Student.maxAge(students), expectedMaxAge);
	}
}
