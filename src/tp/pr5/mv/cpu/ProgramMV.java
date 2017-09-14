package tp.pr5.mv.cpu;

import java.util.ArrayList;
import tp.pr5.mv.ins.Instruction;
public class ProgramMV {

	private ArrayList<Instruction> program;
	
	
	
	public ProgramMV () {
		program = new ArrayList<Instruction> ();
	}
	
	public void addInstruction (Instruction ins) {
		program.add(ins);
	}
	
	public Instruction getInstruction (Integer pos) {
		return program.get(pos); 
	}
	
	public int length() {
		return program.size();
	}
	
	@Override
	public String toString () {
		String r = "";
		for (int i = 0; i < program.size(); i++) {
			r = r + i + ": " + program.get(i).toString() + System.lineSeparator();
		}
		
		return r;
	}
	
	
}
