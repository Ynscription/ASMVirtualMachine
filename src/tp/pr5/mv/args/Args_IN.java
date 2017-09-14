package tp.pr5.mv.args;

import tp.pr5.mv.Config;


public class Args_IN extends Argument {

	public Args_IN(Config c) {
		super(c);
		
	}

	@Override
	public void run(String arg) {
		config.setInRoute(arg);
	}

}
