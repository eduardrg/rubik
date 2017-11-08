# rubik

A Java program that simulates a Rubik's cube, which still needs a lot of work. 

## Features
You can rotate any face of the cube by calling doMove(Move move, boolean save) and passing it an appropriate Move.
A Move has a Direction, a Face, and (int) times, the number of times to rotate the Face in the given Direction.

Direction.LEFT corresponds to counterclockwise relative to the face. 
Direction.RIGHT corresponds to clockwise relative to the face. 

If save == true, the Move will be added to the history of moves so it can later be undone.
This is just for debugging right now. Trying to undo an unsaved move probably causes issues.
