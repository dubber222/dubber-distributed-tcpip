package com.dubber.distributed.siglonsocket;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created on 2018/5/9.
 *
 * @author dubber
 */
public class Client {

    public static void main(String[] args) {

        Socket socket = null;
        try {
            socket = new Socket("localhost", 8888);
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            Scanner sc = new Scanner(System.in);
            System.out.print("客户端：");
            while (sc.hasNext()) {
                String command = sc.nextLine();
                if (command.equals("exit")) {
                    break;
                }
                writer.println(command);
                String serverData = reader.readLine();
                System.out.println("服务器：" + serverData);
                System.out.print("客户端：");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
