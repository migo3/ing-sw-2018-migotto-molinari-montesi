package it.polimi.se2018.network.server.rmi;


import it.polimi.se2018.network.client.ClientConnection;
import it.polimi.se2018.network.client.rmi.RMIClientInterface;
import it.polimi.se2018.network.server.Server;
import it.polimi.se2018.server_to_client_command.ServerToClientCommand;

import java.rmi.RemoteException;
import java.util.Map;

public class RMIVirtualClient implements ClientConnection {

    RMIClientInterface rmiClientInterface;

    public RMIVirtualClient(RMIClientInterface rmiClientInterface) {
        this.rmiClientInterface = rmiClientInterface;
    }

    @Override
    public void notifyClient(ServerToClientCommand command) {

        //TODO: SENZA THREAD!!!!!
            new Thread() {
                public void run() {
                    try {
                        rmiClientInterface.rmiNotifyClient(command);
                    } catch (RemoteException e) {
            /*
            Nota: in alternativa, un modo più semplice di ciclare in tutta la mapppa è aggiungere al comando
            da server a client l'username dell'utente di destinazione (come per l'analogo client to server)
             */
                        String disconnecting;
                        for (Map.Entry<String, ClientConnection> entry : Server.getConnectedClients().entrySet()) {
                            if (entry.getValue().equals(this)) {
                                disconnecting = entry.getKey();
                                Server.disconnnectClient(disconnecting);
                                System.out.println("Client " + entry.getKey() + " disconnected");
                                break;
                            }
                        }
                    }
                }
            }.start();
            //rmiClientInterface.rmiNotifyClient(command);


    }
}

// bella