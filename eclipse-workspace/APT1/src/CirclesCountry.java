
public class CirclesCountry {
    int crosses = 0;
	
	public int leastBorders(int[] x, int[] y, int[] r, int x1, int y1, int x2, int y2) {
        for (int i = 0; i < x.length; i++)
        {
        		if (isInside(x1, y1, x[i], y[i], r[i]) != isInside(x2, y2, x[i], y[i], r[i]))
        		{
        			crosses++;
        		}
        }
        return crosses;
    }
    
    public boolean isInside(int x, int y, int cx, int cy, int r){
		int dist = (int) (Math.pow(x - cx, 2) + Math.pow(y - cy, 2));
		return dist < r*r;
	}

 }