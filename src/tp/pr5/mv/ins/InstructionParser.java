package tp.pr5.mv.ins;

import tp.pr5.mv.ins.arithmetic.*;
import tp.pr5.mv.ins.bool.*;
import tp.pr5.mv.ins.compare.*;
import tp.pr5.mv.ins.jump.*;
import tp.pr5.mv.ins.sequential.*;


public class InstructionParser {
	
	private static Instruction [] insVector1 = {new Ins_ADD(), new Ins_AND(), new Ins_DIV(), new Ins_DUP(), new Ins_END(), 
												new Ins_EQ(), new Ins_FLIP(), new Ins_GT(), new Ins_HALT(), new Ins_IN(), 
												new Ins_JUMPIND(), new Ins_LE(), new Ins_LOADIND(), new Ins_LT(), 
												new Ins_MUL(), new Ins_NEG(), new Ins_NOT(), new Ins_OR(),new Ins_OUT(), 
												new Ins_POP(), new Ins_STOREIND(), new Ins_SUB()};
	
	private static Instruction [] insVector2 = {new Ins_BF(), new Ins_BT(), new Ins_JUMP(), new Ins_LOAD(), new Ins_PUSH(), 
												new Ins_RBF(), new Ins_RBT(), new Ins_RJUMP(), new Ins_STORE()};
	
	
	private static Instruction [] insVector3 = {new Ins_WRITE()};
	
	
	
	public InstructionParser() {

	}

	public static Instruction parse(String ins) {
		Instruction in = null;
		String aux[] = ins.split(" ");
		if (aux.length == 1) {
			
			for (int i = 0; i < insVector1.length; i++) {
				if (insVector1[i].toString().equalsIgnoreCase(aux[0])) {
					in = insVector1[i].getMe();
				}
			}
			
		} else if (aux.length == 2) {
			try {
				int p = (Integer.parseInt(aux[1]));
				for (int i = 0; i < insVector2.length; i++) {
					if (insVector2[i].toString().equalsIgnoreCase(aux[0])) {
						in = insVector2[i].getMe();
						in.parameter = p;
					}
				}
				
			} catch (NumberFormatException e) {
				
			}

		} else if (aux.length == 3) {
			try {
				int p1 = (Integer.parseInt(aux[1]));
				int p2 = (Integer.parseInt(aux[2]));
				for (int i = 0; i < insVector3.length; i++) {
					if (insVector3[i].toString().equalsIgnoreCase(aux[0])) {
						in = insVector3[i].getMe();
						in.parameter = p1;
						in.parameter2 = p2;
					}
				}
				
			} catch (NumberFormatException e) {
				
			}

		}
		return in;
	}
}
