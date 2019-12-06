import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Info_Input extends JFrame implements ActionListener{
	
	private JPanel namepanel;
	private JLabel label;
	private JButton btn3;
	private JTextField field;
	private ImageIcon info=new ImageIcon("images/info.gif");
	private JLabel info_image=new JLabel(info);
	JScrollPane scrollPane;

	//입력

	
	public Info_Input(Music m) {
		
		setLayout(new BorderLayout());	
		
		 JPanel background = new JPanel() {
		        public void paintComponent(Graphics g) {
		        g.drawImage(info.getImage(), 0, 0, null);
		        setOpaque(false); //그림을 표시하게 설정,투명하게 조절
		        super.paintComponent(g);		
		        }
		 };
		 background.setLayout(null); // 배치관리자 설정 안함 - 절대 위치 사용
		 
		field=new JTextField("이름을 입력하세요");		
		field.selectAll();//드래그(?)
		field.setFont(new Font("맑은고딕", Font.BOLD, 17)); 
		field.setBounds(680,430,150,40);
		background.add(field);
		
		btn3=new JButton("확인");
		btn3.setFont(new Font("맑은고딕", Font.BOLD, 15)); 
    	btn3.setBounds(850, 430, 70, 40);
    	background.add(btn3);
    	btn3.addActionListener(this);
    	btn3.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent arg0) {
    			//String name=field.getText();
    			
    			new Intro(field.getText(), m);	
    			dispose();
    		}
    	});
    	
    	scrollPane = new JScrollPane(background);
        setContentPane(scrollPane);
        setVisible(true);
		setSize(Main.SCRREN_WIDTN, Main.SCRREN_HEIGHT); //창 크기
        setLocationRelativeTo(null);//창 가운데  (창 크기 밑)
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x버튼 활성       
        
	}
	
	
	 public void actionPerformed(ActionEvent ae){
		  
         try{
             FileWriter fw=new FileWriter("IOFile/name.txt",false);    //파일명과 같은 파일명이 존재할시 덧붙여쓸여부판단
             BufferedWriter bf=new BufferedWriter(fw);
            
             bf.write(field.getText()+"\n");
            
             bf.close();        //저장 후 텍스트필드의 값을 가져온 자원들을 해제한다.
            
             field.setText("");
           
             FileReader frname=new FileReader("IOFile/name.txt");
             BufferedReader brname=new BufferedReader(frname);
            
             
             FileReader fr=new FileReader("IOFile/name.txt");    //String형으로 파일을 읽어온다.
             BufferedReader br=new BufferedReader(fr);    //한줄씩읽기위해(그리고 빠른속도로 읽어들인다)
             String str=null;        //while조건부
            
             System.out.println("done");
             while((str=br.readLine())!=null){
                 System.out.println(str);        //null이 될때까지 한줄씩 읽어온다.
             }
            
            // br.close();        //읽어온 자원들을 해제한다.
         }catch(Exception n){
             System.out.println(n);
     }
	 }
}


