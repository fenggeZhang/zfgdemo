package com.zfg.test.javatest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zfg on 2019/3/5
 */
public class SocketTest {
    private static final int PORT = 9999;
    private List<Socket> mList = new ArrayList<Socket>();
    private ServerSocket server = null;
    private ExecutorService mExecutorService = null; //thread pool

    public static void main(String[] args) {
        new SocketTest();
    }

    public SocketTest() {
        try {
            server = new ServerSocket(PORT);
            mExecutorService = Executors.newCachedThreadPool();  //create a thread pool
            System.out.print("服务器已启动...");
            Socket client = null;
            while (true) {
                client = server.accept();
                //把客户端放入客户端集合中
                mList.add(client);
                mExecutorService.execute(new Service(client)); //start a new thread to handle the connection
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class Service implements Runnable {
        private Socket socket;
        private BufferedReader in = null;
        private String msg = "";

        public Service(Socket socket) {
            this.socket = socket;
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                //客户端只要一连到服务器，便向客户端发送下面的信息。
                msg = "user" + this.socket.getInetAddress() + "come toal:"
                        + mList.size();
                this.sendmsg();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            // TODO Auto-generated method stub
            try {
                while (true) {
                    if ((msg = in.readLine()) != null) {
                        //当客户端发送的信息为：exit时，关闭连接
                        if (msg.equals("exit")) {
                            System.out.println("关闭连接");
                            mList.remove(socket);
                            in.close();
                            msg = "user:" + socket.getInetAddress()
                                    + "exit total:" + mList.size();
                            socket.close();
                            this.sendmsg();
                            break;
                            //接收客户端发过来的信息msg，然后发送给客户端。
                        } else {
                            msg = socket.getInetAddress() + ":" + msg;
                            this.sendmsg();
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        //循环遍历客户端集合，给每个客户端都发送信息。
        public void sendmsg() {
            System.out.println(msg);
            int num = mList.size();
            for (int index = 0; index < num; index++) {
                Socket mSocket = mList.get(index);
                PrintWriter pout = null;
                try {
                    pout = new PrintWriter(new BufferedWriter(
                            new OutputStreamWriter(mSocket.getOutputStream())), true);
                    pout.println(msg);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
