package lesson12hw11;

public class Configuration {
    private final String serverAddress;
    private final int port;
    private final String username;
    private final String password;

    public Configuration(String serverAddress, int port, String username, String password) {
        this.serverAddress = serverAddress;
        this.port = port;
        this.username = username;
        this.password = password;
    }

    public String getServerAddress() {
        return serverAddress;
    }

    public int getPort() {
        return port;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
