package it.polimi.se2018.MVC;

public class ClientToServerCommand {

    /**
     * Represent all possible methods from Client to Server
     * They are constructed by the View
     *
     */


}


class ChosenToolCardCommand extends ClientToServerCommand{
    int numberChosen;

    public ChosenToolCardCommand(int numberChosen){
        this.numberChosen = numberChosen;
    }


}


//... Many others

class ChosenWindowPatternCardCommand {

}

class ChosenUsernameCommand{

}