package tp.pr5.mv.comm;

import tp.pr5.mv.cpu.Cpu;

public class Comm_QUIT extends CommandInterpreter {

	@Override
	public boolean executeCommand(Cpu cpu) {
		cpu.stopRunning();
		System.exit(0);
		return true;
	}

	@Override
	public CommandInterpreter getMe() {
		return new Comm_QUIT();
	}

}
