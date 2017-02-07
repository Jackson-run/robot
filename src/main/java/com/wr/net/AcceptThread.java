package com.wr.net;
import java.io.DataInputStream;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.Socket;
/**
 * Created by wr on 2017/2/7.
 */
public class AcceptThread implements Runnable
{
	private Socket socket=null;
	private DataInputStream in=null;
	private String str=null;
	public AcceptThread(Socket socket)
	{
		this.socket=socket;
		try
		{
			in=new DataInputStream(new BufferedInputStream(socket.getInputStream()));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public void run()
	{
		try
		{
			while (true)
			{
				str=in.readUTF();
				System.out.println("接受的信息="+str);
				//new Thread(new ClientServer(str)).start();
			}

		}

		catch(Exception e)
		{
			System.out.println("未连接上服务器");
		}
	}
}
