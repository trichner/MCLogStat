package ch.k42.mclogstat.main;

import ch.k42.mclogstat.model.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: Thomas
 * Date: 26.06.13
 * Time: 19:18
 * To change this template use File | Settings | File Templates.
 */
public class Parser {

    private static final String TAG_CHAT = "CHAT";

    public static LogEvent parseLine(String line) throws ParseException {

        Pattern pattern = Pattern.compile("([0-9:\\-\\s]*\\[)");
        Matcher m = pattern.matcher(line);
        m.find();
        String stamp = m.group();

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = df.parse(stamp);

        //line = line.substring(20);

        pattern = Pattern.compile("\\[([A-Z]+)\\]");
        m = pattern.matcher(line);
        boolean isChat = false;

        while (m.find()){
            String tag = m.group(1);
            if(tag.equals(TAG_CHAT)){
                isChat = true;
                break;
            }
        }
        LogEvent event = null;
        if(isChat){ // Only analyze chat logs, rest seems unintresting
            System.out.println(line);
            for(PvEKillType type : PvEKillType.values()){ // is it a PvE Kill ?
                pattern = Pattern.compile(type.regex);
                m = pattern.matcher(line);

                if(m.find()){ //Found PvEkill!
                    System.out.println("PvEKill");
                    event = new PvEDeathEvent(line,date,new Player(m.group(1)),type);
                    System.out.println(event);
                    return event;
                }
            }

            for(PvPKillType type : PvPKillType.values()){

                pattern = Pattern.compile(type.regex);
                m = pattern.matcher(line);
                if(m.find()){ //Found PvPkill!
                    System.out.println("PvPKill");
                    if(type.equals(PvPKillType.ITEM))
                        event = new PvPDeathEvent(line,date,new Player(m.group(1)),type,m.group(2));
                    else
                        event = new PvPDeathEvent(line,date,new Player(m.group(1)),type,"Hand");
                    System.out.println(event);
                    return event;
                }
            }

        }
        return event;
    }
}
