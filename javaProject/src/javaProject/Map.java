package javaProject;

import java.awt.Color;

import java.awt.Graphics;



import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Map extends JPanel{
	private Function func;
	private final int stone=28;

	public Map(Function func) {
		setBackground(new Color(100,60,0));
		setLayout(null);
		this.func=func;
	}

	@Override
	public void paintComponent(Graphics arg0) {
		super.paintComponent(arg0);
		arg0.setColor(Color.BLACK);
		board(arg0); 
		placeStone(arg0);
	}

	public void board(Graphics arg0) {
		for(int i=1;i<=func.getSize();i++){
			arg0.drawLine(func.getBox(), i*func.getBox(),func.getBox()*func.getSize(), i*func.getBox());
			arg0.drawLine(i*func.getBox(), func.getBox(), i*func.getBox() , func.getBox()*func.getSize()); 
		}

	}

	public void placeStone(Graphics arg0) {
		for(int y=0;y<func.getSize();y++){
			for(int x=0;x<func.getSize();x++){
				if(func.getXY(y, x)==func.getBlack())
					blackStone(arg0,x,y);
				else if(func.getXY(y, x)==func.getWhite())
					whiteStone(arg0, x, y);
			}
		}
	}
	public void blackStone(Graphics arg0,int x,int y){
		arg0.setColor(Color.BLACK);
		arg0.fillOval((x+1)*func.getBox()-15, (y)*func.getBox()+15, stone, stone);
	}

	public void whiteStone(Graphics arg0,int x,int y){
		arg0.setColor(Color.WHITE);
		arg0.fillOval(x*func.getBox()+15, y*func.getBox()+15, stone, stone);
	}

}

