package tp.pr5.mv;


import tp.pr5.mv.args.ArgInterpreter;
import tp.pr5.mv.controller.DebugController;
import tp.pr5.mv.cpu.Cpu;
import tp.pr5.mv.cpu.Debugger;
import tp.pr5.mv.cpu.ProgramMV;
import tp.pr5.mv.cpu.AsmReader;
import tp.pr5.mv.exceptions.VMException;
import tp.pr5.mv.iomanagement.ConsoleIn;
import tp.pr5.mv.iomanagement.ConsoleOut;
import tp.pr5.mv.iomanagement.FileIn;
import tp.pr5.mv.iomanagement.FileOut;
import tp.pr5.mv.iomanagement.NullIn;
import tp.pr5.mv.iomanagement.NullOut;
import tp.pr5.mv.iomanagement.StrategyIn;
import tp.pr5.mv.iomanagement.StrategyOut;
import tp.pr5.mv.iomanagement.WinIn;
import tp.pr5.mv.iomanagement.WinOut;
import tp.pr5.mv.view.MainView;
import tp.pr5.mv.view.mainViews.BatchView;
import tp.pr5.mv.view.mainViews.InteractiveView;
import tp.pr5.mv.view.mainViews.WindowView;

public class Main {

	public static void main(String[] args) {	
		
		
		Config config = new Config();
		
		ExceptionManager exceptionManager = null;
		
		
		try {
			ArgInterpreter ai = new ArgInterpreter(config);
			boolean run = false;
			try {
				 run = ai.interpret(args);
			}catch (VMException exc) {
				ExceptionManager.handleStaticException(exc);
			}
			
			exceptionManager = new ExceptionManager(config.getMode());
			
			if (config.getAsmRoute() == null && run) {
				try {
					throw new VMException("Uso incorrecto: Fichero ASM no especificado." + System.lineSeparator() + "Use -h/--help para mas detalles.");
				}catch (VMException exc){
					ExceptionManager.handleStaticException(exc);
				}
			}
			if (run) {
				
				
				ProgramMV pr= AsmReader.readProgram(config.getAsmRoute());				
								
				
				StrategyIn sIn;
				StrategyOut sOut;
				
				
				if (config.getInRoute() != null) {
						sIn = new FileIn(config.getInRoute());	
								
				}else {
					
					if (config.getMode() == 0) {
						sIn	= new ConsoleIn();
						
					}else {
						sIn = new NullIn();
						
					}
					
				}
				
				if (config.getOutRoute() != null) {
					sOut = new FileOut(config.getOutRoute());
				}else {
					if (config.getMode() == 0) {
						sOut = new ConsoleOut();
					}else {
						sOut = new NullOut();
						 
					}
					 
				}
				 
				
					
				if (config.getMode()== 2) {
					sIn = new WinIn(sIn);
					sOut = new WinOut(sOut);			
				}
				
				Cpu cpu = new Cpu(sIn, sOut,exceptionManager);
				DebugController dc = new DebugController(new Debugger(cpu, exceptionManager));
				
						
				cpu.loadProgram(pr);
				
				
				MainView mainView;
				if (config.getMode() == 0) {
					mainView = new BatchView(dc);
					cpu.addAsmObserver(mainView);
					cpu.addRunnerObserver(mainView);
					
					sOut.addOutObserver(mainView);
				}else if (config.getMode() == 1) {
					mainView = new InteractiveView(dc, exceptionManager);
					cpu.addAsmObserver(mainView);
					cpu.addRunnerObserver(mainView);
					
					sOut.addOutObserver(mainView);
					
				}else {
					WindowView wv = new WindowView(dc);	
					mainView = wv;
					
					cpu.addAsmObserver(wv.getAsmObserver());
					cpu.addStackObserver(wv.getStackObserver());
					cpu.addMemoryObserver(wv.getMemoryObserver());
					cpu.addInObserver(wv.getInObserver());
					cpu.addRunnerObserver(wv.getRunnerObserver());
					
					sOut.addOutObserver(wv.getoOutObserver());
					
					
				}
				
				mainView.run();
							
			}
		}catch (VMException e) {
			exceptionManager.handleException(e,true);
		}
	
		

		
	}

}
