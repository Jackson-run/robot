package com.wr.net;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by wr on 2017/2/7.
 */
public class SendThread{
    DataOutputStream out;
    public SendThread(Socket socket){
        try {
            out = new DataOutputStream(
                    new BufferedOutputStream(socket.getOutputStream()));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void SendMessage(String sendstr){
        try {
            out.writeUTF(sendstr);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
            /*System.out.println("发送消息为" + sendStr);
            if (!sendStr.startsWith("0")) {
                lb_rebots.insertDocument("\n蓝宝:" + sdf.format(new Date()) + "\n  ", Color.BLUE);
                lb_rebots.insertDocument("服务器正在更新，请稍后在使用......", Color.BLACK);
            }*/
        } catch (Exception e) {
            e.printStackTrace();
            /*System.out.println("str0" + str0);
            if (!str0.startsWith("0")) {
                lb_rebots.insertDocument("\n蓝宝:" + sdf.format(new Date()) + "\n  ", Color.BLUE);
                lb_rebots.insertDocument("服务器正在更新，请稍后......", Color.BLACK);
            }*/
        }
    }

}
