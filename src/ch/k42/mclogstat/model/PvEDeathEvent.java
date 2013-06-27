package ch.k42.mclogstat.model;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Thomas
 * Date: 26.06.13
 * Time: 19:40
 * To change this template use File | Settings | File Templates.
 */
public class PvEDeathEvent extends LogEvent {
    private Player player;
    private PvEKillType type;

    public PvEDeathEvent(String message, Date timestamp,Player player,PvEKillType type) {
        super(message, timestamp);
        this.player = player;
        this.type = type;
    }

    public Player getPlayer() {
        return player;
    }

    public PvEKillType getType() {
        return type;
    }

    @Override
    public void doStatistics(Statistics statistics) {
        statistics.logPvEKill(this);
    }

    @Override
    public String toString() {
        return player.toString() + " was killed by " + type.toString();    //To change body of overridden methods use File | Settings | File Templates.
    }
}
