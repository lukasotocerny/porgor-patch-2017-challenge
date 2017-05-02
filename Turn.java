
package porgorpatch2017;

public class Turn {
    
    private final Hand myHand;
    private final Hand oppHand;
    private final int myLeft;
    private final int myRight;
    private final boolean switchHands;
    
    public Turn(Hand switchHands, int newLeft, int newRight) {
        this.myHand = null;
        this.oppHand = null;
        this.switchHands = true;
        this.myLeft = newLeft;
        this.myRight = newRight;
    }
    
    public Turn(Hand myHand, Hand oppHand) {
        this.myHand = myHand;
        this.oppHand = oppHand;
        this.switchHands = false;
        this.myLeft = 0;
        this.myRight = 0;
    }
    
    public boolean getSwitchHands() {
        return this.switchHands;
    }
    
    public Hand getMyHand() {
        return this.myHand;
    }
    
    public Hand getOppHand() {
        return this.oppHand;
    }
    public int getMyLeft() {
        return this.myLeft;
    }
    public int getMyRight() {
        return this.myRight;
    }
    
}
