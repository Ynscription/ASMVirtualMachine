package tp.pr5.mv.ins.sequential;

import tp.pr5.mv.cpu.Cpu;
import tp.pr5.mv.cpu.Memory;
import tp.pr5.mv.cpu.OperandStack;
import tp.pr5.mv.exceptions.InstructionException;
import tp.pr5.mv.ins.ICommander;
import tp.pr5.mv.ins.Instruction;

public class Ins_WRITE extends Sequential implements ICommander{

	
	@Override
	public void execute(Cpu cpu, Memory mem, OperandStack os) throws InstructionException {
		
		if(parameter < 0) {
			throw new InstructionException(3, type, toString());
		}
		mem.write(parameter2, parameter);
	}

	@Override
	public Instruction getMe() {

		return new Ins_WRITE();
	}

}
