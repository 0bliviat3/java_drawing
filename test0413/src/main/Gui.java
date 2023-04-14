package main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Gui extends JFrame implements MouseListener,MouseMotionListener,ActionListener{
	
	private List<Point> pList = new ArrayList<>();
	private JButton btn = new JButton("저장");
	private BufferedImage image = null;
	private Graphics2D g2;
	
	private Canvas temp = new Canvas() {

		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			for(int i=0;i<pList.size()-1;i++) {
				int x = (int)pList.get(i).getX();
				int y = (int)pList.get(i).getY();
				int x2 = (int)pList.get(i+1).getX();
				int y2 = (int)pList.get(i+1).getY();
				g.drawLine(x, y, x2, y2);
				g2.setColor(Color.black);
				g2.drawLine(x, y, x2, y2);
			}

		}
		@Override
		public void update(Graphics g) {
			// TODO Auto-generated method stub
			paint(g);
			paint(g2);
		}
		
		
		
	};
	
	
	Gui(){
		this.setBounds(100,100,500,500);
		temp.addMouseListener(this);
		btn.addActionListener(this);
		this.add("Center",temp);
		this.add("South",btn);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		image = new BufferedImage(temp.getWidth(), temp.getHeight(), BufferedImage.TYPE_INT_RGB);
		g2 = (Graphics2D)image.getGraphics();
		g2.setColor(Color.white);
		g2.fillRect(0, 0, temp.getWidth(), temp.getHeight());
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		temp.addMouseMotionListener(this);
		pList.add(new Point(e.getX(),e.getY()));
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		pList = new ArrayList<>();
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		pList.add(new Point(arg0.getX(),arg0.getY()));
		temp.repaint();
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(btn)) {
			File file = new File("D:\\signImage");
			boolean isExist = file.exists();
			System.out.println(isExist);
			if(!isExist) {
				file.mkdir();
			}
			try {
				ImageIO.write(image, "png", new File("D:\\signImage\\sign.png"));
				System.out.println("저장되었습니다.");
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
			this.setVisible(false);
			System.exit(0);
		}
	}
}
