package tp.pr5.mv.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.TreeMap;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import tp.pr5.mv.controller.DebugController;
import tp.pr5.mv.controller.MemoryObserver;

@SuppressWarnings("serial")
public class MemoryP  extends JPanel implements MemoryObserver{

	private JTable memT;
	private DefaultTableModel model;
	private DebugController debugController;
	private MemoryUtilP memUP;
	
	public MemoryP (DebugController dc) {
		
		debugController = dc;
		this.setBorder(new TitledBorder(BorderFactory.createLineBorder(new Color(0, 168, 231)), "Memoria de la Maquina"));
		this.setLayout(new BorderLayout());
		
		model = new DefaultTableModel();
		model.setColumnCount(2);
		
		
		memT = new JTable(model);
		memT.setEnabled(false);
		memT.getTableHeader().getColumnModel().getColumn(0).setHeaderValue("Posicion");
		memT.getTableHeader().getColumnModel().getColumn(1).setHeaderValue("Valor");
		
		
		
		JScrollPane sp = new JScrollPane(memT);
		sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		
		this.add(sp, BorderLayout.CENTER);
		memUP = new MemoryUtilP();
		memUP.addButtonListener(new ButtonListener());
		this.add (memUP, BorderLayout.SOUTH);
		
			
		
	}

	
	
	private class ButtonListener implements ActionListener {
		
		public ButtonListener () {
			super ();
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Integer p = memUP.getPos();
			Integer v = memUP.getValue();
			if ((p != null) && (v != null)) {
				if (p >= 0) {
					
					debugController.runCommand("write " + p + " " + v);
					
				}else {
					JOptionPane.showMessageDialog(null, "No se puede acceder a una posicion de memoria negativa", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}else {
				JOptionPane.showMessageDialog(null, "Error en el formato del numero", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	@Override
	public void update (final TreeMap <Integer,Integer> mem) {
		
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				while (model.getRowCount()> 0) {
					model.removeRow(0);
				}
				
			}
		});
		
		
				
		Iterator<Integer> i = mem.keySet().iterator();

		
		for (int k = 0; i.hasNext(); k++) {
			final int v = (int) i.next();

			final int aux = k;
			SwingUtilities.invokeLater(new Runnable() {
				
				@Override
				public void run() {
					model.insertRow(aux, new Object [] {v,mem.get(v)});
					
				}
			});
		}		
		
	}
	
	
	
	
}
