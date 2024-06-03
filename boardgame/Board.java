package boardgame;

public class Board {
    
    private int rows;
    private int columns;
    private Piece[][] pieces;


    public Board(int rows, int columns) {
        if (rows < 1 || columns < 1) {
            throw new BoardExcpetion("Error creating board: there must be at least 1 row and 1 column");
        }
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }


    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Piece piece(int row, int column){
        if (!positionExistis(row, column)) {
            throw new BoardExcpetion("Position not on the board");
        }
        return pieces[row][column];
    }

    public Piece piece(Position position){
        if (!positionExistis(position)) {
            throw new BoardExcpetion("Position not on the board");
        }
        return pieces[position.getRow()][position.getColumn()];
    }

    public void placePiece(Piece piece, Position position){
        if (thereIsAPiece(position)) {
            throw new BoardExcpetion("There is already a piece on position " + position);
        }
        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }
    private boolean positionExistis(int row, int column){
       return row >= 0 && row < rows && column >= 0 && column < columns;
    }
    public boolean positionExistis(Position position){
        return positionExistis(position.getRow(), position.getColumn());
    }

    public boolean thereIsAPiece(Position position){
        if (!positionExistis(position)) {
            throw new BoardExcpetion("Position not on the board");
        }
        return  piece(position) != null;
    }
}
