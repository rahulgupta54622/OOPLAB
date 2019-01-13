import java.util.regex.Matcher;
import java.util.regex.Pattern;
//ctrl + alt + l ...used for formatting
public class RegEx {

    public static void main(String args[]) {

        Pattern p = Pattern.compile("\\d{2}-\\d{2}-\\d{4}");
        Matcher matcher = p.matcher("ab 10-12-2019 cabxac 10-12-1945 bab");

        while (matcher.find()) {
            System.out.println(matcher.start() + " " + (matcher.end()-1) + " " + matcher.group());
        }

    }
}
