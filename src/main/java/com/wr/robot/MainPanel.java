package com.wr.robot;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import java.awt.Font;

import java.awt.Color;
import java.awt.BorderLayout;

import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.text.*;

/**
 * Created by wr on 2017/1/11.
 * 主界面类继承于JPanel
 * 借用原先代码部分布局稍作改动
 */
public class MainPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	public JButton send_btn;
	public static JTextPane pane,text;
	public JScrollPane jsp;
	private JScrollPane scroll;
	private JLabel label,label2;//占位用
	JLabel divLine;
	private JPanel buttompane=new JPanel();
	public static JPanel rightpane=new JPanel();
	//public static JPanel rightpane1=new JPanel();
	private JPanel North=new JPanel();
	private JTextArea area;
	public JSplitPane vertical=new JSplitPane(JSplitPane.VERTICAL_SPLIT,false);//垂直分割条
	private int width,height;
	public MainPanel(int width, int height)
	{
		this.width=width;
		this.height=height;
		/*if (Info.socket==null)
		{
			new LinkServer().start();
		}*/
		BorderLayout bl=new BorderLayout();
		setLayout(bl);
		bl.setHgap(6);
		initA();
		initB();
		initC();

		setSize(width,height);
		setSplitPane();
		setVisible(true);
	}

	public void initA()//设置下面部分
	{
		final ImageIcon icon1=new ImageIcon("../Image/logoCola.JPG");
		final ImageIcon icon2=new ImageIcon("../Image/Cola.JPG");
		//ImageIcon icon3=new ImageIcon("../java/com/wr/RobotClient/image1/expression/Look_1.png");
		text=new JTextPane();
		send_btn=new JButton(icon1);
		send_btn.setFont(new Font("楷体_gb2312",Font.BOLD,15));
		send_btn.setText("发送");
		send_btn.setHorizontalTextPosition(SwingConstants.CENTER);
		send_btn.setContentAreaFilled(false);
		send_btn.setBorder(null);
		send_btn.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				String inputStr = text.getText();
				SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				insertDocument("我  :"+sf.format(new Date())+"\n",Color.GREEN);
				insertDocument(inputStr,Color.black);
				text.setText("");
			}

			public void mousePressed(MouseEvent e) {
			}

			public void mouseReleased(MouseEvent e) {
			}

			public void mouseEntered(MouseEvent e) {
			}

			public void mouseExited(MouseEvent e) {
			}
		});
		text.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
				if(e.getKeyChar()==KeyEvent.VK_ENTER) {
					String inputStr = text.getText().trim();
					SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					insertDocument("我  :" + sf.format(new Date()) + "\n", Color.GREEN);
					insertDocument(inputStr, Color.black);
					text.setText("");
				}
			}

			public void keyPressed(KeyEvent e) {
			}

			public void keyReleased(KeyEvent e) {
			}
		});

	}
	public void initB()//设置右边部分
	{
		area=new JTextArea(5,10);
		area.append("\n姓名：球球\n\n" +
				"专业：计算机\n\n爱好：帮你解答疑难\n\n特点：知识就是力量的来源\n");
		area.setFont(new Font("宋体",Font.PLAIN,18));
		area.setEditable(false);
		area.setLineWrap(true);
		label=new JLabel("                 ");
		label2=new JLabel("                ");
		rightpane.setLayout(new BorderLayout());
		rightpane.add(label,BorderLayout.NORTH);
		rightpane.add(area,BorderLayout.CENTER);
		rightpane.add(label2,BorderLayout.SOUTH);
		rightpane.setVisible(true);
	}
	public void initC()//设置文本框部分
	{
		pane=new JTextPane();

		pane.setFont(new Font("宋体",Font.PLAIN,15));
		scroll=new JScrollPane(text,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jsp=new JScrollPane(pane);
	/*	text.addCaretListener(new MyActionListener(this));
		text.addKeyListener(new MyActionListener(this));*/
		pane.setEditable(false);

		SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		insertDocument("球球:"+sf.format(new Date())+"\n",Color.BLUE);
		insertDocument("  hi,我是机器人球球,很高兴认识你\n",Color.black);
		//insertDocument("test",Color.BLUE);
	}
	public void setSplitPane()
	{
		North.setLayout(new BorderLayout());
		divLine = new JLabel("======================================================================================");
		North.add(divLine,"West");
		buttompane.setLayout(new BorderLayout());
		buttompane.add(North,"North");
		buttompane.add(scroll,"Center");
		buttompane.add(send_btn,"East");

		vertical.setTopComponent(jsp);
		vertical.setBottomComponent(buttompane);
		vertical.setDividerLocation((int)(this.getHeight()*0.7));
		vertical.setDividerSize(1);
		add(vertical,"Center");
		add(rightpane,"East");
		//	add(rightpane1,"East");
	}
	//文本框加监控
	public static void insertDocument(String text,Color textColor)
	{
		SimpleAttributeSet set = new SimpleAttributeSet();
		StyleConstants.setForeground(set, textColor);//设置文字颜色
		StyleConstants.setFontSize(set, 15);//设置字体大小
		Document doc = pane.getStyledDocument();//获取Document
		//pane.setCaretPosition(doc.getLength());//设置插入符位置
		try
		{
			doc.insertString(doc.getLength(), text, set);//插入文字
		}
		catch (BadLocationException e)
		{}
	}


}
