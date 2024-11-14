package echec;

abstract class Piece 
{
    protected int x, y; //les coordonees de la piece sur le plateau
    protected boolean estBlanc; //couleur de la piece. Soit blanc ou noir
    
    public Piece(int x, int y, boolean estBlnc)
    {
        this.x = x;
        this.y = y;
        this.estBlanc = estBlanc;
    }
    
    public boolean peutCapturer(int x, int y, Board board)
    {
        Piece cible = board.trouvePiece(x,y);
        
        return ( cible != null && cible.estBlanc != this.estBlanc );
    }
    
    public abstract boolean peutBouger(int x, int y, Board board);
}
