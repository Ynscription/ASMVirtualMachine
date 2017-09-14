package tp.pr5.mv.exceptions;

@SuppressWarnings("serial")
public class ASMException extends VMException {

	
	public ASMException (int l, String i) {
		super("Error en el programa. Linea: " + l + ". " + i);
	}
	
	
	
}
