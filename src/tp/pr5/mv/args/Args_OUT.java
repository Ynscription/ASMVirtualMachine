package tp.pr5.mv.args;

import tp.pr5.mv.Config;


public class Args_OUT extends Argument {

	public Args_OUT(Config c) {
		super(c);
		
	}

	@Override
	public void run(String arg) {
		config.setOutRoute(arg);
		
	}

	
}
