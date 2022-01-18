
/*import java.applet.Applet;
import java.applet.AudioClip;*/
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonActionListener;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.FlowLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.CardLayout;


public class DrawPage extends JPanel {
	 
	static Category catg;
	static int qIndex = 0;                //문제의 인덱스
	static String[] question;             //문제배열
	static String questionWord;         //문제단어 
	public JTextField drawuser,answeruser1, answeruser2;
	
	private boolean turnCheck=false;
	private boolean startCheck=false;
	public boolean userCheck = false;
	
	 private JLabel sbook;
	 private ImageIcon sketchbook;
	 private JPanel contentPane;
	 public static JPanel gamemainPanel = new JPanel();    //모든 패널이 붇는 패널
     private static JPanel canvasPanel = new JPanel();  //그림 그리는 패널
     private static JPanel optionPanel = new JPanel();  //색상 등의 옵셩이 있는 패널
     public  static JPanel buttonPanel = new JPanel();   //버튼이 있는 패널
     
     //색상 버튼
     private final JButton redB = new JButton("");
     private final JButton orangeB = new JButton("");
     private final JButton yellowB = new JButton("");
     private final JButton greenB = new JButton("");
     private final JButton blueB = new JButton("");
     private final JButton purpleB = new JButton("");
     private final JButton blackB = new JButton("");
   
     
     public Color col=new Color(0,0,0);
     Brush brush;
     int brushHeight = 4;
     int brushWidth = 4;
     int biHeight = 327;
     int biWidth = 506;
     BufferedImage drawBI = new BufferedImage(biWidth, biHeight, BufferedImage.TYPE_INT_ARGB ); //그림 그리는 판
     boolean drawStart = false; 
   
     private final JLabel lblNewLabel = new JLabel("정답");
     private final static JLabel ansL = new JLabel("\uC0C9\uC5F0\uD544");
     private final JPanel panel = new JPanel();
     private final JButton startB = new JButton("시작");
     private final JButton helpB = new JButton("게임방법");
     private final JButton endB = new JButton("종료");
     private final JButton allclearB = new JButton("모두 지우기");
     private final JPanel buttoninPanel = new JPanel();
     private final JButton clearB;
     
     ObjectInputStream reader;	// 수신용 스트림
     ObjectOutputStream writer;	// 송신용 스트림
     Graphics2D grap;
    
	public static void main(String[] args) {
		DrawPage frame = new DrawPage();			
		frame.setVisible(true);

	}


