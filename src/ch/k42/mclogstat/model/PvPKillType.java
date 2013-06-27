package ch.k42.mclogstat.model;

/**
 * Created with IntelliJ IDEA.
 * User: Thomas
 * Date: 26.06.13
 * Time: 20:22
 * To change this template use File | Settings | File Templates.
 */
public enum PvPKillType {
    ITEM("§3Someone killed §b([A-z0-9_]+)§3 with ([A-z\\s]+)([\\s!]*)$"),
    HAND("§3Someone killed §b([A-z]+)§3 bare handed.");
    public final String regex;
    PvPKillType(String s){
        regex = s;
    }
}
