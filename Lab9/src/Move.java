public class Move {

    private int row;
    private int col;
    private char player;
    private boolean winner;
    private boolean error;
    private String errMsg;
    private char[][] board;

    public Move(int row, int col, char player, boolean winner, boolean error, String errMsg, char[][] board) {
        this.row = row;
        this.col = col;
        this.player = player;
        this.winner = winner;
        this.error = error;
        this.errMsg = errMsg;
        this.board = board;
    }

    public Move(int row, int col, char player, boolean winner, char[][] board){
        this(row, col, player, winner, false, "", board);
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public char getPlayer() {
        return player;
    }

    public boolean isWinner() {
        return winner;
    }

    public boolean isError() {
        return error;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public char[][] getBoard() {
        return board;
    }
}
