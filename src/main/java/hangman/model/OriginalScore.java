package hangman.model;

import hangman.model.GameScore;
import hangman.model.GameScoreException;

/**
 * @author Erika Juliana Castro Romero
 * @author Mariana Pulido Moreno
 * @version 1.0 01/03/2023
 *
 * This Class is a type of score, that the game can use
 */
public class OriginalScore implements GameScore {
    private int score = 100;
    private int failure=10;
    private int minScore=0;

    /**
     * este método calcula el marcador real del partido, siguiendo las siguientes reglas:
     * 1) El Juego comienza con 100 puntos
     * 2) Sin bonificación con intentos correctos
     * 3) penalización por falla de 10 puntos por cada intento incorrecto
     * 4) la puntuación mínima es 0
     * @param correctCount, int que representa los intentos correctos del jugador
     * @param incorrectCount, int que representa los intentos incorrectos del jugador
     * @return int ,que representa el marcador del partido
     * @throws GameScoreException, lanza una excepción si algunos de los números de conteo son negativos
     */
    @Override
    public int calculateScore(int correctCount, int incorrectCount) throws GameScoreException {
        if( correctCount < 0 || incorrectCount <0 ){
            throw new GameScoreException( GameScoreException.NEGATIVE_NUMBERS);
        }
        score =( score - (failure*incorrectCount) < minScore )? minScore :  score - (failure*incorrectCount);
        return score;
    }
}

