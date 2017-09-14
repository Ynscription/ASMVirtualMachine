package tp.pr5.mv.args;

import tp.pr5.mv.Config;
import tp.pr5.mv.exceptions.VMException;


public class Args_MODE extends Argument {

	public Args_MODE(Config c) {
		super(c);
		
	}

	@Override
	public void run(String arg) throws VMException {
		if (arg.equalsIgnoreCase("BATCH")) {
			config.setMode(0);
		}else if (arg.equalsIgnoreCase("INTERACTIVE")){
			config.setMode(1);
		}else if (arg.equalsIgnoreCase("WINDOW")){
			config.setMode(2);
		}else {
			throw new VMException("Uso incorrecto: modo mal especificado." + System.lineSeparator() + "Use -h/--help para mas detalles.");
		}
		
	}

}
