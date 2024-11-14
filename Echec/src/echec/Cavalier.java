package echec;


class Cavalier extends Piece 
{
    public Cavalier(int x, int y, boolean estBlanc)
    {
        super(x,y,estBlanc);
    }
    
    @Override
    public boolean peutBouger(int x, int y, Board board) 
    {
        int dx = Math.abs(this.x - x);
        int dy = Math.abs(this.y - y);
        if (!((dx == 2 && dy == 1) || (dx == 1 && dy == 2))) return false;

        // Permet le déplacement s'il n'y a pas de pièce ou si elle peut être capturée
        return board.trouvePiece(x, y) == null || peutCapturer(x, y, board);
    }

}
