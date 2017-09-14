package tp.pr5.mv.comm;

import tp.pr5.mv.cpu.Cpu;
import tp.pr5.mv.ins.ICommander;
import tp.pr5.mv.ins.Instruction;
import tp.pr5.mv.ins.InstructionParser;

public class Comm_INS extends CommandInterpreter {

	private Instruction instruction;
	
	public Comm_INS() {
	}
	
	public Comm_INS(Instruction in) {
		instruction = in;
	}


	@Override
	public boolean executeCommand(Cpu cpu) {
		return cpu.step(instruction);
	}

	
	public CommandInterpreter getMe(String ins) {
		Instruction in = InstructionParser.parse(ins);
		if (in != null) {
			try {
				@SuppressWarnings("unused")
				ICommander ic = (ICommander)in;
				return new Comm_INS(in);
			}catch (ClassCastException e) {
				return null;
			}
		}
		return null;
	}



	@Override
	public CommandInterpreter getMe() {
		return null;
	}
	
	
	
}
