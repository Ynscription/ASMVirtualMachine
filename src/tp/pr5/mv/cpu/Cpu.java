package tp.pr5.mv.cpu;

import tp.pr5.mv.ExceptionManager;
import tp.pr5.mv.controller.InObserver;
import tp.pr5.mv.controller.AsmObserver;
import tp.pr5.mv.controller.MemoryObserver;
import tp.pr5.mv.controller.RunnerObserver;
import tp.pr5.mv.controller.StackObserver;
import tp.pr5.mv.exceptions.InstructionException;
import tp.pr5.mv.exceptions.VMException;
import tp.pr5.mv.ins.*;
import tp.pr5.mv.iomanagement.StrategyIn;
import tp.pr5.mv.iomanagement.StrategyOut;

public class Cpu {
	private Memory memory;
	private OperandStack operandStack;
	private boolean isRunning;
	
	private ProgramMV prRunning	;
	public Integer currentInstruction;
	
	private StrategyIn sIn;
	private StrategyOut sOut;
	
	
	private AsmObserver asmO;
	private InObserver inO;
	private RunnerObserver runnerO;
	
	private ExceptionManager exceptionManager;
	
	
	
	
	public Cpu(StrategyIn sin, StrategyOut sout, ExceptionManager em)  {
		isRunning = true;
		memory = new Memory();
		operandStack = new OperandStack();
		currentInstruction = 0;
		
		sIn = sin;
		sOut = sout;
				
		exceptionManager = em;
	
	}
	
	

	public void loadProgram(ProgramMV p) {
		prRunning = p;
	}
	
	public boolean step () {
		boolean r = true;
		try {
			
			if (currentInstruction>= 0 && currentInstruction < prRunning.length()) {
				Instruction ins = prRunning.getInstruction(currentInstruction);
				currentInstruction++;
				if (runnerO != null) {
					runnerO.beforeStep(ins.toString());
				}
				ins.execute(this, memory, operandStack);
				if (!r) {
					currentInstruction--;
				}
				if (asmO != null) {
					asmO.onStep(currentInstruction);
				}
				if (runnerO != null) {
					runnerO.afterStep(this.toString());
				}
			}
			if (!hasNextInstruction()) {
				stopRunning();
				runnerO.onEnd();
			}
			
		}catch (InstructionException e) {
			r = false;
			currentInstruction--;
			exceptionManager.handleException(e);
		}catch (VMException e) {
			r = false;
			currentInstruction--;
			exceptionManager.handleException(e,false);
		}
		return r;
	}
	
	public boolean step (Instruction ins) {
		boolean r = true;
		try {
			ins.execute(this, memory, operandStack);
		}catch (InstructionException e) {
			r = false;
			exceptionManager.handleException(e);
		}catch (VMException e) {
			r = false;
			currentInstruction--;
			exceptionManager.handleException(e,false);
		}
		return r;
	}
	
	
	
	public void printCh (char mander) {
		
		try {
			sOut.printCh(mander);
		} catch (VMException e) {
			exceptionManager.handleException(e,true);
		}
	}
	
	public int getCh () {	
		
		try {
			int r = sIn.getCh();
			if ((r != -1)&&(inO != null)) {
				inO.onIn();
			}
			return r; 
		} catch (VMException e) {
			exceptionManager.handleException(e,true);
		}
		return 0;
	}
	
	
	public boolean isRunning() {
		return isRunning;
	}	
	
	public void stopRunning () {
		isRunning = false;
		sIn.close();
		sOut.close();
		
	}
	
	
	
	public boolean hasNextInstruction () {
		return (currentInstruction < prRunning.length());
	}
	
	
	
	public void addAsmObserver (AsmObserver ao) {
		asmO = ao;
		asmO.onProgram(prRunning.toString().split(System.lineSeparator()));
		
	}
	
	public void addInObserver (InObserver io) {
		inO= io;
		inO.onStart(sIn.getText());
	}
	
	public void addStackObserver (StackObserver so) {
		operandStack.addStackObserver(so);
	}
	
	public void addMemoryObserver (MemoryObserver mo) {
		memory.addMemoryObserver(mo);
	}
	
	public void addRunnerObserver (RunnerObserver ro) {
		runnerO = ro;
	}
	
	
	
	@Override
	public String toString (){
		String r = "";
		r =  r + "Memoria : " + memory.toString() + System.lineSeparator();
		r = r + "Pila de operandos: " + operandStack.toString();
		return r;
		
	}
}
