package ch.k42.mclogstat.model;

/**
 * Created with IntelliJ IDEA.
 * User: Thomas
 * Date: 26.06.13
 * Time: 20:51
 * To change this template use File | Settings | File Templates.
 */
public class Increment {
    private int increment = 0;

    public Increment(int i){
        increment = i;
    }

    public void increment(){
        increment++;
    }

    public int getValue() {
        return increment;
    }

    @Override
    public String toString() {
        return Integer.toString(increment);    //To change body of overridden methods use File | Settings | File Templates.
    }
}
