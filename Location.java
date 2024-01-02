import java.util.HashMap;
import java.util.Map;

public class Location {
  //copy the location class code we wrote in the example in here
  private final int locID;
    private final String locDescrip;

    /**
     * this will be all possible directions we can exit from a given location
     * our key is string our value is integer
     * our string will be cardinal direction

     */

    private final Map<String, Integer> exits;

    public Location(int locID, String locDescrip){
        this.locID = locID;
        this.locDescrip = locDescrip;
        this.exits = new HashMap<>();
        exits.put("Q", 0);

    }

    //ability to leave a location in a psecific direction
    //@param direction is a cardinal direction to leave in
    //@param location value of the location id

    public void addExit(String direction, int location){
        exits.put(direction,location);
    }

    public int getID() {
        return locID;
    }


    public String getLocDescrip() {
        return locDescrip;
    }

    /**
     * create new map with all the mappings from exits
     * return a copy of exits
     * NOTHING outside this class can modify exits
     * if the caller wants to change exits by adding or removing
     * the map in this class is not impacted
     */

    public Map<String, Integer> getExits(){
        return new HashMap<String, Integer>(exits);
    }
}
