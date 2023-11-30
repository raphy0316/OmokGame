package javaProject;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class GUI extends JFrame{
	private Container c;
	public GUI(String title) {
		c=getContentPane();
		setBounds(200,20,650,700);
		c.setLayout(null);
		Function func=new Function(this);
		Map m = new Map(func);
		setContentPane(m);
		addMouseListener(new MouseEventHandler(func,m,this));
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		showPopUp("�������!!\n3��2������\nù��°���� ������ �� �� �����Ǻ��ʹ� ������� ������ ���� �������ϴ�.");
		
	}
	public void showPopUp(String message) {
		JOptionPane.showMessageDialog(this, message,"", JOptionPane.INFORMATION_MESSAGE);

	}
}
