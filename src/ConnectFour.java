public class ConnectFour implements BoardGame{
    private int[][] board;
    private int currentPlayer;
    private Position[] winningPositions;
    private int winner;

    public void newGame() {
        board = new int[6][7];
        winningPositions = new Position[4];
        for(int i=0; i<=3; i++)
            winningPositions[i] = new Position();
        currentPlayer = 1 + (int)(Math.random()*2);
        winner = -1;
    }


    public boolean gameOver() {
        for(int r = 5; r >= 0; r--) {
            for(int c = 0; c <= 3; c++){
                if(board[r][c] != 0 && board[r][c] == board[r][c+1] && board[r][c+1] == board[r][c+2] && board[r][c+2] == board[r][c+3]){
                    for(int i=0; i<4;i++){
                        winningPositions[i] = new Position(r,c+i);
                    }
                    return true;
                }
            }
        }

        for(int r = 5; r >= 3; r--) {
            for(int c = 0; c <= 6; c++){
                if(board[r][c] != 0 && board[r][c] == board[r-1][c] && board[r-1][c] == board[r-2][c] && board[r-2][c] == board[r-3][c]){
                    for(int i=0; i<4;i++){
                        winningPositions[i] = new Position(r-i,c);
                    }
                    return true;
                }
            }
        }

        for(int r = 5; r >= 3; r--) {
            for (int c = 0; c <= 3; c++) {
                if (board[r][c] != 0 && board[r][c] == board[r - 1][c + 1] && board[r - 1][c + 1] == board[r - 2][c + 2] && board[r - 2][c + 2] == board[r - 3][c + 3]) {
                    for(int i=0; i<4;i++){
                        winningPositions[i] = new Position(r-i,c+i);
                    }
                    return true;
                }
            }
        }
        for(int r = 5; r >= 3; r--) {
            for (int c = 6; c > 3; c--) {
                if (board[r][c] != 0 && board[r][c] == board[r - 1][c - 1] && board[r - 1][c - 1] == board[r - 2][c - 2] && board[r - 2][c - 2] == board[r - 3][c - 3]) {
                    for(int i=0; i<4;i++){
                        winningPositions[i] = new Position(r-i,c-i);
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public int getWinner() {
        return winner;
    }


    public Position[] getWinningPositions() {
        return winningPositions;
    }


    public boolean columnFull(int column) {
        for(int r = 0; r < board.length; r++){
            if(board[r][column] == 0)
                return false;
        }
        return true;
    }


    public void play(int column) {
        if (!columnFull(column)){
            for(int r = 5; r >= 0; r--){
                if(board[r][column] == 0) {
                    board[r][column] = currentPlayer;
                    break;
                }
            }
        }
        currentPlayer = (currentPlayer == 1) ? 2 : 1;
    }


    public int[][] getBoard() {
        return board;
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }
}

