package els;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;
import javax.swing.event.*;
import javax.swing.Timer;
public class gameWin extends JPanel implements ActionListener ,KeyListener{
	JButton newgame =new JButton ("开始");
	JButton endgame = new JButton ("结束");
	int fengshu = 0,speed = 0,tfengshu;
	gamefangkuai[] fangkuai = new gamefangkuai[4];
	gamefangkuai[] fangkuaitemp = new gamefangkuai[4];
	Random r = new Random();
	int temp;
	boolean start = false;
	int[][]map = new int [10][18];
	Timer t;
	JDialog dialog = new JDialog();
	JLabel label=new JLabel();
	JButton button = new JButton("ok");
	@SuppressWarnings("deprecation")
	public   gameWin()//构造方法
	{	
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 18; j++) {
				map[i][j] = 0;			
			}
		}
		for (int i = 0; i < fangkuai.length; i++) {
			fangkuai[i] = new gamefangkuai();
			}
		setLayout(new FlowLayout(FlowLayout.RIGHT));
		this.add(newgame);
		this.add(endgame);	
		newgame.addActionListener(this);
		endgame.addActionListener(this);
		addKeyListener(this);
		dialog.setLayout(new GridLayout(2,1));
		dialog.add(label);
		dialog.add(button);
		
		button.addActionListener(this);
		dialog.setSize(200,100);
		dialog.setLocation(200, 200);
		dialog.setVisible(false);
		
	}
	public void  paintComponent(Graphics g) //绘制面板
	{
		super.paintComponent(g);
		g.drawRect(9, 10, 200, 360);
		g.drawString("分数"+fengshu, 220, 62);
		g.drawLine(220, 65, 360, 65);
		g.drawString("速度"+speed, 220, 92);
		g.drawLine(220, 95, 360, 95);
		g.drawString("下一个方块：", 220, 130);
		g.drawString("手残没做出来", 250, 180);
		g.drawString("俄罗斯方块  0.1  131115", 220, 340);
		g.drawString("by bk", 320, 360);
		//////////////方块绘制、
		g.setColor(new Color(255,0,0));
		if(start){
			for (int i = 0; i < 4; i++) {
				g.fillRect(10+fangkuai[i].x*20, 10+fangkuai[i].y*20, 20, 20);
			}
		}
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j <18; j++) {
				if (map[i][j]==1){
					g.fillRect(10+i*20, 10+j*20, 20, 20);
				}
				
			}	
		}
	/*	g.setColor(new Color(255,200,60));
		if(start){
			for (int i = 0; i < 4; i++) {
				g.fillRect(150+fangkuaitemp[i].x*20, 150+fangkuaitemp[i].y*20, 20, 20);
			}
		}*/
			
		
	}
	public boolean panding()//勾践方块
	{
	//	int temp = r.nextInt(7);
		switch (temp) {
		case 1:
			fangkuai[0].x = 3; fangkuai[0].y = 0; 
			fangkuai[1].x = 3; fangkuai[1].y = 1;
			fangkuai[2].x = 3; fangkuai[2].y = 2;
			fangkuai[3].x = 3; fangkuai[3].y = 3;
			break;
		case 2:
			fangkuai[0].x = 3; fangkuai[0].y = 0;
			fangkuai[1].x = 3; fangkuai[1].y = 1;
			fangkuai[2].x = 3; fangkuai[2].y = 2;
			fangkuai[3].x = 4; fangkuai[3].y = 2;
			break;
		case 3:
			fangkuai[0].x = 2; fangkuai[0].y = 0; 
			fangkuai[1].x = 3; fangkuai[1].y = 0;
			fangkuai[2].x = 3; fangkuai[2].y = 1;
			fangkuai[3].x = 4; fangkuai[3].y = 1;
			break;
		case 4:
			fangkuai[0].x = 3; fangkuai[0].y = 0; 
			fangkuai[1].x = 4; fangkuai[1].y = 0;
			fangkuai[2].x = 3; fangkuai[2].y = 1;
			fangkuai[3].x = 2; fangkuai[3].y = 1;
			break;
		case 5:
			fangkuai[0].x = 3; fangkuai[0].y = 0; 
			fangkuai[1].x = 2; fangkuai[1].y = 1;
			fangkuai[2].x = 3; fangkuai[2].y = 1;
			fangkuai[3].x = 4; fangkuai[3].y = 1;
			break;
		case 6:
			fangkuai[0].x = 3; fangkuai[0].y = 0; 
			fangkuai[1].x = 3; fangkuai[1].y = 1;
			fangkuai[2].x = 3; fangkuai[2].y = 2;
			fangkuai[3].x = 2; fangkuai[3].y = 2;
			break;
		case 7:
			fangkuai[0].x = 3; fangkuai[0].y = 0; 
			fangkuai[1].x = 4; fangkuai[1].y = 0;
			fangkuai[2].x = 3; fangkuai[2].y = 1;
			fangkuai[3].x = 4; fangkuai[3].y = 1;
			break;	
		}
		for (int i = 0; i < 4; i++) {
			if (panding2(fangkuai[i].x,fangkuai[i].y)) {
				return false ;
			}
		}
		return true ;	
	}
	private int  delect() {
		int line = 0;
		for (int i = 0; i <18; i++) {
			int j;
			for (j = 0; j <10; j++) {
				if (map[j][i]==0) {
					break;
				}
				
			
			}
			if (j==10) {
				line+=1;
				if(i!=0){
					for (int j2 =i-1; j2 >0; j2--) {
						for (int k = 0; k < 10; k++) {
							map[k][j2+1] = map [k][j2];
						}
						
					}
					for (int j2 = 0; j2 < 10; j2++) {
						map[0][j2]=0;
					}
				}
			}
		}
		repaint();
		return line;
		
	}
	public void down() //下降方块
	{
		if (baunnd(0,1)) {
			for (int i = 0; i < 4; i++) {
				fangkuai[i].y +=1; 			
			}
			repaint();
		}
		else{
			t.stop();
			for (int i = 0; i < 4; i++) {
				map[fangkuai[i].x][fangkuai[i].y]=1;	
			}
			int z;
			if((z=delect())!=0){
				fengshu =fengshu +(10*z*z);
				if (fengshu- tfengshu >=300) {
					tfengshu = fengshu;
					if(fengshu-tfengshu==1){
						tfengshu=fengshu;
						if (speed<=9) {
							speed +=1;
							
						}
					}
					
				}
			}
			if (!panding()) {
			//	fengshu+=100;
					temp = r.nextInt(7);
					System.out.println(temp);
					 // temppanding();
					t.start();			
					}
			else {
				//System.out.println("guanle ");
				t.stop();
				label.setText("游戏结束!得分是："+fengshu);
				dialog.setVisible(true);
				}
			
			}repaint();
	}
	public void up(){
		gamefangkuai[] tt = new gamefangkuai[4];
		for (int i = 0; i < tt.length; i++) {
			tt[i] = new gamefangkuai();
			tt[i].x = fangkuai[i].x;
			tt[i].y = fangkuai[i].y;
			}
		int cx =( tt[0].x+tt[1].x+tt[2].x+tt[3].x)/4;
		int cy =( tt[0].y+tt[1].y+tt[2].y+tt[3].y)/4;
		for (int i = 0; i < tt.length; i++) {
			tt[i].x = cx + cy - fangkuai[i].y; 
			tt[i].y = cy - cx + fangkuai[i].x; 
		}
		//System.out.println("up");
		for (int i = 0; i < tt.length; i++) {
			if (!panding2(tt[i].x,tt[i].y))
			{
				//System.out.println("up2");
				return;
			}
			
		} 
		for (int i = 0; i < tt.length; i++) {
			fangkuai[i].x= tt[i].x;
			fangkuai[i].y= tt[i].y;
		}
		repaint();
	}
