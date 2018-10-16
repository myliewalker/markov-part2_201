import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Random;

public class EfficientMarkov extends BaseMarkov {
	Map<String, ArrayList<String>> myMap;
	
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
//		myMap.clear();
		myText = text;
		for (int i = 0; i < myText.length() - myOrder; i++) {
			if (! myMap.containsKey(myText.substring(i, i + myOrder))) {
				myMap.put(myText.substring(i, i + myOrder), new ArrayList<String>());
			}
			ArrayList<String> possible = super.getFollows(myText.substring(i, i + myOrder));
			for (int j = 0; j < possible.size()-1; j++) {
				for (int k = j+1; k < possible.size(); k++) {
					if (possible.get(j).equals(possible.get(k))) {
						possible.remove(k);
						k--;
					}
				}
//				for (int m = 0; m < myMap.getValue(myText.substring(i, i + myOrder).size()) {
//					if (possible.get(j).equals(myMap.getValue(myText.substring(i, i + myOrder)).get(m))) {
//						possible.remove(j);
//						j--;
//					}
//				}
			}
			myMap.put(myText.substring(i, i + myOrder), possible);
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
			throw new NoSuchElementException(key + " not in map");
		}
		return myMap.get(key);
	}
}
