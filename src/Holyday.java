import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Holyday {
    private String date;
    private String name;

    public Holyday() {
    }

    public Holyday(String date, String name) {
        this.date = date;
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public void setDate(String date) {
        Pattern pattern = Pattern.compile("^[0-9]{2}\\/[0-9]{2}\\/[0-9]{4}$");
        Matcher match = pattern.matcher(date);

        if (match.matches()) {
            this.date = date;
        }
    }

    public void setName(String name) {
        this.name = name;
    }
}
