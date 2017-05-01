
package porgorpatch2017;

public class Match {
    
    // main interface for matches
    public static void main(String[] args) {
        Bot red = new Bot("red");
        Bot black = new Bot("black");
        Game game = new Game(red, black);

        Client winner = game.play();
        System.out.println(winner.getName());
    }
}
