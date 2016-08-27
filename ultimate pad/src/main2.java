import java.awt.*;
import java.awt.event.*; // will be used in beta version
import javax.swing.*;

public class main2 extends JFrame {

		private JEditorPane write;
		private JLabel  statusbar;
		private JMenuBar menubar;
		private JMenu file  , help , themes , format , functions;
		private JMenuItem exit  , about ,viewHelp , default_t , theme1 , bold , italic , b_and_i , normal , setFColor , setBColor , wordCount , charcount;
		private Color color = (Color.WHITE);
			
		public main2(){
			//basic things
			super("UltimatePad(Alpha verson 1.01)");
			
			//statusbar
			
			statusbar = new JLabel();
			statusbar.setText("Working Fine...");
			add(statusbar , BorderLayout.SOUTH);
			
			//menu bar
			
			menubar = new JMenuBar();
			setJMenuBar(menubar);
			
			//file
			 file = new JMenu("File");
			menubar.add(file);
			 exit = new JMenuItem("Exit");
			file.add(exit);
			
			//format
			format = new JMenu("Format");
			normal = new JMenuItem("No Formatting");
			bold = new JMenuItem("Bold");
			italic = new JMenuItem("Italic");
			b_and_i = new JMenuItem("Bold & Italic ");
			setFColor = new JMenuItem("Choose Font Color...");
			setBColor = new JMenuItem("Choose Background Color...");
			menubar.add(format);
			format.add(normal);
			format.add(bold);
			format.add(italic);
			format.add(b_and_i);
			format.add(setFColor);
			format.add(setBColor);
			
			//Themes
			themes = new JMenu("Themes");
			default_t = new JMenuItem("Default Theme");
			theme1 = new JMenuItem("Theme1"); 
			menubar.add(themes);
			themes.add(default_t);
			themes.add(theme1);
			
			//functions
			functions = new JMenu("Functions");
			wordCount = new JMenuItem("Count Words...");
			charcount = new JMenuItem("Count Characters...");
			menubar.add(functions);
			functions.add(wordCount);
			functions.add(charcount);
			
			//Help
			 help = new JMenu("Help");
			 menubar.add(help);
			 about = new JMenuItem("About");
			 viewHelp = new JMenuItem("View Help");
			 viewHelp.setEnabled(false);
			 help.add(viewHelp);
			 help.add(about);
			
			//define JEditorPane
			write = new JEditorPane();
			write.setEditable(true);
			write.setFont(new Font("Verdana" , Font.PLAIN , 14));

			add(new JScrollPane(write) , BorderLayout.CENTER);
			
			//adding action listeners
			handle handler = new handle();
			exit.addActionListener(handler);
			about.addActionListener(handler);
			default_t.addActionListener(handler);
			theme1.addActionListener(handler);
			bold.addActionListener(handler);
			italic.addActionListener(handler);
			b_and_i.addActionListener(handler);
			normal.addActionListener(handler);
			setBColor.addActionListener(handler);
			setFColor.addActionListener(handler);
			wordCount.addActionListener(handler);
			charcount.addActionListener(handler);
																												
																												//changing theme
																												//changeTheme = new JButton("Switch Theme");
																												//changeTheme.addActionListener(
																														//new ActionListener(){
																															//public void actionPerformed(ActionEvent event){
																																//write.setForeground(Color.WHITE);
																																//write.setBackground(Color.BLACK);
																																//write.setFont(new Font("Serif",Font.BOLD + Font.ITALIC ,14));
																																
																															//}
																														//}
																									  			
																												//);
																												//add(changeTheme , BorderLayout.SOUTH);
				
			
		}
		//action listeners
		
		private class handle implements ActionListener{
				public void actionPerformed(ActionEvent event){
					if(event.getSource() == exit)
						System.exit(0);
					else if(event.getSource() == about)
						JOptionPane.showMessageDialog(null, "Developer - Prince Gupta     Version : alpha-version 1.01");
					else if(event.getSource() == default_t){
						write.setBackground(Color.WHITE);
						write.setForeground(Color.BLACK);
					}
					else if(event.getSource() == theme1){
						write.setBackground(Color.BLACK);
						write.setForeground(Color.WHITE);
					}
					else if(event.getSource() == bold)
						write.setFont(new Font("Verdana" , Font.BOLD , 14));
					else if(event.getSource() == italic)
						write.setFont(new Font("Verdana" , Font.ITALIC , 14));
					else if(event.getSource() == b_and_i)
						write.setFont(new Font("Verdana" , Font.BOLD + Font.ITALIC , 14));
					else if(event.getSource() == normal)
						write.setFont(new Font("Verdana" , Font.PLAIN , 14));
					else if(event.getSource() == setFColor){
						color = JColorChooser.showDialog(null , "Choose a color..." , color);
						if(color == null)
							write.setForeground(Color.WHITE);
						else
							write.setForeground(color);
					} 
					else if(event.getSource() == setBColor){
						color = JColorChooser.showDialog(null , "Choose a color..." , color);
						if(color == null)
							write.setBackground(Color.WHITE);
						else
							write.setBackground(color);
					} 
					else if(event.getSource() == wordCount){
						String newPara = write.getText();
						String words[] = newPara.split("\\s");
						JOptionPane.showMessageDialog(null, "The Number of words are: " + ((newPara.length() == 0)?(words.length-1) : words.length)) ; 
					}
					else if(event.getSource() == charcount){
						String newPara1 = write.getText();
						JOptionPane.showMessageDialog(null, "The Number of Characters are: " + newPara1.length() ); 
					}
				}
		}
		
		
}
