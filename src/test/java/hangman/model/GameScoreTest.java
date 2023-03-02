package hangman.model;

import hangman.model.*;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Erika Juliana Castro Romero
 * @author Mariana Pulido Moreno
 *
 * ***************************************************************************
 * OriginalScore
 * failure = 10;
 *              Numero                 Clase de Equivalencia                                  Resultado
 *              1)                          correctCount < 0                       Incorrect/ Throws NEGATIVE_NUMBERS  Exception
 *              2)                         incorrectCount < 0                      Incorrect/ Throws NEGATIVE_NUMBERS  Exception
 *              3)                    correctCount>= 0 ^ incorrectCount=0                  Correct/  100
 *              4)              correctCount>= 0 ^  0<incorrectCount<=10                   Correct/  score - (incorrectCount*failure)
 *              5)             correctCount>= 0 ^  incorrectCount>10                       Correct/ 0
 * ***************************************************************************
 * BonusScore
 * failure = 5;
 * bonus = 10;
 *             Numero                 Clase de Equivalencia                                  Resultado
 *               1)                          correctCount < 0                       Incorrect/ Throws NEGATIVE_NUMBERS  Exception
 *               2)                         incorrectCount < 0                      Incorrect/ Throws NEGATIVE_NUMBERS  Exception
 *               3)               incorrectCount >=0  ^ correctCount>=0                         Correct/  0
 *                                          ^    2*incorrectCount>= correctCount
 *               4)               incorrectCount >=0  ^ correctCount>=0                         Correct/  score +(correctCount*bonus - incorrectCount*failure )
 *                                           ^    incorrectCount< correctCount
 *
 * ***************************************************************************
 * PowerBonusScore
 *failure = 8;
 *bonus = 5^correctCount;
 *             Numero                 Clase de Equivalencia                                  Resultado
 *               1)                          correctCount < 0                       Incorrect/ Throws NEGATIVE_NUMBERS  Exception
 *               2)                         incorrectCount < 0                      Incorrect/ Throws NEGATIVE_NUMBERS  Exception
 *               3)                  incorrectCount = 0 ^  correctCount>=4                         Correct/ 500
 *               4)                  incorrectCount >= 0 ^  correctCount=0                         Correct/ 0
 *               5)           incorrectCount > 0 ^  correctCoun>0              Correct/  score +(sum(5^correctCount) - incorrectCount*failure )
 *
 */
public class GameScoreTest {

    //Arrange
    private GameScore original = new OriginalScore();
    private GameScore bonus = new BonusScore();
    private GameScore power = new PowerScore();

    //*********************************************OriginalScore***********************************************

    @Test
    public void debeLanzarUnaExcepcionDelOriginal(){
        try{
            //Act
            original.calculateScore(-1,-1);
        }
        catch( Exception e ){
            //Assert
            Assert.assertTrue( true );
        }
    }


    // Limit test with  incorrectCount = 0
    @Test
    public void deberiaSer100OnOriginal() throws GameScoreException {
        //Act
        int score = original.calculateScore(100,0);
        //Assert
        Assert.assertEquals(score,100);

    }

    // Limit test with  correctCount = 10
    @Test
    public void deberiaSer500nOriginal() throws GameScoreException {
        //Act
        int score = original.calculateScore(0,5);
        //Assert
        Assert.assertEquals(score,50);

    }
    // Limit test with  incorrectCount = 10
    @Test
    public void deberiaSer0EnOriginal() throws GameScoreException {
        //Act
        int score = original.calculateScore(0,10);
        //Assert
        Assert.assertEquals(score,0);

    }

    // Limit test with  incorrectCount = 10
    @Test
    public void deberíaSerMínimoOriginal1() throws GameScoreException {
        //Act
        int score = original.calculateScore(26,11);
        //Assert
        Assert.assertEquals(score,0);

    }

    @Test
    public void deberíaSerMínimoOriginal2() throws GameScoreException {
        //Act
        int score = original.calculateScore(34,40);
        //Assert
        Assert.assertEquals(score,0);

    }

    //*********************************************BonusScore***********************************************
    @Test
    public void debeLanzarUnaExcepcionDelBonus(){
        try{
            //Act
            bonus.calculateScore(-1,-1);
        }
        catch( Exception e ){
            //Assert
            Assert.assertTrue( true );
        }
    }

    @Test
    public void deberíaSerUnBonoMínimo1() throws GameScoreException {
        //Act
        int score = bonus.calculateScore(10,20);
        //Assert
        Assert.assertTrue(score==0);

    }
    // Limit test with  incorrectCount = 0 ^  correctCount = 0
    @Test
    public void deberíaSerUnBonoMínimo2() throws GameScoreException {
        //Act
        int score = bonus.calculateScore(0,0);
        //Assert
        Assert.assertEquals(score,0);

    }

    @Test
    public void deberíaSer100EnBonificación() throws GameScoreException {
        //Act
        int score = bonus.calculateScore(20,20);
        //Assert
        Assert.assertTrue(score==100);

    }

    //*****************************************PowerScore***************************************************
    @Test
    public void deberíaLanzarUnaExcepciónDelPoder(){
        try{
            //Act
            power.calculateScore(-1,-1);
        }
        catch( Exception e ){
            //Assert
            Assert.assertTrue( true );
        }
    }

    // Limit test with  incorrectCount = 0 ^  correctCount = 4
    @Test
    public void deberíaSerMaxPuntuaciónPoder() throws GameScoreException {
        //Act
        int score = power.calculateScore(4,0);
        //Assert
        Assert.assertTrue(score == 500);

    }

    @Test
    public void deberíaSerUnaPuntuaciónMínimaPotencia() throws GameScoreException {
        //Act
        int score = power.calculateScore(0,15);
        //Assert
        Assert.assertTrue(score==0);


    }


    @Test
    public void  deberíaSerUnPoderDePuntuaciónNormal() throws GameScoreException {
        //Act
        int score = power.calculateScore(4,63);
        //Assert
        Assert.assertTrue(score==276);


    }


}

