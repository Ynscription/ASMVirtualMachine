package tp.pr5.mv.args;

import tp.pr5.mv.Config;
import tp.pr5.mv.exceptions.VMException;


public class ArgInterpreter {

	private Config config;
	
	private Argument [] argsVector1;
	
	
	
	
	public ArgInterpreter (Config c) {
		config = c;
		argsVector1 = 	new Argument [] { new Args_HELP(config), new Args_ASM(config), new Args_IN(config), 
						new Args_MODE(config), new Args_OUT(config)};
	}
	
	
	
	public boolean interpret (String [] args) throws VMException{

		try {
		for (int j = 0; j < args.length; j ++) {
			
			boolean found = false;
			for (int i = 0; i < argsVector1.length && !found; i++) {
				if (argsVector1 [i].toString().equalsIgnoreCase(args [j]) || argsVector1 [i].toString2().equalsIgnoreCase(args [j])) {
					if (i == 0) {
						argsVector1[i].run(null);
						return false;
					}else if (args.length > j+1) {
						boolean miss = false;
						for (int k = 0; k < argsVector1.length && !miss; k++) {
							if (argsVector1 [k].toString().equalsIgnoreCase(args [j+1]) || argsVector1 [k].toString2().equalsIgnoreCase(args [j+1])) {
								miss = true;
							}
						}
						
						if (miss) {
							throw new VMException("Uso incorrecto: Missing argument for option: " + args [j] + System.lineSeparator() + "Use -h/--help para mas detalles.");
						}
						
						argsVector1[i].run(args [j+1]);
						found = true;
						j++;
						
					}else {
						throw new VMException("Uso incorrecto: Missing argument for option: " + args [j] + System.lineSeparator() + "Use -h/--help para mas detalles.");
					}
				}
			}
			if (!found) {
				throw new VMException("Uso incorrecto: argumento no valido" + System.lineSeparator() + "Use -h/--help para mas detalles.");
			}
		}
		}catch (VMException e) {
			System.err.println(e.getMessage());
			System.exit(1);
		}
		return true;
		
	}	
	
	
	
	
	
}
