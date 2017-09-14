package tp.pr5.mv.ins.sequential;

import tp.pr5.mv.cpu.Cpu;
import tp.pr5.mv.cpu.Memory;
import tp.pr5.mv.cpu.OperandStack;
import tp.pr5.mv.exceptions.InstructionException;
import tp.pr5.mv.ins.Instruction;

public class Ins_LOADIND extends Sequential {

	@Override
	public void execute(Cpu cpu, Memory mem, OperandStack os) throws InstructionException {
		if (os.length() < 1) {
			throw new InstructionException(os.length(), type, toString());
		}
		int op1 = os.pop();
		if (op1 < 0) {
			throw new InstructionException(3, type, toString());
		}
		Integer i = mem.read(op1);
		if (i == null) {
			throw new InstructionException(4, type, toString());
		}
		
		os.push(i);
		
	}

	@Override
	public Instruction getMe() {
		return new Ins_LOADIND();
	}

}
