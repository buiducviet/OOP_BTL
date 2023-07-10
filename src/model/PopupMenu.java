package model;

import javax.swing.JPopupMenu;
import javax.swing.JMenuItem;

import java.io.Serializable;

import javax.swing.JMenu;
public class PopupMenu extends JPopupMenu implements Serializable{
	
	public JMenuItem itemCopy = new JMenuItem("Copy");
	public JMenuItem itemPaste = new JMenuItem("Paste");
	public JMenuItem itemDelete = new JMenuItem("Delete");
	
	public JMenuItem getItemCopy() {
		return itemCopy;
	}
	public void setItemCopy(JMenuItem itemCopy) {
		this.itemCopy = itemCopy;
	}
	public JMenuItem getItemPaste() {
		return itemPaste;
	}
	public void setItemPaste(JMenuItem itemPaste) {
		this.itemPaste = itemPaste;
	}
	public JMenuItem getItemDelete() {
		return itemDelete;
	}
	public void setItemDelete(JMenuItem itemDelete) {
		this.itemDelete = itemDelete;
	}
	public  PopupMenu() {
		
		super();
		
		this.add(itemCopy);
		this.add(itemPaste);
		this.add(itemDelete);
	}	
}
