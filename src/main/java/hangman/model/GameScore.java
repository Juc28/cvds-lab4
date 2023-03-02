package hangman.model;
/**
 *  @author Erika Juliana Castro Romero
 *  @author Mariana Pulido Moreno
 *  @version 1.0 01/03/2023
 */
public interface GameScore {
    /**
     * este método calcula el marcador real del partido
     * @param correctCount, int que representa los intentos correctos del jugador
     * @param incorrectCount, int que representa los intentos incorrectos del jugador
     * @return int ,que representa el marcador del partido
     * @throws GameScoreException, lanza una excepción si algunos de los números de conteo son negativos
     */
    public int calculateScore( int correctCount, int incorrectCount ) throws GameScoreException;

}
