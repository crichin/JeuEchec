package echec;


public class Board 
{   
    public Piece[][] board;
    
    public Board()
    {
        board = new Piece[8][8]; //creer un plateau
        initialisePieces();
    }


    private void initialisePieces()
    {
//        //Placer les pieces noires
//        board[0][0] = new Tour(0,0, false);
//        board[1][0] = new Cavalier(1,0, false);
////        board[2][0] = new Four(2,0);
////        board[3][0] = new Dame(3,0");
////        board[4][0] = new Roi(4,0);
////        board[5][0] = new Four(5,0);
////        board[6][0] = new Cavalier(6,0);
////        board[7][0] = new Tour(7,0);
    }
    
    public Piece trouvePiece(int x, int y)
    {
        return board[x][y];
    }
    
    public boolean bougePiece(int startX, int startY, int endX, int endY) 
    {
        Piece piece = trouvePiece(startX, startY);

        if (piece != null && piece.peutBouger(endX, endY, this)) 
        {
            Piece target = trouvePiece(endX, endY);

            if (target != null && piece.peutCapturer(endX, endY, this)) 
            {
                System.out.println("Capture de la pièce en position (" + endX + ", " + endY + ")");
            }

            board[endX][endY] = piece;
            board[startX][startY] = null;
            piece.x = endX;
            piece.y = endY;

            return true; // Mouvement réussi
        }
        return false; // Mouvement invalide
    }

    
    
    
    public boolean deplacePiece(int startX, int startY, int endX, int endY)
    {
        Piece piece = trouvePiece(startX, startY);

        // Vérifie qu'il y a une pièce à déplacer et que le mouvement est valide
        if (piece != null && piece.peutBouger(endX, endY, this)) {
            Piece target = trouvePiece(endX, endY);

            // Si la destination contient une pièce ennemie, elle est capturée
            if (target != null && piece.peutCapturer(endX, endY, this)) {
                System.out.println("Capture de la pièce en position (" + endX + ", " + endY + ")");
            }

            // Déplace la pièce
            board[endX][endY] = piece;
            board[startX][startY] = null;
            piece.x = endX;
            piece.y = endY;

            return true; // Mouvement réussi
    }
    return false; // Mouvement invalide
    }

}