package tp.pr5.mv.controller;

public interface RunnerObserver {

	
	public void beforeStep (String instruction);
	public void afterStep (String result);
	public void onEnd ();
	
}
