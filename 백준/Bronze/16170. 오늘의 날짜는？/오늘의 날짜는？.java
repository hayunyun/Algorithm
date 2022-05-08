import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Date now = new Date();
        TimeZone tz = TimeZone.getTimeZone("UTC");

        SimpleDateFormat y = new SimpleDateFormat( "yyyy");
        SimpleDateFormat m = new SimpleDateFormat( "MM");
        SimpleDateFormat d = new SimpleDateFormat( "dd");

        y.setTimeZone(tz);
        System.out.println(y.format(now));
        System.out.println(m.format(now));
        System.out.println(d.format(now));
    }
}