package tp.pr5.mv.exceptions;

import java.util.HashMap;

public class InstructionExceptionConsts {

	private static String [] arithmetic= {"Faltan operandos en la pila (hay 0)", "Faltan operandos en la pila (hay 1)", "No se puede dividir entre cero"};
	private static String [] bool= {"Faltan operandos en la pila (hay 0)", "Faltan operandos en la pila (hay 1)"};
	private static String [] comp= {"Faltan operandos en la pila (hay 0)", "Faltan operandos en la pila (hay 1)"};
	private static String [] jump= {"Faltan operandos en la pila (hay 0)", "Faltan operandos en la pila (hay 1)", "No se puede alcanzar la instruccion", "No se puede saltar a una instruccion negativa"};
	private static String [] seq = {"Faltan operandos en la pila (hay 0)", "Faltan operandos en la pila (hay 1)", "Se ha llegado al final de la entrada", "No se puede acceder una posicion de memoria negativa", 
									"La posicion de memoria esta vacia", "No hay entrada"};
	
	
	private HashMap<String, String[]> errorLists; 
	
	public InstructionExceptionConsts () {
		errorLists = new HashMap<String, String[]>();
		errorLists.put("ARITHMETIC", arithmetic);
		errorLists.put("BOOLEAN", bool);
		errorLists.put("COMPARE", comp);
		errorLists.put("JUMP", jump);
		errorLists.put("SEQUENTIAL", seq);
		
		
	}
	
	
	
	public String getMessage (String type, int error) {
		return ((String[]) errorLists.get(type))[error];
	}
	
}
