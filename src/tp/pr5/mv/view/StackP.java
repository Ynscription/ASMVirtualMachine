package tp.pr5.mv.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;

import tp.pr5.mv.controller.DebugController;
import tp.pr5.mv.controller.StackObserver;

@SuppressWarnings("serial")
public class StackP extends JPanel implements StackObserver{

	private JList<Integer> operandL;
	private DefaultListModel<Integer> modelo;
	private StackUtilP stackUtilP;
	private DebugController debugController;
	
	public StackP ( DebugController dc) {
		super();
		
		this.setBorder(new TitledBorder(BorderFactory.createLineBorder(new Color(0, 168, 231)), "Pila de Operandos"));
		this.setLayout(new BorderLayout());
		
		modelo = new DefaultListModel<Integer>();
		
		operandL = new JList<Integer>(modelo);
		operandL.setBorder(new CompoundBorder(BorderFactory.createLineBorder(new Color(202, 202, 202)), BorderFactory.createLineBorder(new Color(101, 101, 101))));
		operandL.setEnabled(false);
		this.add(operandL,BorderLayout.CENTER);	
		
		stackUtilP = new StackUtilP();
		this.add(stackUtilP, BorderLayout.SOUTH);
		
		ButtonListener b = new ButtonListener();
		
		stackUtilP.addButtonListener(b);
		
		debugController = dc;
		
	}
	
	
	
	
	private class ButtonListener implements ActionListener {
		
		public ButtonListener () {
			super ();
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if (((JButton)e.getSource()).getName().equalsIgnoreCase("PUSH")) {
				Integer i =  stackUtilP.getValue();
				if (i != null) {
					debugController.runCommand("push " + i);
				}else {
					JOptionPane.showMessageDialog(null, "Error en el formato del numero", "Error", JOptionPane.ERROR_MESSAGE);
				
				}
				
			}else if (((JButton)e.getSource()).getName().equalsIgnoreCase("POP")) {
				if (!modelo.isEmpty()) { 
					debugController.runCommand("pop");
				}
			}
		}
	}


	@Override
	public void onPush(final int op) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				modelo.add(0, op);			
			}
		});
		
		
	}


	@Override
	public void onPop() {
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {

				modelo.remove(0);
				
			}
		});
		
	}

	
	
	
}
