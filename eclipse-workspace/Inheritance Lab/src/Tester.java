
public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Person p = new Person ("George", 1990);
		Student s = new Student ("Liz", 2000, "computer science");
		Instructor i = new Instructor ("Ms. T", 1980, 50000);
		
		System.out.println("Name: " + p.getName() + ", birth year: " + p.getBirthYear());
		System.out.println("Name: " + s.getName() + ", birth year: " + s.getBirthYear() + ", major: " + s.getMajor());
		System.out.println("Name: " + i.getName() + ", birth year: " + i.getBirthYear() + ", salary $" + i.getSalary());
	}

}
