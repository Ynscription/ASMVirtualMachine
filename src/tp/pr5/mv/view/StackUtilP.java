package tp.pr5.mv.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class StackUtilP extends JPanel{
	
	private JTextField value;
	private JButton pushB;
	private JButton popB;
	
	
	public StackUtilP () {
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
	
		c.insets = new Insets(3, 3, 3, 3);
		c.gridx = 0;
		c.gridy = 0;
		
		this.add(new JLabel("Valor:"),c);
		
		c.gridx = 1;
		c.gridy = 0;
		
		value = new JTextField(6);
		
		this.add(value,c);
				
		c.gridx = 2;
		c.gridy = 0;
		
		pushB = new JButton ("Push");
		pushB.setName("PUSH");
		this.add(pushB,c);
		
		c.gridx = 1;
		c.gridy = 1;
		
		popB = new JButton ("Pop");
		popB.setName("POP");
		this.add (popB,c);
		
		
	}
	
	public Integer getValue () {
		try {
			Integer v = Integer.parseInt(value.getText()); 
			value.setText("");
			return v;
		}catch (NumberFormatException e) {
			value.setText("");
			return null;
		}
	}
	
	public void addButtonListener (ActionListener l) {
		pushB.addActionListener(l);
		popB.addActionListener(l);
	}
	
	
	
}
