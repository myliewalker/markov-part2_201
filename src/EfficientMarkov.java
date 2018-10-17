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
		ArrayList<String> follows = new ArrayList<String>();
		int pos = 0;
				
		for (int i = 0; i < text.length() - myOrder; i++) {
			String temp = text.substring(i, i + myOrder);
			while (pos < myText.length()){
				int start = myText.indexOf(temp,pos);
				if (start == -1){
					//System.out.println("didn't find "+key);
					break;
				}
				if (start + temp.length() >= myText.length()){
					//System.out.println("found end with "+key);
					follows.add(PSEUDO_EOS);
					break;
				}
				// next line is string equivalent of myText.charAt(start+key.length())
				String next = myText.substring(start+temp.length(), start+temp.length()+1);
				follows.add(next);
				pos = start+1;  // search continues after this occurrence
			}
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
//			throw new NoSuchElementException(key + " not in map");
		}
		return myMap.get(key);
	}
}
