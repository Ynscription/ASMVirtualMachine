package tp.pr5.mv.iomanagement;



import tp.pr5.mv.exceptions.VMException;

public class WinIn implements StrategyIn{

	private StrategyIn subStrat;
	
	public WinIn (StrategyIn subS) {
		subStrat = subS;
		
	}
	
	
	@Override
	public int getCh() throws VMException {
		int r = subStrat.getCh();
		return r;
	}
	
	
	@Override
	public void close() {
		subStrat.close();
		
	}


	@Override
	public String getText() {
		return subStrat.getText();
	}



}
