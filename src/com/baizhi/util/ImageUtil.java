package com.baizhi.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Random;

public class ImageUtil {
	
	public static void main(String[] args) {
		String code = getCode();
		System.out.println(code);
	}
	/**
	 * ��������
	 * 
	 */
	public static String getCode(){
		//һЩ����ʶ����ַ�  ��Ҫ����������  ����    1  l   0  o   2  z
		String s = "10";
		Random r = new Random();
		StringBuffer sb = new StringBuffer();//���ַ�ƴ��
		int len = s.length();//ȡ�ַ�ĳ���
		for(int i =0;i<4;i++){
			char c = s.charAt(r.nextInt(len));
			sb.append(c);
		}
		return sb.toString();
	}
	/*
	*	���ͼƬ��֤��
	*/
	 public static BufferedImage createImage(String securityCode){

	        int codeLength = securityCode.length();//��֤�볤��

	        int fontSize = 20;//�����С

	        int fontWidth = fontSize+1;

	        //ͼƬ���

	        int width = codeLength*fontWidth;
	        int height = fontSize*2;
	        //ͼƬ

	        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

	        Graphics2D g = image.createGraphics();

	        g.setColor(Color.WHITE);//���ñ���ɫ

	        g.fillRect(0, 0, width, height);//��䱳��

	        g.setColor(Color.LIGHT_GRAY);//���ñ߿���ɫ

	        g.setFont(new Font("Courier New", Font.BOLD, height-2));//�߿�������ʽ

	        g.drawRect(0, 0,0, 0);//���Ʊ߿�

	        //�������

	        Random rand = new Random();

	        g.setColor(Color.LIGHT_GRAY);

	        for (int i = 0; i < codeLength*6; i++) {

	            int x = rand.nextInt(width);

	            int y = rand.nextInt(height);

	            g.drawRect(x, y, 1, 1);//����1*1��С�ľ���

	        }

	        //������֤��

	        int codeY = height-10;

	        g.setColor(new Color(19,148,246));

	        g.setFont(new Font("Georgia", Font.BOLD, fontSize));
	        for(int i=0;i<codeLength;i++){
	        	double deg=new Random().nextDouble()*20;
	        	g.rotate(Math.toRadians(deg), i*16+13,codeY-7.5);
	            g.drawString(String.valueOf(securityCode.charAt(i)), i*16+5, codeY);
	            g.rotate(Math.toRadians(-deg), i*16+13,codeY-7.5);
	        }
	       
	        g.dispose();//�ر���Դ

	        return image; //����һ����֤���ͼƬ

	    }
	
}
