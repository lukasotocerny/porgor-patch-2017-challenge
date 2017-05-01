## Porgor Patch 2017 - Bot Challenge API ##

Document bellow provides the basic structure of the methods that you can use for the challenge. The class that you are going to implement is the `Bot` class.

### RULES ###
#### Game ####


#### Penalties, rewards ####
* Illegal turn results immediate loss of the game.
* An individual game can also be a tie in case 1000 rounds being reached (infinite repetition)
* There will be 1000 games in every match between a pair of bots.
* In a match, the bot with more wins wins the game
* Match can also end up as a tie, if both have the same amount of wins
* For winning a match team gets 3 points, tie 1 point, loss 0 points.
* After all the matches the team with the most points wins the challenge.

### IMPLEMENTATION ###
#### Bot class ####
Your job is to implement the `sendTurn()` function. This function is called by `match` class, when it is waiting for you take make your turn. In the initial lines
```java
int myLeft = this.getMyLeft();
int myRight = this.getMyRight();
int oppLeft = this.getOppLeft();
int oppRight = this.getMyRight();
```
the variables are assigned the current number of fingers at each hand, so that you can decided what move to take based on that data. 
Once you have decided, rewrite lines 
```java
Hand chooseMyHand = Hand.RIGHT;
Hand chooseOppHand = Hand.LEFT;
```
in each case either using Hand.RIGHT or Hand.LEFT, which are constants used to standardize the notion of hands. `chooseMyHand` designates the hand with which you want to hit opponent's hand, i.e. `chooseOppHand`.
That is all you need to know and implement. You can write any other class as you
wish.

#### Match class ####
Once you have implemented your `Bot` class, you can test it against our Porgor AI, which we happened to name Johnny. 
`Game game = new Game(johnny, black);` instantiates a new game and `game.play()` calls the game to start and eventually finish. You can view the progress of the game in the console log.