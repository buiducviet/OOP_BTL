package view;

import java.awt.EventQueue;


import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

import org.apache.poi.xwpf.usermodel.XWPFDocument;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import com.aspose.*;
import com.aspose.words.FileFormatUtil;
import com.aspose.words.NodeType;
import com.aspose.words.Shape;
import com.aspose.words.Document;
import com.aspose.words.NodeCollection;
import DB.fileQuestionBank;
import model.Question;
import model.QuestionBank;

public class guitest_1 extends JFrame {
	

	private JPanel panel;
	
	public JPanel getPanel() {
		return panel;
	}
	public void setPanel(JPanel panel) {
		this.panel = panel;
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					guitest_1 frame = new guitest_1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public guitest_1() {
		this.setSize(504, 400);
		getContentPane().setLayout(null);
		
		/*this.panel = panel;
		this.panel.setBounds(0, 45, 488, 316);
		getContentPane().add(this.panel);*/
		panel = new JPanel();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 65, 468, 263);
		getContentPane().add(scrollPane);
		
		JTextPane textPaneCateInfor = new JTextPane();
		scrollPane.setViewportView(textPaneCateInfor);
		textPaneCateInfor.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JScrollPane scrollPane_1 = new JScrollPane(panel);		
		textPaneCateInfor.insertComponent(scrollPane_1);
		
		JButton button = new JButton("abc");
		panel.add(button);
		this.setVisible(true);
		

        /*//file you want to play
        URL mediaURL = //Whatever
        //create the media player with the media url
        Player mediaPlayer = Manager.createRealizedPlayer(mediaURL);
        //get components for video and playback controls
        Component video = mediaPlayer.getVisualComponent();
        Component controls = mediaPlayer.getControlPanelComponent();
        add(video,BorderLayout.CENTER);
        add(controls,BorderLayout.SOUTH);
	*/ 
		ImageIcon icon = new ImageIcon("C:\\Users\\Administrator\\Pictures\\dog-gif.gif");
		textPaneCateInfor.insertIcon(icon);
		
		Document doc ;
		try {
			doc = new Document("C:\\Users\\Administrator\\Pictures\\New Microsoft Word Document.docx");
			NodeCollection<Shape> shapes = (NodeCollection<Shape>) doc.getChildNodes(NodeType.SHAPE, true);
			int imageIndex = 0;

			// Loop through the shape collection
			for (Shape shape : shapes) {
			  
			    // Check if shape has image
			    if (shape.hasImage()) {
			      
			        // Extract and save the image
			        String imageFileName = String.format("Image", imageIndex, FileFormatUtil.imageTypeToExtension(shape.getImageData().getImageType()));
			        System.out.println(imageFileName);
			        shape.getImageData().save("C:\\Users\\Administrator\\"  + imageFileName+".png");
			        ImageIcon icon_1 = new ImageIcon("C:\\Users\\Administrator\\"  + imageFileName+".png");
			        textPaneCateInfor.insertIcon(icon_1);
			        imageIndex++;
			    }
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Get all the shapes
	
		

	}
	/*public static List<byte[]> extractImagesFromWord(File file) {
	    if (file.exists()) {
	        try {
	            List<byte[]> result  = new ArrayList<byte[]>();
	            if ("docx".equals(getMimeType(file).getExtension())) {
	                org.apache.poi.xwpf.usermodel.XWPFDocument doc = new XWPFDocument(new FileInputStream(file));
	                for (org.apache.poi.xwpf.usermodel.XWPFPictureData picture : doc.getAllPictures()) {
	                    result.add(picture.getData());
	                }
	            } else if ("doc".equals(getMimeType(file).getExtension())) {
	            	org.apache.poi.hwpf.HWPFDocument doc = new HWPFDocument(new FileInputStream(file));
	                for (org.apache.poi.hwpf.usermodel.Picture picture : doc.getPicturesTable().getAllPictures()) {
	                    result.add(picture.getContent());
	                }
	            }
	            return result;
	        } catch (Exception e) {
	            throw new RuntimeException( e);
	        }
	    }
	    return null;
	}*/
}
