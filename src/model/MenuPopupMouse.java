package model;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JList;
import javax.swing.JTextPane;

import view.BTL_View;
import view.GUI3_2;

public class MenuPopupMouse implements MouseListener{
	JList list;
	BTL_View mainView;
	int index;
	
//	JTextPane textPaneCateInfor;
	public  MenuPopupMouse( BTL_View mainView) {
		this.mainView = mainView;
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
			
		mainView.do_list_mouseClicked(e);
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.isPopupTrigger()) {
			this.setIndex(mainView.list.locationToIndex(e.getPoint())) ;
			System.out.println(this.index);
	        PopupMenu menu = new PopupMenu();		         
	        menu.show(e.getComponent(), e.getX(), e.getY());
	        System.out.println(mainView.list.getModel().getElementAt(index));
			this.mainView.popupMenu.show(e.getComponent(),e.getX(),e.getY());
//			this.mainView.popupMenu.show(e.getComponent(),e.getX(),e.getY()); 
		}
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
