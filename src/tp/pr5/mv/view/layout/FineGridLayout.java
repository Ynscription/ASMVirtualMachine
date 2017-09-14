package tp.pr5.mv.view.layout;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager2;
import java.util.HashMap;
import java.util.Map;

public class FineGridLayout implements LayoutManager2 {
	
	private Dimension gridDimension;

	private Map<Component, FineGridConstraints> mapConstraints;

	
	
	public FineGridLayout (int width, int height) {
		mapConstraints = new HashMap<Component, FineGridConstraints>();
		gridDimension = new Dimension(width, height);
	}
	
	public FineGridLayout (Dimension dimension) {
		mapConstraints = new HashMap<Component, FineGridConstraints>();
		gridDimension = new Dimension(dimension);
	}
	
	
	
	

	public FineGridConstraints getConstraintsFor(Component comp) {
		return mapConstraints.get(comp);
	}

	public void setConstraintsFor(Component comp, FineGridConstraints fc) {
		mapConstraints.put(comp, fc);
	}

	@Override
	public void addLayoutComponent(Component comp, Object constraints) {
		if (constraints instanceof FineGridConstraints) {
			mapConstraints.put(comp, (FineGridConstraints) constraints);
		} else {
			throw new IllegalArgumentException(
					"Constraints must be ProportionalConstraints");
		}
	}

	@Override
	public Dimension maximumLayoutSize(Container target) {
		return preferredLayoutSize(target);
	}

	@Override
	public float getLayoutAlignmentX(Container target) {
		return 0.5f;
	}

	@Override
	public float getLayoutAlignmentY(Container target) {
		return 0.5f;
	}

	@Override
	public void invalidateLayout(Container target) {

	}

	@Override
	public void addLayoutComponent(String name, Component comp) {

	}

	@Override
	public void removeLayoutComponent(Component comp) {
		mapConstraints.remove(comp);
	}

	@Override
	public Dimension preferredLayoutSize(Container parent) {
		return parent.getSize();
	}

	@Override
	public Dimension minimumLayoutSize(Container parent) {
		return preferredLayoutSize(parent);
	}

	@Override
	public void layoutContainer(Container parent) {
		int width = parent.getWidth();
		int height = parent.getHeight();
		
		int wFraction = width/gridDimension.width;
		int hFraction = height/gridDimension.height;
		
		for (Component comp : parent.getComponents()) {
			FineGridConstraints con = mapConstraints.get(comp);
			
			if (con != null) {
				
				int sx = wFraction * con.getX();
				int sy = hFraction * con.getY();
				int ex = wFraction * con.getWidth();
				int ey = hFraction * con.getHeight(); 
				
				
				comp.setLocation(sx, sy);
				comp.setSize(ex, ey);
				
			} else {
				comp.setBounds(0, 0, 0, 0);
			}
		}
	}

}
