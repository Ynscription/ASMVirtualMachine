package tp.pr5.mv.iomanagement;

import java.io.FileWriter;
import java.io.IOException;

import tp.pr5.mv.controller.OutObserver;
import tp.pr5.mv.exceptions.VMException;

public class FileOut implements StrategyOut {

	private FileWriter writer; 
	private OutObserver outO;
	
	public FileOut (String out) throws VMException {
		try {
			writer = new FileWriter(out);
		} catch (IOException e) {
			throw new VMException("No se puede acceder al archivo de salida out: " + out);
		}
		
	}
	
	
	@Override
	public void printCh(int c) throws VMException {
		try {
			writer.append((char)c);
			if (outO!= null) {
				outO.onPrintch((char) c);
			}
		} catch (IOException e) {
			throw new VMException("PETO LA SALIDA");
		}
		
		
	}


	@Override
	public void close() {
		try {
			writer.close();
		} catch (IOException e) {
		
		}
		
	}


	@Override
	public void addOutObserver(OutObserver oo) {
		outO = oo;
		
	}

}
