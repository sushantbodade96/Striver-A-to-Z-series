
import java.text.SimpleDateFormat;
import java.util.Date;
//import java.util.*;

public class DateFormatConverter {

    public static void main(String[] args) {
        String input = "1st Aug 2025";

        String cleanedDate = input.replaceAll("(st|nd|rd|th)", "");
        SimpleDateFormat inputFormat1 = new SimpleDateFormat("dd MMM yyyy");
        SimpleDateFormat inputFormat2 = new SimpleDateFormat("dd MMMM yyyy");
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy MM dd");

        try {
            Date date = inputFormat1.parse(cleanedDate);
            String output = outputFormat.format(date);
            System.out.println(output);
            System.out.println(3 * 5 * 6 + "hello");
        } catch (Exception e) {
            try {
                Date date = inputFormat2.parse(cleanedDate);
                String output = outputFormat.format(date);
                System.out.println(output);
            } catch (Exception j) {

            }
        }
    }
}
