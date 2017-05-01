
package porgorpatch2017;

public class Bot extends Client {
    
    public Bot(String name) {
        super(name);
    }

    private Turn sendTurn() {
        Hand myHand = Hand.RIGHT;
        Hand oppHand = Hand.LEFT;
        return new Turn(myHand, oppHand);
    }
    
}
