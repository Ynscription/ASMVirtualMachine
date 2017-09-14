package tp.pr5.mv.args;


import tp.pr5.mv.Config;


public class Args_ASM extends Argument {

	public Args_ASM(Config c) {
		super(c);
	}

	@Override
	public void run(String arg) {
		config.setAsmRoute(arg);		
	}

	
	
	
}
