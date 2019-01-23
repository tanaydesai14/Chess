
Main File: P2.java

Other instructions: All the image files  have to be imported into the source directory of the project.

This application launches a playable chessboard allowing users to play two player chess. At every point of the game, users can view all the possible moves which can be made by each of the pieces and a hint for the best move possible at that point.

The algorithm for the priority of the best move at each point is as below: 

(1) Highest priority goes to moves that capture an opposing piece

(2) If two, more, or no moves capture an opposing piece, then, out of those moves
    whichever move who ends with a piece furthest to the right, with respect to the player.
    (ie Furthest Right for White, Left for Black)

(3) If the first two conditions do not eliminate a tie, then from those moves choose
    whichever move ends with a piece furthest away from the player. (ie Furthest Up for
    white, Down for Black)

(4) If the previous conditions still do not eliminate a tie, then from those moves choose the
    piece that started furthest left with respect to the player (ie Furthest Left for White,
    Right for Black)

(5) If the previous conditions still do not eliminate a tie, then from those moves, choose
    the piece that started most back from the player. (Furthest Down for White, Up for
    Black)
