package ch.k42.mclogstat.model;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Thomas
 * Date: 26.06.13
 * Time: 19:40
 * To change this template use File | Settings | File Templates.
 */
public class PvPDeathEvent extends LogEvent {
    private Player player;
    private PvPKillType type;
    private String item;

    public PvPDeathEvent(String message, Date timestamp, Player player, PvPKillType type,String item) {
        super(message, timestamp);
        this.player = player;
        this.type = type;
        this.item = item;

    }

    @Override
    public void doStatistics(Statistics statistics) {
        statistics.logPvPKill(this);
    }

    public Player getPlayer() {
        return player;
    }

    public PvPKillType getType() {
        return type;
    }

    public String getItem() {
        return item;
    }

    @Override
    public String toString() {
        return player.toString() + " was killed with " + item;    //To change body of overridden methods use File | Settings | File Templates.
    }
}
