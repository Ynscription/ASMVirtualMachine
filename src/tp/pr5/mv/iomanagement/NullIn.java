package tp.pr5.mv.iomanagement;

import tp.pr5.mv.exceptions.VMException;

public class NullIn implements StrategyIn {

	public NullIn () {
		
	}

	@Override
	public int getCh() throws VMException {
		return -1;
	}

	@Override
	public void close() {
		
	}

	@Override
	public String getText() {
		return "";
	}
	
	
	
	
}
