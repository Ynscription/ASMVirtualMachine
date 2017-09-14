package tp.pr5.mv.ins;

import tp.pr5.mv.cpu.*;
import tp.pr5.mv.exceptions.InstructionException;
import tp.pr5.mv.exceptions.VMException;


public abstract class Instruction  {
		
	public static String type;
		
	public Integer parameter;
	
	public Integer parameter2;

	
	
	
	
	public abstract void execute (Cpu cpu, Memory mem, OperandStack os) throws InstructionException, VMException;
	
	
	public abstract Instruction getMe ();
	
	
	@Override
	public String toString () {
		
		String r = "";
		r = this.getClass().getSimpleName();
		r = r.substring(r.indexOf("_") + 1);
		if (parameter != null) {
			r =  r + " " + parameter.toString();
		}
		if (parameter2 != null) {
			r =  r + " " + parameter2.toString();
		}
		
		return r;
		
	}
	


	
	
	
}
	
	

