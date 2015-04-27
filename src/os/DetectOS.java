package os;
/**
 * Sert a detecter l'OS
 * @author Sebastien Klasa
 *
 */
public class DetectOS {
	
	private static String OS = System.getProperty("os.name").toLowerCase();
	
	private DetectOS() {}
	
	public static boolean Windows() {
		return (OS.indexOf("win") >= 0);
	}
 
	public static boolean Mac() {
		return (OS.indexOf("mac") >= 0);
	}
 
	public static boolean Unix() {
		return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0 );
	}
 
	public static boolean Solaris() {
		return (OS.indexOf("sunos") >= 0);
	}
	
}
