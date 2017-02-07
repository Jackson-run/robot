package com.wr.net;

import java.net.Socket;

/**
 * Created by wr on 2017/2/7.
 */
public class ConThread implements Runnable {
    String ipstr = "127.0.0.1";
    int port = 5558;
    Socket consocket;
    public ConThread(){
        try
        {
            consocket=new Socket(ipstr,port);
        }
        catch(Exception e)
        {}
    }
    public void run() {
        //socket传出去
        new Thread(new AcceptThread(consocket)).start();
    }
}
