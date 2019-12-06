import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.awt.*;

public class Game_Rules extends JFrame{

	private JButton btn1,btn2;//전, 게임시작
	private JPanel panel = new JPanel();
	private ImageIcon first = new ImageIcon("images/game_rules.gif");
	private ImageIcon play_img=new ImageIcon("images/play_img.gif");//게임 방법 버튼 이미지 - 300
	private ImageIcon change_play_img=new ImageIcon("images/play_img_change.gif");//게임 방법 버튼 이미지 체인지
	//1180px
	private JLabel imageLabel = new JLabel(first);
	
	 public Game_Rules(Music m)  {	    	
		    setLayout(new BorderLayout());	    
	    	panel.setLayout(null); // 배치관리자 설정 안함 - 절대 위치 사용					
	    	
	    	btn2=new JButton(play_img);
	    	btn2.setRolloverIcon(change_play_img);//마우스 올리면 바뀜
	    	btn2.setBounds(920, 840, 230, 70); 
	    	panel.add(btn2);
	    	getContentPane().add(btn2);
	    	btn2.setBorderPainted(false);
	    	btn2.setFocusPainted(false);
	    	btn2.setContentAreaFilled(false);
	    	
	    	
	    	btn2.addActionListener(new ActionListener() {
	    		public void actionPerformed(ActionEvent arg0) {
	    			new Info_Input(m);
	    			m.StopClips2();
	    			m.OpenClips1();
	    			dispose();
	    		}
	    	});
	    	add(panel);
	        add(imageLabel);
	    	 setSize(Main.SCRREN_WIDTN, Main.SCRREN_HEIGHT); //창 크기
	         setLocationRelativeTo(null);//창 가운데  (창 크기 밑)
	         setVisible(true); //보여줌    
	         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x버튼 활성   
	    			
	    }
}