package shared.server_network;


import shared.commands.client_to_server_command.ClientToServerCommand;

public interface ServerConnection {

    void send(ClientToServerCommand command);

    void startConnection(String username);
}