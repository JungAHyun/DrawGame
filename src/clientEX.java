

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.io.File;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class clientEX extends JFrame {

	private JPanel contentPane;
	JFrame frame;
	String frameTitle = "ä�� Ŭ���̾�Ʈ";
	JTextArea incoming;			// ���ŵ� �޽����� ����ϴ� ��
    JTextArea outgoing;			// �۽��� �޽����� �ۼ��ϴ� ��
    JList counterParts;			// ���� �α����� ä�� ������� ��Ÿ���� ����Ʈ.
    ObjectInputStream reader;	// ���ſ� ��Ʈ��
    ObjectOutputStream writer;	// �۽ſ� ��Ʈ��
    Socket sock;				// ���� ����� ����
    String user;				// �� Ŭ���̾�Ʈ�� �α��� �� ������ �̸�
    JButton logButton;			// ����� �Ǵ� �α���/�α׾ƿ� ��ư
    JScrollPane qScroller;
    
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new clientEX();
	}

	/**
	 * Create the frame.
	 */
	public clientEX() {

		frame = new JFrame(frameTitle + " : �α����ϼ���");
	
	   	// �޽��� ���÷��� â
	   	incoming = new JTextArea(15,20);
        incoming.setLineWrap(true);
        incoming.setWrapStyleWord(true);
        incoming.setEditable(false);
        qScroller = new JScrollPane(incoming);
        qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        // ��ȭ ��� ���. �ʱ⿡�� "��ü" - ChatMessage.ALL �� ����
        String[] list = {GameMessage.ALL};
        counterParts = new JList(list);
        JScrollPane cScroller = new JScrollPane(counterParts);
        cScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        cScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        
     
        counterParts.setVisibleRowCount(5);
        counterParts.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        counterParts.setFixedCellWidth(100);
        
        // �޽��� ������ ���� ��ư
        JButton sendButton = new JButton("Send");
        
        
        // �޽��� ���÷��� â  
	   	outgoing = new JTextArea(5,20);
	   //outgoing.addKeyListener(new EnterKeyListener());
	   	outgoing.setLineWrap(true);
	   	outgoing.setWrapStyleWord(true);
	   	outgoing.setEditable(true);
	   	
        JScrollPane oScroller = new JScrollPane(outgoing);
        oScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        oScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        // �α��ΰ� �ƿ��� ����ϴ� ��ư. ó������ Login �̾��ٰ� �ϴ� �α��� �ǰ��� Logout���� �ٲ�
        logButton = new JButton("Login");
        logButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		System.out.println("login");
        	}
        });
       // logButton.addActionListener(new LogButtonListener());

	   	// GUI ��ġ
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JPanel upperPanel = new JPanel();
        upperPanel.setLayout(new BoxLayout(upperPanel, BoxLayout.X_AXIS));
        upperPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
 
        JPanel lowerPanel = new JPanel();
        lowerPanel.setLayout(new BoxLayout(lowerPanel, BoxLayout.X_AXIS));
        lowerPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1,2));
        
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        
        JPanel sendPanel = new JPanel();
        sendPanel.setLayout(new BorderLayout());
        

        inputPanel.add(new JLabel("�����Է�"));
        inputPanel.add(Box.createRigidArea(new Dimension(0,5)));
        inputPanel.add(oScroller);
        
        buttonPanel.add(sendButton);
        buttonPanel.add(logButton);
        
        sendPanel.add(BorderLayout.CENTER, inputPanel);
        sendPanel.add(BorderLayout.SOUTH, buttonPanel);

        lowerPanel.add(Box.createRigidArea(new Dimension(5,0)));
        lowerPanel.add(sendPanel);
        lowerPanel.add(Box.createRigidArea(new Dimension(5,0)));
        

        upperPanel.add(qScroller);
        
        mainPanel.add(upperPanel);
        mainPanel.add(lowerPanel);

        
        
        // ��Ʈ��ŷ�� �õ��ϰ�, �������� �޽����� ���� ������ ����
       // setUpNetworking();
       // Thread readerThread = new Thread(new IncomingReader());
       // readerThread.start();
          
        // Ŭ���̾�� ������ â ����
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(BorderLayout.EAST, mainPanel);
        frame.getContentPane().add(BorderLayout.CENTER, DrawPage.gamemainPanel);
        frame.setSize(1017,528);
        frame.setVisible(true);
	}
	public void playSound() {
		
        File file = new File("C://DEV//eclipse-workspace//DrawGame//nope(����Ҹ�).wav");
        System.out.println(file.exists()); //true
        
        try {
            
            AudioInputStream stream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(stream);
            clip.start();
            
        } catch(Exception e) {
            
            e.printStackTrace();
        }

	}
	
	public class SendButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String string = e.getActionCommand();
			if(string.equals("Send")) {
				System.out.println("send");
				playSound();
				
			}
			}
		}
}
