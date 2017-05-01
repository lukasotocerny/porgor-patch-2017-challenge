
package porgorpatch2017;

public class Bot extends Client {
    
    public Bot(String name) {
        super(name);
    }
    
    // method implemented by teams
    @Override
    public Turn sendTurn() {
        int myLeft = this.getMyLeft();
        int myRight = this.getMyRight();
        int oppLeft = this.getOppLeft();
        int oppRight = this.getMyRight();
          
        // *******
        // INSERT CODE HERE
        // *******
        
        // choose my hand that will hit opponent's hand
        Hand chooseMyHand = Hand.RIGHT;
        Hand chooseOppHand = Hand.LEFT;
        return new Turn(chooseMyHand, chooseOppHand);
    }
    
}
