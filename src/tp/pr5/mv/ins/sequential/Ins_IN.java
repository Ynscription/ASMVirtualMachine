package tp.pr5.mv.ins.sequential;

import tp.pr5.mv.cpu.Cpu;
import tp.pr5.mv.cpu.Memory;
import tp.pr5.mv.cpu.OperandStack;
import tp.pr5.mv.exceptions.InstructionException;
import tp.pr5.mv.ins.Instruction;

public class Ins_IN extends Sequential {

	@Override
	public void execute(Cpu cpu, Memory mem, OperandStack os) throws InstructionException {
		os.push(cpu.getCh());
		
	}

	@Override
	public Instruction getMe() {
		
		return new Ins_IN ();
	}

}
