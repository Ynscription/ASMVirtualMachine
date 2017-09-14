package tp.pr5.mv.view.mainViews;

import tp.pr5.mv.controller.AsmObserver;
import tp.pr5.mv.controller.DebugController;
import tp.pr5.mv.controller.InObserver;
import tp.pr5.mv.controller.MemoryObserver;
import tp.pr5.mv.controller.OutObserver;
import tp.pr5.mv.controller.RunnerObserver;
import tp.pr5.mv.controller.StackObserver;
import tp.pr5.mv.view.MainView;
import tp.pr5.mv.view.MainW;

public class WindowView extends MainView{

	private DebugController debugC;
	private MainW  mainW;
	
	public WindowView (DebugController dc) {
		debugC = dc;
		mainW = new MainW(debugC);
	}
	
	
	@Override
	public void run() {
		
	}
	
	
	
	
	public AsmObserver getAsmObserver () {
		return mainW.getAsmObserver();
	}
	
	public StackObserver getStackObserver () {
		return mainW.getStackObserver();
	}
	
	public MemoryObserver getMemoryObserver () {
		return mainW.getMemoryObserver();
	}
	
	public InObserver getInObserver () {
		return mainW.getInObserver();
	}
	
	public OutObserver getoOutObserver () {
		return mainW.getoOutObserver();
	}
	
	public RunnerObserver getRunnerObserver () {
		return mainW.getRunnerObserver();
	}
	
	
	


	@Override
	public void onProgram(String[] s) {
		
	}


	@Override
	public void onStep(int currIns) {
		
	}


	@Override
	public void onPrintch(char mander) {
		
	}


	@Override
	public void beforeStep(String instruction) {
		
	}


	@Override
	public void afterStep(String result) {
		
	}


	@Override
	public void onEnd() {
		
	}

	
	
	
	
}
