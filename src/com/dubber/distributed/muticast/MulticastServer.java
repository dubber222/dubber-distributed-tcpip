package com.dubber.distributed.muticast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

/**
 * Created by dubber on 2018/5/8.
 */
public class MulticastServer {

    public static void main(String[] args) {
        try {
            InetAddress group = InetAddress.getByName("224.5.6.7");

            /**
             * 组播组由D类IP地址和标准UDP端口号指定
             * D类IP地址范围为224.0.0.0至239.255.255.255 （含）。
             * 地址224.0.0.0是保留的，不应该使用。
             */
            MulticastSocket socket = new MulticastSocket();
            for (int i = 0; i < 10; i++) {
                String data = "Hello shuai";
                byte[] bytes = data.getBytes();

                DatagramPacket hi = new DatagramPacket(bytes, bytes.length, group, 8888);
                socket.send(hi);
                TimeUnit.SECONDS.sleep(2);
            }

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
