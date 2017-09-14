package tp.pr5.mv.view.mainViews;

import java.util.Scanner;

import tp.pr5.mv.ExceptionManager;
import tp.pr5.mv.controller.DebugController;
import tp.pr5.mv.exceptions.VMException;
import tp.pr5.mv.view.MainView;

public class InteractiveView extends MainView { 

	
	private Scanner scanner;
	private DebugController debugC;
	private ExceptionManager exceptionM;
	private boolean finished;
	
	public InteractiveView (DebugController dc, ExceptionManager eM) {
		 debugC = dc;
		 scanner = new Scanner(System.in);
		 exceptionM = eM;
		 finished = false;
		
	}
	
	@Override
	public void run() {
		boolean go;
		boolean once = true;
		do {
			
			System.out.print (">");
			
			go  = debugC.runCommand(scanner.nextLine());
			if (finished) {
				if (once) {
					once = false;
				}else {
					try {
						throw new VMException("El programa ya ha terminado");
					}catch (VMException e) {
						exceptionM.handleException(e,false);
					}
				}
			}
			
		}while (go);
		scanner.close();
		
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
		finished = true;
	}
	

}
