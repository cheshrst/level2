package lesson4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Chat {
    private final JFrame mainFrame;
    public Chat(){
        mainFrame = new JFrame();

        mainFrame.setTitle("Chat");
        mainFrame.setBounds(new Rectangle(300,500));
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        JTextField textField = new JTextField();
        textField.setBounds(10,10,270,380);
        textField.setEditable(false);
        mainFrame.add(textField);
        mainFrame.setLayout(null);
        JTextField field = new JTextField();
        field.setBounds(10, 400, 200, 50);
        mainFrame.add(field);
        JButton button = new JButton("Send");
        button.setBounds(210, 400, 70, 50);
        mainFrame.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                textField.setText(field.getText());
            }
        });


        mainFrame.setVisible(true);
    }
}