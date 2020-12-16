import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JComponent;

public class FileSystemObjectView extends JComponent
{
	private FileSystemObject fileObject;
	public FileSystemObjectView(Rectangle rec, FileSystemObject fileObject)
	{
		this.fileObject = fileObject;
		setBounds(rec);
	}
	
	public void paintComponent(Graphics graphics)
	{
		super.paintComponent(graphics);
		Graphics2D g = (Graphics2D)graphics;
		if(fileObject.getClass() == Folder.class)
		{
			g.setColor(new Color(251,189,4));
			g.fill(new Rectangle.Double(5, 5, getBounds().width-10, getBounds().height-8));
			g.setColor(Color.black);
			g.draw(new Rectangle.Double(5, 5, getBounds().width-10, getBounds().height-8));
			g.setColor(Color.black);
			String folderInfo = String.format("%s | %d bytes", fileObject.getName(),fileObject.getSize());
			g.drawString(folderInfo, 20, 20);
		}
		
		if(fileObject.getClass() == File.class)
		{
			g.setColor(Color.lightGray);
			g.fill(new Rectangle.Double(5, 5, getBounds().width-10, getBounds().height-8));
			g.setColor(Color.black);
			g.draw(new Rectangle.Double(5, 5, getBounds().width-10, getBounds().height-8));
			g.setColor(Color.black);
			String folderInfo = String.format("%s | %d bytes", fileObject.getName(),fileObject.getSize());
			g.drawString(folderInfo, 20, 20);
		}
	}
}
