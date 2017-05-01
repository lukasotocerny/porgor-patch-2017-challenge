
package porgorpatch2017;

public class Game {

    private int playerALeft;
    private int playerARight;
    private int playerBLeft;
    private int playerBRight;
    
    private final Client playerA;
    private final Client playerB;
    
    public Game(Client A, Client B) {
        this.playerA = A;
        this.playerB = B;
        this.playerARight = 0;
        this.playerALeft = 0;
        this.playerBRight = 0;
        this.playerBLeft = 0;
    }
    
    private boolean isFinished() {
        if (this.playerALeft==0 && this.playerARight==0) {
            return true;
        } else if (this.playerBLeft==0 && this.playerBRight==0) {
            return true;
        } else {
            return false;
        }
    }
    
    private void updateWithAsTurn(Turn turn) {
        if (turn.getMyHand() == Hand.RIGHT) {
            if (turn.getOppHand() == Hand.RIGHT) {
                if (5-this.playerBRight>this.playerARight) {
                    this.playerBRight += this.playerARight;
                } else {
                    this.playerBRight = 0;
                }
            } else {
                if (5-this.playerBLeft>this.playerARight) {
                    this.playerBLeft += this.playerARight;
                } else {
                    this.playerBLeft = 0;
                } 
            }
        } else {
            if (turn.getOppHand() == Hand.RIGHT) {
                if (5-this.playerBRight>this.playerALeft) {
                    this.playerBRight += this.playerALeft;
                } else {
                    this.playerBRight = 0;
                }
            } else {
                if (5-this.playerBLeft>this.playerALeft) {
                    this.playerBLeft += this.playerALeft;
                } else {
                    this.playerBLeft = 0;
                } 
            }
        }
    }
    
    private void updateWithBsTurn(Turn turn) {
        if (turn.getMyHand() == Hand.RIGHT) {
            if (turn.getOppHand() == Hand.RIGHT) {
                if (5-this.playerARight>this.playerBRight) {
                    this.playerARight += this.playerBRight;
                } else {
                    this.playerARight = 0;
                }
            } else {
                if (5-this.playerALeft>this.playerBRight) {
                    this.playerALeft += this.playerBRight;
                } else {
                    this.playerALeft = 0;
                } 
            }
        } else {
            if (turn.getOppHand() == Hand.RIGHT) {
                if (5-this.playerARight>this.playerBLeft) {
                    this.playerARight += this.playerBLeft;
                } else {
                    this.playerARight = 0;
                }
            } else {
                if (5-this.playerALeft>this.playerBLeft) {
                    this.playerALeft += this.playerBLeft;
                } else {
                    this.playerALeft = 0;
                } 
            }
        }
    }

    public Client play() {
        boolean AsTurn = 0.6<0.5;
        while (!isFinished()) {
            if (AsTurn) {
                Turn turn = this.playerA.getTurn();
                this.playerA.updateWithMyTurn(turn);
                this.playerB.updateWithOpponentTurn(turn);
                this.updateWithAsTurn(turn);
            } else {
                Turn turn = this.playerB.getTurn();
                this.playerA.updateWithOpponentTurn(turn);
                this.playerB.updateWithMyTurn(turn);
                this.updateWithBsTurn(turn);
            }
            AsTurn = !AsTurn;
        }
        if (this.playerALeft==0 && this.playerARight==0) {
            return this.playerB;
        } else {
            return this.playerA;
        }
    }
    
}
