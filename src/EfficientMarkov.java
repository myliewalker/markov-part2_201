
public class EfficientMarkov<myMap> extends BaseMarkov {
    Map<String, ArrayList<String>> myMap;
    
    public EfficientMarkov(int order)) {
        super(order);
        myMap = new HashMap<>();
    }

    public EfficientMarkov() {
        myMap = new HashMap<>();
    }

    @Override
    public void setTraining(String text) {
		myText = text;
	}

}