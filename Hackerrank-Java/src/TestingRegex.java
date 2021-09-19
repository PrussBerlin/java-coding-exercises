import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestingRegex {
	public static void main(String[] args) {
		String zeroTo255 = "(\\d{1,2}|([0-1]\\d{2})|(2[0-4]\\d)|(25[0-5]))";
		String regex = "^(" + zeroTo255 + "\\.){3}" + zeroTo255 + "$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher("222.55.55.55");
		System.out.println(matcher.find());
    }
}
