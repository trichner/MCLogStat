package ch.k42.mclogstat.model;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Thomas
 * Date: 26.06.13
 * Time: 20:43
 * To change this template use File | Settings | File Templates.
 */
public class Statistics {

    private class PrettyPrintingMap<K, V> {
        private Map<K, V> map;

        public PrettyPrintingMap(Map<K, V> map) {
            this.map = map;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            Iterator<Map.Entry<K, V>> iter = map.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry<K, V> entry = iter.next();
                sb.append(entry.getKey());
                sb.append(';');
                sb.append(entry.getValue());
                if (iter.hasNext()) {
                    sb.append('\n');
                }
            }
            return sb.toString();

        }
    }



    private int death_count = 0;
    private Map<PvEKillType,Increment> kill_mob = new HashMap<PvEKillType, Increment>();
    private Map<Player,Increment> deaths_player = new HashMap<Player, Increment>();
    private Map<String,Increment> deaths_item = new HashMap<String , Increment>();

    public void logPvPKill(PvPDeathEvent event){
        death_count++;
        if(deaths_item.containsKey(event.getItem())){
            deaths_item.get(event.getItem()).increment();
        }else{
            deaths_item.put(event.getItem(),new Increment(1));
        }

        if(deaths_player.containsKey(event.getPlayer())){
            deaths_player.get(event.getPlayer()).increment();
        }else{
            deaths_player.put(event.getPlayer(),new Increment(1));
        }
    }

    public void logPvEKill(PvEDeathEvent event){
        death_count++;

        if(deaths_player.containsKey(event.getPlayer())){
            deaths_player.get(event.getPlayer()).increment();
        }else{
            deaths_player.put(event.getPlayer(),new Increment(1));
        }

        if(kill_mob.containsKey(event.getType())){
            kill_mob.get(event.getType()).increment();
        }else{
            kill_mob.put(event.getType(), new Increment(1));
        }
    }

    public void printStatistics(){
        System.out.println("#============== Deaths by Player");
        System.out.println(new PrettyPrintingMap<Player,Increment>(deaths_player));
        System.out.println("#============== Deaths by Item");
        System.out.println(new PrettyPrintingMap<String ,Increment>(deaths_item));
        System.out.println("#============== Deaths by Mob");
        System.out.println(new PrettyPrintingMap<PvEKillType,Increment>(kill_mob));

        System.out.println("Total Number of Deaths: "+death_count);
    }

}
