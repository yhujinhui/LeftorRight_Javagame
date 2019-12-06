import javax.sound.sampled.*;
import java.io.*;
import com.*;
//import javax.microedition.io.*;

class Music{
	boolean bl;
	File file1 = new File("musics/music.wav");
	File file2 = new File("musics/game_rules.wav");
	File wrong=new File("musics/sound_button_wrong.wav");
	
	Clip clip1;
	Clip clip2;
	//Clip clip3;
	
	public Music() {}
	 
	 public void OpenClips1() {			 
		 try {	
			 AudioInputStream ais1 = AudioSystem.getAudioInputStream(file1);     
			 clip1 = AudioSystem.getClip();
        	 clip1.open(ais1);
	         clip1.start();
	         System.out.println("T");
		     clip1.loop(-1);		        
		     
	         //배경음악	    
		 } catch(Exception e) {} 
	 }
	 //music 배경 음악 on
	 public void StopClips1() {

		 try
		 {		 
			 System.out.println("F");
			 clip1.stop();
		 }catch(Exception e) {}
	 }
	 //music 배경 음악 off
	 public void OpenClips2() {			 
		 try {	
			 AudioInputStream ais2 = AudioSystem.getAudioInputStream(file2);     
			 clip1 = AudioSystem.getClip();
        	 clip1.open(ais2);
	         clip1.start();
	         System.out.println("T");
		     clip1.loop(-1);		        
		     
	         //배경음악	    
		 } catch(Exception e) {} 
	 }
	 //game_rules 음악 in
	 public void StopClips2() {
		 try
		 {		 
			 System.out.println("F");
			 clip1.stop();
		 }catch(Exception e) {}
	 }
	 //game_rules 음악 off
	 
	 public void OpenClips3() {			 
		 try {	
			 AudioInputStream ais2 = AudioSystem.getAudioInputStream(file2);     
			 clip2 = AudioSystem.getClip();
        	 clip2.open(ais2);
	         clip2.start();
	         System.out.println("T");
		     clip2.loop(-1);		        
		     
	         //배경음악	    
		 } catch(Exception e) {} 
	 }
	 //game_rules 음악 in
	 
	 public void StopClips3() {
		 try
		 {		 
			 System.out.println("노래 끔");
			 clip2.stop();
		 }catch(Exception e) {}
	 }
	 //game_rules 음악 off
	 public void openWrong() {
		 try {
		 AudioInputStream ais4 = AudioSystem.getAudioInputStream(wrong);     
		 clip1=AudioSystem.getClip();
		 clip1.open(ais4);
		 clip1.start();
		 System.out.println();
	 }catch(Exception e) {}
  } 
	 //game_rules 음악 off
}




     
