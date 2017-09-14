package tp.pr5.mv.view;

import tp.pr5.mv.controller.AsmObserver;
import tp.pr5.mv.controller.OutObserver;
import tp.pr5.mv.controller.RunnerObserver;

public abstract class MainView implements AsmObserver, OutObserver, RunnerObserver{

	public abstract void run ();
	
}
