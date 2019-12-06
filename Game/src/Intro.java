import javax.swing.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.awt.*;

public class Intro extends JFrame{

	//private JPanel panel=new JPanel();
	private JLabel label1=new JLabel();;//화면에 나타나는 글씨
	private JButton btn4;//버튼
	private ImageIcon skip = new ImageIcon("images/skip.gif"); //배경이미지
	private ImageIcon intro = new ImageIcon("images/intro.gif"); //배경이미지
	//private JLabel imageLabel=new JLabel(intro); 
	JScrollPane scrollPane;


	JPanel background = new JPanel() {
        public void paintComponent(Graphics g) {
	        g.drawImage(intro.getImage(), 0, 0, null);
	        setOpaque(false); //그림을 표시하게 설정,투명하게 조절
	        super.paintComponent(g);		
        }
	};
	
	public void actionPerformed(ActionEvent e) {
		// int arcnt[]=new int[5];
		 
				try{
		            
		            
		     		
		            
		         }catch(Exception n){
		  }
	}
				
	public Intro(String name, Music m) {
		//setLayout(new BorderLayout());	
		
		
		JPanel background = new JPanel() {
	        public void paintComponent(Graphics g) {
		        g.drawImage(intro.getImage(), 0, 0, null);
		        setOpaque(false); //그림을 표시하게 설정,투명하게 조절
		        super.paintComponent(g);		
	        }
		};
	 	background.setLayout(null); // 배치관리자 설정 안함 - 절대 위치 사용
		
        JLabel label1 = new JLabel("<html>"+name+
        		",<br>네가<font color=red size=23>설거지의 고수</font>"
        		+ "라는 것을<br>증명해라!</html>");
        //JLabel label1=new JLabel(name);
		label1.setFont(new Font("맑은고딕", Font.BOLD, 30)); 
		label1.setBounds(600,300,800,300);
		background.add(label1);
		
    	
    	btn4=new JButton(skip);
    	//btn4.setRolloverIcon(change_play_img);//마우스 올리면 바뀜
    	btn4.setBounds(920, 870, 230, 70); 
    	getContentPane().add(btn4);
    	btn4.setBorderPainted(false);
    	btn4.setFocusPainted(false);
    	btn4.setContentAreaFilled(false);
    	background.add(btn4);
    	
    	btn4.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent arg0) {		
    			new Game_Play1();
    			m.StopClips1();
    			dispose();
    			}
    	});
		//add(panel);
    	scrollPane = new JScrollPane(background);
        setContentPane(scrollPane);
        
		setSize(Main.SCRREN_WIDTN, Main.SCRREN_HEIGHT); //창 크기
        setLocationRelativeTo(null);//창 가운데  (창 크기 밑)
        setVisible(true); //보여줌    
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x버튼 활성   
	}
	
}