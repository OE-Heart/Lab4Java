import java.io.*;
import java.net.*;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.*;

interface ClientListener {
  void msgRcvd(String message);
  void clientQuit(Client c);
}

public class Server implements ClientListener {
  private static Server theServer = new Server();
  static final int PORT = 8080;
  static LinkedList<Client> lstClient = new LinkedList<Client>();
  private MsgSender sender = new MsgSender();
  private final int MaxThread = 2000;
  private ExecutorService threadPool = new ThreadPoolExecutor(0, MaxThread, 60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());

  private Server() {}

  static Server getServer() {
    return theServer;
  }

  public void msgRcvd(String msg) {
    sendMessage(msg);
  }

  public void clientQuit(Client c) {
    lstClient.remove(c);
    c.stopRx();
    sender.rmClient(c);
  }

  void go() throws IOException {
    threadPool.submit(() -> {
      ServerSocket s = new ServerSocket(PORT);
      System.out.println("Server Started");
      try {
        while(true) {
          // Blocks until a connection occurs:
          Socket socket = s.accept();
          try {
            Client c = new Client(socket);
            threadPool.submit(c);
            c.addClientListener(this);
            lstClient.add(c);
            c.startListen();
            sender.addClient(c);
            System.out.println("Client Connected");
          } catch(IOException e) {
            // If it fails, close the socket,
            // otherwise the thread will close it:
            socket.close();
          }
        }
      } finally {
        s.close();
      }
    });
    threadPool.submit(sender);
  }

  synchronized void sendMessage(String msg) {
    sender.sentToClient(msg);
  }

  public static void main(String[] args) throws IOException {
    Server server = new Server();
    server.go();
  }
}

class MsgSender extends Thread {
  static LinkedList<Client> lstClient;
  private final Queue<String> messageQueue;

  public MsgSender() {
    lstClient = new LinkedList<Client>();
    messageQueue = new ArrayDeque<>();
  }

  public synchronized void addClient(Client c) {
    lstClient.add(c);
  }

  public synchronized void rmClient(Client c) {
    lstClient.remove(c);
  }

  public synchronized void sentToClient(String msg) {
    messageQueue.add(msg);
    this.notify();
  }
  
  public void run() {
    while (true) {
      synchronized (this) {
        try {
          while (!messageQueue.isEmpty()) {
            String msg = messageQueue.poll();
            // messageQueue.remove();
            lstClient.forEach(c -> {
              try {
                c.sendMessage(msg);
              } catch (Exception e) {}
            });
          }
          this.wait();
        } catch (InterruptedException e) {}
      }
    }
  }
}