/*	public void temppanding (){
		
		switch (temp) {
		case 1:
			fangkuaitemp[0].x = 3; fangkuaitemp[0].y = 0; 
			fangkuaitemp[1].x = 3; fangkuaitemp[1].y = 1;
			fangkuaitemp[2].x = 3; fangkuaitemp[2].y = 2;
			fangkuaitemp[3].x = 3; fangkuaitemp[3].y = 3;
			break;
		case 2:
			fangkuaitemp[0].x = 3; fangkuaitemp[0].y = 0;
			fangkuaitemp[1].x = 3; fangkuaitemp[1].y = 1;
			fangkuaitemp[2].x = 3; fangkuaitemp[2].y = 2;
			fangkuaitemp[3].x = 4; fangkuaitemp[3].y = 2;
			break;
		case 3:
			fangkuaitemp[0].x = 2; fangkuaitemp[0].y = 0; 
			fangkuaitemp[1].x = 3; fangkuaitemp[1].y = 0;
			fangkuaitemp[2].x = 3; fangkuaitemp[2].y = 1;
			fangkuaitemp[3].x = 4; fangkuaitemp[3].y = 1;
			break;
		case 4:
			fangkuaitemp[0].x = 3; fangkuaitemp[0].y = 0; 
			fangkuaitemp[1].x = 4; fangkuaitemp[1].y = 0;
			fangkuaitemp[2].x = 3; fangkuaitemp[2].y = 1;
			fangkuaitemp[3].x = 2; fangkuaitemp[3].y = 1;
			break;
		case 5:
			fangkuaitemp[0].x = 3; fangkuaitemp[0].y = 0; 
			fangkuaitemp[1].x = 2; fangkuaitemp[1].y = 1;
			fangkuaitemp[2].x = 3; fangkuaitemp[2].y = 1;
			fangkuaitemp[3].x = 4; fangkuaitemp[3].y = 1;
			break;
		case 6:
			fangkuaitemp[0].x = 3; fangkuaitemp[0].y = 0; 
			fangkuaitemp[1].x = 3; fangkuaitemp[1].y = 1;
			fangkuaitemp[2].x = 3; fangkuaitemp[2].y = 2;
			fangkuaitemp[3].x = 2; fangkuaitemp[3].y = 2;
			break;
		case 7:
			fangkuaitemp[0].x = 3; fangkuaitemp[0].y = 0; 
			fangkuaitemp[1].x = 4; fangkuaitemp[1].y = 0;
			fangkuaitemp[2].x = 3; fangkuaitemp[2].y = 1;
			fangkuaitemp[3].x = 4; fangkuaitemp[3].y = 1;
			break;	
		}
	}*/
 	public void move(int x, int y) //方块移动
 	{
 		if(baunnd(x,y)){
 		for (int i = 0; i < 4; i++) 
 		{
 			fangkuai[i].x +=x;fangkuai[i].y +=y;	
 			//System.out.println(fangkuai[i].x +"  "+fangkuai[i].y	);
		}repaint();//	System.out.println("///////////");
		}
 	}
 	public boolean  baunnd(int x,int y) //移动判定
 	{
		for (int i = 0; i < 4; i++)
		{
			if (!panding2(fangkuai[i].x+x, fangkuai[i].y+y))
			{
				return false;
			}
		}
			return true;		
	}
 	public boolean panding2(int x,int y )
 	{
 		if (x<0||x>=10||y<0||y>=18){
 			return false ;	
 		}
 		if (map[x][y]== 1 ) {
			return false ;
		}
		return true;
 	
 	}
	public void actionPerformed(ActionEvent e)//按钮监听
 {
		// TODO Auto-generated method stub
		if (e.getSource()==newgame)//开始游戏
		{
			if (e.getActionCommand().equals("开始"))
			{
				newgame.setText("重置");
				
				requestFocus(true);
				start = true ;
				temp = r.nextInt(7);
				if (!panding()) {
					t = new Timer(1000-(100*speed),new myTimer());
					t.start();
					 temp = r.nextInt(7);
					 System.out.println(temp);
					 //  temppanding(); 
					 //////////////////////////////////
					repaint();		
				}
				else {
					//System .out.println("输了");
						return ;//失败弹出窗口还要添加			
				}
				
			}
			else
			{
				start = false ;
				for (int i = 0; i < 10; i++) {
					for (int j = 0; j < 18; j++) {
						map[i][j] = 0;			
					}
				}
				repaint();
				newgame.setText("开始");	
			}
		}
		if (e.getSource()==endgame)//退出游戏
		{
			System.exit(0);
		}
		if (e.getSource()==button)
		{
			fengshu = 0;
			tfengshu = 0;
			speed = 0;
			start = false;
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 18; j++) {
					map[i][j]=0;
				}
				
			}
			dialog.setVisible(false);
			newgame.setText("开始");	
			repaint();
		}
		
	}
	public void keyPressed(KeyEvent e) //键盘监听
	{
		// TODO Auto-generated method stub
		if (start){
			switch (e.getKeyCode()) {
			case KeyEvent.VK_DOWN:
				down();
				break;
			case KeyEvent.VK_UP:
				 up();	
				break;
			case KeyEvent.VK_LEFT:
			//	System.out.println("anjian1ci");
				move(-1,0);	
				break;
			case KeyEvent.VK_RIGHT:
				move(1,0);	
				break;
			default:
				break;
			}
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	public class myTimer implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (start) {
				down();
			}
		}
		
	}
}