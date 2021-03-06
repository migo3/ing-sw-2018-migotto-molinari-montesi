package client.view.gui.notifiers;

import client.view.gui.notifiers.gameboardactions.GameBoardAction;

import java.util.Observable;

public class GameBoardNotifier extends Observable {
    private boolean open;

    private GameBoardNotifier() {
        open = false;
    }

    private static class GameBoardNotifierHolder {
        private static final GameBoardNotifier INSTANCE = new GameBoardNotifier();
    }

    public static GameBoardNotifier getInstance() {
        return GameBoardNotifierHolder.INSTANCE;
    }

    public void updateGui() {
        setChanged();
        notifyObservers();
    }

    public void updateGui(GameBoardAction gameBoardAction) {
        setChanged();
        notifyObservers(gameBoardAction);
    }

    public void setOpen(boolean b) {
        if (b) {
            this.open = true;
        } else {
            this.open = false;
        }
    }

    public boolean isOpen() {
        return open;
    }
}