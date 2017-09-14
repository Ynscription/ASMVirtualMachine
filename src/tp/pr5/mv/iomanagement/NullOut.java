package tp.pr5.mv.iomanagement;

import tp.pr5.mv.controller.OutObserver;
import tp.pr5.mv.exceptions.VMException;

public class NullOut implements StrategyOut {

	
	public NullOut () {
		
		
	}
	
	

	@Override
	public void printCh(int c) throws VMException {
			
	}


	@Override
	public void close() {
		
	}



	@Override
	public void addOutObserver(OutObserver oo) {
	}

}
