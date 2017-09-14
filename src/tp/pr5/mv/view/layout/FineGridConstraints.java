package tp.pr5.mv.view.layout;

public class FineGridConstraints {

	private int posX;
	private int posY;
	private int width;
	private int height;

	public FineGridConstraints(int px, int py, int w, int h) {
		posX = px;
		posY = py;
		width = w;
		height = h;
			
	}

	public int getX() {
		return posX;
	}

	public int getY() {
		return posY;
	}
	
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public void setX(int x) {
		
		posX = x;
	}

	public void setY(int y) {
		
		posY = y;
	}
	
	public void setWidth(int w) {
		
		width = w;
	}

	public void setHeight(int h) {
		
		height = h;
	}

}
