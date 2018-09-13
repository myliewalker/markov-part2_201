
public class LogInForm {

	private String username = "";
	private String password = "";
	private String expectedUsername;
	private String expectedPassword;
	boolean proceed = false;
	boolean login = false;
	boolean in = false;
	
	public LogInForm (String newUsername, String newPassword)
	{
		expectedUsername = newUsername;
		expectedPassword = newPassword;
	}
	
	public void input (String text)
	{
		if (username.length() == 0)
		{
			username = text;
		}
		else
		{
			password = text;
		}
	}
	
	public void click (String button)
	{
		if (button.toLowerCase().equals("submit"))
		{
			boolean proceed = true;
		}
		if (button.toLowerCase().equals("reset"))
		{
			username = "";
			password = "";
		}
	}
	
	public boolean loggedIn()
	{
		if (username.equals(expectedUsername) && password.equals(expectedPassword))
		{
			login = true;
			{
				if (proceed = true)
				{
					in = true;
				}
			}
		}
		else
		{
			username = "";
			password = "";
		}
		return in;
	}
}
