package tp.pr5.mv.ins.sequential;

import tp.pr5.mv.cpu.Cpu;
import tp.pr5.mv.cpu.Memory;
import tp.pr5.mv.cpu.OperandStack;
import tp.pr5.mv.exceptions.InstructionException;
import tp.pr5.mv.ins.Instruction;

public class Ins_OUT extends Sequential {

	
	@Override
	public void execute(Cpu cpu, Memory mem, OperandStack os) throws InstructionException {
		if (os.length() < 1) {
			throw new InstructionException(os.length(), type, toString());
		}
		char mander = (char)((int)(os.pop()));
		
		cpu.printCh(mander);
		
	}
	
	
		
	
	@Override
	public Instruction getMe() {
		return new Ins_OUT();
	}

}
