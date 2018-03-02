package main;

import java.io.IOException; // Per gestire le eccezioni.
import java.io.PrintWriter; // Per leggere e assegnare l'output in arrivo dal client.
import java.net.ServerSocket; // Per settare la porta del server.
import java.net.Socket; // Per utilizzare i metodi dell'oggetto Socket
import java.util.Date; // Da modificare, ed eventualmente cancellare, sostituendolo con oggetto utile ai fini del progetto.

/**
 * A TCP server that runs on port 9090.  When a client connects, it
 * sends the client the current date and time, then closes the
 * connection with that client.  Arguably just about the simplest
 * server you can write.
 */
public class ServerCup {

    /**
     * Runs the server.
     */
    public static void main(String[] args) throws IOException {
        ServerSocket listener = new ServerSocket(9090);
        try {
            while (true) {
                Socket socket = listener.accept();
                try {
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    out.println(new Date().toString());
                } finally {
                    socket.close();
                }
            }
        }
        finally {
            listener.close();
        }
    }
}