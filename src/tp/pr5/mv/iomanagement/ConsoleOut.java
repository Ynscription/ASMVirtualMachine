package tp.pr5.mv.iomanagement;

import tp.pr5.mv.controller.OutObserver;
import tp.pr5.mv.exceptions.VMException;

public class ConsoleOut implements StrategyOut {

	private OutObserver outO;
	
	public ConsoleOut () {
		
		
		
	}
		
	@Override
	public void printCh(int c) throws VMException {
		if (outO != null) {
			outO.onPrintch((char) c);
		}
		
	}

	@Override
	public void close() {
		
	}

	@Override
	public void addOutObserver(OutObserver oo) {
		outO = oo;
	}
	
	
}
