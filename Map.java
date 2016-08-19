import java.awt.image.BufferedImage;
import javax.swing.*;
import java.io.*;
import javax.imageio.ImageIO;

// creates and displays image from JPG, GIF, or PNG format file. Responds to close event.

public class Map
{
 private BufferedImage image;
 private JFrame frame;
 private String fileName;
 
 public Map (String inFile)  // creates image from file
 {
  fileName = inFile;
  try
  {
   File file = new File (fileName);
   if (file.isFile())
    image = ImageIO.read (file);
  }
  catch (IOException e)
  {
   throw new RuntimeException ("Could not open the file.");
  }
 }
 
 public void show()
 {
  frame = new JFrame();
  
  if (image == null)
   return;
  ImageIcon icon = new ImageIcon (image);
  JLabel labelPix = new JLabel (icon);
  
  frame.setContentPane(labelPix);
  frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  frame.setTitle("The Laboratory");
  frame.setResizable (true);
  frame.pack();
  frame.setVisible (true);
  frame.repaint();
 }
}

