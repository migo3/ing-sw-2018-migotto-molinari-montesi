package it.polimi.se2018.utils;

import it.polimi.se2018.client_to_server_command.*;
import it.polimi.se2018.server_to_client_command.ServerToClientCommand;

public interface ControllerServerInterface {

    /**
     * The choice of wpc is always right
     * That method removes the player that chooses its card, and moves it to the List of initialized player.
     * Checks if all players are initialized to call the next Controller Method
     * @param playerUsername the username who is applying the command
     * @param command the coming command
     */
    public void applyCommand(String playerUsername, ChosenWindowPatternCard command);

    public void applyCommand(String playerUsername, ClientToServerCommand command);


    public void applyCommand(String playerUsername, MoveChoiceToolCard command);

    //TODO: già controllato se è allowed  il player deve essere il current )
    public void applyCommand(String playerUsername, MoveChoiceDicePlacement command);
    

    //TODO: già controllato se è allowed (il player deve essere il current )
    public void applyCommand(String playerUsername, MoveChoicePassTurn command);

    //Those methods represents the view that uses correctly a tool.
    // The server has to validate the move and edit the model, if the move is correct
    // else, has to call a new Request of re-use of that tool, re-sending a event of AllowedUseToolCommand(usedToolNumber)

    /**
     * Applies commands coming from the Client, answering with correct/incorrect command responses
     */
    public void applyCommand(String playerUsername, UseToolCopperFoilReamer command);

    /**
     * Applies commands coming from the Client, answering with correct/incorrect command responses
     */
    //MOSSA SENZA RESTRIZIONE POSIZIONE E DEVONO ESSERE NON ADIACENTI
    public void applyCommand(String playerUsername,UseToolCorkLine command);
    
    /**
     * Applies commands coming from the Client, answering with correct/incorrect command responses
     */
    public void applyCommand(String playerUsername ,UseToolDiamondSwab command);
    
    /**
     * Applies commands coming from the Client, answering with correct/incorrect command responses
     */
    public void applyCommand(String playerUsername ,UseToolEglomiseBrush command);

    /**
     * Applies commands coming from the Client, answering with correct/incorrect command responses
     * BRUSH: decide the new value
     */
    public void applyCommand(String playerUsername ,UseToolFirmPastryBrush command);

    /**
     * Applies commands coming from the Client, answering with correct/incorrect command responses
     * THINNER: die from DiceBag
     */
    public void applyCommand(String playerUsername , UseToolFirmPastryThinner command);

    /**
     * Applies commands coming from the Client, answering with correct/incorrect command responses
     */
    public void applyCommand(String playerUsername ,UseToolGavel command);
    
    /**
     * Applies commands coming from the Client, answering with correct/incorrect command responses
     */
    public void applyCommand(String playerUsername ,UseToolLathekin command);
    
    /**
     * Applies commands coming from the Client, answering with correct/incorrect command responses
     */
    public void applyCommand(String playerUsername ,UseToolManualCutter command);
    
    /**
     * Applies commands coming from the Client, answering with correct/incorrect command responses
     */
    public void applyCommand(String playerUsername ,UseToolRoughingForceps command);
    
    /**
     * Applies commands coming from the Client, answering with correct/incorrect command responses
     */
    public void applyCommand(String playerUsername ,UseToolWheelsPincher command);
    
}