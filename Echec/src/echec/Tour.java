package echec;

class Tour extends Piece
{    
    public Tour(int x, int y, boolean estBlanc)
    {
        super(x, y, estBlanc);
    }
    
    
    @Override
    public boolean peutBouger(int x, int y, Board board) 
    {
        if (this.x != x && this.y != y) return false; // Doit être en ligne droite

        // Vérifie que le chemin est dégagé
        if (!cheminEstLibre(x, y, board)) return false;

        // Permet le déplacement s'il n'y a pas de pièce ou si elle peut être capturée
        return board.trouvePiece(x, y) == null || peutCapturer(x, y, board);
    }
    
    
    private boolean cheminEstLibre(int x, int y, Board board) 
    {
        int dx = Integer.compare(x, this.x); // Direction en x
        int dy = Integer.compare(y, this.y); // Direction en y

        int currX = this.x + dx;
        int currY = this.y + dy;

        // Parcours des cases intermédiaires
        while (currX != x || currY != y) 
        {
            if (board.trouvePiece(currX, currY) != null) return false;
            currX += dx;
            currY += dy;
        }
        return true;
        }
}