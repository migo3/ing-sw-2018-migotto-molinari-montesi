package shared.network_interfaces;


import shared.commands.server_to_client_command.ServerToClientCommand;

public interface ClientConnection {

    void notifyClient(ServerToClientCommand command);
}
