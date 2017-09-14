package tp.pr5.mv.cpu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import tp.pr5.mv.exceptions.ASMException;
import tp.pr5.mv.ins.Instruction;
import tp.pr5.mv.ins.InstructionParser;

public class AsmReader {


	private static String format (String s) {
		try {
			
			return s.substring(0, s.indexOf(';'));
			
		}catch (StringIndexOutOfBoundsException e) {
			
			return s;
			
		}
		
	}
	
	
	public static ProgramMV readProgram ( String asmRoute) throws ASMException {
		ProgramMV pr = new ProgramMV();
		Instruction ins;
		
		int line = 0;
		
		BufferedReader br;
		
		try {
			br = new BufferedReader(new FileReader(asmRoute));
			String s = "";
			boolean endOfFile = false;
			do {
				ins = null;
				
				try {
					s = br.readLine();
					line++;
					if (s != null) {
						s = format(s);
						if (!s.equalsIgnoreCase("")) {
							ins = InstructionParser.parse(s);
							if ((ins != null) && !ins.toString().equalsIgnoreCase("WRITE")) {
								pr.addInstruction(ins);
							}else if (ins == null || ins.toString().equalsIgnoreCase("WRITE")) {
								throw new ASMException(line, s);
							}
						}
					}else {
						endOfFile = true;
					}
				
				}
				catch (IOException e) {
					endOfFile = true;
				}
				
				
			}while (!endOfFile);
			
			br.close();
			
		} catch (IOException e) {
			System.err.println("Uso incorrecto: Error al acceder al fichero asm: " + asmRoute);
			System.exit (1);
		}
			
		return pr;
	}
	
	
}
