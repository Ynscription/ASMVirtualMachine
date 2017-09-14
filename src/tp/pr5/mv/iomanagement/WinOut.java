package tp.pr5.mv.iomanagement;

import tp.pr5.mv.controller.OutObserver;
import tp.pr5.mv.exceptions.VMException;

public class WinOut implements StrategyOut{

	private StrategyOut subStrat;
	private OutObserver outO;
	
	public WinOut (StrategyOut subS) {
		subStrat = subS;
	}
	
	
	@Override
	public void printCh(int c) throws VMException {
		subStrat.printCh(c);
		outO.onPrintch((char) c);
	}

	@Override
	public void close() {
		subStrat.close();
		
	}


	@Override
	public void addOutObserver(OutObserver oo) {
		outO = oo;
	}
	
}
