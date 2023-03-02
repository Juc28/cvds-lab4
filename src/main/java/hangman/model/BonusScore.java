package hangman.model;

/**
 * @author Erika Juliana Castro Romero
 * @author Mariana Pulido Moreno
 * @version 1.0 01/03/2023
 *
 * This Class is a type of score, that the game can use
 */
public class BonusScore implements GameScore {
    private int score = 0;
    private int failure= 5;
    private int bonus=10;
    private int minScore= 0;

    /**
     * este método calcula el marcador real del partido, siguiendo las siguientes reglas:
     * 1) El Juego comienza con 0 puntos
     * 2) Bonificación de 10 puntos con cada intento correcto
     * 3) Penalización de falla de 5 puntos por cada intento incorrecto
     * 4) la puntuación mínima es 0
     * @param correctCount, int que representa los intentos correctos del jugador
     * @param incorrectCount, int que representa los intentos incorrectos del jugador
     * @return int ,que representa el marcador del partido
     * @throws GameScoreException, lanza una excepción si algunos de los números de conteo son negativos
     */
    @Override
    public int calculateScore(int correctCount, int incorrectCount) throws GameScoreException {
        
        score =( score+(correctCount*bonus) - (failure*incorrectCount) < minScore )? minScore :  score+(correctCount*bonus) - (failure*incorrectCount);
        return score;
    }
}
