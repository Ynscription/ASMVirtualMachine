package tp.pr5.mv.ins.compare;

import tp.pr5.mv.ins.Instruction;

public class Ins_GT extends Compare {

	
	@Override
	protected int operate(int op1, int op2) {
		
		if (op1 > op2) {
			return 1;
		}else {
			return 0;
		}
		
	}

	@Override
	public Instruction getMe() {
		return new Ins_GT();
	}

}
