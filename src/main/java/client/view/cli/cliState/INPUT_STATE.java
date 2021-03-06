package client.view.cli.cliState;

public enum INPUT_STATE {
    YOUR_TURN,
    NOT_YOUR_TURN,
    CHOOSE_WPC,
    PLACE_DIE_INDEX,
    PLACE_DIE_ROW_COLUMN,
    TOOLCARD_CHOICE,
    REPLY_ANOTHER_ACTION,
    REPLY_DIE_VALUE,
    REPLY_INCREASE_DECREASE,
    REPLY_PICK_DIE,
    REPLY_PLACE_DIE,
    END_GAME;

    /**
     * Next state function
     */
    public static INPUT_STATE nextState(INPUT_STATE currentState, String input){
        INPUT_STATE nextState;

        //undo action
        if (input.equals("u") && isLocallyReversible(currentState)){
            nextState = YOUR_TURN;
        } else if((input.equals("d")) && currentState.equals(YOUR_TURN)){
            nextState = PLACE_DIE_INDEX;
            //use toolcard
        } else if(currentState.equals(PLACE_DIE_INDEX)){
            nextState = PLACE_DIE_ROW_COLUMN;
        } else if(currentState.equals(PLACE_DIE_ROW_COLUMN)) {
            nextState = YOUR_TURN;
        } else if ((input.equals("t")) && currentState.equals(YOUR_TURN)){
            nextState = TOOLCARD_CHOICE;
        } else if ((input.equals("p")) && currentState.equals(YOUR_TURN)){
            nextState = NOT_YOUR_TURN;
        } else if (currentState.equals(CHOOSE_WPC)){
            nextState = NOT_YOUR_TURN;
        }
        else {
            nextState = currentState;
        }
        return nextState;
    }

    /**
     * Checks if it is possible to go back from current state without notifying the Controller
     */
   public static boolean isLocallyReversible(INPUT_STATE currentState){
        if ((currentState.equals(PLACE_DIE_ROW_COLUMN))
                || currentState.equals(PLACE_DIE_INDEX)
                || currentState.equals(TOOLCARD_CHOICE)){
            return true;
        } else {
            return false;
        }
    }
}
