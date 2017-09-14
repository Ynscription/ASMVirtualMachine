package tp.pr5.mv.ins.sequential;

import tp.pr5.mv.cpu.Cpu;
import tp.pr5.mv.cpu.Memory;
import tp.pr5.mv.cpu.OperandStack;
import tp.pr5.mv.ins.Instruction;

public class Ins_END extends Sequential {

	@Override
	public void execute(Cpu cpu, Memory mem, OperandStack os) {
		
	}

	@Override
	public Instruction getMe() {
		return new Ins_END();
	}

}
