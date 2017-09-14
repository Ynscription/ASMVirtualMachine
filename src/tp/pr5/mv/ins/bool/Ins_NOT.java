package tp.pr5.mv.ins.bool;

import tp.pr5.mv.cpu.Cpu;
import tp.pr5.mv.cpu.Memory;
import tp.pr5.mv.cpu.OperandStack;
import tp.pr5.mv.exceptions.InstructionException;
import tp.pr5.mv.ins.Instruction;

public class Ins_NOT extends Boolean {

	
	@Override
	protected int operate(int op1, int op2) {
		if (Boolean.isTrue(op1)) {
			return 0;
		}else {
			return 1;
		}
	}
	
	
	
	
	@Override
	public void execute(Cpu cpu, Memory mem, OperandStack os) throws InstructionException {
		if (os.length() < 1) {
			throw new InstructionException(os.length(), type, toString());
		}
		int op1 = os.pop();
		os.push (operate (op1, 0));
		
		
		
	}




	@Override
	public Instruction getMe() {
		return new Ins_NOT();
	}


	

	

}
