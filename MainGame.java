import java.security.Key;
import java.util.*;

public class MainGame {

    private static Map<Integer, Location> locs = new HashMap<>();
    public static void main(String[] args) {
        //copy the code from the class example we did in here

        Scanner sc = new Scanner(System.in);
        //Locations
        locs.put(0, new Location(0, "You are sitting room 218 learning Java"));
        locs.put(1, new Location(1, "You are standing at the end of a road before a rundown gas station"));
        locs.put(2, new Location(2, "You are on top of dune"));
        locs.put(3, new Location(3, "You are inside a building, a great hall surrounded by vibrant colors"));
        locs.put(4, new Location(4, "You are in a canyon beside a stream"));
        locs.put(5, new Location(5, "You are in a forest outside an abandoned cabin"));
        locs.put(6, new Location(6, "You are in the Amazon rainforest"));
        locs.put(7, new Location(7, "You are at Hogwarts"));
        locs.put(8, new Location(8, "Uh..you lost! you landed on the losing position. The game will now direct you to reality. Bye Bye"));
        locs.put(9, new Location(9, "You are on top of Mount Everest"));
        locs.put(10, new Location(10, "You are at the deepest level of the pacific ocean"));
        locs.put(11, new Location(11, "Congratulations this was the winning location! You won the game!"));
        locs.put(12, new Location(12, "You are on a plane flying to Sydney, Australia"));

        //location exits

        locs.get(1).addExit("N", 5);
        locs.get(1).addExit("E", 3);
        locs.get(1).addExit("S", 4);
        locs.get(1).addExit("W", 2);

        locs.get(2).addExit("E", 5);
        locs.get(2).addExit("W", 7);

        locs.get(3).addExit("N", 6);
        locs.get(3).addExit("W", 1);

        locs.get(4).addExit("E", 8);
        locs.get(4).addExit("S", 9);
        locs.get(4).addExit("N", 1);
        locs.get(4).addExit("W", 2);

        locs.get(5).addExit("E", 6);
        locs.get(5).addExit("W", 2);
        locs.get(5).addExit("S", 1);

        locs.get(6).addExit("E", 10);
        locs.get(6).addExit("W", 5);
        locs.get(6).addExit("S", 3);

        locs.get(7).addExit("N", 12);
        locs.get(7).addExit("E", 2);

        locs.get(9).addExit("W", 11);

        locs.get(10).addExit("W", 6);

        locs.get(12).addExit("S", 7);

        int loc = 1;
        String locDirec = "";

        Map<String, String> vocab = new HashMap<String, String>();
        vocab.put("north", "N");
        vocab.put("south", "S");
        vocab.put("east", "E");
        vocab.put("west", "W");
        vocab.put("quit", "Q");

        int moves = 11;

        System.out.println("Welcome to Adventuring Around the World!!! In this game, the goal is to find the winning location.\n" +
                "You will have 11 moves to find the winning location out of the 12 locations. One of the spots is the losing location. Land on the" +
                "losing location and you will automatically lose. Good luck!");
        System.out.println();

        while(moves > 0){

            //grab and print description
            System.out.println(locs.get(loc).getLocDescrip());

            //take us back to reality out of our game
            if(loc == 0){
                break;
            } else if (loc == 8) {
                System.out.println(locs.get(0).getLocDescrip());
                break;
            } else if(loc == 11){
                break;
            }

            Map<String, Integer> map = locs.get(loc).getExits();
            System.out.print("Here are your available exits: ");
            System.out.println(map.keySet());
            System.out.println();
            System.out.println("You have " + moves + " moves to win");

            System.out.print("What direction next? (Please only put first letter of direction. Press 'Q' to quit): ");
            locDirec = sc.nextLine();
            locDirec = locDirec.toUpperCase();
            if(locDirec.length() >=4){
                String[] words = locDirec.split(" ");
                for(int i = 0; i < words.length; i++){
                    if(vocab.containsKey(words[i].toLowerCase())){
                        locDirec = words[i].substring(0,1).toUpperCase();
                        break;
                    }
                }
            }

            //make sure the user is going to a location that exists

            if(!locs.get(loc).getExits().containsKey(locDirec)){
                System.out.println("You cannot go to that location. It is forbidden");
                moves++;
            } else {
                loc = locs.get(loc).getExits().get(locDirec);
            }
            System.out.println();
            moves--;
        }

        if(moves==0) {
            System.out.println("You lost because you ran out of moves");
        }
        System.out.println("Thanks for playing!");
    }


}
