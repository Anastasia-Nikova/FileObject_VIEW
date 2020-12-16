import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;



public class Test {

	public static void main(String[] args)
	{
		
		File file1 = new File("Parks.txt", 20);
		File file2 = new File("Gardents.txt", 30);
		File file3 = new File("Reservations.txt", 60);
		FileSystemObject[] files = {file1, file2, file3};
		Folder folder = new Folder("Green files", files);
		
		int folderSize = folder.getSize();
		System.out.println(folderSize);
		
		File file4 = new File("Forests.txt", 40);
		folder.add(file4);
		
		
		JFrame window = new JFrame();
		window.setBounds(20, 20, 500, 500);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		window.setLayout(null);
		
		FileSystemObjectView firstView = new FileSystemObjectView(new Rectangle(50,50,150,25), folder);
		window.add(firstView);
	
		FileSystemObjectView firstFile = new FileSystemObjectView(new Rectangle(55,70,170,25), file1);
		FileSystemObjectView secondFile = new FileSystemObjectView(new Rectangle(55,90,170,25), file2);
		FileSystemObjectView thirdFile = new FileSystemObjectView(new Rectangle(55,110,170,25), file3);
		
		JButton btnClose = new JButton("Close");
		btnClose.setBounds(300, 100, 70, 40);
		btnClose.setBackground(new Color(181,181,181));
		btnClose.addActionListener(new ActionListener() 
		{

			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				System.exit(0);				
			}
			
		});
		window.add(btnClose);
				
		JButton btnOpen = new JButton("Open folder");
		btnOpen.setBounds(300, 50, 120, 40);
		btnOpen.setBackground(new Color(181,181,181));
		btnOpen.addActionListener(new ActionListener() 
		{

			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				//btnOpen.doClick();
				window.add(firstFile);	
				window.add(secondFile);	
				window.add(thirdFile);
				window.repaint();
			}
			
		});
		window.add(btnOpen);
		

		
		
	}

}
