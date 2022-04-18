package online_tusur.unit_online_tusur;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Tag;
import org.testng.annotations.Test;


public class GroupTesting {
	/*объект тестового класса  Student*/
	private Student s = new Student();	 	   

	    
/* проверка возраста студента, 
 входящего в диапазон */
	  @Test(groups = {"gr_positive"})
	  @Tag("postive")
	  void test_assert1() {
		int age = 26;
		s.setAge(age);
	    int expectedAge = 26;
	    int actualsAge=s.getAge();
	    assertEquals(expectedAge, actualsAge);
	  }
	  
	  
	  /* проверка возраста студента, 
	  выходящего за диапазон */
	  	@Test(groups = {"gr_negative"})
	  	@Tag("negative")
	 	  void test_assert2() {
	 		int age = -5;
	 		s.setAge(age);
	 	    int unExpectedAge = -5;
	 	    int actualsAge=s.getAge();
	 	    assertNotEquals(unExpectedAge, actualsAge);
	 	  }  
	  	
	  	
	  	/* проверка имени студента, 
	  	 с корректным вводом */
	  		  @Test(groups = {"gr_positive"})
	  		  @Tag("postive")
	  		  void test_assert3() {
	  			String fname = "Ivan";
	  			s.setFirstName(fname);
	  		    String expectedFirstName = "Ivan";
	  		    String actualsFirstName=s.getFirstName();
	  		    assertEquals(expectedFirstName, actualsFirstName);
	  		  }
	  		  
	  	  	/* проверка имени студента, 
	 	  	 с некорректным вводом (сбитый регистр букв) */
	 	  		  @Test(groups = {"gr_negative"})
	 	  		  @Tag("negative")
	 	  		  void test_assert4() {
	 	  			String fname = "niKolaIy";
	 	  			s.setFirstName(fname);
	 	  		    String expectedFirstName = "Nikolaiy";
	 	  		    String actualsFirstName=s.getFirstName();
	 	  		    assertEquals(expectedFirstName, actualsFirstName);
	 	  		  }
	 	  		  
	 	 	  	/* проверка вычисления максимального возраста */
	 		  		  @Test(groups = {"gr_positive"})
	 		  		  @Tag("postive")
	 		  		  void test_assert5() {
	 		  			Student s0 = new Student("none", "none", 21);  	
	 		  			Student s1 = new Student("none", "none", 19);  	
	 		  			Student s2 = new Student("none", "none", 20);  
	 		  			
	 		  			Student[] s = { s0, s1, s2};
	 		  			
	 		  		    int expectedMaxAge = 21;
	 		  		    int actualsMaxAge = Student.maxAge(s);
	 		  		    assertEquals(expectedMaxAge, actualsMaxAge);
	 		  		  }		  
	 	  
	 		 	 	  /* проверка вычисления минимального возраста с некорректными данными */
	 		  		  @Test(groups = {"gr_negative"})
	 		  		  @Tag("negative")
	 		  		  void test_assert6() {
		 		  			Student s0 = new Student("none", "none", -15);  	
		 		  			Student s1 = new Student("none", "none", 25);  	
		 		  			Student s2 = new Student("none", "none", 100);  
		 		  			
		 		  			Student[] s = { s0, s1, s2};
	 		  			
	 		  		    int expectedMinAge = 18;
	 		  		    int actualsMinAge = Student.minAge(s);
	 		  		    assertEquals(expectedMinAge, actualsMinAge);
	 		  		  }	
}
