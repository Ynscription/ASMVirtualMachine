package tp.pr5.mv.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import tp.pr5.mv.controller.DebugController;
import tp.pr5.mv.controller.RunnerObserver;

@SuppressWarnings("serial")
public class ActionButtonP extends JPanel implements RunnerObserver{

	private DebugController debugController;
	private Thread threadRun;
	private boolean finished;
	private boolean isRunning;
	
	ActionButtonB stepb;
	ActionButtonB runb;
	ActionButtonB pauseb;
	ActionButtonB exitb;
	
	
	public ActionButtonP (DebugController dc) {
		debugController = dc;
		isRunning = false;
		this.setBorder(new TitledBorder(BorderFactory.createLineBorder(new Color(0, 168, 231)), "Acciones"));
		
		stepb = null;
		runb = null;
		pauseb = null;
		exitb = null;
		
		
		Icon is = ActionButtonB.image("step");
		Icon ir = ActionButtonB.image("run");
		Icon ip = ActionButtonB.image("pause");
		Icon ie = ActionButtonB.image("exit");
		
		
		if (is != null) {
			 stepb = new ActionButtonB(is);
		
		}else {
			stepb = new ActionButtonB("STEP");
		}
		
		
		if (ir != null) {
			 runb = new ActionButtonB(ir);
		
		}else {
			runb = new ActionButtonB("RUN");
		}
		
		if (ip != null) {
			 pauseb = new ActionButtonB(ip);
		
		}else {
			pauseb = new ActionButtonB("PAUSE");
		}
				
		if (ie != null) {
			 exitb = new ActionButtonB(ie);
		
		}else {
			exitb = new ActionButtonB("EXIT");
		}
		
		
		
		
		
		stepb.setName("STEP");
		runb.setName("RUN");
		pauseb.setName("PAUSE");
		exitb.setName("EXIT");
		
		ButtonListener b = new ButtonListener();
		
		stepb.addActionListener(b);
		runb.addActionListener(b);
		pauseb.addActionListener(b);
		exitb.addActionListener(b);
		
		pauseb.setEnabled(false);
		
		this.add(stepb);
		this.add(runb);
		this.add(pauseb);
		this.add(exitb);
		
		
	
		
	}
	
	private class ButtonListener implements ActionListener {
		
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if (((ActionButtonB)e.getSource()).getName().equalsIgnoreCase("STEP")) {
				if (!finished){
					RunRunnable runRunable = new RunRunnable(debugController, true);
					threadRun = new Thread (runRunable);
					threadRun.start();
					
				}else {
					JOptionPane.showMessageDialog(null, "El programa ya ha terminado", "ERROR!", JOptionPane.ERROR_MESSAGE);
				}
				
			}else if(((ActionButtonB)e.getSource()).getName().equalsIgnoreCase("RUN")){
				if (!finished){
					RunRunnable runRunable = new RunRunnable(debugController, false);
					threadRun = new Thread (runRunable);
					threadRun.start();
				}else {
					JOptionPane.showMessageDialog(null, "El programa ya ha terminado", "ERROR!", JOptionPane.ERROR_MESSAGE);
				}
				
			}else if(((ActionButtonB)e.getSource()).getName().equalsIgnoreCase("PAUSE")){
				
				threadRun.interrupt();
				
				
			}else if(((ActionButtonB)e.getSource()).getName().equalsIgnoreCase("EXIT")){
				if (JOptionPane.showConfirmDialog(null, "¿Realmente desea abandonar la aplicación?", "Exit", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE) == JOptionPane.YES_OPTION) {
					
					debugController.runCommand("quit");
				
				}
				
			}
		}
	}

	@Override
	public void beforeStep(String instruction) {
		
	}

	@Override
	public void afterStep(String result) {
		
	}

	@Override
	public void onEnd() {
		finished = true;
	}

	
}
