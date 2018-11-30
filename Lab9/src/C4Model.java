/**
 * Model Class for Connect 4
 *
 * Both model and controller
 *
 * author: Scott C Johnson (scj@cs.rit.edu)
 */

import java.util.ArrayList;
import java.util.List;

public class C4Model {

    private char[][] board;
    private char currPlayer;

    private List<Observer<Move>> observers = new ArrayList<>();

    /**
     * Constructor
     */
    public C4Model(){
        board = new char[6][7];
        for(int row = 0; row < 6; row++)
            for(int col = 0; col < 7; col++)
                board[row][col] = '*';
        currPlayer = '1';
    }

    /**
     * Registers observers of this model
     * @param observer the observer to register
     */
    public void register( Observer<Move> observer){
        observers.add(observer);
    }

    /**
     * Places a piece in the given column from bottom to top.
     *
     * Notifies the observers of the changes.
     *
     * @param col the column to add the piece too.
     */
    public void makeMove(int col){
        Move m = null;
        for(int row = 0; row < 6; row++){
            if(board[row][col] == '*'){
                board[row][col] = currPlayer;
                m = new Move(row, col, currPlayer, checkWin(row, col), board);
                currPlayer = currPlayer == '1' ? '2' : '1';
                for(Observer<Move> o: observers){
                    o.update(m);
                }
                return;
            }
        }

        // Error. Move could not be made. Column full
        m = new Move(6, col, currPlayer, false, true, "Invalid move", board);

        for(Observer<Move> o: observers){
            o.update(m);
        }
    }

    /**
     * Checks starting at the provided row,col if the move is a winner.
     * @param row the row to start at
     * @param col the col to start at
     * @return true if winning move, false otherwise
     */
    private boolean checkWin(int row, int col){
        return checkDown(row, col)
                || checkUp(row, col)
                || checkLeft(row, col)
                || checkRight(row, col)
                || checkDownLeft(row, col)
                || checkDownRight(row, col)
                || checkUpLeft(row, col)
                || checkUpRight(row, col);
    }

    /**
     * Checks for winning move down.
     * @param row the row to start at
     * @param col the col to start at
     * @return true if winning move, false otherwise
     */
    private boolean checkDown(int row, int col){
        if(row < 3){
            return false;
        }

        for(int r = row; r > row - 4; r--){
            if(board[r][col] != currPlayer){
                return false;
            }
        }

        return true;
    }

    /**
     * Checks for winning move down.
     * @param row the row to start at
     * @param col the col to start at
     * @return true if winning move, false otherwise
     */
    private boolean checkUp(int row, int col){
        if(row > 2){
            return false;
        }

        for(int r = row; r < row + 4; r++){
            if(board[r][col] != currPlayer){
                return false;
            }
        }

        return true;
    }

    /**
     * Checks for winning move left.
     * @param row the row to start at
     * @param col the col to start at
     * @return true if winning move, false otherwise
     */
    private boolean checkLeft(int row, int col){
        if(col < 3){
            return false;
        }

        for(int c = col; c > col - 4; c--){
            if(board[row][c] != currPlayer){
                return false;
            }
        }

        return true;
    }

    /**
     * Checks for winning move right.
     * @param row the row to start at
     * @param col the col to start at
     * @return true if winning move, false otherwise
     */
    private boolean checkRight(int row, int col){
        if(col > 3){
            return false;
        }

        for(int c = col; c < col + 4; c++){
            if(board[row][c] != currPlayer){
                return false;
            }
        }

        return true;
    }

    /**
     * Checks for winning move up and right.
     * @param row the row to start at
     * @param col the col to start at
     * @return true if winning move, false otherwise
     */
    private boolean checkUpRight(int row, int col){
        if(col > 3 || row > 2){
            return false;
        }

        for(int c = col, r = row; c < col + 4; c++, r++){
            if(board[r][c] != currPlayer){
                return false;
            }
        }

        return true;
    }

    /**
     * Checks for winning move up and left.
     * @param row the row to start at
     * @param col the col to start at
     * @return true if winning move, false otherwise
     */
    private boolean checkUpLeft(int row, int col){
        if(col < 3 || row > 2){
            return false;
        }

        for(int c = col, r = row; c > col - 4; c--, r++){
            if(board[r][c] != currPlayer){
                return false;
            }
        }

        System.out.println("left");

        return true;
    }

    /**
     * Checks for winning move down and right.
     * @param row the row to start at
     * @param col the col to start at
     * @return true if winning move, false otherwise
     */
    private boolean checkDownRight(int row, int col){
        if(col > 3 || row < 3 ){
            return false;
        }

        for(int c = col, r = row; c < col + 4; c++, r--){
            if(board[r][c] != currPlayer){
                return false;
            }
        }

        return true;
    }

    /**
     * Checks for winning move down and left.
     * @param row the row to start at
     * @param col the col to start at
     * @return true if winning move, false otherwise
     */
    private boolean checkDownLeft(int row, int col){
        if(col < 3 || row < 3 ){
            return false;
        }

        for(int c = col, r = row; c > col - 4; c--, r--){
            if(board[r][c] != currPlayer){
                return false;
            }
        }

        return true;
    }
}
