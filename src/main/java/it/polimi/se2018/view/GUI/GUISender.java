package it.polimi.se2018.view.GUI;

import it.polimi.se2018.commands.client_to_server_command.ChosenWindowPatternCard;
import it.polimi.se2018.utils.Observable;

public class GUISender extends Observable {
    public void chosenWindowPatternCardMenu(String wpc) {
        notify(new ChosenWindowPatternCard(wpc));
    }

}