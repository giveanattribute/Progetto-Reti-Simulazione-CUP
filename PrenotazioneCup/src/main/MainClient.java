package main;

import java.io.IOException;

import frames.RicettaFrame;
import users.Client;

public class MainClient {
	public static void main(String[] args) throws IOException {
		//RicettaFrame rcFrm = new RicettaFrame();
		Client client= new Client();
		
		client.connect();
	}
}
