import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Ending2 extends JFrame{

    private JPanel panel=new JPanel(); 
    private ImageIcon ending2 = new ImageIcon("images/ending2.gif");
    private ImageIcon exit=new ImageIcon("images/exit.gif");//게임 방법 버튼 이미지 체인지
    private JButton en;
    private JLabel label=new JLabel(ending2);
	//1180px
	
	 public Ending2()
	    {
		 
	    setLayout(new BorderLayout());
    	panel.setLayout(null); // 배치관리자 설정 안함 - 절대 위치 사용   
    	
    	en=new JButton(exit);
    	//re.setRolloverIcon(change_play_img);//마우스 올리면 바뀜
    	en.setBounds(940, 840, 230, 70); 
    	panel.add(en);
    	getContentPane().add(en);
    	en.setBorderPainted(false);
    	en.setFocusPainted(false);
    	en.setContentAreaFilled(false);	    
    	
    	en.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent arg0) {
    			new Title();
    			dispose();
    		}
    	});
    	
    	add(panel);
        add(label);
    	 setSize(Main.SCRREN_WIDTN, Main.SCRREN_HEIGHT); //창 크기
         setLocationRelativeTo(null);//창 가운데  (창 크기 밑)
         setVisible(true); //보여줌    
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x버튼 활성   
    			
    }

}