
package porgorpatch2017;

public abstract class Client {
    
    private int myLeft;
    private int myRight;
    private int oppLeft;
    private int oppRight;
    
    private final String name;
    
    // constructor with initial game data
    public Client(String name) {
        this.myLeft = 1;
        this.myRight = 1;
        this.oppLeft = 1;
        this.oppRight = 1;
        this.name = name;
    }
    
    // public method for updating attributes after my turn
    public void updateWithMyTurn(Turn turn) {
        if (turn.getSwitchHands()) {
            this.myLeft = turn.getMyLeft();
            this.myRight = turn.getMyRight();
        } else {
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
    }
    
    // public method for updating attributes after opponents turn    
    public void updateWithOpponentTurn(Turn turn) {
        if (turn.getSwitchHands()) {
            this.oppLeft = turn.getMyLeft();
            this.oppRight = turn.getMyRight();
        } else {
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
    }
    
    private boolean isLegalHit(int myHand, int oppHand) {
        if (myHand==0) {
            System.out.println("Invalid move from " + this.name + ". Cannot "
                + "HIT with hand that has 0 fingers.");
            return false;
        } else if (oppHand==0) {
            System.out.println("Invalid move from " + this.name + ". Cannot "
                + "HIT hand that has 0 fingers.");
            return false;
        } else {
            return true;
        } 
    }
    
    // return whether a turn in a specific moment is legal
    public boolean isLegalMove(Turn turn) {
        if (turn.getSwitchHands()) {
            if (turn.getMyLeft()+turn.getMyRight()!=this.myLeft+this.myRight) {
                System.out.println("Invalid move from " + this.name + ". Cannot "
                        + "SWITCH from " + this.myLeft + " " + this.myRight + " -> " + 
                        turn.getMyLeft() + " " + turn.getMyRight());
                return false;
            } else if (turn.getMyLeft()==this.myRight && turn.getMyRight()==this.myLeft) {
                System.out.println("Invalid move from " + this.name + ". Cannot "
                        + "SWITCH from " + this.myLeft + " " + this.myRight + " -> " + 
                        turn.getMyLeft() + " " + turn.getMyRight());
                return false;
            }
        } else {
            if (turn.getMyHand()==Hand.RIGHT && turn.getOppHand()==Hand.RIGHT) {
                if (!isLegalHit(this.myRight, this.oppRight)) return false;
            } else if (turn.getMyHand()==Hand.RIGHT && turn.getOppHand()==Hand.LEFT) {
                if (!isLegalHit(this.myRight, this.oppLeft)) return false;
            } else if (turn.getMyHand()==Hand.LEFT && turn.getOppHand()==Hand.RIGHT) {
                if (!isLegalHit(this.myLeft, this.oppRight)) return false;
            } else {
                if (!isLegalHit(this.myLeft, this.oppLeft)) return false;
            }
        }
        return true;
    }
    
    // public method for getting client's turn, implemented by sendTurn() in subclass
    public Turn getTurn() {
        return sendTurn();
    }
    
    // public method for getting name in String
    public String getName() {
        return this.name;
    }
    
    // implemented by subclass Bot
    public abstract Turn sendTurn();
    
    // getters for number of fingers
    public int getMyLeft() {
        return this.myLeft;
    }
    public int getMyRight() {
        return this.myRight;
    }
    public int getOppLeft() {
        return this.oppLeft;
    }
    public int getOppRight() {
        return this.oppRight;
    }
    
}
