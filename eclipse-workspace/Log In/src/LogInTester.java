
public class LogInTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LogInForm myInfo = new LogInForm ("myliewalker", "abcdefg");
		myInfo.input("myliewalker");
		myInfo.input("abcdefg");
		myInfo.click("submit");
		System.out.println ("Expected: true");
		System.out.println(myInfo.loggedIn());
	}

}
