package tp.pr5.mv.controller;

public interface AsmObserver {

	public void onProgram(String [] s);
	public void onStep (int currIns);
	
}
