///import javax.swing.JButton; 
//import javax.swing.JFrame; 
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
//import java.awt.BorderLayout;
//import java.awt.Font;
import java.awt.event.*;
import java.io.File;
import java.awt.*;

public class Title extends JFrame{
	
    private JButton btn1,btn2,btn3;//게임시작, 게임방법,랭킹
    private JPanel gamepanel;
    
    public Title()
    {
    	Music m=new Music();
    	m.OpenClips1();
    	setLayout(new BorderLayout());
    	JPanel gamepanel = new JPanel();
    	ImageIcon first = new ImageIcon("images/title.jpg"); //배경이미지
    	ImageIcon rule_img=new ImageIcon("images/rule_img.gif");//게임 방법 버튼 이미지 - 300
    	ImageIcon change_rule_img=new ImageIcon("images/rule_img_change.gif");//게임 방법 버튼 이미지 체인지
    	ImageIcon play_img=new ImageIcon("images/play_img.gif");//게임 방법 버튼 이미지 - 300
    	ImageIcon change_play_img=new ImageIcon("images/play_img_change.gif");//게임 방법 버튼 이미지 체인지
		JLabel imageLabel = new JLabel(first);
    	gamepanel.setLayout(null); // 배치관리자 설정 안함 - 절대 위치 사용
    	setTitle("설거지의 고수");
    	
    	btn1=new JButton(rule_img);
    	btn1.setRolloverIcon(change_rule_img);//마우스 올리면 바뀜
    	//btn1.setFont(new Font("맑은고딕", Font.BOLD, 27)); 
    	btn1.setBounds(930, 690, 230,120);//x y 가로크기 세로크기
    	gamepanel.add(btn1);//1
    	getContentPane().add(btn1);//2
    	btn1.setBorderPainted(false);
    	btn1.setFocusPainted(false);
    	btn1.setContentAreaFilled(false);
    
    	btn2=new JButton(play_img);
    	btn2.setRolloverIcon(change_play_img);//마우스 올리면 바뀜
    	//btn2.setFont(new Font("맑은고딕", Font.BOLD, 27)); 
    	btn2.setBounds(930, 800, 230, 120); 
    	gamepanel.add(btn2);
    	getContentPane().add(btn2);
    	btn2.setBorderPainted(false);
    	btn2.setFocusPainted(false);
    	btn2.setContentAreaFilled(false);
    	
    	
    	btn1.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent arg0) {
    			new Game_Rules(m);
    			m.StopClips1();
    			m.OpenClips2();
    			dispose();
    		}
    	});
    	
    	btn2.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent arg0) {
    			new Info_Input(m);
    			dispose();
    		}
    	});
    	
    	
    	
    	
		add(gamepanel);
        add(imageLabel);
        
        //setExtendedState(JFrame.MAXIMIZED_BOTH);//전체화면
		//setUndecorated(true);
        setSize(Main.SCRREN_WIDTN, Main.SCRREN_HEIGHT); //창 크기
        setLocationRelativeTo(null);//창 가운데  (창 크기 밑)
        setVisible(true); //보여줌    
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x버튼 활성   
    }

}
