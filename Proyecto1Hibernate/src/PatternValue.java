import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternValue {

	public static void main(String[] args) {
	
		String regex = "\\d+";
		String numero = "124332";
		
		if(numero.matches(regex)) {
			System.out.println("Esta bien");
		}else {
			System.out.println("No");
		}
		
	}

}
