import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class PwdGen {
	
	public static void main (String[] args) {
		
		Arguments arg = new Arguments();
		int size = 16;
		int parameterT = 1;
		String parameterE = " ";
		String parameterA = " ";	
		boolean parameterU = false;
		boolean parameterL = false;
		boolean parameterN = false;
		boolean parameterS = false;	
		boolean parameterC = false;
		
		for (int i = 0; i < args.length; i++) {		
			
			switch (args[i]) {
			case "-Size:":
				size = Integer.parseInt(args[i+1]);						
				break;
		
			case "-U":
				parameterU = true;						
				break;
							
			case "-L":
				parameterL = true;						
				break;
					
			case "-N":			
				parameterN = true;						
				break;
				
			case "-S":
				parameterS = true;						
				break;
				
			case "-A":
				parameterA = "iILl1oO0";	
				break;
					
			case "-E:":
				parameterE = args[i+1];
				break;
				
			case "-T:":
				parameterT = Integer.parseInt(args[i+1]);					
				break;
				
			case "-Copy":
				parameterC = true;					
				break;
				
			case "-?":
				System.out.println("-Size:16 Contraseña de 16 caracteres");
				System.out.println("-U Incluir letras en mayúscula (Uppercase)");
				System.out.println("-L Incluir letras en minúscula (Lowercase)");
				System.out.println("-N Incluir números (Numbers) ");
				System.out.println("-S Incluir símbolos (Symbols). Entiéndase caracteres como: $%&()=# entre otros.");
				System.out.println("-A Excluye los caracteres ambiguos: i, I, L, l, 1, o, O, 0");
				System.out.println("-E: []{}@ Excluir los símbolos suministrados. En este caso la contraseña generada no contendrá los caracteres []{}@");
				System.out.println("-T: 3 Generar 3 contraseñas (Total)");
				System.out.println("-Copy Copia la contraseña generada en el ClipBoard para solo hacer CTRL + V y utilizarla. Si el usuario genera múltiples contraseñas, solo la última se copiará al Clipboard.");
				break;		

			case "":
				System.out.println("dir -?");
				break;
				
			default: 							
				break;					
			}	
		}	
		
		Configuration conf = new Configuration(size, parameterU, parameterL, parameterN, parameterS, parameterA, parameterE, parameterT);
		String[] pss = arg.generatePassword(conf);
			
		for (int j = 0; j < pss.length; j++) {
			System.out.println(pss[j]);
			arg.clipBoard(pss[pss.length-1],parameterC);
		}	
	}
}
