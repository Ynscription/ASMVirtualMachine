package tp.pr5.mv.view;

import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class ActionButtonB extends JButton{
	
	
	public static Icon image(String file) {
		URL path = ActionButtonB.class.getResource("resources/" + file + ".png");
		if (path != null) {
			return new ImageIcon (path);
		}else {
			return null;
		}
		
		
	}
	
	public ActionButtonB (String title) {
		
		super(title);
		this.setSize(48,48);
		
			
		
	}

	public ActionButtonB (Icon buttonIcon) {
		
		super(buttonIcon);
		this.setSize(buttonIcon.getIconWidth(),buttonIcon.getIconHeight());
		
		
		
		
		
	}
	
}
