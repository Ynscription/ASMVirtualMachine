package tp.pr5.mv.ins.jump;

import tp.pr5.mv.cpu.Cpu;
import tp.pr5.mv.cpu.Memory;
import tp.pr5.mv.cpu.OperandStack;
import tp.pr5.mv.exceptions.InstructionException;
import tp.pr5.mv.ins.Instruction;

public class Ins_JUMPIND extends Jump {

	@Override
	protected boolean operate(int op1) {
		return false;
	}
	
	@Override
	public void execute(Cpu cpu, Memory mem, OperandStack os) throws InstructionException {
		if (os.length() < 1) {
			throw new InstructionException(os.length(), type, toString());
		}
		int op1 = os.pop();
		if (op1 < 0) {
			throw new InstructionException(3, type, toString());
		}
		cpu.currentInstruction = op1;
	
	}
	
	
	@Override
	public Instruction getMe() {
		return new Ins_JUMPIND();
	}

}
