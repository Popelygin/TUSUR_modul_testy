package online_tusur.unit_online_tusur;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.DynamicContainer.dynamicContainer;

import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.DynamicContainer;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;


public class StudentTestZ4 
{
	/*
	 * Динамический тест для геттера getLastName() класса Student.
	 */
	@TestFactory
	Collection<DynamicTest> dynamicTestStudentGetterGetLastName() 
	{
		// Создаём список студентов.
		ArrayList<Student> student = new ArrayList<Student>();
		// Добавляем в список студентов, вызывая конструктор класса Student.
		student.add(new Student("Александр", "иванов", 55));
		student.add(new Student("Владимир", "Петров", 34));
		student.add(new Student("Алексей", "алексеев", 18));

		List<String> exp = Arrays.asList("Иванов", "Петров", "Алексеев");

		ArrayList<DynamicTest> res = new ArrayList<>();

		for (int i = 0; i < student.size(); i++) 
		{
			String firstName = student.get(i).getFirstName();
			String lastName = student.get(i).getLastName();
			int age = student.get(i).getAge();
			
			String r = exp.get(i);

			DynamicTest dTest = dynamicTest("test" + i + " { " + firstName + ", " + 
					lastName + ", " + age + " }", () -> {assertEquals(r, lastName);});
			
			// Записываем тест в коллецию res на каждой итерации цикла.
			res.add(dTest);
		}
	
		return res;
	}

	
	/*
	 * Динамический тест для геттера getFirstName() класса Student.
	 */
	@TestFactory
	Collection<DynamicTest> dynamicTestStudentGetterGetFirstName() 
	{
		// Создаём список студентов.
		ArrayList<Student> student = new ArrayList<Student>();
		// Добавляем в список студентов, вызывая конструктор класса Student.
		student.add(new Student("Александр", "Иванов", 55));
		student.add(new Student("владимир", "Петров", 34));
		student.add(new Student("Алексей", "Алексеев", 18));

		List<String> exp = Arrays.asList("Александр", "Владимир", "Алексей");

		ArrayList<DynamicTest> res = new ArrayList<>();

		for (int i = 0; i < student.size(); i++) 
		{
			String firstName = student.get(i).getFirstName();
			String lastName = student.get(i).getLastName();
			int age = student.get(i).getAge();
			
			String r = exp.get(i);

			DynamicTest dTest = dynamicTest("test" + i + " { " + firstName + ", " + 
					lastName + ", " + age + " }", () -> {assertEquals(r, firstName);});
			
			// Записываем тест в коллецию res на каждой итерации цикла.
			res.add(dTest);
		}
	
		return res;
	}
	
	
	/*
	 * Динамический тест для геттера getAge() класса Student.
	 */
	@TestFactory
	Collection<DynamicTest> dynamicTest0StudentGetterGetAge() 
	{
		// Создаём список студентов.
		ArrayList<Student> student = new ArrayList<Student>();
		// Добавляем в список студентов, вызывая конструктор класса Student.
		student.add(new Student("Александр", "Иванов", 55));
		student.add(new Student("Владимир", "Петров", 34));
		student.add(new Student("Алексей", "Алексеев", 18));

		List<Integer> exp = Arrays.asList(18, 34, 18);

		ArrayList<DynamicTest> res = new ArrayList<>();

		for (int i = 0; i < student.size(); i++) 
		{
			String firstName = student.get(i).getFirstName();
			String lastName = student.get(i).getLastName();
			int age = student.get(i).getAge();
			
			int r = exp.get(i);

			DynamicTest dTest = dynamicTest("test" + i + " { " + firstName + ", " + 
					lastName + ", " + age + " }", () -> {assertEquals(r, age);});
			
			// Записываем тест в коллецию res на каждой итерации цикла.
			res.add(dTest);
		}
	
		return res;
	}
	
	
	/*
	 * Динамический тест для геттера getAge() класса Student.
	 */
	@TestFactory
	Collection<DynamicTest> dynamicTest1StudentGetterGetAge() 
	{
		// Тестовый студент: экземпляр класса Student.
		Student student = new Student();

		List<Integer> act = Arrays.asList(55, 34, 48);
		List<Integer> exp = Arrays.asList(18, 34, 48);

		ArrayList<DynamicTest> res = new ArrayList<>();

		// Перебор в цикле всех элементов коллекции-списка act.
		for (int i = 0; i < act.size(); i++) 
		{
			student.setAge(act.get(i));
			
			int cur_age = student.getAge();
			int exp_age = exp.get(i);

			// Создание выполнения теста на каждой итерации.
			Executable exec = () -> assertEquals(exp_age, cur_age);

			/* Формирование одного теста из отображаемого имени, 
			 * которое будет отображаться в отчёте JUnit и расширения Executable на каждой итерации. 
			 * Итого в примере будет 3 таких теста.
			 */
			DynamicTest dTest = dynamicTest("test" + i + " { age=" + cur_age + " }", exec);

			// Записываем тест в коллецию res на каждой итерации цикла.
			res.add(dTest);
		}

		return res;
	}
		
	
	/*
	 * Коллекция из DynamicContainer с позитивными и негативными тестами из GroupTesting.
	 */
	@TestFactory
	Collection<DynamicContainer> dynamicContainerFromCollection() 
	{
		// Объект класса GroupTesting с ранее разработанными позитивными и негативными тестами.
		GroupTesting groupTesting = new GroupTesting();
		
		// Возвращаем список из динамических тестов dynamicTest.
		return Arrays.asList
				(      
						dynamicContainer
						(
								"--- Позитивные и негативные тесты ---",
								Arrays.asList
								(
										dynamicContainer
										(
												"-- Позитивные тесты --",
													Arrays.asList
													(
															dynamicTest("- Первый позитивный тест { test_assert1() } -",
																	() -> groupTesting.test_assert1()),

															dynamicTest("- Второй позитивный тест { test_assert3() } -",
																	() -> groupTesting.test_assert3()),
	                         
															dynamicTest("- Третий позитивный тест { test_assert5() } -",
																	() -> groupTesting.test_assert5())
													)
										 ),                            

										dynamicContainer
										(
												"-- Негативные тесты --",
												Arrays.asList
												(
														dynamicTest("- Первый негативный тест { test_assert2() } -",
																() -> groupTesting.test_assert2()),
														
														dynamicTest("- Второй негативный тест { test_assert4() } -",
																() -> groupTesting.test_assert4()),
														
														dynamicTest("- Третий негативный тест { test_assert6() } -",
																() -> groupTesting.test_assert6())

												)
										)
								)
						)
	             );
		}
}
