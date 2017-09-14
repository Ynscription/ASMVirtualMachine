package tp.pr5.mv.ins.sequential;

import tp.pr5.mv.cpu.Cpu;
import tp.pr5.mv.cpu.Memory;
import tp.pr5.mv.cpu.OperandStack;
import tp.pr5.mv.exceptions.InstructionException;
import tp.pr5.mv.ins.Instruction;

public class Ins_STOREIND extends Sequential {

	@Override
	public void execute(Cpu cpu, Memory mem, OperandStack os) throws InstructionException {
		if (os.length() < 2) {
			throw new InstructionException(os.length(), type, toString());
		}
		int cima = os.pop();
		int subcima = os.pop();
		if (subcima < 0) {
			throw new InstructionException(3, type, toString());
		}
		mem.write(cima, subcima);
	}

	@Override
	public Instruction getMe() {
		return new Ins_STOREIND();
	}

}
