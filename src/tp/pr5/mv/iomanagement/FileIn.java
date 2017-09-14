package tp.pr5.mv.iomanagement;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import tp.pr5.mv.exceptions.VMException;

public class FileIn implements StrategyIn {

	private BufferedReader br;
	private String route;
	
	public FileIn (String in) throws VMException {
		try {
			route = in;
			br = new BufferedReader (new FileReader(route));
			
		} catch (FileNotFoundException e) {
			throw new VMException("No se puede acceder al archivo de entrada in: " + in);
		}
	}
	
	@Override
	public String getText () {
		String text = "";
		try {
			
			while (br.ready()) { 
				text = text + br.readLine() + System.lineSeparator();
			}
			
			br.close();
			br = new BufferedReader (new FileReader(route));
			
		} catch (IOException e) {
			
		}
		return text;
		
	}
	
	@Override
	public int getCh() {
		int r;
        try {
			r = br.read();
			return r;
			
		} catch (IOException e) {
			return -1;
		}
	}
	public void close () {
		try {
			br.close();
		} catch (IOException e) {
			
		}
		
	}

}
