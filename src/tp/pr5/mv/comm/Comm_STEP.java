package tp.pr5.mv.comm;

import tp.pr5.mv.cpu.Cpu;

public class Comm_STEP extends CommandInterpreter {

	
	public Comm_STEP () {
		param1 = 1;
	}
	
	@Override
	public boolean executeCommand(Cpu cpu) {
		boolean hasNotBlown = true;
		for (int i = 0; i < param1 && hasNotBlown; i++) {
			if (cpu.hasNextInstruction()) {
				if (!cpu.step()) {
					hasNotBlown = false;
					
				}
			}
		}
		return hasNotBlown;
	}
	


	@Override
	public CommandInterpreter getMe() {
		return new Comm_STEP();
	}
	
	

}
