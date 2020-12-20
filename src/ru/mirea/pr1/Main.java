package ru.mirea.pr1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;

public class Main {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.exit(1);
        }
        String host = args[0];
        int port = Integer.parseInt(args[1]);

        try {
            Socket mySocket = new Socket(host, port);
            PrintWriter mySocketOut = new PrintWriter(mySocket.getOutputStream(), true);
            BufferedReader mySocketReader = new BufferedReader(new InputStreamReader(mySocket.getInputStream()));
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            String input;
            while ((input = userInput.readLine()) != null) {
                mySocketOut.println(input);
                System.out.println(mySocketReader.readLine());
            }
        } catch (Exception e) {
            System.out.println(e);
            System.exit(1);
        }
    }
}
