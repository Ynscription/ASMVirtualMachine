package tp.pr5.mv.args;

import tp.pr5.mv.Config;
import tp.pr5.mv.exceptions.VMException;


public abstract class Argument {

	protected Config config;

	public Argument (Config c) {
		config = c;
		
	}
	
	public abstract void run(String arg) throws VMException;
	
	
	
	@Override
	public String toString () {
		
		String r = "";
		r = this.getClass().getSimpleName();
		r = r.substring(r.indexOf("_") + 1);
		r = "--" + r;
		
		return r;
		
	}
	
	public String toString2 () {
		
		String r = "";
		r = this.getClass().getSimpleName();
		r = Character.toString(r.substring(r.indexOf("_") + 1).charAt(0));
		r = "-" + r;
		
		return r;
		
	}
	
	
}
