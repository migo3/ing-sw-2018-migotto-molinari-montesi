package it.polimi.se2018.public_obj_cards;

import it.polimi.se2018.COLOR;
import it.polimi.se2018.Exceptions.EmptyCellException;
import it.polimi.se2018.WindowPatternCard;

import java.util.HashSet;

public class RowColorVariety extends PublicObjectiveCard{
    private int score = 6;

    public int calculateScore(WindowPatternCard w){
        int total = 0;
        for (int i = 0; i < 4; i++){
            HashSet<COLOR> colors = new HashSet<>();
            for(int j = 0; j < 5; j++){
                try {
                    colors.add(w.getCell(i, j).getAssociatedDie().getColor());
                } catch (EmptyCellException e) {
                    continue;
                }
            }
            if(colors.size() == 5){
                total += score;
            }
        }
        return total;
    }
}
