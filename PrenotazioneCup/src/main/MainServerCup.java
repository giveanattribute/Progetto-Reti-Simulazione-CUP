package main;

import java.io.IOException;

import users.ServerCup;

public class MainServerCup {
	
	public static void main(String[] args) throws IOException {
		
		ServerCup server= new ServerCup();
		server.listenServer();
	}

}
