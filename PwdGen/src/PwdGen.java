import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class PwdGen 
{
	public static void main (String[] args)
	{
		Arguments arg = new Arguments();
	
		int size = 16;
		int T=1;
		String E=" ";
		String A=" ";	
		boolean U=false;
		boolean L=false;
		boolean N=false;
		boolean S=false;	
		boolean C =false;
		
		for (int i=0; i<args.length; i++)
		{
				switch (args[i]) 
				{
					case "-Size:":
					{
						size = Integer.parseInt(args[i+1]);						
						break;
					}
					
					case "-U":
					{
						U = true;						
						break;
					}
					
					case "-L":
					{
						L = true;						
						break;
					}
					
					case "-N":
					{
						N = true;						
						break;
					}
					
					case "-S":
					{
						S = true;						
						break;
					}
					
					case "-A":
					{
						A = "iILl1oO0";	
						break;
					}
					
					case "-E:":
					{
						E = args[i+1];
						break;
					}
					
					case "-T:":
					{
						T=Integer.parseInt(args[i+1]);					
						break;
					}
					
					case "-Copy":
					{
						C= true;					
						break;
					}
					
					case "-?":
					{
						System.out.println("-Size:16 Contrase�a de 16 caracteres");
						System.out.println("-U Incluir letras en may�scula (Uppercase)");
						System.out.println("-L Incluir letras en min�scula (Lowercase)");
						System.out.println("-N Incluir n�meros (Numbers) ");
						System.out.println("-S Incluir s�mbolos (Symbols). Enti�ndase caracteres como: $%&()=# entre otros.");
						System.out.println("-A Excluye los caracteres ambiguos: i, I, L, l, 1, o, O, 0");
						System.out.println("-E: []{}@ Excluir los s�mbolos suministrados. En este caso la contrase�a generada no contendr� los caracteres []{}@");
						System.out.println("-T: 3 Generar 3 contrase�as (Total)");
						System.out.println("-Copy Copia la contrase�a generada en el ClipBoard para solo hacer CTRL + V y utilizarla. Si el usuario genera m�ltiples contrase�as, solo la �ltima se copiar� al Clipboard.");
						break;
					}					

					case "":
					{
						System.out.println("dir -?");
					}
					
					default: 							
						break;					
				}	
		}	
		Configuration conf = new Configuration(size, U, L, N, S, A, E, T);
		String[] pss= arg.generatePassword(conf);
			
		for (int j=0; j < pss.length; j++)
		{						
			System.out.println(pss[j]);
			arg.clipBoard(pss[pss.length-1],C);
		}	
	}
}