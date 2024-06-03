package boardgame;

public class BoardExcpetion extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public BoardExcpetion(String msg){
        super(msg);
    }
}
