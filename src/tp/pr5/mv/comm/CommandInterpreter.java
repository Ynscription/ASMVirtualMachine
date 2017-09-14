package tp.pr5.mv.comm;


import tp.pr5.mv.cpu.Cpu;

public abstract class CommandInterpreter {

	public abstract boolean executeCommand (Cpu cpu);

	public Integer param1;
	public Integer param2;
	
	
	/*
	public Integer getParam1() {
		return param1;
	}

	public void setParam1(Integer p) {
		param1 = p;
	}
	
	public Integer getParam2() {
		return param2;
	}

	public void setParam2(Integer p) {
		param2 = p;
	}
	*/
	
	public abstract CommandInterpreter getMe();
	
	
	
	@Override
	public String toString () {
		
		String r = "";
		r = this.getClass().getSimpleName();
		r = r.substring(r.indexOf("_") + 1);
		
		return r;
		
	}	
		
	
}
