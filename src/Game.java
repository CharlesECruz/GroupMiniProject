import enumeration.ApplicationUtils;
import enumeration.BoardIcons;

public class Game {
    private Piece[][] board;

    public Game(){
        board = new Piece[8][8];
        createBoard();
        printBoard();
    }

    private void createBoard() {
        for (int i = 7; i >= 0;i--){
            for (int j = 0; j < board[i].length; j ++ ){
                Piece p = null;
                if(i == 0){
                    if (j == 0 || j == 7){
                        p = new Rook(true, new Position(i,j));
                    }else if (j == 1 || j == 6){
                        p= new Knight(true,new Position(i,j));
                    }else if (j == 2 || j == 5){
                        p = new Bishop(true,new Position(i,j));
                    }else if (j == 3){
                        p = new Queen(true,new Position(i,j));
                    }else if (j == 4){
                        p = new King(true,new Position(i,j));
                    }
                }else if(i == 1){
                    p = new Pawn(true,new Position(i,j));
                }else if (i == 6){
                    p = new Pawn(false,new Position(i,j));
                }else if (i == 7){
                    if (j == 0 || j == 7){
                        p = new Rook(false, new Position(i,j));
                    }else if (j == 1 || j == 6){
                        p = new Knight(false,new Position(i,j));
                    }else if (j == 2 || j == 5){
                        p = new Bishop(false,new Position(i,j));
                    }else if (j == 3){
                        p = new Queen(false,new Position(i,j));
                    }else if (j == 4){
                        p = new King(false,new Position(i,j));
                    }
                }
                board[i][j] = p;
            }
        }
    }

    public void printBoard(){
        for (int i = 7; i >= 0;i--) {
            for (int j = 0; j < board[i].length; j++) {
                Piece piece = board[i][j];
                if(piece !=null){
                    System.out.print(" " +((Piece)board[i][j]).getIcon());
                }else{
                    System.out.print(" "+BoardIcons.EMPTY.getCode());
                }

            }
            System.out.println(" " + (i+1));
        }
        ApplicationUtils.axis_x.forEach(c-> System.out.print(" " + c));
    }

    public Piece[][] getBoard() {
        return board;
    }
    public void changePosition(Piece piece){
        this.board[piece.getPosition().getRow()][piece.getPosition().getCol()]=piece;
        this.board[piece.getOldPosition().getRow()][piece.getOldPosition().getCol()] = null;
        printBoard();
    }
}
