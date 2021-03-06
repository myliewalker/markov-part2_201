import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class EfficientMarkov extends BaseMarkov {
	private Map<String, ArrayList<String>> myMap;
	
	/**
	 * Constructs an EfficientMarkov object with the specified order
	 * @param order size of this markov generator
	 */
	public EfficientMarkov(int order) {
		super(order);
		myRandom = new Random(RANDOM_SEED);
		myMap = new HashMap<>();
	}
	
	/**
	 * Constructs an EfficientMarkov object with the specified order
	 */
	public EfficientMarkov() {
		this(3);
	}
	
	/**
	 * Checks if an integer is in the tree.
	 * @param tree Root of the tree
	 */
	@Override
	public void setTraining(String text) {
		myText = text;
		String temp = "";
		for (int start = 0; start <= text.length() - myOrder; start++) {
			temp = text.substring(start, start + myOrder);
			if (start == text.length() - myOrder) {
				if (! myMap.containsKey(temp)) {
					myMap.put(temp, new ArrayList<String>());
				}
				myMap.get(temp).add(PSEUDO_EOS);
				break;
			}
			if (myText.substring(start, start+myOrder).equals(temp)) {
				if (! myMap.containsKey(temp)) {
					myMap.put(temp, new ArrayList<String>());		
				}
				myMap.get(temp).add(myText.substring(start + myOrder, start + myOrder + 1));
			}
		}
	}
	
	/**
	 * Checks if an integer is in the tree.
	 * @param key Root of the tree
	 * @return ArrayList of the strings that follow the key
	 * @throws NullPointerException if key is not found
	 */
	@Override
	public ArrayList<String> getFollows(String key) {
		if (! myMap.containsKey(key)) {
			return new ArrayList<String>();
		}
		return myMap.get(key);
	}
}
