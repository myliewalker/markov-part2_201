
public class BillfoldTester {

	public static void main (String[] args)
	{
		IDCard id = new IDCard ("My ID", "2018046");
		DriversLicense license = new DriversLicense("My license", "2020");
		CallingCard card = new CallingCard("My calling card", "90801", "324");
		
		Billfold myCard = new Billfold(id, license);

		myCard.addCard(card);
		myCard.getExpiredCardCount();
		myCard.formatCards();
	}
}
