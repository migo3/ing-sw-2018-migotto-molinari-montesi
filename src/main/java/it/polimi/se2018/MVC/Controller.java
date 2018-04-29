package it.polimi.se2018.MVC;

import it.polimi.se2018.Die;
import it.polimi.se2018.Model;
import it.polimi.se2018.Player;
import it.polimi.se2018.WindowPatternCard;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

public class Controller extends Observable implements Observer {

    private Model model;
    private HashMap<Player, ClientController> playerClientControllerMap;
    private ArrayList<Player> orderedPlayers;
    private ArrayList<ClientController> clients;
    private ArrayList<ClientController> disconnectedClients;
    private int roundNumber;
    private ServerInterface server;




    public Controller(ArrayList<ClientConnection> clients, ServerInterface server){
        this.clients = clients;
        this.server = server;
    }


    /**
     * do per scontato che il Model sia già stato costruito
     * @param orderedPlayers
     */

    /**
     * Create a match with 4 players. It calls initializePlayers() and setInitialPlayer()
     */
    public void initializeGame() {

    }

    /**
     * Call methods for starting the board of each player
     * including:
     * choose the WPattern Card
     * ...
     */
    public void initializePlayers() {

    }

    /**
     * Inizialise the next player for the turn
     * eventually, if every player played twice, it calls passRound()
     */
    public void passTurn() {
    }

    /**
     * Initialize next Round.
     * eventually calls endGame if rounds are 10
     */
    public void passRound() {
    }


    /**
     * Calls method for initializing a new round
     * -> send to all players a new RefreshBoardCommand
     * -> extract Dices ..
     * -> set first player and
     */
    public void startRound() {
    }

    /**
     * Calculate total score of plsyers and determine who is the winner
     */
    public void endGame() {

    }

    /**
     * Generally returns true if need ad allowance to perform a command
     * @return
     */
    public boolean isAllowed(){

    }

    public void sendCommandToAllPlayers(ServerToClientCommand command){

    }

    public void sendCommandToPlayer(Player player, ServerToClientCommand command){

    }

    public void sendCommandToAllExceptCurrent(ServerToClientCommand command){

    }

    @Override
    public void update(Observable o, Object arg) {

    }


/*
    public void startGame(ArrayList<Player> orderedPlayers) {
        // assegno i players al model e l'ordine di gioco
        this.orderedPlayers = orderedPlayers;

        // start i game di tutti (i players sono già salvati, e di standard il primo ad effettuare il turno sarà il primo che si è connesso
        view.initializeAllGames(orderedPlayers.get(0));

        for (Player p : orderedPlayers) { //TODO concurrent
            if (p == orderedPlayers.get(0)) {
                model.nextRound();
                view.startTurn(p);
            } else
                view.waitForYourTurn(p);
        }

        playerViewHashMap.get(playerToInitializeGame).initializeGame();
    }
        // Methods that calls the Client's View...
        // decido chi comincia per primo e chiamo il metodo del suo view


        // Inizializzo la schermata dei giocatori

        // faccio schegliere la carta Pattern a ogni giocatore

        //viewPlayerHashMap.put(one, new Player())...

        // la assegno







    public void performMoveToServer(Die dieToPlace, int row, int column, Player player) {
        if (model.getCurrentRound.getCurrentPlayer() == player) {
            WindowPatternCard patternCardWhereToPlaceDie = model.getCurrentRound.getCurrentPlayer().getWindowPatternCard();
            if (patternCardWhereToPlaceDie.placeDie(dieToPlace, row, column,
                    false, false, false)) {
                view.notifyCorrectMoveServerToClient(player);
            } else {
                view.notifyIncorrectMoveServerToClient(player);
            }
        } else { // Case it's not player's turn
            view.notifyNotYourTurn();
        }
    }

        public void performToolActionToServer(int numberOfToolToUse, Player player){
            if (player.getTokens() >
                    (model.getExtractedToolCard.get(numberOfToolToUse).getTokenCounts()>0 ? 1: 2)) {
                //posso utilizzarlo
                player.decreaseTokens(model.getExtractedToolCard.get(numberOfToolToUse).getTokenCounts()>0 ? 1: 2);
                view.notifyAbleToUseTool(model.getExtractedToolCard.get(numberOfToolToUse), player);
            }
            else {
                view.notifyNotAbleToUseTool(player);
            }
    }


    */


}