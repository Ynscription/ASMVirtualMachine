package tp.pr5.mv.exceptions;

@SuppressWarnings("serial")
public class VMException extends Exception {
	
	protected String message;
	
	
	public VMException (String m) {
		message = m;
	}
	
	@Override
	public String getMessage (){
		return message;
	}
	
		
}
