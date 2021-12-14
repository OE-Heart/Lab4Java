import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class Client extends Thread {
  private Socket socket;
  private BufferedReader in;
  private PrintWriter out;
  ArrayList<ClientListener> lstListener = new ArrayList<ClientListener>();
  private boolean running = true;

  public Client(Socket s) throws IOException {
    socket = s;
    in = 
      new BufferedReader(
        new InputStreamReader(
          socket.getInputStream()));
    out = 
      new PrintWriter(
        new BufferedWriter(
          new OutputStreamWriter(
            socket.getOutputStream())), true);
  }

  public void startListen() {
    start();
  }

  public void stopRx() {
    running = false;
  }

  public void run() {
    try {
      while (running) {  
        String str = in.readLine();
        notifyMsgRcvd(str);
        if (str.equals("END")) break;
        System.out.println("Echoing: " + str);
      }
      System.out.println("closing...");
    } catch (IOException e) {
    } finally {
      notifyQuit();
      try {
        socket.close();
      } catch(IOException e) {}
    }
  }

  public void sendMessage(String line) {
    out.println(line);
  }

  public synchronized void addClientListener(ClientListener listener) {
    lstListener.add(listener);
  }

  synchronized void notifyMsgRcvd(String msg) {
    for (ClientListener listener: lstListener) {
      listener.msgRcvd(msg);
    }
  }

  synchronized void notifyQuit() {
    for (ClientListener listener: lstListener) {
      listener.clientQuit(this);
    }
  }
}