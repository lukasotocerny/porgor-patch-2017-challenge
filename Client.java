
package porgorpatch2017;

public class Client {
    
    private int myLeft;
    private int myRight;
    private int oppLeft;
    private int oppRight;
    
    private String name;
    
    public Client(String name) {
        this.myLeft = 0;
        this.myRight = 0;
        this.oppLeft = 0;
        this.oppRight = 0;
        this.name = name;
    }
    
    public void updateWithMyTurn(Turn turn) {
        if (turn.getMyHand() == Hand.RIGHT) {
            if (turn.getOppHand() == Hand.RIGHT) {
                if (5-this.oppRight>this.myRight) {
                    this.oppRight += this.myRight;
                } else {
                    this.oppRight = 0;
                }
            } else {
                if (5-this.oppLeft>this.myRight) {
                    this.oppLeft += this.myRight;
                } else {
                    this.oppLeft = 0;
                } 
            }
        } else {
            if (turn.getOppHand() == Hand.RIGHT) {
                if (5-this.oppRight>this.myLeft) {
                    this.oppRight += this.myLeft;
                } else {
                    this.oppRight = 0;
                }
            } else {
                if (5-this.oppLeft>this.myLeft) {
                    this.oppLeft += this.myLeft;
                } else {
                    this.oppLeft = 0;
                } 
            }
        }
    }
    
    public void updateWithOpponentTurn(Turn turn) {
        if (turn.getMyHand() == Hand.RIGHT) {
            if (turn.getOppHand() == Hand.RIGHT) {
                if (5-this.myRight>this.oppRight) {
                    this.myRight += this.oppRight;
                } else {
                    this.myRight = 0;
                }
            } else {
                if (5-this.myLeft>this.oppRight) {
                    this.myLeft += this.oppRight;
                } else {
                    this.myLeft = 0;
                } 
            }
        } else {
            if (turn.getOppHand() == Hand.RIGHT) {
                if (5-this.myRight>this.oppLeft) {
                    this.myRight += this.oppLeft;
                } else {
                    this.myRight = 0;
                }
            } else {
                if (5-this.myLeft>this.oppLeft) {
                    this.myLeft += this.oppLeft;
                } else {
                    this.myLeft = 0;
                } 
            }
        }
    }
    
    public Turn getTurn() {
        return sendTurn();
    }
    
    public String getName() {
        return this.name;
    }
    
    private Turn sendTurn() {
        Hand myHand = Hand.RIGHT;
        Hand oppHand = Hand.LEFT;
        return new Turn(myHand, oppHand);
    }
    
}
