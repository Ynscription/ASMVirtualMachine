package tp.pr5.mv.ins.arithmetic;

import tp.pr5.mv.ins.Instruction;


public class Ins_SUB  extends Arithmetic{

	@Override
	protected int operate (int op1, int op2) {
		return op1 - op2;		
	}

	@Override
	public Instruction getMe() {
		return new Ins_SUB();
	}
	
}
