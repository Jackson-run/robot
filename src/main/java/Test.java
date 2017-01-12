/**
 * Created by wr on 2017/1/3.
 */
import com.wr.MainPanel;

import javax.swing.*;

public class Test {
    public  static void main(String args[]){
        JFrame frame = new JFrame();
        frame.setSize(750,600);
    MainPanel lb = new MainPanel(500,600);
    frame.add(lb);
    frame.setVisible(true);
    }
}
