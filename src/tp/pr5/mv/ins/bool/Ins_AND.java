package tp.pr5.mv.ins.bool;

import tp.pr5.mv.ins.Instruction;

public class Ins_AND extends Boolean {


	@Override
	protected int operate (int op1, int op2) {
		if (Boolean.isTrue(op1) && Boolean.isTrue(op2)) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public Instruction getMe() {
		return new Ins_AND();
	}

}
