package online_tusur.unit_online_tusur;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class StudentTestNGZ7 
{
	
	@DataProvider(name="data", parallel=true)
	public Object[][][] getName()
	{
		return new Object[][][]
				{
					{
						{ "Иванов", "Иван", 25 },
						{ "Петров", "Пётр", 33 },
						{ "Сидоров", "Антон", 42}
					},
					
					{
						{ "Аксёнова", "Ольга", 21 },
						{ "Рыбаков", "Александр", 40 }
					},
					
					{
						{ "Мельников", "Николай", 27 }
					}
				};
	}
	
	
	/* 
	 * Параметризированный тест для метода расчёта среднего возраста avgAge().
	 * Использование @DataProvider.
	 */
	@Test(dataProvider="data", priority=1, timeOut=150, threadPoolSize=3)
	void testAvgAge(Object[][] str_arr)
	{	  
	
		// Количество студентов в массиве.
		int cntStudents = str_arr.length;
		
		// Массив студентов.
		Student[] student = new Student[cntStudents];
		
		// Счётчик суммы возраста.
		int sumAge = 0; 

		for (int i = 0; i < cntStudents; i++)
			{		  				  
				// Фамилия.
				String lastName = str_arr[i][0].toString();			  
				// Имя.
				String firstName = str_arr[i][1].toString();
				// Возраст.
				int age = ((Integer)str_arr[i][2]).intValue();
				
				// Считаем сумму.
				sumAge += age;
					  
				// Создание и инициализация объекта класса Student.
				student[i] = new Student(lastName, firstName, age);
			}		  

		// Рассчитанный вручную ожидаемый средний возраст.
		double expectedAvgAge = sumAge / cntStudents;
		// Рассчитанный методом средний возраст.
		double actualAvgAge = Student.avgAge(student);
		assertEquals(expectedAvgAge, actualAvgAge);
		
		long thread_id = Thread.currentThread().getId();
		System.out.println("Тест testAvgAge(Thread ID: " + thread_id + ")");
	}
	
	
	/*
	 * Проверка возраста студента, выходящего за диапазон.
	 * Использование @Parameters.
	 */
		@Test(priority=2, timeOut=50, threadPoolSize=3)
		@Parameters({"age"})
		void testAgeOut(@Optional("100500") int age) 
		{
			Student s = new Student();
			
			s.setAge(age);
			
			int expectedAge = 18;
			int actualAge = s.getAge();
			
			assertEquals(expectedAge, actualAge);
			
			long thread_id = Thread.currentThread().getId();
			System.out.println("Тест testAgeOut(Thread ID: " + thread_id + ")");
		}
}
