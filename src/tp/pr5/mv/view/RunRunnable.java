package tp.pr5.mv.view;


import tp.pr5.mv.controller.DebugController;

public class RunRunnable implements Runnable{

	private DebugController debugController;

	private boolean once;
	private boolean finished;
	
	public RunRunnable (DebugController dc, boolean o) {
		debugController = dc;
		once = o;
		finished = false;
	}
	


	@Override
	public void run() {
		try {
			if (!once) {
			
				while (debugController.runCommand("step")) {

					Thread.sleep(100);

				}
							
			}
			if (once) {
			
				debugController.runCommand("step");
		
			}
		} catch (InterruptedException e) {

		}
		
	}
	
	public boolean hasFinished () {
		return finished;
	}
	
}
