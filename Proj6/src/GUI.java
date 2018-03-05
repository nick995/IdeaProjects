import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class GUI extends JPanel {
    private JButton jButton1;
    private JScrollPane jScrollPane1;
    private JTextArea jTextArea;
    private JPanelTest win;

    public GUI(JPanelTest win) {
        this.win = win;
        setLayout(null);






        jButton1 = new JButton("next step");
        jButton1.setSize(70, 20);
        jButton1.setLocation(10, 10);
        add(jButton1);


        jButton1.addActionListener(new MyActionListener());
    }

    class MyActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            win.change("panel02");
        }
    }
}

class GUI2 extends JPanel {
    private JTextField textField;
    private JPanelTest win;

    public GUI2(JPanelTest win) {
        setLayout(null);
        this.win = win;
        JLabel label = new JLabel("아이디");
        label.setBounds(31, 40, 67, 15);
        add(label);

        textField = new JTextField();
        textField.setBounds(31, 40, 67, 15);
        add(textField);
        textField.setColumns(10);

        JButton btn = new JButton("next step");
        btn.setSize(70, 20);
        btn.setLocation(10, 10);
        add(btn);
        btn.addActionListener(new MyActionListener());
    }
    class MyActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            win.change("panel03");
        }
    }
}

class GUI3 extends JPanel {
    private JPanelTest win;

    public GUI3(JPanelTest win){
        this.win = win;
        JButton btn = new JButton("creating");
        btn.setSize(70, 20);
        btn.setLocation(10, 10);
        add(btn);
        btn.addActionListener(new MyActionListener());

    }
    class MyActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            win.change("panel01");
        }
    }
}


class JPanelTest extends JFrame {
    public GUI gui = null;
    public GUI2 gui2 = null;
    public GUI3 gui3 = null;

    public void change(String panelName) {

        if (panelName.equals("panel01")) {

            getContentPane().removeAll();
            getContentPane().add(gui);
            revalidate();
            repaint();
        } else if(panelName.equals("panel02")) {
            getContentPane().removeAll();
            getContentPane().add(gui2);
            revalidate();
            repaint();


        }else{
            getContentPane().removeAll();
            getContentPane().add(gui3);
            revalidate();
            repaint();
        }
    }
    public static void main(String[] args) {

        JPanelTest win  = new JPanelTest();



        win.setTitle("setting");
        win.gui = new GUI(win);
        win.gui2 = new GUI2(win);
        win.gui3 = new GUI3(win);


        JTabbedPane jtab = new JTabbedPane();

        jtab.addTab("Depth", win.gui);
        jtab.addTab("Ratio", win.gui2);
        jtab.addTab("Color", win.gui3);

        win.add(jtab);


        win.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        win.setSize(300, 350);
        win.setVisible(true);

    }
}