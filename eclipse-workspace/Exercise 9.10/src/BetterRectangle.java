import java.awt.Rectangle;
public class BetterRectangle extends Rectangle{

	public BetterRectangle(int x, int y, int width, int height)
	{
		setLocation(x, y);
		setSize(width, height);
	}
	
	public double getPerimeter()
	{
		return 2*(getWidth() + getHeight());
	}
	
	public double getArea(Rectangle r)
	{
		return getWidth()*getHeight();
	}
}
