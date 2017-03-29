package com.qingke.units;

import java.awt.image.BufferedImage;

public class Snake {
	protected Integer x;
	protected Integer y;
	protected Integer width;
	protected Integer height;
	protected BufferedImage image;
	
	public Snake(Integer x,Integer y,BufferedImage image){
		this.x = x;
		this.y = y;
		this.image = image;
		height = image.getHeight();
		width = image.getWidth();
	}
}
