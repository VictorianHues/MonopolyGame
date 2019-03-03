# Monopolymorphism Assignment
#### INCOMPLETE
#### Julieon Peterson
#### Object Oriented Programming
#### Stephen Hughes
#### Due Date: 25 February 2019

## Objective:
* Work with Abstract classes
* Implement classes with a polymorphic relationship.
##Problem:
Consider the game of Monopoly™. At its essence, this game consists of a sequential set of 40 squares containing 28 properties, 6 Action squares (3 "Chance", 3 "Community Chest"), 2 Tax squares, "GO", "Jail", "Free Parking", and "Go To Jail.". The game is played by moving through the set of squares. Every time a player lands on a square, they take a different action, depending on the type of a square. For example, if you land on a "Tax Square", you must pay the bank a certain amount of money, but if you land on an "Action Square" you must draw a card from the appropriate pile and follow the instructions on the card.
The complete version of Monopoly has some additional nuances – Mortgages, Trading, Buildings, Auctions, etc. that would extend the due date for implementing a computer version of the game. Fortunately, the good folks a Hasbro created Monopoly Junior™, recognizing that the gameplay boils down to two parts:
* Roll the dice and move your token that many spaces
* Follow the instructions for that space.
For this assignment, you will be implementing a 2-player, computer vs. computer version of Monopoly Junior

## Specification:
1. The complete rules for Monopoly Junior can be found at
  http://www.hasbro.com/common/instruct/monojr.pdf
16 properties
* The distribution of colors and cost are:(2 Purple $1, 2 White $2, 2 Magenta $2, 2 Orange $3, 2 Red $3, 2 Yellow $4, 2 Green $4, 2 Blue $5)
Each should have a name (you can make up your own names).
6 Chance Spots
2 “Tax” spots (Watershow and Fireworks).
4 Railroads are located at the midpoint of each side.
The corners are
* Go (lower right)
* RestRoom (lower left)
* Loose Change (upper left)
* Goto Rest Room (upper right)
3. There are 24 chance cards – don’t forget to shuffle them.
* 16 = goto a specific square of a color (e.g. Blue #1)
* 8 Free Ticket Booth Cards 1 per color
4. You may assume that the bank has unlimited cash; you do not need to track which bills a player has, only the total cash on hand.
5. After the initial setup of the game, two computer-based players play the game. Every move should be documented. After each move, the player status should be displayed, e.g.
Player 1 Rolls: 3
Player 1 moves to Blueberry Falls
It is not owned; Player 1 purchased Blueberry Falls for $4
Player 1 Ends turn with 5 properties and $56
Player 2 Rolls: 2
Player 2 moves to the SweetTooth Railroad
Player 2 Rolls: 4
Player 2 moves to Chance
FREE TICKET BOOTH: Blue;
Player 2 takes B1ue Moon Acres
Player 2 Ends turn with 2 properties and $24
6. The player’s decisions do not need to be “smart” or “strategic”. It is appropriate for decisions to
be made randomly.

## Implementation Tips:
1. Start by Thinking about what classes you need and how they relate.
2. Create a sample board that just prints what happens when you landOn that square --- don’t worry
about maintaining the game state initially. Add this functionality incrementally at a later point.
3. Think carefully about how you want to manage the monopolies. There are several ways to do it.
Some are better than others. This is probably one of the last things to implement.
