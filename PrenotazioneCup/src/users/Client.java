package users;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.JOptionPane;


public class Client{
    
    public void connect() throws IOException {
    	
        String serverAddress = "127.0.0.1"; // IP LoopBack
        Socket s = new Socket(serverAddress, 9090);
        
        Paziente caz= new Paziente();
        
        BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));
        caz = (Paziente) input.lines();
        
        JOptionPane.showMessageDialog(null, caz.nome);
        
    }
    
}