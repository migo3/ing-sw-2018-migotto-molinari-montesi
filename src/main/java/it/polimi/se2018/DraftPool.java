package it.polimi.se2018;

import it.polimi.se2018.exceptions.EmptyCellException;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Describes DraftPool behavior. A die can be placed in the draftPool, removed from it, rolled or switched with
 * another one (not in de draftPool). The number of present dice can be returned as well.
 * @author Alessio Molinari, Nives Migotto, Daniele Montesi
 */

//TODO: Ho cambiato il draftpool mettendo le cells al posto dei dadi, poichè è possibile che delle celle si svuotino quando i giocsatori le assegnano.Graficamente, questo deve essere rappresentato dalle celle vuote
public class DraftPool {
    /**
     * The arraylist is a List of Die.
     * If a Die is picked, the value has to remain NULL in order to let the Graphic to remain the same when a die is removed
     */
    private ArrayList<Cell> cells;

    /**
     * Constructor: generates a draftPool by taking from the dicebag 2 dice for each player + 1
     * @param dice dice to assign
     */
    public DraftPool(ArrayList<Die> dice) {
        this.cells = new ArrayList<>();
        for (int i = 0; i < dice.size(); i++) {
            cells.add(new Cell(dice.get(i), i));
        }
    }

    /**
     * Removes a die from the draftPool
     * @param diePosition position from which the die is taken
     * @return removed die
     */
    public Die takeDie(int diePosition) throws EmptyCellException {
        return cells.get(diePosition).removeDie();
    }

    /**
     * Switches a die with a random one
     * @param toBeSwitched new die in draftPool
     * @return old die from draftPool
     */
    public Die switchDie(Die toBeSwitched) throws EmptyCellException {
        boolean ok=false;
        int index=0;
        while (!ok) {
            index = ThreadLocalRandom.current().nextInt(0, cells.size());
            if (cells.get(index).hasDie())
                ok=true; }
        Die temp = cells.get(index).removeDie();
        cells.get(index).setAssociatedDie(toBeSwitched);
        return temp;
    }

    /**
     * Switches a die with a given one
     * @param diePosition position from which the die is taken
     * @param toBeSwitched new die in draftPool
     * @return old die from draftPool
     */
    public Die switchDie(int diePosition, Die toBeSwitched){
        Die temp = null;
        try {
            temp = cells.get(diePosition).removeDie();
        } catch (EmptyCellException e) {
            e.printStackTrace();
        }
        cells.get(diePosition).setAssociatedDie(toBeSwitched);
        return temp;
    }

    /**
     * Places a die in the draftPool
     * @param toBePlaced to be placed in the draftPool die
     */
    public void placeDie(int index, Die toBePlaced){
        cells.get(index).setAssociatedDie(toBePlaced);
    }

    //roll all dice in the DraftPool

    /**
     * Rolls all dice in the draftPool (gives all dice a new random value)
     */
    public void rollDice() throws EmptyCellException {
        for (Cell cell : cells) {
            if (!cells.isEmpty())
                cell.getAssociatedDie().roll(); //TODO does it change the value in the cell?
        }
    }

    /**
     *
     * @return numbers of dice in Draft Pool
     */
    public int draftPoolSize(){
        int counter=0;
        for (Cell cell: cells) {
            if (cell.hasDie())
                counter++;
        }
        return counter;
    }

    /**
     *
     * @param index draftPool index
     * @return Die at given index
     */
    public Die getDie(int index) throws EmptyCellException {
        return cells.get(index).getAssociatedDie();
    }

    public String toString(){
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < cells.size(); i++) {
            try {
                if (cells.get(i).getAssociatedDie().getValue() == 0) {
                    builder.append(i).append(":- ").append("noDie");
                } else {
                    builder.append(i).append(":- ").append(cells.get(i).getAssociatedDie().toString());
                }
            } catch (EmptyCellException e) {
                e.printStackTrace();
            }
            builder.append("\t");
        }
        builder.append("\n");
        return builder.toString();
    }

}
