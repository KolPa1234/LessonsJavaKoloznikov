package netWork;

import java.io.*;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.EventListener;

public class TCPConnection {
    private final Socket socket;
    private final Thread rxThread;
    private final TCPConnectionListener eventListener; //слушатель событий является неким интрейфейсом
    private final BufferedReader in;
    private final BufferedWriter out;

    public TCPConnection(TCPConnectionListener eventListener, String ipAddr, int port)throws IOException{
        this(eventListener, new Socket(ipAddr, port));//создаем сокет на оснвании ip and port

    }

    public TCPConnection(TCPConnectionListener eventListener, Socket socket) throws IOException{
        this.eventListener = eventListener;
        this.socket = socket;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream(), Charset.forName("UTF-8")));
        out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), Charset.forName("UTF-8")));

        //Создаем поток, который будет слушать все входящие
        rxThread = new Thread(new Runnable() { //создаем ананимный класс
            @Override
            public void run() {
                try{
                   eventListener.onConnectionReady(TCPConnection.this);//передали экземпляр, таким образом
                    while (!rxThread.isInterrupted()){
                        String msg = in.readLine();
                        eventListener.onReceiveString(TCPConnection.this, in.readLine());
                    }

                }catch (IOException e){
                    eventListener.onException(TCPConnection.this, e);
                }finally {
                    eventListener.onDisconnect(TCPConnection.this);//случился дисконект
                }
            }
        });
        rxThread.start();
    }
    public synchronized void sendString(String value){ //синхронизацию делаем для безопасности многопоточнсти
       try {
           out.write(value + "\r\n");
           out.flush();//сбрасывает буферы и отправляем
       }catch (IOException e){
           eventListener.onException(TCPConnection.this, e);
           disconnect();
       }
    }

    public synchronized void disconnect(){
        rxThread.isInterrupted();
        try {
            socket.close();
        }catch (IOException e){
            eventListener.onException(TCPConnection.this, e);
        }
    }
    @Override
    public String toString(){
        return  "TCPConnection: " + socket.getInetAddress() + ": " + socket.getPort();
    }
}
