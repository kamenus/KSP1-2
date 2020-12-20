package ru.mirea.pr1;

import java.net.*;

public class SocketServer {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.exit(1);
        }
        int port = Integer.parseInt(args[0]);
        try {
            ServerSocket serverSocket = new ServerSocket(port);

//            while (true) {
                new SocketThread(serverSocket.accept()).start();
//            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
