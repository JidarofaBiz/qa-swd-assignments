
public class Configuration {
	
	int size = 16;
	int parameterT=1;
	String parameterE=" ";
	String parameterA=" ";	
	boolean parameterU=false;
	boolean parameterL=false;
	boolean parameterN=false;
	boolean parameterS=false;	
	boolean parameterC =false;
	
	public Configuration(int si, boolean u, boolean l, boolean n, boolean s, String e, String a, int t) {
		size = si;
		parameterU = u;
		parameterL = l;
		parameterN=n;
		parameterS=s;
		parameterE=e;
		parameterA= a;
		parameterT=t;
	}
}
