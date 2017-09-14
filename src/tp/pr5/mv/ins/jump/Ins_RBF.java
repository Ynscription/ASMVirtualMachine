package tp.pr5.mv.ins.jump;

import tp.pr5.mv.ins.Instruction;

public class Ins_RBF extends RJump {

	@Override
	protected boolean operate(int op1) {
		
		return op1 == 0;
		
	}

	@Override
	public Instruction getMe() {
		return new Ins_RBF();
	}	

}
