
package porgorpatch2017;

public class Game {

    private int playerALeft;
    private int playerARight;
    private int playerBLeft;
    private int playerBRight;
    private int round;
    
    private final Client playerA;
    private final Client playerB;
    
    // instantiate a new game with initial game data
    public Game(Client A, Client B) {
        this.playerA = A;
        this.playerB = B;
        this.round = 0;
        this.playerARight = 1;
        this.playerALeft = 1;
        this.playerBRight = 1;
        this.playerBLeft = 1;
    }
    
    // check if game is finished
    private boolean isFinished() {
        if (this.playerALeft==0 && this.playerARight==0) {
            return true;
        } else if (this.playerBLeft==0 && this.playerBRight==0) {
            return true;
        } else {
            return false;
        }
    }
    
    private boolean isLegalMove(Turn turn) {
        return true;
    }
    
    // update this instance's attributes after A's turn
    private void updateWithAsTurn(Turn turn) {
        if (turn.getSwitchHands()) {
            this.playerALeft = turn.getMyLeft();
            this.playerARight = turn.getMyRight();
        } else {
            if (turn.getMyHand() == Hand.RIGHT) {
                if (turn.getOppHand() == Hand.RIGHT) {
                    if (5>this.playerARight+this.playerBRight) {
                        this.playerBRight += this.playerARight;
                    } else {
                        this.playerBRight = 0;
                    }
                } else {
                    if (5>this.playerARight+this.playerBLeft) {
                        this.playerBLeft += this.playerARight;
                    } else {
                        this.playerBLeft = 0;
                    } 
                }
            } else {
                if (turn.getOppHand() == Hand.RIGHT) {
                    if (5>this.playerALeft+this.playerBRight) {
                        this.playerBRight += this.playerALeft;
                    } else {
                        this.playerBRight = 0;
                    }
                } else {
                    if (5>this.playerALeft+this.playerBLeft) {
                        this.playerBLeft += this.playerALeft;
                    } else {
                        this.playerBLeft = 0;
                    } 
                }
            }
        }
    }
    
    // update this instance's attributes after B's turn
    private void updateWithBsTurn(Turn turn) {
        if (turn.getSwitchHands()) {
            this.playerBLeft = turn.getMyLeft();
            this.playerBRight = turn.getMyRight();
        } else {
            if (turn.getMyHand() == Hand.RIGHT) {
                if (turn.getOppHand() == Hand.RIGHT) {
                    if (5>this.playerBRight+this.playerARight) {
                        this.playerARight += this.playerBRight;
                    } else {
                        this.playerARight = 0;
                    }
                } else {
                    if (5>this.playerBRight+this.playerALeft) {
                        this.playerALeft += this.playerBRight;
                    } else {
                        this.playerALeft = 0;
                    } 
                }
            } else {
                if (turn.getOppHand() == Hand.RIGHT) {
                    if (5>this.playerBLeft+this.playerARight) {
                        this.playerARight += this.playerBLeft;
                    } else {
                        this.playerARight = 0;
                    }
                } else {
                    if (5>this.playerBLeft+this.playerALeft) {
                        this.playerALeft += this.playerBLeft;
                    } else {
                        this.playerALeft = 0;
                    } 
                }
            }
        }
    }

    // API method for playing the game instance, returns winner
    public Client play() {
        boolean AsTurn = Math.random()<0.5;
        while (!isFinished()) {
            if (this.round > 1000) {
                return new Bot("tie");
            }
            if (AsTurn) {
                Turn turn = this.playerA.getTurn();
                this.playerA.updateWithMyTurn(turn);
                this.playerB.updateWithOpponentTurn(turn);
                this.updateWithAsTurn(turn);
                System.out.println("-----------");
                System.out.println("Round " + this.round);
                if (turn.getSwitchHands()) {
                    System.out.println("Player A switches hands");
                    System.out.println("A: " + this.playerALeft + " " + this.playerARight);
                    System.out.println("B: " + this.playerBLeft + " " + this.playerBRight);
                } else {
                    System.out.println("Player A uses " + turn.getMyHand().toString()
                            + " to hit player B's " + turn.getOppHand());
                    System.out.println("A: " + this.playerALeft + " " + this.playerARight);
                    System.out.println("B: " + this.playerBLeft + " " + this.playerBRight);
                }
            } else {
                Turn turn = this.playerB.getTurn();
                this.playerA.updateWithOpponentTurn(turn);
                this.playerB.updateWithMyTurn(turn);
                this.updateWithBsTurn(turn);
                System.out.println("-----------");
                System.out.println("Round " + this.round);
                if (turn.getSwitchHands()) {
                    System.out.println("Player B switches hands");
                    System.out.println("A: " + this.playerALeft + " " + this.playerARight);
                    System.out.println("B: " + this.playerBLeft + " " + this.playerBRight);    
                } else {
                    System.out.println("Player B uses " + turn.getMyHand().toString()
                            + " to hit player A's " + turn.getOppHand());
                    System.out.println("A: " + this.playerALeft + " " + this.playerARight);
                    System.out.println("B: " + this.playerBLeft + " " + this.playerBRight);
                }
            }
            this.round++;
            AsTurn = !AsTurn;
        }
        if (this.playerALeft==0 && this.playerARight==0) {
            return this.playerB;
        } else {
            return this.playerA;
        }
    }
    
}
