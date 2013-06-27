package ch.k42.mclogstat.main;

import ch.k42.mclogstat.model.LogEvent;
import ch.k42.mclogstat.model.Statistics;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Thomas
 * Date: 26.06.13
 * Time: 19:11
 * To change this template use File | Settings | File Templates.
 */
public class Main {

    public static void main(String[] args) {
//        if(args.length<1){
//            System.out.println("Usage: mclogstat [log-file]");

        String filename = "output-client.log";
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filename),"ISO-8859-1"));
            List<LogEvent> logbook = new ArrayList<LogEvent>();
            String line;
            System.out.println("Start parsing...");
            while ((line = reader.readLine())!=null){
                try {
                    LogEvent event = Parser.parseLine(line);
                    if(event!=null){
                        logbook.add(event);
                        System.out.println("added event");
                    }
                } catch (ParseException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }

            }
            System.out.println("Finished parsing...");
            Statistics statistics = new Statistics();
            for(LogEvent event : logbook){
                event.doStatistics(statistics);
            }
            statistics.printStatistics();
            //Collections.sort(logbook);

        } catch (FileNotFoundException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IOException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
         }
    }
}


