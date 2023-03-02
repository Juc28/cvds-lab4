package hangman.model;

/**
 * @author Erika Juliana Castro Romero
 * @author Mariana Pulido Moreno
 * @version 1.0 01/03/2023
 *
 * Esta clase es un tipo de puntaje que el juego puede usar
 */
public class PowerScore implements GameScore {
    private int score = 0;
    private int failure= 8;
    private int bonus= 5;
    private int minScore= 0;
    private int maxScore =500;

    /**
     * Este método calcula el marcador real del partido, siguiendo las siguientes reglas:
     * 1) El Juego comienza con 0 puntos
     * 2) Bonificación de 5^i puntos con cada intento correcto, donde i es un iterador sobre el recuento correcto
     * 3) Penalización de falla de 8 puntos por cada intento incorrecto
     * 4) la puntuación mínima es 0
     * 5) La puntuación máxima es 500
     * @param correctCount, int que representa los intentos correctos del jugador
     * @param incorrectCount, int que representa los intentos incorrectos del jugador
     * @return int ,que representa el marcador del partido
     * @throws GameScoreException, lanza una excepción si algunos de los números de conteo son negativos
     */
    @Override
    public int calculateScore(int correctCount, int incorrectCount) throws GameScoreException {
        if( correctCount < 0 || incorrectCount <0 ) {
            throw new GameScoreException(GameScoreException.NEGATIVE_NUMBERS);
        }

        for( int i=1 ; i <=correctCount; i++){
            score+= (Math.pow(bonus,i));
        }

        score =( score - (failure*incorrectCount) < minScore )? minScore :  score - (failure*incorrectCount);
        score =( score > maxScore )? maxScore :  score ;
        return score;
    }
}