	public DrawPage() {
		setBounds(100, 100, 770, 547);
		gamemainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		gamemainPanel.setLayout(null);
		

		sketchbook = new ImageIcon("/C:/DEV/eclipse-workspace/DrawGame/스케치북2.jpg");
		gamemainPanel.setBackground(Color.WHITE);
		gamemainPanel.setLayout(null);
		canvasPanel.setBackground(Color.WHITE);
		canvasPanel.setBounds(12, 10, 562, 398);
		canvasPanel.setLayout(new CardLayout(0, 0));
		
		
		sbook = new JLabel(sketchbook);
		sbook.setBackground(Color.WHITE);
		canvasPanel.add(sbook, "name_435042085240200");
		optionPanel.setBackground(Color.WHITE);
		optionPanel.setBounds(573, 120, 125, 277);
		
		
		//색연필 그림 넣기
		redB.setIcon(new ImageIcon("//C:/DEV/eclipse-workspace/DrawGame/빨간색.png"));
		orangeB.setIcon(new ImageIcon("//C:/DEV/eclipse-workspace/DrawGame/주황색.png"));
        yellowB.setIcon(new ImageIcon("//C:/DEV/eclipse-workspace/DrawGame/노랑색.png"));
		greenB.setIcon(new ImageIcon("//C:/DEV/eclipse-workspace/DrawGame/초록색png.png"));
		blueB.setIcon(new ImageIcon("//C:/DEV/eclipse-workspace/DrawGame/파랑색.png"));
        purpleB.setIcon(new ImageIcon("//C:/DEV/eclipse-workspace/DrawGame/보라색.png"));
		blackB.setIcon(new ImageIcon("//C:/DEV/eclipse-workspace/DrawGame/검정색.png"));
		optionPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		redB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				brushHeight = 4; brushWidth = 4;
				col = Color.RED;
			}
		});
		orangeB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				brushHeight = 4; brushWidth = 4;
				col = Color.ORANGE;
			}
		});
		yellowB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				brushHeight = 4; brushWidth = 4;
				col = Color.YELLOW;
			}
		});
		greenB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				brushHeight = 4; brushWidth = 4;
				col = Color.GREEN;
			}
		});		
		blueB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				brushHeight = 4; brushWidth = 4;
				col = Color.BLUE;
			}
		});
		purpleB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				brushHeight = 4; brushWidth = 4;
				col = new Color(0x8B00FF);
			}
		});
		blackB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				brushHeight = 4; brushWidth = 4;
				col = Color.BLACK;
			}
		});
		
		
		optionPanel.add(redB);
		optionPanel.add(orangeB);
		optionPanel.add(yellowB);
		optionPanel.add(greenB);		
		optionPanel.add(blueB);
		optionPanel.add(purpleB);
		optionPanel.add(blackB);
		
		buttonPanel.setBounds(0, 420, 760, 70);
		
		
	    JLabel brushLabel = new JLabel(new ImageIcon(drawBI));    //선을 그리는 원
	    brushLabel.setBounds(40,48,506,327);
	    gamemainPanel.add(brushLabel);
	    brush = new Brush();
	    brush.setBounds(40,48,506,327);
	    gamemainPanel.add(brush);
		brushLabel.addMouseMotionListener(new DrawMouseListener());
	    
	    
	    gamemainPanel.add(optionPanel);
	    gamemainPanel.add(buttonPanel);
	    buttonPanel.setLayout(null);
	    buttoninPanel.setBounds(69, 15, 537, 39);
	    buttoninPanel.setLayout(null);
	    startB.setBounds(1, 0, 82, 39);
	    buttoninPanel.add(startB);
	    startB.addActionListener(new StartButtonListener());
	    
	    helpB.setBounds(108, 0, 92, 39);
	    buttoninPanel.add(helpB);

	    clearB = new JButton("지우기");
	    clearB.addActionListener(new clearButtonListener());

	    clearB.setBounds(227, 0, 76, 39);
	    buttoninPanel.add(clearB);
	    endB.setBounds(455, 0, 82, 39);
	    buttoninPanel.add(endB);
	    endB.addActionListener(new EndButtonListener());
	    
	    buttonPanel.add(buttoninPanel);
	
	    allclearB.setBounds(330, 0, 101, 39);
	    allclearB.addActionListener(new clearButtonListener());
	    buttoninPanel.add(allclearB);
	    
	    
	    gamemainPanel.add(canvasPanel);
	    panel.setBackground(SystemColor.inactiveCaption);
	    panel.setBounds(573, 28, 121, 82);
	    
	    gamemainPanel.add(panel);
	    panel.setLayout(null);
	    lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	    lblNewLabel.setBounds(0, 20, 121, 15);
	    panel.add(lblNewLabel);
	    ansL.setHorizontalAlignment(SwingConstants.CENTER);
	    ansL.setFont(new Font("HY엽서M", Font.PLAIN, 16));
	    ansL.setBounds(0, 45, 121, 27);
	    ansL.setVisible(false);
	    panel.add(ansL);
	    
	    
		setLayout(new BorderLayout());
	    add(BorderLayout.CENTER,gamemainPanel);
		setVisible(true);
	}
	
	
	public void setStartCheck(boolean x)
	{
		startCheck = x;
	}
	public void setTurnCheck(boolean x)
	{
		turnCheck = x;
	}
	
	public void gameSet(String du, String au){

		if(this.turnCheck){
			catg = new Category();
		}
		else {
			ansL.setVisible(false);
		}

	}
	
	public static void selectQuestion() {	
		question =catg.getQuestion() ;  //문제 단어배열 가져오기
	
		//문제배열확인
		for(int i=0; i<5; i++)
			System.out.println( i + "=> 1 " + question[i]); 
	   
		questionWord = question[qIndex]; 
		
		ansL.setText(questionWord);
		ansL.setVisible(true);

	    qIndex++;
	}
	
	
	public class StartButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
	
			if(!startCheck){ 
				System.out.println("startbutton");
				try {
					drawStart = true;
					startCheck = true;
					turnCheck = true;
					userCheck = true;
			   		writer.writeObject(new GameMessage(GameMessage.MsgType.GAME_START, userCheck));
			   		writer.flush();
		   					   		 
			   	  } catch(Exception ex) {
			   		  JOptionPane.showMessageDialog(null, "메시지 전송중 문제가 발생하였습니다.");
			      	  ex.printStackTrace();
				}
			}
			else  JOptionPane.showMessageDialog(null, "게임이 진행중입니다.");
		}
	}
	
	
	private class EndButtonListener implements ActionListener 	// 종료 버튼(모든 프레임과 창이  강제로 닫힌다.)
	{                
		public void actionPerformed(ActionEvent event) 
		{
			System.exit(0);	// 프로그램 종료
		}
	}
	  
	
	private class clearButtonListener implements ActionListener {
		  
		public void actionPerformed(ActionEvent e) {
			String string = e.getActionCommand();
			
			if(string.equals("지우기")) {
				brushHeight = 9; brushWidth = 9;
				col = Color.WHITE;
				System.out.println("지우기");
			}
			
			if(string.equals("모두 지우기")) 
				allClear();
 
		}	
	}
	
	//그림 모두 지우는 함수
	public void allClear() {
		drawBI.createGraphics().fillRect(drawBI.getMinX(), drawBI.getMinY(),biWidth,biHeight);
		repaint();
		col = Color.BLACK;
		System.out.println("모두 지우기");		
	}

	
	
	//브러쉬 정보를 가지는 클래스
	class Brush extends JLabel{

		 public int x1, y1;  //지금 위치
		 public int x2, y2;  //이전 위치
		 public int xM;  //x 두 점의 중점      
		 public int yM ;   //y 두 점의 중점
		

		 public void paint(Graphics g) {     
			 grap= (Graphics2D) g; 
			 x2=x1-10;
			 y2=y1-10;

		     xM = (x1+x2)/2;     
			 yM = (y1+y2)/2;
			 if(drawStart) {
				 grap.setColor( col );
				 grap.fillOval( x2, y2, brushHeight, brushWidth);
				 grap.fillOval( x1-10, y1-10, brushHeight, brushWidth);
			 }
		 }  

	}
	
	//그림 그리는 마우스어뎁터
	class DrawMouseListener extends MouseAdapter{
		public void mouseDragged(MouseEvent e) {			
			brush.x1=e.getX();
			brush.y1=e.getY();
			brush.repaint();                            
			brush.printAll( drawBI.createGraphics() ); //브러쉬를 BufferedImage 에 그린다.   

		}

	}
}
