package tp.pr5.mv.ins.sequential;

import tp.pr5.mv.cpu.Cpu;
import tp.pr5.mv.cpu.Memory;
import tp.pr5.mv.cpu.OperandStack;
import tp.pr5.mv.exceptions.InstructionException;
import tp.pr5.mv.ins.Instruction;

public class Ins_LOAD extends Sequential {

	@Override
	public void execute(Cpu cpu, Memory mem, OperandStack os) throws InstructionException {
		
		if (parameter < 0) {
			throw new InstructionException(3, type, toString());
		}
		Integer i = mem.read(parameter);
		if (i == null) {
			throw new InstructionException(4, type, toString());
		}
		
		os.push(i);
	}

	@Override
	public Instruction getMe() {
		return new Ins_LOAD();
	}

}
