package users;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException; // Per gestire le eccezioni.
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter; // Per leggere e assegnare l'output in arrivo dal client.
import java.net.ServerSocket; // Per settare la porta del server.
import java.net.Socket; // Per utilizzare i metodi dell'oggetto Socket
import java.util.Date; // Da modificare, ed eventualmente cancellare, sostituendolo con oggetto utile ai fini del progetto.



public class ServerCup extends Thread
{
	BufferedReader in;
	PrintWriter out;
	
	public ServerCup()
	{
		this.start();
	}
	
	public void run()
	{
		
		try
		{
			ServerSocket server = new ServerSocket(9090);

			// ciclo infinito, in attesa di connessioni
			while(true)
			{
				// chiamata bloccante, in attesa di una nuova connessione
				Socket client = server.accept();

				try
				{
					// inizializza i buffer in entrata e uscita
					in = new BufferedReader(new InputStreamReader(client.getInputStream()));
					out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(client.getOutputStream())), true);


					System.out.println("Sto servendo il client che ha indirizzo " + client.getInetAddress());

					out.println("Connessione effettuata con successo!");
					
					Paziente paz= new Paziente("Raffaele", "Barbato", "34");
					out.print(paz);
					// eventuali elaborazioni e scambi di informazioni con il client

					// ...

					// chiusura dei buffer e del socket
					in.close();
		 			out.close();
		 			client.close();
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
}