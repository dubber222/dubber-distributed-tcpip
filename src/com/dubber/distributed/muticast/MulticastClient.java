package com.dubber.distributed.muticast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

/**
 * Created by dubber on 2018/5/8.
 */
public class MulticastClient {

    public static void main(String[] args) throws UnknownHostException {
        InetAddress group = InetAddress.getByName("224.5.6.7");

        try {
            MulticastSocket socket = new MulticastSocket(8888);

            // 加到指定的组里面
            socket.joinGroup(group);

            byte[] buf = new byte[256];

            while (true) {
                DatagramPacket msgPacket = new DatagramPacket(buf, buf.length);

                //只要有 receive 就有阻塞
                socket.receive(msgPacket);
                System.out.println("接收到的数据：" + new String(msgPacket.getData()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
