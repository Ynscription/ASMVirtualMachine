package tp.pr5.mv.ins.jump;

import tp.pr5.mv.cpu.Cpu;
import tp.pr5.mv.cpu.Memory;
import tp.pr5.mv.cpu.OperandStack;
import tp.pr5.mv.exceptions.InstructionException;
import tp.pr5.mv.ins.Instruction;

public class Ins_RJUMP extends RJump {

	
	@Override
	protected boolean operate(int op1) {
		return false;
	}
	
	@Override
	public void execute(Cpu cpu, Memory mem, OperandStack os) throws InstructionException {
		if (cpu.currentInstruction + parameter -1 < 0) {
			throw new InstructionException(3, type, toString());
		}
		cpu.currentInstruction = cpu.currentInstruction + parameter -1;
		
	}

	@Override
	public Instruction getMe() {
		return new Ins_RJUMP();
	}

	

}
