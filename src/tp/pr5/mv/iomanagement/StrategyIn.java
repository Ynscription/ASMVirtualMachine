package tp.pr5.mv.iomanagement;

import tp.pr5.mv.exceptions.VMException;

public interface StrategyIn {
	
	public int getCh () throws VMException;
	
	public void close ();
	
	public String getText ();
	
	
}
