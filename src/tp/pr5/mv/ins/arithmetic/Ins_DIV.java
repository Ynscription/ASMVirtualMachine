package tp.pr5.mv.ins.arithmetic;

import tp.pr5.mv.cpu.Cpu;
import tp.pr5.mv.cpu.Memory;
import tp.pr5.mv.cpu.OperandStack;
import tp.pr5.mv.exceptions.InstructionException;
import tp.pr5.mv.exceptions.VMException;
import tp.pr5.mv.ins.Instruction;

public class Ins_DIV extends Arithmetic {

	@Override
	protected int operate (int op1, int op2) {
		return op1 / op2;		
	}
	
	@Override
	public void execute(Cpu cpu, Memory mem, OperandStack os) throws InstructionException, VMException {
		if (os.length() < 2) {
			throw new InstructionException(os.length(), type, toString());
		}
		
		int op2 = os.pop();
		if (op2 == 0) {
			os.push(op2);
			throw new VMException("Division por cero.");
		}
		int op1 = os.pop();
		os.push(operate(op1, op2));
		
		
	}

	@Override
	public Instruction getMe() {
		return new Ins_DIV();
	}

}
