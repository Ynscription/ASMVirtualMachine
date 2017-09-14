package tp.pr5.mv.view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;

import tp.pr5.mv.controller.InObserver;

@SuppressWarnings("serial")
public class InP extends JPanel implements InObserver{

	private JTextArea area;
	private int step;
	
	public InP () {
		this.setBorder(new TitledBorder(BorderFactory.createLineBorder(new Color(0, 168, 231)), "Entrada del programa"));
		this.setLayout(new BorderLayout());
		
		area = new JTextArea(0,0);
		area.setBorder(new CompoundBorder(BorderFactory.createLineBorder(new Color(202, 202, 202)), BorderFactory.createLineBorder(new Color(101, 101, 101))));
		area.setEditable(false);
		area.setLineWrap(true);
		area.setWrapStyleWord(true);
		
		
		
		JScrollPane inSP = new JScrollPane(area);
		
		this.add (inSP,BorderLayout.CENTER);
		
		step = 0;
		
	}
	
	

	@Override
	public void onIn() {
		
	
		StringBuilder sb = new StringBuilder(area.getText());
		if ((((int)sb.charAt(step)) != 10) && (((int)sb.charAt(step)) != 13)) {
			sb.setCharAt(step, '*');
			
		}
		final String aux = sb.toString(); 
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				
				area.setText(aux);
				
				
			}
		});
		step++;
		
		
		
	}

	@Override
	public void onStart(final String text) {
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				area.setText(text);
				
			}
		});
		
		
	}
	
}
