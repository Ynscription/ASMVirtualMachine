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
public class MemoryUtilP extends JPanel{

	

	private JTextField value;
	private JTextField position;
	private JButton writeB;
	
	public MemoryUtilP () {
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
	
		c.insets = new Insets(3, 3, 3, 3);
		c.gridx = 0;
		c.gridy = 0;
		
		this.add(new JLabel("Pos:"),c);
		
		c.gridx = 2;
		c.gridy = 0;
		
		this.add(new JLabel("Val:"),c);
		
		c.gridx = 1;
		c.gridy = 0;
		
		position = new JTextField(6);
		
		this.add(position,c);
		
		c.gridx = 3;
		c.gridy = 0;
		
		value = new JTextField(6);
		
		this.add(value,c);
		
		c.gridx = 1;
		c.gridy = 1;
		
		writeB = new JButton ("Write");
		this.add (writeB,c);

		
		
		
		
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
	
	public Integer getPos () {
		try {
			Integer p = Integer.parseInt(position.getText());
			position.setText("");
			return p;
		}catch (NumberFormatException e) {
			position.setText("");
			return null;
		}
		
	}
	
	public void addButtonListener (ActionListener l) {
		writeB.addActionListener(l);
	}
	
}
