package ch.k42.mclogstat.model;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Thomas
 * Date: 26.06.13
 * Time: 19:15
 * To change this template use File | Settings | File Templates.
 */
public abstract class LogEvent implements Comparable<LogEvent> {
    private String message;
    private Date timestamp;

    public LogEvent(String message, Date timestamp) {
        this.message = message;
        this.timestamp = timestamp;
    }

    @Override
    public int compareTo(LogEvent o) {
        return this.timestamp.compareTo(o.timestamp);  //To change body of implemented methods use File | Settings | File Templates.
    }

    abstract public void doStatistics(Statistics statistics);
}
