package main;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

public class Gui extends JFrame implements MouseListener,MouseMotionListener{
	
//	private int x = 0;
//	private int y = 0;
//	private int x2 = 0;
//	private int y2 = 0;
	private List<Point> pList = new ArrayList<>();
	
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
			}

		}
		@Override
		public void update(Graphics g) {
			// TODO Auto-generated method stub
			paint(g);
		}
		
		
		
	};
	
	Gui(){
		this.setBounds(100,100,500,500);
		temp.addMouseListener(this);
		
		this.add("Center",temp);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
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
//		x = e.getX();
//		y = e.getY();
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
//		x = arg0.getX();
//		y = arg0.getY();
//		temp.repaint();
		//
//		x2 = arg0.getX();
//		y2 = arg0.getY();
//		System.out.println(x);
//		System.out.println(y);
//		System.out.println(x2);
//		System.out.println(y2);
//		System.out.println("---------------------");
//		temp.repaint();
//		x = x2;
//		y = y2;
		
		pList.add(new Point(arg0.getX(),arg0.getY()));
		temp.repaint();
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}
}
