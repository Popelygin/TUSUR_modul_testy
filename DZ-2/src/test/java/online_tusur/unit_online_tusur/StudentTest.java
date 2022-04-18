package online_tusur.unit_online_tusur;
import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

public class StudentTest {
	/*объект тестового класса  Student*/
	private Student s = new Student();	 	   

	    
/* проверка возраста студента, 
 выходящего за диапазон */
	  @Test
	  void test_assert1() {
		int age = 26;
		s.setAge(age);
	    int expectedAge = 26;
	    int actualsAge=s.getAge();
	    assertEquals(expectedAge, actualsAge);
	  } 	    
}