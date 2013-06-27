package ch.k42.mclogstat.model;

/**
 * Created with IntelliJ IDEA.
 * User: Thomas
 * Date: 26.06.13
 * Time: 19:41
 * To change this template use File | Settings | File Templates.
 */
public enum PvEKillType {
    ZOMBIE("§b([A-z0-9_]+)§3 was overwhelmed by zombies!", "Zombie"),
    HORDE("§b([A-z0-9_]+)§3 fell to the hunger of the horde!","Horde"),
    CREEPER("§3A creeper blasted §b([A-z0-9_]+)§3!", "Creeper"),
    SPIDER("§b([A-z0-9_]+)§3 got trampled by arachnids!", "Spider"),
    FALL("§b([A-z0-9_]+)§3 slipped from an edge.", "Slipped & fell"),
    DROWN("§b([A-z0-9_]+)§3 is swimming with the fishes!", "Drowned"),
    HUNGER("§b([A-z0-9_]+)§3 starved to death.", "Starved"),
    LAVA("§b([A-z0-9_]+)x§3 fell into lava.", "Lava"),
    SKELETON("§b([A-z0-9_]+)§3 was shot by a skeleton.", "Skeleton");
    public final String regex;
    public final String type;
    PvEKillType(String s, String type){
        regex = s;
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }
}
