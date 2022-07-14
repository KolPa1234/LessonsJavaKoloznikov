package ChatServer;

import netWork.TCPConnection;
import netWork.TCPConnectionListener;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;

public class ChatServer implements TCPConnectionListener  {
    public static void main(String[] args) {
        new ChatServer();

    }

    private final ArrayList<TCPConnection> connections = new ArrayList<>();//создаем список соеденений
    private ChatServer(){
        System.out.println("Server running...");
        //ServerSocket serverSocket = new ServerSocket(8189);
        //Создаем серрверсокет который слушает порт 8189
        //В бесконечном цикле мы висим в методе accept
        try (ServerSocket serverSocket = new ServerSocket(8189)){
            while (true){
                try{
                    new TCPConnection(this, serverSocket.accept());

                }catch (IOException e){
                    System.out.println("TCPConnection exception: " + e);
                }
            }

        }catch (IOException e){
            throw  new RuntimeException(e);
        }

    }
    //пишем обработку наших событий
    @Override
    public synchronized void onConnectionReady(TCPConnection tcpConnection) {
        connections.add(tcpConnection);
        sendToAllConnections("Client connected: " + tcpConnection);//оповещаем при подключении

    }

    @Override
    public synchronized void onReceiveString(TCPConnection tcpConnection, String value) {
        sendToAllConnections(value);


    }

    @Override
    public synchronized void onDisconnect(TCPConnection tcpConnection) {
        sendToAllConnections("Client disconnected: " + tcpConnection);


    }

    @Override
    public synchronized void onException(TCPConnection tcpConnection, Exception e) {
        System.out.println("TCPConnection exception: " + e);

    }
    private void sendToAllConnections(String value){
        System.out.println(value);
        //сделаем оптимизацию для методы size
        final int cnt = connections.size();
        for(int i = 0; i< connections.size(); i++){connections.get(i).sendString(value);}
    }
}
