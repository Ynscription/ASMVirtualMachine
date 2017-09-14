package tp.pr5.mv.iomanagement;

import tp.pr5.mv.controller.OutObserver;
import tp.pr5.mv.exceptions.VMException;

public interface StrategyOut {

	public abstract void printCh (int c) throws VMException;
	
	public abstract void close ();
	

	public void addOutObserver (OutObserver oo);
	
	
}
