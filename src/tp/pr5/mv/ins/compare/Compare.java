package tp.pr5.mv.ins.compare;

import tp.pr5.mv.cpu.Cpu;
import tp.pr5.mv.cpu.Memory;
import tp.pr5.mv.cpu.OperandStack;
import tp.pr5.mv.exceptions.InstructionException;
import tp.pr5.mv.ins.Instruction;


public abstract class Compare extends Instruction {

	public static String type = "COMPARE";
	
	protected abstract int operate (int op1, int op2);
	
	public void execute(Cpu cpu, Memory mem, OperandStack os) throws InstructionException {
		if (os.length() < 2) {
			throw new InstructionException(os.length(), type, toString());
		}
		
		int op2 = os.pop();
		int op1 = os.pop();
		os.push (operate(op1, op2));
		
	}
	
	
	
}
