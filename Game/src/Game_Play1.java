
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Game_Play1 extends JFrame implements  ActionListener{
	
	Random r=new Random();
	
	private JPanel panel;
	private JPanel background;
	private JButton btn1,btn2,btn3,btn4;
	private JLabel label[]=new JLabel[5];//2~5
	private JLabel label_change=new JLabel();//1
	private JLabel Score=new JLabel();//점수 
	private JLabel Time=new JLabel();//시간
	private JLabel temp1=new JLabel();
	private JLabel temp2=new JLabel();
	private JLabel cup_image=new JLabel();
	private JLabel cup2_image=new JLabel();
	private JLabel plate_image=new JLabel();
	private JLabel plate2_image=new JLabel();
	private JLabel cup3_image=new JLabel();
	private JLabel plate3_image=new JLabel();
	private ImageIcon cup = new ImageIcon("images/cup.gif");
	private ImageIcon cup_big = new ImageIcon("images/cup_big.gif");	
	private ImageIcon plate = new ImageIcon("images/plate.gif");	
	private ImageIcon plate_big = new ImageIcon("images/plate_big.gif");
	private ImageIcon cup_2 = new ImageIcon("images/cup_2.gif");
	private ImageIcon cup_2_big = new ImageIcon("images/cup_2_big.gif");
	private ImageIcon plate_2 = new ImageIcon("images/plate_2.gif");	
	private ImageIcon plate_2_big = new ImageIcon("images/plate_2_big.gif");
	private ImageIcon cup_3 = new ImageIcon("images/cup_3.gif");
	private ImageIcon cup_3_big = new ImageIcon("images/cup_3_big.gif");
	private ImageIcon plate_3 = new ImageIcon("images/plate_3.gif");	
	private ImageIcon plate_3_big = new ImageIcon("images/plate_3_big.gif");
	private ImageIcon bug = new ImageIcon("images/bug.gif");
	private ImageIcon bug1 = new ImageIcon("images/bug1.gif");
	private ImageIcon left = new ImageIcon("images/left.gif");
	private ImageIcon right = new ImageIcon("images/right.gif");
	private ImageIcon left_change = new ImageIcon("images/left_change.gif");
	private ImageIcon right_change = new ImageIcon("images/right_change.gif");
	private ImageIcon sp = new ImageIcon("images/sp.gif");
	private ImageIcon sp_change = new ImageIcon("images/sp_change.gif");
	private ImageIcon sp1 = new ImageIcon("images/sp1.gif");
	private ImageIcon sp1_change = new ImageIcon("images/sp1_change.gif");
	private ImageIcon click_sp = new ImageIcon("images/click_sp.gif");
	private ImageIcon screen=new ImageIcon("images/screen.gif");
	JScrollPane scrollPane;
	static int cnt=0;
	//static int highcnt=0;
	Timer mTimer=new Timer(1500,(ActionListener) this);//1250->25초
    int mTime=30;
	Music m=new Music();

	//private BufferedWriter bfranname;



	public void actionPerformed(ActionEvent e) {
		 int arcnt[]=new int[5];
		 if(mTimer == e.getSource()){
			mTime--;
			
			if(mTime <= 0)
			{
				try{
		             FileWriter fwcnt=new FileWriter("IOFile/cnt.txt",false);
		             BufferedWriter bfcnt=new BufferedWriter(fwcnt);
		             
		             bfcnt.write(cnt+"");
		             bfcnt.close();
		             
		             FileReader frcnt=new FileReader("IOFile/cnt.txt");
		             BufferedReader brcnt=new BufferedReader(frcnt);
		             
		             brcnt.read();
		             brcnt.close();
		         
		            
		         }catch(Exception n){
		         }
				
								
				mTimer.stop();
				if(cnt>=70) {
					new Ending1();	}			
				else if(cnt>=45&&cnt<70) {
					new Ending2();	}			
				else if(cnt<45) {
					new Ending3();	}
				cnt=0;
				dispose();
				m.StopClips3();

			}
			repaint();
		}
		  
	}
	
	public Game_Play1() {
	
	int x=450,y=-30,heart_x=-90;
	setLayout(new BorderLayout());	
	
	m.OpenClips3();
	
	setLayout(null); // 배치관리자 설정 안함 - 절대 위치 사용
	
	Container c=getContentPane();
	
	for(int i=0;i<3; i++) {
	c.addMouseListener(new MyMouseListener());
	}
   
    
    mTimer.start();
    
	int k=0;
	
	 background = new JPanel() {
        public void paintComponent(Graphics g) {
        g.drawImage(screen.getImage(), 0, 0, null);
        setOpaque(false); //그림을 표시하게 설정,투명하게 조절
        super.paintComponent(g);		
        }
        public void paint(Graphics g) {
        super.paint(g);
		String msg = "time: " + mTime;
		//g.setFont(g.getFont().deriveFont(25.0f));
		Font font=new Font("나눔스퀘어라운드 ExtraBold",Font.BOLD,25);
		//g.setFont(g.getFont().deriveFont(25.0f));
		g.setFont(font);
		g.drawString(msg, 970, 100);
        }     
    };
	background.setLayout(null); 
	
	Score.setText("Score : 0");   
    System.out.println(cnt);
    Score.setSize(300,300);
    Score.setFont(new Font("나눔스퀘어라운드 ExtraBold",Font.BOLD,25));
    //Score.setForeground(Color.DARK_GRAY);
    Score.setLocation(970,-30); 	
    background.add(Score);
    
	cup_image.setIcon(cup_big);
	cup_image.setSize(290, 151);
	cup_image.setLocation(815, 450);
	background.add(cup_image);
	
   
	plate_image.setIcon(plate_big);
	plate_image.setSize(290, 151);
	plate_image.setLocation(110, 450);
	background.add(plate_image);
	
	plate2_image.setIcon(cup_2_big);
	plate2_image.setLocation(110, 400);
	background.add(plate2_image);
	
	cup2_image.setIcon(plate_2_big);
	cup2_image.setLocation(110, 400);
	background.add(cup2_image);
	
	plate3_image.setIcon(cup_3_big);
	plate3_image.setLocation(110, 350);
	background.add(plate3_image);
	
	cup3_image.setIcon(plate_3_big);
	cup3_image.setLocation(815, 350);
	background.add(cup3_image);
	
    for(int i=0;i<label.length;i++) {//4   	 
    	ImageLocation(i, label,0);
    	label[i].setSize(300,300);
    	label[i].setLocation(x,y+=120); 
    	background.add(label[i]);
    	
    }//for

    btn1=new JButton(left);//왼쪽
    btn1.setPressedIcon(left_change);//클릭시 이미지 변환
	btn1.setBounds(260, 665, 230,120);//x y 가로크기 세로크기
	getContentPane().add(btn1);//2
	btn1.setBorderPainted(false);
	btn1.setFocusPainted(false);
	btn1.setContentAreaFilled(false);
	background.add(btn1);//1
	
	
	btn2=new JButton(right);//오른쪽
	btn2.setPressedIcon(right_change);
	btn2.setBounds(700, 665, 230,120);//x y 가로크기 세로크기
	getContentPane().add(btn2);//2
	btn2.setBorderPainted(false);
	btn2.setFocusPainted(false);
	btn2.setContentAreaFilled(false);
	background.add(btn2);//1
	
	btn3=new JButton(sp);//오른쪽
	btn3.setPressedIcon(click_sp);
	btn3.setRolloverIcon(sp_change);//마우스 올리면 바뀜
	btn3.setBounds(670, 100, 230,283);//x y 가로크기 세로크기
	getContentPane().add(btn3);//2
	btn3.setBorderPainted(false);
	btn3.setFocusPainted(false);
	btn3.setContentAreaFilled(false);
	background.add(btn3);//1
	
	btn4=new JButton(sp1);//오른쪽
	//btn4.setPressedIcon(click_sp);
	btn4.setRolloverIcon(sp1_change);//마우스 올리면 바뀜
	btn4.setBounds(50, 665, 230,283);//x y 가로크기 세로크기
	getContentPane().add(btn4);//2
	btn4.setBorderPainted(false);
	btn4.setFocusPainted(false);
	btn4.setContentAreaFilled(false);
	background.add(btn4);//1
	
	btn1.addActionListener(new ActionListener() {//왼쪽
		public void actionPerformed(ActionEvent arg0) {		
			 ImageChange(x,-30,cnt,background);
			 if(temp1.getIcon()==plate||temp1.getIcon()==cup_2||temp1.getIcon()==plate_3){
				count(++cnt,background);
			 }
			 else {
				/* if(heart_cnt>0)
					 remove(heart_image[--heart_cnt]);*/
				 m.openWrong();
				 count(--cnt,background);

			 }
		}
	});
	
	btn2.addActionListener(new ActionListener() {//오른쪽
		public void actionPerformed(ActionEvent arg0) {
			ImageChange(x,-30,cnt,background);
			if(temp1.getIcon()==cup||temp1.getIcon()==plate_2||temp1.getIcon()==cup_3){
				count(++cnt,background);
			 }
			else {
				/*if(heart_cnt>0)
					remove(heart_image[--heart_cnt]);*/
				 m.openWrong();
				 count(--cnt,background);
			 }
		}
	});
	
	btn3.addActionListener(new ActionListener() {//파리채
		public void actionPerformed(ActionEvent arg0) {
			ImageChange(x,-30,cnt,background);
			if(temp1.getIcon()==bug){
				count(++cnt,background);
			 }
			else {
				/* if(heart_cnt>0)
					 remove(heart_image[--heart_cnt]);*/
				 m.openWrong();
				 count(--cnt,background);
			 }
		}
	});
	
	btn4.addActionListener(new ActionListener() {//썪은 파리채
		public void actionPerformed(ActionEvent arg0) {
			ImageChange(x,-30,cnt,background);	
			if(temp1.getIcon()==bug1){
				count(++cnt,background);
			 }
			else { m.openWrong();
		    count(--cnt,background);
			}
		}
	});
	
	scrollPane = new JScrollPane(background);
    setContentPane(scrollPane);
	
    setSize(Main.SCRREN_WIDTN,Main.SCRREN_HEIGHT);//1200 1000
	setLocationRelativeTo(null);//창 가운데  (창 크기 밑)
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x버튼 활성   
	
    setVisible(true);  
  
	}//Game_play
	
	public JLabel ImageLocation(int i, JLabel label[],int c) {//c가 1일때 label[0] 랜덤으로 바꿈
		int rd=(r.nextInt(12))+1;//1~13
		int rd1=(r.nextInt(2));//0~1
		if(rd%2==0) {
    		if(c!=1)label[i]=new JLabel(plate);
    		label_change=new JLabel(plate);   		
    	}
    	else if(rd%2==1&&rd!=5) {
    		if(c!=1)label[i]=new JLabel(cup);
    		label_change=new JLabel(cup);
    	}
    	else if(rd==5){
    		if(rd1==0) {
	    		if(c!=1)label[i]=new JLabel(bug);
	    		label_change=new JLabel(bug);//label[0] 랜덤으로 바꿈
    		}
    		else {
    			if(c!=1)label[i]=new JLabel(bug1);
	    		label_change=new JLabel(bug1);//label[0] 랜덤으로 바꿈
    		}
    	}
    	return label_change;
	}//ImageLocation
	
	public JLabel level2_ImageLocation(int i, JLabel label[],int c) {//c가 1일때 label[0] 랜덤으로 바꿈
		int rd=(r.nextInt(12))+1;//1~13
		int rd1=(r.nextInt(2));//0~1
		System.out.println("level2");
		if(rd%2==0) {
    		if(c!=1)label[i]=new JLabel(plate_2);
    		label_change=new JLabel(plate_2);   		
    	}
    	else if(rd%2==1&&rd!=5) {
    		if(c!=1)label[i]=new JLabel(cup_2);
    		label_change=new JLabel(cup_2);
    	}
    	else if(rd==5){
    		if(rd1==0) {
	    		if(c!=1)label[i]=new JLabel(bug);
	    		label_change=new JLabel(bug);//label[0] 랜덤으로 바꿈
    		}
    		else {
    			if(c!=1)label[i]=new JLabel(bug1);
	    		label_change=new JLabel(bug1);//label[0] 랜덤으로 바꿈
    		}
    	}
    	return label_change;
	}//ImageLocation
	
	public JLabel level3_ImageLocation(int i, JLabel label[],int c) {//c가 1일때 label[0] 랜덤으로 바꿈
		System.out.println("level3");
		int rd=(r.nextInt(12))+1;//1~13
		int rd1=(r.nextInt(2));//0~1
		if(rd%2==0) {
    		if(c!=1)label[i]=new JLabel(plate_3);
    		label_change=new JLabel(plate_3);   		
    	}
    	else if(rd%2==1&&rd!=5) {
    		if(c!=1)label[i]=new JLabel(cup_3);
    		label_change=new JLabel(cup_3);
    	}
    	else if(rd==5){
    		if(rd1==0) {
	    		if(c!=1)label[i]=new JLabel(bug);
	    		label_change=new JLabel(bug);//label[0] 랜덤으로 바꿈
    		}
    		else {
    			if(c!=1)label[i]=new JLabel(bug1);
	    		label_change=new JLabel(bug1);//label[0] 랜덤으로 바꿈
    		}
    	}
    	return label_change;
	}//ImageLocation
	
	public Icon ImageChange(int x,int y,int cnt,JPanel background){
		
    	x=450; y=90;
    	
    	int sp_x[]= {300,50,910,320,900,670};
    	int sp_y[]= {0,665,120,380,665,100};
    	
    	int sp_x1[]= {670,900,320,910,50,200};
    	int sp_y1[]= {100,665,380,120,665,0};
    	int rd1=0;
    	
    	if(temp2.getIcon()==bug||temp2.getIcon()==bug1) {
    	rd1=(r.nextInt(6));//0~6
    	
    	btn3.setLocation(sp_x[rd1],sp_y[rd1]); 
    	background.add(btn3);
    	btn4.setLocation(sp_x1[rd1],sp_y1[rd1] );
		background.add(btn4);
    	} 
    	
		
    	for(int j=1; j<label.length;j++) {//1~4
    		if(j%2==1) {
    			temp2.setIcon(label[j].getIcon());
    			if(j==1) temp1.setIcon(label[j-1].getIcon());
    			label[j].setIcon(temp1.getIcon());	    			
    		}
    		else if(j%2==0) {
    			temp1.setIcon(label[j].getIcon());
    			label[j].setIcon(temp2.getIcon());
    		}
	    				
			label[j].setSize(300,300);
	    	label[j].setLocation(x,y+=120); 		    	
	    	background.add(label[j]);   
		    	
    	}
    	
    	if(cnt>=45) {    		
    		int rd=(r.nextInt(3));//0,1,2
    		System.out.println(rd);
    		if(rd==0) 
    			label[0].setIcon(ImageLocation(0, label,1).getIcon());
    		else if(rd==1) 
    			label[0].setIcon(level2_ImageLocation(0, label,1).getIcon());
    		else if(rd==2) 
    			label[0].setIcon(level3_ImageLocation(0, label,1).getIcon());
    	}
    	
    	else if(cnt>=25) {	//2단계   		
    		int rd=(r.nextInt(2));//0,1   
    		
    		if(rd==0) {
    			label[0].setIcon(ImageLocation(0, label,1).getIcon());
    		}
    		else label[0].setIcon(level2_ImageLocation(0, label,1).getIcon());
    	}
    	
    	
    	else label[0].setIcon(ImageLocation(0, label,1).getIcon());
    	
    	label[0].setSize(300,300);
 		label[0].setLocation(x,90); 
 		background.add(label[0]);
 		return label[4].getIcon();
    }//ImageChange
	
	public void count(int cnt,JPanel background) {		
		Score.setText("Score : "+cnt);
		
		if(cnt==25) {
			cup2_image.setSize(290, 151);
			plate2_image.setSize(290,191);
    		cup2_image.setLocation(800, 290);
    		plate2_image.setLocation(110, 290); 		
    		background.add(plate2_image);
    		background.add(cup2_image);    		
    	}
		if(cnt==45) {
			cup3_image.setSize(290, 151);
			plate3_image.setSize(290,191);
    		cup3_image.setLocation(110, 150);
    		plate3_image.setLocation(800, 135); 		
    		background.add(plate3_image);
    		background.add(cup3_image);    	
		}
		
	}//count
	
	
	private class MyMouseListener implements MouseListener,MouseMotionListener{
		@Override
		public void mousePressed(MouseEvent e) {
			if(e.getX()>550&&e.getX()<640&&e.getY()>680&&e.getY()<760) {	
				if(temp1.getIcon() == bug) {	
					ImageChange(450,-30,cnt, background);
					count(++cnt,background);
					
				}
			}
		}
		
		@Override
		public void mouseDragged(MouseEvent e) {
			
		}
		@Override
		public void mouseClicked(MouseEvent e) {}
		@Override
		public void mouseReleased(MouseEvent e) {}
		@Override
		public void mouseEntered(MouseEvent e) {}
		@Override
		public void mouseExited(MouseEvent e) {}
		
		@Override
		public void mouseMoved(MouseEvent e) {}
	}
	
}

