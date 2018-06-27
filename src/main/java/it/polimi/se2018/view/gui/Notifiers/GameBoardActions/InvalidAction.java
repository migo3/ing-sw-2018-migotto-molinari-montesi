package it.polimi.se2018.view.gui.Notifiers.GameBoardActions;

public class InvalidAction implements GameBoardAction {
    private String message;

    public InvalidAction(String message) {
        this.message = message;
    }

    @Override
    public void acceptGameBoardVisitor(GameBoardVisitor gameBoardVisitor) {
        gameBoardVisitor.visitGameBoardAction(this);
    }

    public String getMessage() {
        return message;
    }
}