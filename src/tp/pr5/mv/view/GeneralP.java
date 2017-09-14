package tp.pr5.mv.view;

import javax.swing.JPanel;

import tp.pr5.mv.controller.AsmObserver;
import tp.pr5.mv.controller.DebugController;
import tp.pr5.mv.controller.InObserver;
import tp.pr5.mv.controller.MemoryObserver;
import tp.pr5.mv.controller.OutObserver;
import tp.pr5.mv.controller.StackObserver;
import tp.pr5.mv.view.layout.FineGridConstraints;
import tp.pr5.mv.view.layout.FineGridLayout;

@SuppressWarnings("serial")
public class GeneralP extends JPanel {
	
	private AsmP asmP;
	private StackP stackP;
	private MemoryP memP;
	private InP inP;
	private OutP outP;
	
	
	public GeneralP (DebugController dc) {
		this.setLayout(new FineGridLayout(3,4));
		
		
		FineGridConstraints asmpCons = new FineGridConstraints(0, 0, 1, 4);
		asmP = new AsmP();
		this.add(asmP, asmpCons);
		
		
		FineGridConstraints stackCons = new FineGridConstraints(1, 0, 1, 2);
		stackP = new StackP(dc);
		this.add(stackP,stackCons);
		
		FineGridConstraints memCons = new FineGridConstraints(2, 0, 1, 2);
		memP = new MemoryP(dc);
		this.add (memP, memCons);
		
		FineGridConstraints inCons = new FineGridConstraints(1, 2, 2, 1);
		inP = new InP();
		this.add (inP, inCons);
		
		FineGridConstraints outCons = new FineGridConstraints(1, 3, 2, 1);
		outP = new OutP();
		this.add (outP, outCons);
		
	
		
		
	
	}	
	
	public AsmObserver getAsmObserver () {
		return asmP;
	}
	
	public StackObserver getStackObserver () {
		return stackP;
	}

	public MemoryObserver getMemoryObserver() {
		return memP;
	}
	
	public InObserver getInObserver () {
		return inP;
	}
	
	public OutObserver getoOutObserver () {
		return outP;
	}

}
