import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MainFrame extends JFrame {
    JTextArea taMessages;
    JScrollPane spScroll;
    JLabel lblComment;
    JTextField tfUserMessage;
    JButton btnSend;
    public MainFrame(){
        setSize(600, 450);
        setMinimumSize(new Dimension(400, 300));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        taMessages = new JTextArea();
        taMessages.setEditable(false);
        spScroll = new JScrollPane(taMessages);
        lblComment = new JLabel("Введите текст:");
        tfUserMessage = new JTextField();
        tfUserMessage.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == '\n')
                    btnSend.doClick();
            }
        });
        btnSend = new JButton("Отправить");
        btnSend.addActionListener((e)->{
            taMessages.setText(taMessages.getText()+tfUserMessage.getText()+"\n");
            tfUserMessage.setText("");
        });

        var gl = new GroupLayout(getContentPane());
        setLayout(gl);
        gl.setVerticalGroup(
                gl.createSequentialGroup()
                        .addGap(8)
                        .addComponent(spScroll, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE)
                        .addGap(8)
                        .addComponent(lblComment, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(8)
                        .addGroup(
                                gl.createParallelGroup(GroupLayout.Alignment.CENTER)
                                        .addComponent(tfUserMessage, 27, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnSend, 27, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        )
                        .addGap(8)
        );
        gl.setHorizontalGroup(
                gl.createSequentialGroup()
                        .addGap(8)
                        .addGroup(
                                gl.createParallelGroup()
                                        .addComponent(spScroll, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE)
                                        .addComponent(lblComment, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE)
                                        .addGroup(
                                                gl.createSequentialGroup()
                                                        .addComponent(tfUserMessage, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE)
                                                        .addGap(8)
                                                        .addComponent(btnSend, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                        )
                        )
                        .addGap(8)
        );
    }
}
