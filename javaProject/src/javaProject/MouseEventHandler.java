package javaProject;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class MouseEventHandler extends MouseAdapter {
	private Function func;
	private Map m;
	private GUI gui;
	
	
	public MouseEventHandler(Function func, Map m, GUI gui) {
		this.func = func;
		this.m =m;
		this.gui = gui;
	}
		
	@Override
	public void mousePressed(MouseEvent arg0) {
		super.mousePressed(arg0);
		int x= (int) Math.round(arg0.getX()/(double)func.getBox())-1;
		int y = (int) Math.round(arg0.getY()/(double)func.getBox())-2;
		if(x<0||x>19||y<0||y>19) {
			return;
		}
		if(func.getXY(y, x)==func.getBlack()||func.getXY(y, x)==func.getWhite()) {
			return;
		}
		System.out.println(x+" "+y);
		func.turnCheck(y, x);
		func.changeCheck();
		
		if(func.winCheck(x, y)==1) {
			gui.showPopUp("흑돌이 승리하였습니다.");
			System.exit(0);
		}
		else if(func.winCheck(x, y)==-1) {
			gui.showPopUp("백돌이 승리하였습니다");
			System.exit(0);
		}
		m.repaint();
				
	}	
		

}
