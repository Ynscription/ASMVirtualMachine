package tp.pr5.mv.ins.jump;

import tp.pr5.mv.cpu.Cpu;
import tp.pr5.mv.cpu.Memory;
import tp.pr5.mv.cpu.OperandStack;
import tp.pr5.mv.exceptions.InstructionException;
import tp.pr5.mv.ins.Instruction;

public abstract class RJump extends Instruction {
	
	public static String type = "JUMP";

	protected abstract boolean operate (int op1);
	
	@Override
	public void execute(Cpu cpu, Memory mem, OperandStack os) throws InstructionException {
		if (os.length() < 1) {
			throw new InstructionException(os.length(), type, toString());
		}
		int op1 = os.pop();
		if (op1 < 0) {
			throw new InstructionException(3, type, toString());
		}
		if (operate (op1)) {
			cpu.currentInstruction = cpu.currentInstruction + parameter -1;
				
		}
	}

}
