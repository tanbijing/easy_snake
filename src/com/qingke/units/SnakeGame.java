package com.qingke.units;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class SnakeGame extends JPanel implements ActionListener {
	private static final long serialVersionUID = 672308109818902483L;
	private static Integer WIDTH = 600;
	private static Integer HIGHT = 600;
	private static SnakeGame game = null;
	private JFrame frame;
	private Snake food;
	private ArrayList<Snake> snakeArr;
	private Integer speed = 25;
	private Timer time = new Timer(1000, this);
	
	private static BufferedImage snakeHeadRight;
	private static BufferedImage snakeFood;
	
	static {
		try {
			snakeHeadRight = ImageIO.read(new File("images/right.png"));
			snakeFood = ImageIO.read(new File("images/food.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private SnakeGame(){
		snakeArr = new ArrayList<Snake>();
		System.out.println(snakeHeadRight.getWidth());
		Snake snake = new Snake(200, 50, snakeHeadRight);
		snakeArr.add(snake);
		food = new Snake(500, 100, snakeFood);
		initGameWindows();
	}
	
	private void initGameWindows(){
		frame = new JFrame("贪吃蛇");
		frame.setBounds(0, 0, WIDTH, HIGHT);
		//设置关闭窗口即关闭程序
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//设置窗口初始化在屏幕正中间
		frame.setLocationRelativeTo(null);
//		frame.setResizable(false);
		frame.add(this);
		frame.setVisible(true);
	}
	
	public static SnakeGame getGame(){
		if(game==null){
			game = new SnakeGame();
		}
		return game;
	}
	
	public void run(){
		time.start();
	}
	
	public void move(){
		snakeArr.get(0).x += speed;
		Random rd = new Random();
		Integer rdx = rd.nextInt(WIDTH-food.width);
		Integer rdy = rd.nextInt(HIGHT-food.height);
		System.out.println(rdx); 
		System.out.println(rdy);
		food.x = rdx;
		food.y = rdy;
	}
	
	public ArrayList<Snake> getSnakeArr() {
		return snakeArr;
	}

	public void setSnakeArr(ArrayList<Snake> snakeArr) {
		this.snakeArr = snakeArr;
	}
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
//		super.paint(g);
		g.setColor(Color.darkGray);
		g.fillRect(0, 0, WIDTH-15, HIGHT-40);
		g.drawImage(snakeArr.get(0).image, snakeArr.get(0).x, snakeArr.get(0).y, null);
		g.drawImage(food.image, food.x, food.y, null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		move();
		repaint();
	}
}
