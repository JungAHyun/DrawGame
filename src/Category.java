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
	int count=0;                           //�ߺ�Ȯ�ο� ���
	int indexs[] = {6,6,6,6,6} ;             //question �迭���� ����� �ε��� ����	
	int index;                                //�����ε���
	boolean randomCheck = false;                   // �����ϰ� �迭�Ȱ� Ȯ��                
	static int questionNum = 5;  // �������� 5�� 
	static public String[] question = new String[questionNum];  //�ܾ ����ִ� �迭
	public String[] randomquestion = new String[questionNum];  //�ܾ �����ϰ� ����ִ� �迭
	
   
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
		
		JLabel foodL = new JLabel("����");
		foodL.setFont(new Font("HY����L", Font.PLAIN, 18));
		foodL.setHorizontalAlignment(SwingConstants.CENTER);
		foodP.add(foodL, BorderLayout.SOUTH);
		
		
		
		JButton foodB = new JButton("");
		foodP.add(foodB);
		foodB.setIcon(new ImageIcon("C:/DEV/eclipse-workspace/DrawGame/��.jpg"));
		
		JPanel objectP = new JPanel();
		panel.add(objectP);
		objectP.setLayout(new BorderLayout(5, 5));
		
		JButton objectB = new JButton("");
		objectB.setIcon(new ImageIcon("C:/DEV/eclipse-workspace/DrawGame/���� ���찳.png"));
		objectP.add(objectB, BorderLayout.CENTER);
		
		JLabel objectL = new JLabel("����");
		objectL.setHorizontalAlignment(SwingConstants.CENTER);
		objectL.setFont(new Font("HY����L", Font.PLAIN, 18));
		objectP.add(objectL, BorderLayout.SOUTH);
		
		JPanel jobP = new JPanel();
		panel.add(jobP);
		jobP.setLayout(new BorderLayout(5, 5));
		
		JButton jobB = new JButton("");
		jobB.setIcon(new ImageIcon("C:/DEV/eclipse-workspace/DrawGame/�丮��.png"));
		jobP.add(jobB, BorderLayout.CENTER);
		
		JLabel jobL = new JLabel("����");
		jobL.setHorizontalAlignment(SwingConstants.CENTER);
		jobL.setFont(new Font("HY����L", Font.PLAIN, 18));
		jobP.add(jobL, BorderLayout.SOUTH);
		
		JPanel animalP = new JPanel();
		panel.add(animalP);
		animalP.setLayout(new BorderLayout(5, 5));
		
		JButton animalB = new JButton("");
		animalB.setIcon(new ImageIcon("C:/DEV/eclipse-workspace/DrawGame/������.png"));
		animalP.add(animalB, BorderLayout.CENTER);
		
		JLabel animalL = new JLabel("����");
		animalL.setHorizontalAlignment(SwingConstants.CENTER);
		animalL.setFont(new Font("HY����L", Font.PLAIN, 18));
		animalP.add(animalL, BorderLayout.SOUTH);
		
		JLabel lblNewLabel = new JLabel("ī�װ�");
		lblNewLabel.setFont(new Font("HY����L", Font.BOLD, 19));
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
			if(icon.equals("C:/DEV/eclipse-workspace/DrawGame/��.jpg")) {
				String[] q =  {"����", "�ܹ���","���", "ġŲ", "���"};
				question = q;						    
				DrawPage.selectQuestion();
			}
			else if(icon.equals("C:/DEV/eclipse-workspace/DrawGame/���� ���찳.png")){
				String[] q =  {"����", "���찳","�ڵ���", "����", "���ڷ�����"};
				question = q;				 
				DrawPage.selectQuestion();
		
			}
			else if(icon.equals("C:/DEV/eclipse-workspace/DrawGame/�丮��.png")){
				String[] q =  {"�丮��", "������", "��ȣ��", "�ҹ��", "������"};
				question = q;				 
				DrawPage.selectQuestion();
			}
			else if(icon.equals("C:/DEV/eclipse-workspace/DrawGame/������.png")){
				String[] q =  {"������", "�����", "��", "��", "��"};
				question = q;
				DrawPage.selectQuestion();
			}

			frame.setVisible(false);
			
		}
	}
	
	//�����迭�� �����ϰ� �����ϴ� �Լ�
	public String[] getQuestion() {

	    int num = 0;
        int end=0;
		
        //�ߺ� Ȯ��
		//�������� �ܾ� 5���� ��� ��ġ�Ǹ� while�� ��������
		while(num < questionNum)   
		{		
			
			count = 0;
			index = (int)(Math.random() * 5);    
			System.out.println(index);
			
			//���ڰ� ���� ������ count
			//count�� 4�̸� ���� ���ڰ� ���ٴ� �ǹ� 
			for(int i=0; i<5; i++ ) {
				if(indexs[i] != index) 
				  count++;                
			}
			System.out.println("count = " + count );
			
			//�ߺ�������
			if(count == 5) {                
				indexs[num] = index;     //����� �ε��� ����
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
		
		
		//�����ϰ� ���ĵ� �迭 Ȯ��
		for(int i=0; i<5; i++)
			System.out.println( i + "=>" + randomquestion[i]); 
		
		return randomquestion;

	}
	

}
