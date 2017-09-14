package tp.pr5.mv.args;

import tp.pr5.mv.Config;


public class Args_HELP extends Argument {

	public Args_HELP(Config c) {
		super(c);
		
	}

	@Override
	public void run(String arg) {
		
		System.out.println( "usage: tp.pr5.mv.Main [-a <asmfile>] [-h] [-i <infile>] [-m <mode>] [-o<outfile>]" + System.lineSeparator() +  
							"-a,--asm <asmfile>			Fichero con el codigo en ASM del programa a ejecutar. Obligatorio en modo batch." + System.lineSeparator() +
							"-h,--help 					Muestra esta ayuda." + System.lineSeparator() +
							"-i,--in <infile> 			Entrada del programa de la maquina-p." + System.lineSeparator() +
							"-m,--mode <mode> 			Modo de funcionamiento (batch | interactive). Por defecto, batch." + System.lineSeparator() +
							"-o,--out <outfile> 			Fichero donde se guarda la salida del programa de la maquina-p.");
		
	}

}
