package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import DB.FileDsQuiz;
import DB.fileQuestionBank;
import view.BTL_View;

public class MouseController implements ActionListener{
	private MenuPopupMouse menuPopupMouse;
	private BTL_View mainView;
	public MouseController(BTL_View mainView, MenuPopupMouse menuPopupMouse) {
		this.mainView = mainView;
		this.menuPopupMouse = menuPopupMouse;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JList list = mainView.list;
		String button = e.getActionCommand();
		if(button.equalsIgnoreCase("Delete")) {
			try {		
				ArrayList<Quiz> quizList= new FileDsQuiz().docQuiz();
				ArrayList<Quiz> listt= new ArrayList<>();
				DefaultListModel<Quiz> listModel = (DefaultListModel<Quiz>) list.getModel();
				/*int size = listModel.size();
				for (int i = 0; i < size; i++) {
				    Quiz quiz = listModel.getElementAt(i);
				    listt.add(quiz);
				};	*/
				System.out.println(listModel.getElementAt(this.menuPopupMouse.index).getQuizName());
				System.out.println(menuPopupMouse.index);
				ArrayList<Quiz> quizListResult = new ArrayList();
				for(Quiz q:quizList) {				
					if(!q.getQuizName().equalsIgnoreCase(listModel.getElementAt(this.menuPopupMouse.index).getQuizName())) {						
						quizListResult.add(q);
					}
				
				}
				new FileDsQuiz().ghiQuiz(quizListResult);
				this.mainView.setVisible(false);
				BTL_View mainView1 = new BTL_View();			
				mainView1.setVisible(true);		
				
			} catch (Exception ex) {
				// TODO: handle exception
				ex.printStackTrace();
			}
			
		}
		if(button.equalsIgnoreCase("Copy")) {			
			JOptionPane.showMessageDialog(menuPopupMouse.mainView, "banj ddax nhans vao");
		}
	}
	
}
