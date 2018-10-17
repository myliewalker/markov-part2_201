import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Random;

public class EfficientWordMarkov extends BaseWordMarkov{
	private Map<WordGram, ArrayList<String>> myMap;
	
	public EfficientWordMarkov(int order) {
		super(order);
		myOrder = order;
		myRandom = new Random(RANDOM_SEED);
		myMap = new HashMap<>();
	}
	
	public EfficientWordMarkov() {
		this(2);
	}
	
	@Override
	public void setTraining(String text) {
		myWords = text.split("\\s+");
		ArrayList<String> follows = new ArrayList<String>();
		for (int start = 0; start < myWords.length - myOrder; start++) {
			follows = new ArrayList<String>();
			WordGram wg = new WordGram(myWords, start, myOrder);
			String temp = myWords[start].substring(start, start + myOrder);
			for (int end = start + myOrder; end < text.length(); end++) {
				if (myWords[start].equals(temp)) {
					if (end >= myWords.length-1) {
						follows.add(PSEUDO_EOS);
					}
					else {
						follows.add(myWords[end]);
					}
					break;
				}
			}
//			while (true) {
//				int index = indexOf(myWords,wg,pos);
//				if (index == -1) {
//					break;
//				}
//				int start = index + wg.length();
//				if (start >= myWords.length) {
//					follows.add(PSEUDO_EOS);
//					break;
//				}		
//				follows.add(myWords[start]);
//				pos = index+1;
//			}
			myMap.put(wg, follows);
		}
	}
	
	@Override
	public ArrayList<String> getFollows(WordGram wg) {
		if (! myMap.containsKey(wg)) {
			return new ArrayList<String>();
//			throw new NoSuchElementException(wg + " not in map");
		}
		return myMap.get(wg);
	}
}
