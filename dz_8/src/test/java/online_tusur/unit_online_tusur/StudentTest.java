package online_tusur.unit_online_tusur;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class StudentTest {
	/*объект тестового класса  Student*/
	private Student s = new Student();	 	   

	   
/* проверка возраста студента, 
 выходящего за диапазон */
	  @Test
	  void test_assert1() {
		int age = 26;
		s.setAge(age);
		
	    int expectedAge = 18;
	    int actualAge = s.getAge();
	    
	    assertEquals(expectedAge, actualAge);
	  }
}