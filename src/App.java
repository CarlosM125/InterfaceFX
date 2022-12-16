
import java.awt.*;
import javax.swing.*;
public class App {
    public static void main(String[] args) throws Exception {
       JFrame chat = new JFrame("chat");
       chat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       chat.setSize(400,500);
       chat.setLayout(new BorderLayout());

       //menubar
       JMenuBar menuBar = new JMenuBar();
       JMenu file = new JMenu("archivos");
       JMenu help = new JMenu("help");
       menuBar.add(file);
       menuBar.add(help);
       
       //Create panel
       JPanel panel = new JPanel();
       JLabel messageLa = new JLabel();
       JTextField chatField = new JTextField(10);
       JButton send = new JButton("enviar");
       JButton reset = new JButton("borrar todo");
       panel.setLayout(new FlowLayout());
       panel.add(messageLa);
       panel.add(chatField);
       panel.add(send);
       panel.add(reset);

       //dasd
       JTextArea chatHistory = new JTextArea();
       chatHistory.setEditable(false);

       //configurar chat 
       chat.getContentPane().add(BorderLayout.SOUTH, panel);
       chat.getContentPane().add(BorderLayout.NORTH, menuBar);
       chat.getContentPane().add(BorderLayout.CENTER, chatHistory);

        send.addActionListener(e->addMessage(chatField.getText(), chatHistory, chatField));
        reset.addActionListener(e-> resetText(chatField));

       chat.setVisible(true);

    }
    public static void resetText(JTextField target){
        target.setText("");
    }
    public static void addMessage(String message, JTextArea targetTextArea, JTextField targetTextField){
        if(message.equalsIgnoreCase("")){
            resetText(targetTextField);
        }else{
            targetTextArea.append("Carlos dice:"+message+"\n");
        }
        
    }
}
