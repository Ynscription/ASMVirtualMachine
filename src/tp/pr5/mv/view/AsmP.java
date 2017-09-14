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

import tp.pr5.mv.controller.AsmObserver;

@SuppressWarnings("serial")
public class AsmP extends JPanel implements AsmObserver{
	
	private JTextArea area;
	private int current;
	private String [] program;
	

	public AsmP() {
		this.setBorder(new TitledBorder(BorderFactory.createLineBorder(new Color(0, 168, 231)), "Programa"));
		this.setLayout(new BorderLayout());
		
		
		area = new JTextArea(0,0);
		area.setBorder(new CompoundBorder(BorderFactory.createLineBorder(new Color(202, 202, 202)), BorderFactory.createLineBorder(new Color(101, 101, 101))));
		area.setEditable(false);
		area.setTabSize(4);
		
		
		JScrollPane asmSP = new JScrollPane(area);
		asmSP.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		this.add (asmSP,BorderLayout.CENTER);
		
		current = 0;
		
		
		
	}
	
	@Override
	public void onProgram(final String[] s) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				area.setText("");
				program = s;
				for (int i = 0; i < program.length; i++) {
					if (i != current) {
						area.setText(area.getText() + "	" + program [i] + System.lineSeparator());
					}else {
						area.setText(area.getText() + "	*" + program [i] + System.lineSeparator());
					}
				}
				
			}
		});
		
		
	}

	@Override
	public void onStep(final int currIns) {
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				current = currIns;
				onProgram(program);
				
			}
		});
		
		
		
	}
	
	
}
