
package porgorpatch2017;

public class Match {
    
    // main interface for matches
    public static void main(String[] args) {
        Bot johnny = new Bot("johnny");
        Bot black = new Bot("black");
        Game game = new Game(johnny, black);

        Client winner = game.play();
        System.out.println(winner.getName());
    }
}
