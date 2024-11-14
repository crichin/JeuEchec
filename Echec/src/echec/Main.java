package echec;

public class Main 
{
    public static void main(String[] args)
    {
        Board board = new Board();

        // Placer une Tour et un Cavalier pour tester les déplacements et captures
        board.board[0][0] = new Tour(0, 0, true);  // Tour blanche
        board.board[3][3] = new Cavalier(3, 3, false); // Cavalier noir

        // Tentative de déplacement de la Tour
        System.out.println("Déplacement de la Tour à (0, 3) : " + board.bougePiece(0, 0, 0, 3)); // Déplacement valide
        System.out.println("Déplacement de la Tour à (3, 3) pour capturer le Cavalier : " + board.bougePiece(0, 3, 3, 3)); // Capture
    }
   
}
 