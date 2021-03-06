## Porgor Patch 2017 - Bot Challenge API ##

Document bellow provides the basic structure of the methods that you can use for the challenge. The class that you are going to implement is the `Bot` class.

### RULES ###
#### Game ####

##### Illegal moves, beware! #####
* Switching symmetrically, e.g. 1 1 -> 1 1, or 2 3 -> 3 2 is not allowed.
* Hitting opponent with a hand with 0 fingers, e.g. 0 3 -> you cannot hit with LEFT hand
* Hitting opponent's hand that has 0 fingers, e.g. ME: 2 3 OPP: 0 2, I cannot hit OPP's LEFT hand


#### Penalties, rewards ####
* Illegal turn results immediate loss of the game.
* An individual game can also be a tie in case 1000 rounds being reached (infinite repetition)
* There will be 1000 games in every match between a pair of bots.
* In a match, the bot with more wins wins the game
* Match can also end up as a tie, if both have the same amount of wins
* For winning a match team gets 3 points, tie 1 point, loss 0 points.
* After all the matches the team with the most points wins the challenge.

### IMPLEMENTATION ###
#### `Bot` class ####
Your job is to implement the `sendTurn()` function in the area:
```java
// *******
// INSERT CODE HERE
// *******
```
The `sendTurn()` function is called by `Match` class, when it is waiting for you take make your turn. In the initial lines
```java
int myLeft = this.getMyLeft();
int myRight = this.getMyRight();
int oppLeft = this.getOppLeft();
int oppRight = this.getMyRight();
```
the variables represent the current number of fingers at each hand, so that you can decide what move to take based on that data. 
Once you have decided, rewrite lines 
```java
Hand chooseMyHand = Hand.RIGHT;
Hand chooseOppHand = Hand.LEFT;
```
in each case either using `Hand.RIGHT` or `Hand.LEFT`, which are constants used to standardize the notion of hands. `chooseMyHand` designates the hand with which you want to hit opponent's hand, i.e. `chooseOppHand`.
If you wish to hit opponent's hand, use `return new Turn(chooseMyHand, chooseOppHand)`, but if you wish to switch your hands use `return new Turn(Hand.SWITCH, 1, 1)` which represents `Turn(Hand switchHands, int newLeft, int newRight)`
That is all you need to know and implement. You can use any tools and additional code as you like.

#### `Match` class ####
Once you have implemented your `Bot` class, you can test it against our Porgor AI, bot Lukas, named after its father. 
`Game game = new Game(lukas, black);` instantiates a new game and `game.play()` calls the game to start and eventually finish. You can view the progress of the game in the console log.