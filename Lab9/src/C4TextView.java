import java.util.Scanner;

public class C4TextView implements Observer<Move>{

    private C4Model model;
    private boolean winner;

    public C4TextView(){
        this.model = new C4Model();
        this.model.register(this);
        this.winner = false;
    }

    private void printBoard(char[][] board){
        for(int i = 5;  i > -1; i--){
            char[] row = board[i];
            for(char c: row){
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }
    @Override
    public void update(Move pushData) {
        if(pushData.isError()){
            System.out.println("Error: " + pushData.getErrMsg());
        }
        printBoard(pushData.getBoard());

        if(pushData.isWinner() == false){
            System.out.println(String.format("Player %s has won!", pushData.getPlayer()));
            winner = true;
        }
    }

    public void playGame(){
        Scanner scanner = new Scanner(System.in);
        while(!winner){
            System.out.println("Please enter your move [ 0 - 6 ]: ");
            int col = scanner.nextInt();
            model.makeMove(col);
        }
    }

    public static void main(String[] args) {
        C4TextView tView = new C4TextView();
        tView.playGame();
    }


}
