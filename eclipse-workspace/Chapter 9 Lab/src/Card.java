
public class Card {

		private String name;
		
		public Card ()
		{
			name = "";
		}
		
		public Card (String n)
		{
			name = n;
		}
		
		public String getName()
		{
			return name;
		}
		
		public boolean isExpired()
		{
			return false;
		}
		
		public String format()
		{
			return "Card holder: " + name;
		}
		
		public String toString()
		{
			return getClass().getName() + "[name: " + name + "]";
		}
		
		public boolean equals(Object c)
		{
			if (name == c && name.equals(c))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
}
