package ru.mirea.pr1;

import java.io.*;
import java.net.*;

public class SocketThread extends Thread {
    Socket client = null;
    public SocketThread(Socket client) {
        this.client = client;
    }

    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);
            String userInput;
            while ((userInput = in.readLine()) != null) {
                String[] input = userInput.split(" ", 3);
                int firstArg = Integer.parseInt(input[0]);
                int secondArg = Integer.parseInt(input[2]);
                System.out.println(firstArg);
                switch(input[1]) {
                    case "+":
                        out.println(firstArg + secondArg);
                        break;
                    case "-":
                        out.println(firstArg - secondArg);
                        break;
                    case "*":
                        out.println(firstArg * secondArg);
                        break;
                    case "/":
                        out.println(firstArg / secondArg);
                        break;
                    default:
                        break;
                }
            }

            client.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
