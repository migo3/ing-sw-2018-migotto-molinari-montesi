package it.polimi.se2018.MatchTest;

import server.model.COLOR;
import server.model.DiceBag;
import server.model.Die;
import server.model.DraftPool;
import shared.exceptions.EmptyCellException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * Tests DraftPool methods.
 * @author Alessio Molinari
 */
public class DraftPoolTest {

    DraftPool dp;
    int numberOfPlayers = 2;

    @Before
    public void setUp(){
        //Instantiate a DiceBag and get dice from that bag
        DiceBag diceBag = new DiceBag();
        dp = new DraftPool(numberOfPlayers);
        dp.fillDraftPool(diceBag.extractDice(numberOfPlayers));
    }

    @Test
    public void printRepresentation(){
        System.out.println(dp.draftpoolPathRepresentation());
    }

    @Test
    public void printRepresentationWithTakenDie(){
        try {
            dp.takeDie(3);
        } catch (EmptyCellException e) {
            Assert.fail();
        }
        System.out.println(dp.draftpoolPathRepresentation());
    }

    @Test
    public void correctNumberOfDice(){
        assertEquals(numberOfPlayers*2+1, dp.draftPoolSize());
    }

    @Test
    public void testRoll() {
        dp.rollDice();
        assertEquals(numberOfPlayers*2+1, dp.draftPoolSize());
    }

    @Test
    public void testTakeDie() {
        try {
            dp.takeDie(0);
            assertEquals(numberOfPlayers*2, dp.draftPoolSize());
            dp.takeDie(2);
            assertEquals(numberOfPlayers*2-1, dp.draftPoolSize());
        } catch (EmptyCellException e) {
            Assert.fail();
        }
    }

    @Test
    public void testInvalidTakeDie(){
        try {
            dp.takeDie(8);
        } catch (EmptyCellException e) {
            assertTrue(true);
        }
    }

    @Test
    public void switchRandomDie(){
        dp.switchDie(new Die(COLOR.YELLOW));
        assertEquals(numberOfPlayers*2+1, dp.draftPoolSize());
    }

    @Test
    public void testSwitchDie() {

        COLOR tempCol = null;
        Die temp = null;
        try {
            tempCol = dp.getDie(3).getColor();
            temp = dp.switchDie(3, new Die(COLOR.GREEN));
        } catch (EmptyCellException e) {
            Assert.fail();
        }
        try {
            assertEquals(COLOR.GREEN, dp.getDie(3).getColor());
            assertEquals(tempCol, temp.getColor());
        } catch (EmptyCellException e) {
            Assert.fail();
        }
    }

    @Test
    public void testPlaceDie(){
        assertEquals(numberOfPlayers*2+1, dp.draftPoolSize());
        dp.placeDie(3, new Die(COLOR.GREEN));
         assertEquals(numberOfPlayers*2+1, dp.draftPoolSize());
    }
}
