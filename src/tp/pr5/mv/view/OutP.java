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

import tp.pr5.mv.controller.OutObserver;



@SuppressWarnings("serial")
public class OutP extends JPanel implements OutObserver{

	private JTextArea area;
	
	public OutP () {
		
		this.setBorder(new TitledBorder(BorderFactory.createLineBorder(new Color(0, 168, 231)), "Salida del programa"));
		this.setLayout(new BorderLayout());
		
		area = new JTextArea(0,0);
		area.setBorder(new CompoundBorder(BorderFactory.createLineBorder(new Color(202, 202, 202)), BorderFactory.createLineBorder(new Color(101, 101, 101))));
		area.setEditable(false);
		area.setLineWrap(true);
		area.setWrapStyleWord(true);
		
		
		
		JScrollPane outSP = new JScrollPane(area);
		
		this.add (outSP,BorderLayout.CENTER);
		
		
	}
	

	@Override
	public void onPrintch(final char mander) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {

				area.setText(area.getText() + mander);
				
			}
		});
		
	}
	
}
