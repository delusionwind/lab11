package student;
import java.time.LocalDate;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Consumer;
import java.util.Comparator;

/**
 * Display reminders of students having a birthday soon.
 * @author you
 */
public class StudentApp {

	/**
	 * Print the names (and birthdays) of students having a birthday in the
	 * specified month.
	 * @param students list of students
	 * @param month the month to use in selecting bithdays
	 */
	public void filterAndPrint( List<Student> students, Predicate<Student> filter, Consumer<Student> action, Comparator<Student> compare ) {
		students.stream().filter(filter).sorted(compare).forEach(action);
	}
	
	public static void main(String[] args) {
		List<Student> students = Registrar.getInstance().getStudents();
		Comparator<Student> byName = (a, b) -> a.toString().compareTo(b.toString());
		Comparator<Student> byBirthday = (a, b) -> a.getBirthdate().getDayOfYear() - b.getBirthdate().getDayOfYear();
		students.sort(byBirthday); //for(Student s: students) { System.out.println(s.getBirthdate());} //test sort Birthday
		
		StudentApp app = new StudentApp();
		
		Predicate<Student> isBirthday = (s) -> (s.getBirthdate().getMonthValue() == LocalDate.now().getMonthValue());
		Predicate<Student> birthdaySoon = (s) -> (LocalDate.now().getDayOfYear()+14 - s.getBirthdate().getDayOfYear() >= 0 && LocalDate.now().getDayOfYear()+14 - s.getBirthdate().getDayOfYear() <= 14);
		//for(Student s: students) {if(birthdaySoon.test(s)) System.out.println(s.getBirthdate());	}
		
		
		Consumer<Student> printName = (s) -> System.out.printf("%s will have birthday on %d %s.\n", s, 
												s.getBirthdate().getDayOfMonth(), s.getBirthdate().getMonth());
		app.filterAndPrint(students, isBirthday, printName, byBirthday);
	}
}
