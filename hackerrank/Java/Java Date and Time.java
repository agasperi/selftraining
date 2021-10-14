import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.util.Calendar;

public class Solution {
    public static String getDay(String day, String month, String year) {
        String diaSemana = "";
        Calendar calendario = Calendar.getInstance();
        calendario.set(Integer.parseInt(year),Integer.parseInt(month)-1,Integer.parseInt(day));
        switch(calendario.get(Calendar.DAY_OF_WEEK)){
            case Calendar.SUNDAY : diaSemana = "SUNDAY";
                break;
            case Calendar.MONDAY : diaSemana = "MONDAY";
                break;
            case Calendar.TUESDAY : diaSemana = "TUESDAY";
                break;
            case Calendar.WEDNESDAY : diaSemana = "WEDNESDAY";
                break;
            case Calendar.THURSDAY : diaSemana = "THURSDAY";
                break;
            case Calendar.FRIDAY : diaSemana = "FRIDAY";
                break;
            case Calendar.SATURDAY : diaSemana = "SATURDAY";
                break;
        }
        return diaSemana;
    }

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int month = Integer.parseInt(firstMultipleInput[0]);

        int day = Integer.parseInt(firstMultipleInput[1]);

        int year = Integer.parseInt(firstMultipleInput[2]);

        String res = Result.findDay(month, day, year);

        bufferedWriter.write(res);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
