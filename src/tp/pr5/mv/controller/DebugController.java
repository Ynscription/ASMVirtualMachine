package tp.pr5.mv.controller;

import tp.pr5.mv.cpu.Debugger;

public class DebugController {

	private Debugger debugger;
	
	
	public DebugController (Debugger deb){
		debugger = deb;
		
	}
	
	
	public boolean runCommand (String command) {
		return debugger.runCommand(command);
	}
	
	
}
