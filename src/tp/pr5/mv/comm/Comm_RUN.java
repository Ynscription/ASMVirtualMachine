package tp.pr5.mv.comm;

import tp.pr5.mv.cpu.Cpu;

public class Comm_RUN extends CommandInterpreter {

	@Override
	public boolean executeCommand(Cpu cpu) {
		boolean hasNotBlown = true;
		if (cpu.hasNextInstruction()) {
			do {
				if (cpu.hasNextInstruction()) {
					
					if (!cpu.step()) {
						hasNotBlown = false;
					}
				}
			}while (cpu.isRunning() && hasNotBlown && cpu.hasNextInstruction());
		}
		return hasNotBlown;
	}

	@Override
	public CommandInterpreter getMe() {
		return new Comm_RUN();
	}

}
