package tp.pr5.mv.exceptions;

@SuppressWarnings("serial")
public class InstructionException extends VMException {


	public InstructionException (int e, String t,String i) {
		super (e + ";" + t + ";" + i);
		
	}
	
	
	
}
