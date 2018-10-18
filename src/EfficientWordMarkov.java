import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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
		for (int start = 0; start <= myWords.length - myOrder; start++) {
			WordGram wg = new WordGram(myWords, start, myOrder);
			if (start == text.length() - myOrder) {
				if (! myMap.containsKey(wg)) {
					myMap.put(wg, new ArrayList<String>());
				}
				myMap.get(wg).add(PSEUDO_EOS);
				break;
			}
			if (new WordGram(myWords, start, myOrder).equals(wg)) {
				if (! myMap.containsKey(wg)) {
					myMap.put(wg, new ArrayList<String>());
				}
				myMap.get(wg).add(myWords[start + myOrder -1]);
			}
		}
	}
	
//	public void setTraining(String text) {
//		myText = text;
//		String temp = "";
//		for (int start = 0; start <= text.length() - myOrder; start++) {
//			temp = text.substring(start, start + myOrder);
//			if (start == text.length() - myOrder) {
//				if (! myMap.containsKey(temp)) {
//					myMap.put(temp, new ArrayList<String>());
//				}
//				myMap.get(temp).add(PSEUDO_EOS);
//				break;
//			}
//			if (myText.substring(start, start+myOrder).equals(temp)) {
//				if (! myMap.containsKey(temp)) {
//					myMap.put(temp, new ArrayList<String>());		
//				}
//				myMap.get(temp).add(myText.substring(start + myOrder, start + myOrder + 1));
//			}
//		}
//	}
	
	@Override
	public ArrayList<String> getFollows(WordGram wg) {
		if (! myMap.containsKey(wg)) {
			return new ArrayList<String>();
		}
		return myMap.get(wg);
	}
}
