package tp.pr5.mv.comm;


public class CommandParser {
		
	private static Comm_INS comm0 = new Comm_INS();
	private static CommandInterpreter [] commVector1 = { new Comm_QUIT(), new Comm_RUN(), new Comm_STEP()};
	private static CommandInterpreter [] commVector2 = { new Comm_STEP()};
	
	
	public static CommandInterpreter parse (String c) {
		CommandInterpreter comm = null;
		comm = comm0.getMe(c);
		
		
		if (comm == null) {
			
			String aux[] = c.split(" ");
			
			
			if (aux.length == 1) {
					for (int i = 0; i < commVector1.length; i++) {
						if (aux [0].equalsIgnoreCase(commVector1[i].toString())) {
							comm = commVector1[i].getMe();
						}
					}
			
			}
			
			else if (aux.length == 2) {
				try {
					int p = (Integer.parseInt(aux[1]));
					for (int i = 0; i < commVector2.length; i++) {
						if (aux [0].equalsIgnoreCase(commVector2[i].toString())) {
							comm = commVector2[i].getMe();
							comm.param1 = p;
						}
					}
					
					
				} catch (NumberFormatException e) {
					
				}		
			}
			
		
		}
		
		
		
		return comm;
	}
	
}
