package tp.pr5.mv.view.mainViews;


import tp.pr5.mv.controller.DebugController;
import tp.pr5.mv.view.MainView;

public class BatchView extends MainView {

	private DebugController debugC;
	
	public BatchView (DebugController dc) {
		debugC =dc;
	}

	@Override
	public void run() {
		
		debugC.runCommand("run");
				
	}

	@Override
	public void beforeStep(String instruction) {
		System.out.println("Comienza la ejecucion de la instruccion: " + instruction);
	}

	@Override
	public void afterStep(String result) {
		System.out.println(result);
	}

	@Override
	public void onPrintch(char mander) {
		System.out.println(mander);
		
	}

	@Override
	public void onProgram(String[] s) {
		System.out.println("PROGRAMA");
		for (int i = 0; i < s.length; i++) {
			System.out.println("  " + s[i]);
		}
	}

	@Override
	public void onStep(int currIns) {
		
	}

	@Override
	public void onEnd() {
		
	}
	
	
	
}
