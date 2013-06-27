package ch.k42.mclogstat.model;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Thomas
 * Date: 26.06.13
 * Time: 20:33
 * To change this template use File | Settings | File Templates.
 */
public class LogoutEvent extends LogEvent {
    private Player player;
    public LogoutEvent(String message, Date timestamp,Player player) {
        super(message, timestamp);
        this.player = player;
    }

    @Override
    public void doStatistics(Statistics statistics) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
