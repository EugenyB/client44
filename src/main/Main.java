package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    new Main().run();
    }

    private void run() {
        try {
            Socket socket = new Socket("localhost", 12345);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String s = reader.readLine(); // hello
            System.out.println(s);
            Scanner in = new Scanner(System.in);
            String line = in.nextLine();
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println(line);
            s = reader.readLine();
            System.out.println(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
