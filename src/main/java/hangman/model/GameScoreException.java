package hangman.model;

/**
 * @author Erika Juliana Castro Romero
 * @author Mariana Pulido Moreno
 * @version 1.0 01/03/2023
 */
public class GameScoreException extends Exception {
    public static final String NEGATIVE_NUMBERS = "Algunos de los números de conteo son negativos.";
    public GameScoreException(String message ){
        super( message);
    }
}

