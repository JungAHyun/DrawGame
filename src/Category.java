import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Category extends JFrame {

	private JPanel contentPane;
	int count=0;                           //중복확인에 사용
	int indexs[] = {6,6,6,6,6} ;             //question 배열에서 사용할 인덱스 저장	
	int index;                                //랜덤인덱스
	boolean randomCheck = false;                   // 랜덤하게 배열된것 확인                
	static int questionNum = 5;  // 문제개수 5개 
	static public String[] question = new String[questionNum];  //단어가 들어있는 배열
	public String[] randomquestion = new String[questionNum];  //단어가 랜덤하게 들어있는 배열
	
   
	private JFrame frame;
	
	public static void main(String[] args) {
     new Category();
	}


	public Category() {
		
		frame = new JFrame();
		frame .setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame .setBounds(400, 200, 332, 435);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(15, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 10));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(2, 0, 10, 10));
		
		JPanel foodP = new JPanel();
		panel.add(foodP);
		foodP.setLayout(new BorderLayout(5, 5));
		
		JLabel foodL = new JLabel("음식");
		foodL.setFont(new Font("HY엽서L", Font.PLAIN, 18));
		foodL.setHorizontalAlignment(SwingConstants.CENTER);
		foodP.add(foodL, BorderLayout.SOUTH);
		
		
		
		JButton foodB = new JButton("");
		foodP.add(foodB);
		foodB.setIcon(new ImageIcon("C:/DEV/eclipse-workspace/DrawGame/밥.jpg"));
		
		JPanel objectP = new JPanel();
		panel.add(objectP);
		objectP.setLayout(new BorderLayout(5, 5));
		
		JButton objectB = new JButton("");
		objectB.setIcon(new ImageIcon("C:/DEV/eclipse-workspace/DrawGame/연필 지우개.png"));
		objectP.add(objectB, BorderLayout.CENTER);
		
		JLabel objectL = new JLabel("물건");
		objectL.setHorizontalAlignment(SwingConstants.CENTER);
		objectL.setFont(new Font("HY엽서L", Font.PLAIN, 18));
		objectP.add(objectL, BorderLayout.SOUTH);
		
		JPanel jobP = new JPanel();
		panel.add(jobP);
		jobP.setLayout(new BorderLayout(5, 5));
		
		JButton jobB = new JButton("");
		jobB.setIcon(new ImageIcon("C:/DEV/eclipse-workspace/DrawGame/요리사.png"));
		jobP.add(jobB, BorderLayout.CENTER);
		
		JLabel jobL = new JLabel("직업");
		jobL.setHorizontalAlignment(SwingConstants.CENTER);
		jobL.setFont(new Font("HY엽서L", Font.PLAIN, 18));
		jobP.add(jobL, BorderLayout.SOUTH);
		
		JPanel animalP = new JPanel();
		panel.add(animalP);
		animalP.setLayout(new BorderLayout(5, 5));
		
		JButton animalB = new JButton("");
		animalB.setIcon(new ImageIcon("C:/DEV/eclipse-workspace/DrawGame/강아지.png"));
		animalP.add(animalB, BorderLayout.CENTER);
		
		JLabel animalL = new JLabel("동물");
		animalL.setHorizontalAlignment(SwingConstants.CENTER);
		animalL.setFont(new Font("HY엽서L", Font.PLAIN, 18));
		animalP.add(animalL, BorderLayout.SOUTH);
		
		JLabel lblNewLabel = new JLabel("카테고리");
		lblNewLabel.setFont(new Font("HY엽서L", Font.BOLD, 19));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
		foodB.addActionListener(new ButtonListener());
		animalB.addActionListener(new ButtonListener());
		jobB.addActionListener(new ButtonListener());
		objectB.addActionListener(new ButtonListener());
		
		frame.add(contentPane);
		frame.setVisible(true);
		
		
	}
	
	private class ButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton) e.getSource();
			String icon = b.getIcon().toString();
			if(icon.equals("C:/DEV/eclipse-workspace/DrawGame/밥.jpg")) {
				String[] q =  {"피자", "햄버거","김밥", "치킨", "라면"};
				question = q;						    
				DrawPage.selectQuestion();
			}
			else if(icon.equals("C:/DEV/eclipse-workspace/DrawGame/연필 지우개.png")){
				String[] q =  {"연필", "지우개","핸드폰", "휴지", "전자레인지"};
				question = q;				 
				DrawPage.selectQuestion();
		
			}
			else if(icon.equals("C:/DEV/eclipse-workspace/DrawGame/요리사.png")){
				String[] q =  {"요리사", "경찰관", "간호사", "소방관", "선생님"};
				question = q;				 
				DrawPage.selectQuestion();
			}
			else if(icon.equals("C:/DEV/eclipse-workspace/DrawGame/강아지.png")){
				String[] q =  {"강아지", "고양이", "곰", "닭", "고래"};
				question = q;
				DrawPage.selectQuestion();
			}

			frame.setVisible(false);
			
		}
	}
	
	//문제배열을 랜던하게 정렬하는 함수
	public String[] getQuestion() {

	    int num = 0;
        int end=0;
		
        //중복 확인
		//랜덤으로 단어 5개가 모두 배치되면 while문 빠져나옴
		while(num < questionNum)   
		{		
			
			count = 0;
			index = (int)(Math.random() * 5);    
			System.out.println(index);
			
			//숫자가 같지 않으면 count
			//count가 4이면 같은 숫자가 없다는 의미 
			for(int i=0; i<5; i++ ) {
				if(indexs[i] != index) 
				  count++;                
			}
			System.out.println("count = " + count );
			
			//중복없을때
			if(count == 5) {                
				indexs[num] = index;     //사용한 인덱스 저장
				randomquestion[num] = question[index];
				num++;
			}
			else if(count==0)
				break;
			
			end++;
			if(end == 20) {
				randomCheck = false;
				break;
				
			}
			
		}
		
		
		//랜덤하게 정렬된 배열 확인
		for(int i=0; i<5; i++)
			System.out.println( i + "=>" + randomquestion[i]); 
		
		return randomquestion;

	}
	

}
