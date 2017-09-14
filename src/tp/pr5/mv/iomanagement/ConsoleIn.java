package tp.pr5.mv.iomanagement;

import java.util.Scanner;


public class ConsoleIn implements StrategyIn {

	
	private Scanner sc;
	private String buffer;

	public ConsoleIn() {
		sc = new Scanner (System.in);
		buffer = "";
	}
	
	
	
	@Override
	public int getCh() {
		int r = -1;
		if (buffer.equals("")) {
			buffer = sc.nextLine() + System.lineSeparator();
		}
		r = buffer.charAt(0);
		buffer = buffer.substring(1);
		
		return r;
	}



	@Override
	public void close() {
		sc.close();
	}



	@Override
	public String getText() {
		return "";
	}

	
	
	
}
