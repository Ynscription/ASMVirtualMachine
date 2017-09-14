package tp.pr5.mv.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JFrame;

import tp.pr5.mv.controller.AsmObserver;
import tp.pr5.mv.controller.DebugController;
import tp.pr5.mv.controller.InObserver;
import tp.pr5.mv.controller.MemoryObserver;
import tp.pr5.mv.controller.OutObserver;
import tp.pr5.mv.controller.RunnerObserver;
import tp.pr5.mv.controller.StackObserver;

@SuppressWarnings("serial")
public class MainW extends JFrame{

	private Container mainPanel;
	private GeneralP generalP;
	private ActionButtonP actionButtonP;
	
	public MainW (DebugController dc) throws HeadlessException{
		//Titulo de la ventana
		super ("TP Virtual Machine");
		
		//Calculamos la dimension de la ventana de acuerdo a la pantalla
		Insets scnMax = Toolkit.getDefaultToolkit().getScreenInsets(getGraphicsConfiguration());
		int taskBarSize = scnMax.bottom;
		Dimension screenDimension = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
		screenDimension.height = screenDimension.height - taskBarSize;
		
		//Establecemos parametros
		this.setSize(screenDimension);
		this.setResizable(true);
		this.setLocation(0, 0);
		
		//dividimos el contenedor
		mainPanel = this.getContentPane();
		mainPanel.setLayout(new BorderLayout());
		actionButtonP = new ActionButtonP(dc);
		mainPanel.add (actionButtonP, BorderLayout.NORTH);
		generalP = new GeneralP(dc);
		mainPanel.add (generalP,BorderLayout.CENTER);
		
		
		
		//Mostramos la ventana
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	
	
	
	
	public AsmObserver getAsmObserver () {
		return generalP.getAsmObserver();
	}
	
	public StackObserver getStackObserver () {
		return generalP.getStackObserver();
	}
	
	public MemoryObserver getMemoryObserver () {
		return generalP.getMemoryObserver();
	}
	
	public InObserver getInObserver () {
		return generalP.getInObserver();
	}
	
	public OutObserver getoOutObserver () {
		return generalP.getoOutObserver();
	}
	
	public RunnerObserver getRunnerObserver () {
		return actionButtonP;
	}
	
}
