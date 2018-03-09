package main;

import java.io.IOException;

import frames.RicettaFrame;
import users.Client;

public class MainClient {
	public static void main(String[] args) throws IOException 
	{
		Client client= new Client();
		
		client.connect();
		//RicettaFrame rcFrm = new RicettaFrame();

	}
}
