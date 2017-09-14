package tp.pr5.mv;

import javax.swing.JOptionPane;

import tp.pr5.mv.exceptions.InstructionException;
import tp.pr5.mv.exceptions.InstructionExceptionConsts;
import tp.pr5.mv.exceptions.VMException;


public class ExceptionManager {
	
	
	private int mode;
	
	public ExceptionManager (int m) {
		mode = m;
		
	}
	
	public void handleException (InstructionException exc) {
		InstructionExceptionConsts consts = new InstructionExceptionConsts ();
		String [] data = exc.getMessage().split(";");
		String error = "Error en la ejecucion de la instruccion " + data [2] + ". " + consts.getMessage(data [1], Integer.parseInt(data [0]));
		
		if (mode == 2) {
			JOptionPane.showMessageDialog(null, error, "ERROR!", JOptionPane.ERROR_MESSAGE);
		}else {
			System.out.flush();
			System.err.println(error);
			
		}
		
	}
	public void handleException (VMException exc, boolean exit) {
		if (mode == 2) {
			JOptionPane.showMessageDialog(null, exc.getMessage(), "ERROR!", JOptionPane.ERROR_MESSAGE);
		}else {
			System.out.flush();
			System.err.println(exc.getMessage());
			
		}
		if (exit) {
			System.exit(1);
		}
		
	}
	
	public static void handleStaticException (VMException exc) {
		System.out.flush();
		System.err.println(exc.getMessage());
		System.exit(1);		
	}
	
	
}
