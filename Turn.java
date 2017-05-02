
package porgorpatch2017;

public class Turn {
    
    private final Hand myHand;
    private final Hand oppHand;
    private final int myLeft;
    private final int myRight;
    private final boolean switchHands;
    
    public Turn(Hand switchHands, int left, int right) {
        this.myHand = null;
        this.oppHand = null;
        this.switchHands = true;
        this.myLeft = left;
        this.myRight = right;
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
