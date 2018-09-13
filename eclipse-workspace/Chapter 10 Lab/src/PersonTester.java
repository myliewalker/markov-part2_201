import java.util.Scanner;
public class PersonTester {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in); 
		
		Person[] people = new Person[10];
	//	people[0] = new Person(sc.next(), sc.nextInt());
		
		for (int i = 0; i < people.length; i++)
		{
			System.out.println("Please enter the name of a person and their height in inches");
			people[i] = new Person (sc.next(), sc.nextInt());
		}
	
		Person first = people[0];
		Person last = people[0];
		
		for (int i = 0; i < people.length; i++)
		{
			if (people[i].compareTo(first) > 0)
			{
				first = people[i];
			}
			if (people[i].compareTo(last) < 0)
			{
				last = people[i];
			}
		}
		
		System.out.println (first);
		System.out.println(last);
	}
}
