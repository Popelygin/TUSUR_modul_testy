package online_tusur.unit_online_tusur;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvSource;

public class StudentTestZ3 
{
	/*
	 * Параметризированный тест для метода расчёта среднего возраста avgAge(),
	 * используя аннотацию @CsvSource.
	 */
	@ParameterizedTest(name = "Подтест {index}: {0}, {1}, {2}, {3}, {4}, ...")
	@CsvSource(value = {
			  "Иванов, Иван, 25, Петров, Пётр, 33, Сидоров, Антон, 42", 
			  "Аксёнова, Ольга, 21, Рыбаков, Александр, 40",
			  "Мельников, Николай, 27"
			  			 })
	void testAvgAge(ArgumentsAccessor argumentsAccessor)
	{
		// Количество аргументов в csv-строке.
		int cntArguments = argumentsAccessor.size();
		// Количество студентов = количество аргументов в csv-строке / 3.
		int cntStudents =  cntArguments / 3;
		  
		// Массив студентов.
		Student[] student = new Student[cntStudents];		  
		// Счётчик суммы возраста.
		int sumAge = 0; 
		for (int i = 0; i < cntStudents; i++)
		{		  
			// Позиция аргумента в строке.
			int posArgument = i * 3;
			  
			// Фамилия.
			String lastName = argumentsAccessor.get(posArgument, String.class);			  
			// Имя.
			String firstName = argumentsAccessor.get(posArgument + 1, String.class);
			// Возраст.
			int age = argumentsAccessor.get(posArgument + 2, Integer.class);
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
	}
}
