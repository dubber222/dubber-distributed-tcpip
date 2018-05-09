package com.dubber.distributed.siglonsocket;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created on 2018/5/9.
 *
 * @author dubber
 *         <p>
 *         接收消息的到来
 */
public class SocketServer {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // 启动服务，
        ServerSocket server = null;
        try {
            // 默认绑定本机ip, 多网卡的另说
            server = new ServerSocket(8888);
            //等待一个请求接口
            Socket socket = server.accept();
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

            while (true) {
                String msg = reader.readLine();
                if(msg == null){
                    break;
                }
                System.out.println("客户端：" + msg);

                System.out.print("服务器：");
                String command = sc.nextLine();
                writer.println(command);
                writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
