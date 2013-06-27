package ch.k42.mclogstat.model;

/**
 * Created with IntelliJ IDEA.
 * User: Thomas
 * Date: 26.06.13
 * Time: 19:13
 * To change this template use File | Settings | File Templates.
 */
public class Player {
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Player){
            Player p = (Player) obj;
            System.out.println("Equals: " + getName().equals(p.getName()));
            return getName().equals(p.getName());
        }
        return false;    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public int hashCode() {
        return name.hashCode();    //To change body of overridden methods use File | Settings | File Templates.
    }
}
