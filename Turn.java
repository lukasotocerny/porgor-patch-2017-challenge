
package porgorpatch2017;

public class Turn {
    
    private final Hand myHand;
    private final Hand oppHand;
    
    public Turn(Hand myHand, Hand oppHand) {
        this.myHand = myHand;
        this.oppHand = oppHand;
    }
    
    public Hand getMyHand() {
        return this.myHand;
    }
    
    public Hand getOppHand() {
        return this.oppHand;
    }
    
}
