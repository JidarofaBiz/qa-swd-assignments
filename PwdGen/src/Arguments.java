import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class Arguments {
	
	private String generateStringPassword(boolean u, boolean l, boolean n, boolean s) {
		
		String defaultList = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ12345678901234567890890123!$%'/()_.,<>{}[]+-*@^#=!$%'";
		boolean[] args = {l, u, n, s};		
		int begin = 0;
		int end = 26;	
		StringBuffer stPass = new StringBuffer();
		String stringPass;
		
		for(int j = 0; j < args.length; j++) {		
			if (args[j] == true) {	
				stringPass = defaultList.substring(begin, end);
				stPass.append(stringPass);		
			} 		
			begin = end;
			end += 26;	
    	}	
		
		if (stPass.toString().isEmpty()) {		
    		stringPass = defaultList.substring(0, 78);
    		stPass.append(stringPass);	
		}
		
		return stPass.toString();
	}
	
	private String deleteCharters(String text, String chartersToDelete)
	{			
		int cont = 0;	
		StringBuffer stringOK = new StringBuffer();	
		
		for(int i = 0; i < text.length(); i++) {	
			cont = 0;
			
			for (int j = 0; j < chartersToDelete.length(); j++) {	
				if (text.charAt(i) != chartersToDelete.charAt(j)) {	
					cont++;
					
					if (cont == chartersToDelete.length()) {					
						stringOK.append(text.charAt(i));		
					}				
				}
			}
		}	
		
		return stringOK.toString();
	}
	
	public String clipBoard(String text, boolean c)
	{
		if (c == true) {
			
			String clip = text;
			StringSelection selection = new StringSelection(clip);
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			clipboard.setContents(selection, selection);
			return clip;
		}	
		
		return " ";
	}
	
	public String[] generatePassword(Configuration conf)
	{	
		
		int x = 0;
		String[] passwords = new String[conf.parameterT];	
		String correctCharters = generateStringPassword(conf.parameterU, conf.parameterL, conf.parameterN, conf.parameterS);		
		correctCharters = deleteCharters(correctCharters, conf.parameterE);
		correctCharters = deleteCharters(correctCharters, conf.parameterA);	
		
		while(x < conf.parameterT) {	 
			StringBuffer pass = new StringBuffer();	
			
	        for(int i = 0; i < conf.size; i++) {	
        		int number = (int)(Math.random() * (correctCharters.length()));
            	char ch = correctCharters.charAt(number);
                pass.append(ch);        
	        }     	        
	      
	        passwords[x] = pass.toString();	        
	        x += 1; 
		}
		
        return passwords;	
	}	
}
