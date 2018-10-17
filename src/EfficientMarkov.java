import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
//import java.util.NoSuchElementException;
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
//		int pos = 0;
		ArrayList<String> follows = new ArrayList<String>();
		for (int i = 0; i < text.length() - myOrder; i++) {
			follows = new ArrayList<String>();
//			pos = 0;
			String temp = text.substring(i, i + myOrder);
//			while (pos < myText.length()){
//				int start = myText.indexOf(temp,pos);
//				if (start == -1){
//					break;
//				}
//				if (start + temp.length() >= myText.length()){
//					follows.add(PSEUDO_EOS);
//					break;
//				}
//				String next = myText.substring(start+temp.length(), start+temp.length()+1);
//				follows.add(next);
//				pos++;
//			}
			for (int j = i + myOrder; j < text.length(); j++) {
				if (myText.substring(i, j).equals(temp)) {
					if (j == text.length()-1) {
						follows.add(PSEUDO_EOS);
					}
					else {
						follows.add(myText.substring(j, j+1));
					}
					break;
				}
			}
//			if (! myMap.containsKey(temp)) {
//				myMap.put(temp, follows);
//			}
//			ArrayList<String> all = new ArrayList<String>();
//			for (String str : myMap.get(temp)) {
//				all.add(str);
//			}
//			for (int j = 1; j < follows.size(); j++) {
//				all.add(follows.get(j));
//			}
			myMap.put(temp, follows);
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
