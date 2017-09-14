package tp.pr5.mv.cpu;

import tp.pr5.mv.ExceptionManager;
import tp.pr5.mv.comm.CommandInterpreter;
import tp.pr5.mv.comm.CommandParser;
import tp.pr5.mv.exceptions.VMException;

public class Debugger {

	private Cpu cpu;
	private ExceptionManager exceptionManager;
	
	public Debugger (Cpu c, ExceptionManager eM) {
		cpu = c;
		exceptionManager = eM;
	}
	
	public boolean runCommand (String command) {
		CommandInterpreter comm;
		try {
			comm = CommandParser.parse(command);
			
			if (comm != null) {
				
				if (!comm.executeCommand(cpu)) {
					return false;
				}
			}else {
				throw new VMException("Comando no reconocido");
			}
			if (comm.toString().equals("QUIT")) {
				return false;
			}
			
		
		}catch (VMException e) {
			exceptionManager.handleException(e, false);
		}
		return true;
	}
	
	
	
}
