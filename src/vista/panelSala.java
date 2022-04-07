package vista;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

public class panelSala extends JPanel {
	
	private Image imagen = new ImageIcon(getClass().getResource("/Imagen/Sala.jpeg")).getImage();
	private JCheckBox sillaG1;
	private JCheckBox sillaG2;
	private JCheckBox sillaG3;
	private JCheckBox sillaG4;
	private JCheckBox sillaG5;
	private JCheckBox sillaG6;
	private JCheckBox sillaG7;
	private JCheckBox sillaG8;
	private JCheckBox sillaG9;
	private JCheckBox sillaG10;
	private JCheckBox sillaG11;
	private JCheckBox sillaG12;
	private JCheckBox sillaG13;
	private JCheckBox sillaG14;
	private JCheckBox sillaG15;
	private JCheckBox sillaG16;
	private JCheckBox sillaG17;
	private JCheckBox sillaG18;
	private JCheckBox sillaG19;
	private JCheckBox sillaG20;
	private JCheckBox sillaG21;
	private JCheckBox sillaG22;
	private JCheckBox sillaG23;
	private JCheckBox sillaG24;
	private JCheckBox sillaG25;
	private JCheckBox sillaG26;
	private JCheckBox sillaG27;
	private JCheckBox sillaG28;
	private JCheckBox sillaG29;
	private JCheckBox sillaG30;
	private JCheckBox sillaG31;
	private JCheckBox sillaG32;
	private JCheckBox sillaG33;
	private JCheckBox sillaG34;
	private JCheckBox sillaG35;
	private JCheckBox sillaG36;
	private JCheckBox sillaG37;
	private JCheckBox sillaG38;
	private JCheckBox sillaG39;
	private JCheckBox sillaG40;
	
	public JCheckBox[] sillasG;
	/*
	public JCheckBox[] sillasG = {sillaG1, sillaG2, sillaG3,sillaG4, sillaG5, sillaG6, sillaG7, sillaG8, sillaG9, sillaG10,
			sillaG11, sillaG12, sillaG13,sillaG14, sillaG15, sillaG16, sillaG17, sillaG18, sillaG19, sillaG20,
			sillaG21, sillaG22, sillaG23,sillaG24, sillaG25, sillaG26, sillaG27, sillaG28, sillaG29, sillaG30,
			sillaG31, sillaG32, sillaG33,sillaG34, sillaG35, sillaG36, sillaG37, sillaG38, sillaG39, sillaG40};
	*/
	private JCheckBox sillaP1;
	private JCheckBox sillaP2;
	private JCheckBox sillaP3;
	private JCheckBox sillaP4;
	private JCheckBox sillaP5;
	private JCheckBox sillaP6;
	private JCheckBox sillaP7;
	private JCheckBox sillaP8;
	private JCheckBox sillaP9;
	private JCheckBox sillaP10;
	private JCheckBox sillaP11;
	private JCheckBox sillaP12;
	private JCheckBox sillaP13;
	private JCheckBox sillaP14;
	private JCheckBox sillaP15;
	private JCheckBox sillaP16;
	private JCheckBox sillaP17;
	private JCheckBox sillaP18;
	private JCheckBox sillaP19;
	private JCheckBox sillaP20;
	
	public JCheckBox[] sillasP;
	

	public panelSala () {
		
		this.setBounds(103, 96, 570, 288);
		this.setLayout(null);
		
		sillaG1 = new JCheckBox("");
		sillaG1.setBounds(43, 206, 21, 12);
		this.add(sillaG1);
		
		sillaG2 = new JCheckBox("");
		sillaG2.setBounds(95, 206, 21, 12);
		this.add(sillaG2);
		
		sillaG3 = new JCheckBox("");
		sillaG3.setBounds(146, 206, 21, 12);
		this.add(sillaG3);
		
		sillaG4 = new JCheckBox("");
		sillaG4.setBounds(197, 206, 21, 12);
		this.add(sillaG4);
		
		sillaG5 = new JCheckBox("");
		sillaG5.setBounds(248, 206, 21, 12);
		this.add(sillaG5);
		
		sillaG6 = new JCheckBox("");
		sillaG6.setBounds(300, 206, 21, 12);
		this.add(sillaG6);
		
		sillaG7 = new JCheckBox("");
		sillaG7.setBounds(352, 206, 21, 12);
		this.add(sillaG7);
		
		sillaG8 = new JCheckBox("");
		sillaG8.setBounds(403, 206, 21, 12);
		this.add(sillaG8);
		
		sillaG9 = new JCheckBox("");
		sillaG9.setBounds(454, 206, 21, 12);
		this.add(sillaG9);
		
		sillaG10 = new JCheckBox("");
		sillaG10.setBounds(506, 206, 21, 12);
		this.add(sillaG10);
		
		sillaG11 = new JCheckBox("");
		sillaG11.setBounds(43, 170, 21, 12);;
		this.add(sillaG11);
		
		sillaG12 = new JCheckBox("");
		sillaG12.setBounds(95, 170, 21, 12);
		this.add(sillaG12);
		
		sillaG13 = new JCheckBox("");
		sillaG13.setBounds(146, 170, 21, 12);
		this.add(sillaG13);
		
		sillaG14 = new JCheckBox("");
		sillaG14.setBounds(197, 170, 21, 12);
		this.add(sillaG14);
		
		sillaG15 = new JCheckBox("");
		sillaG15.setBounds(248, 170, 21, 12);
		this.add(sillaG15);
		
		sillaG16 = new JCheckBox("");
		sillaG16.setBounds(300, 170, 21, 12);
		this.add(sillaG16);
		
		sillaG17 = new JCheckBox("");
		sillaG17.setBounds(352, 170, 21, 12);
		this.add(sillaG17);
		
		sillaG18 = new JCheckBox("");
		sillaG18.setBounds(403, 170, 21, 12);
		this.add(sillaG18);
		
		sillaG19 = new JCheckBox("");
		sillaG19.setBounds(454, 170, 21, 12);
		this.add(sillaG19);
		
		sillaG20 = new JCheckBox("");
		sillaG20.setBounds(506, 170, 21, 12);
		this.add(sillaG20);
		
		sillaG21 = new JCheckBox("");
		sillaG21.setBounds(43, 134, 21, 12);;
		this.add(sillaG21);
		
		sillaG22 = new JCheckBox("");
		sillaG22.setBounds(95, 134, 21, 12);
		this.add(sillaG22);
		
		sillaG23 = new JCheckBox("");
		sillaG23.setBounds(146, 134, 21, 12);
		this.add(sillaG23);
		
		sillaG24 = new JCheckBox("");
		sillaG24.setBounds(197, 134, 21, 12);
		this.add(sillaG24);
		
		sillaG25 = new JCheckBox("");
		sillaG25.setBounds(248, 134, 21, 12);
		this.add(sillaG25);
		
		sillaG26 = new JCheckBox("");
		sillaG26.setBounds(300, 134, 21, 12);
		this.add(sillaG26);
		
		sillaG27 = new JCheckBox("");
		sillaG27.setBounds(352, 134, 21, 12);
		this.add(sillaG27);
		
		sillaG28 = new JCheckBox("");
		sillaG28.setBounds(403, 134, 21, 12);
		this.add(sillaG28);
		
		sillaG29 = new JCheckBox("");
		sillaG29.setBounds(454, 134, 21, 12);
		this.add(sillaG29);
		
		sillaG30 = new JCheckBox("");
		sillaG30.setBounds(506, 134, 21, 12);
		this.add(sillaG30);
		
		sillaG31 = new JCheckBox("");
		sillaG31.setBounds(43, 100, 21, 12);;
		this.add(sillaG31);
		
		sillaG32 = new JCheckBox("");
		sillaG32.setBounds(95, 100, 21, 12);
		this.add(sillaG32);
		
		sillaG33 = new JCheckBox("");
		sillaG33.setBounds(146, 100, 21, 12);
		this.add(sillaG33);
		
		sillaG34 = new JCheckBox("");
		sillaG34.setBounds(197, 100, 21, 12);
		this.add(sillaG34);
		
		sillaG35 = new JCheckBox("");
		sillaG35.setBounds(248, 100, 21, 12);
		this.add(sillaG35);
		
		sillaG36 = new JCheckBox("");
		sillaG36.setBounds(300, 100, 21, 12);
		this.add(sillaG36);
		
		sillaG37 = new JCheckBox("");
		sillaG37.setBounds(352, 100, 21, 12);
		this.add(sillaG37);
		
		sillaG38 = new JCheckBox("");
		sillaG38.setBounds(403, 100, 21, 12);
		this.add(sillaG38);
		
		sillaG39 = new JCheckBox("");
		sillaG39.setBounds(454, 100, 21, 12);
		this.add(sillaG39);
		
		sillaG40 = new JCheckBox("");
		sillaG40.setBounds(506, 100, 21, 12);
		this.add(sillaG40);
		
		sillaP1 = new JCheckBox("");
		sillaP1.setBounds(44, 68, 21, 12);;
		this.add(sillaP1);
		
		sillaP2 = new JCheckBox("");
		sillaP2.setBounds(95, 68, 21, 12);;
		this.add(sillaP2);
		
		sillaP3 = new JCheckBox("");
		sillaP3.setBounds(146, 68, 21, 12);;
		this.add(sillaP3);
		
		sillaP4 = new JCheckBox("");
		sillaP4.setBounds(197, 68, 21, 12);;
		this.add(sillaP4);
		
		sillaP5 = new JCheckBox("");
		sillaP5.setBounds(248, 68, 21, 12);;
		this.add(sillaP5);
		
		sillaP6 = new JCheckBox("");
		sillaP6.setBounds(300, 68, 21, 12);;
		this.add(sillaP6);
		
		sillaP7 = new JCheckBox("");
		sillaP7.setBounds(352, 68, 21, 12);;
		this.add(sillaP7);
		
		sillaP8 = new JCheckBox("");
		sillaP8.setBounds(403, 68, 21, 12);;
		this.add(sillaP8);
		
		sillaP9 = new JCheckBox("");
		sillaP9.setBounds(455, 68, 21, 12);;
		this.add(sillaP9);
		
		sillaP10 = new JCheckBox("");
		sillaP10.setBounds(506, 68, 21, 12);;
		this.add(sillaP10);
		
		sillaP11 = new JCheckBox("");
		sillaP11.setBounds(44, 36, 21, 12);;
		this.add(sillaP11);
		
		sillaP12 = new JCheckBox("");
		sillaP12.setBounds(95, 36, 21, 12);;
		this.add(sillaP12);
		
		sillaP13 = new JCheckBox("");
		sillaP13.setBounds(146, 36, 21, 12);;
		this.add(sillaP13);
		
		sillaP14 = new JCheckBox("");
		sillaP14.setBounds(197, 36, 21, 12);;
		this.add(sillaP14);
		
		sillaP15 = new JCheckBox("");
		sillaP15.setBounds(248, 36, 21, 12);;
		this.add(sillaP15);
		
		sillaP16 = new JCheckBox("");
		sillaP16.setBounds(300, 36, 21, 12);;
		this.add(sillaP16);
		
		sillaP17 = new JCheckBox("");
		sillaP17.setBounds(352, 36, 21, 12);;
		this.add(sillaP17);
		
		sillaP18 = new JCheckBox("");
		sillaP18.setBounds(403, 36, 21, 12);;
		this.add(sillaP18);
		
		sillaP19 = new JCheckBox("");
		sillaP19.setBounds(455, 36, 21, 12);;
		this.add(sillaP19);
		
		sillaP20 = new JCheckBox("");
		sillaP20.setBounds(506, 36, 21, 12);;
		this.add(sillaP20);
		
		sillasG = new JCheckBox[] {sillaG1, sillaG2, sillaG3,sillaG4, sillaG5, sillaG6, sillaG7, sillaG8, sillaG9, sillaG10,
				sillaG11, sillaG12, sillaG13,sillaG14, sillaG15, sillaG16, sillaG17, sillaG18, sillaG19, sillaG20,
				sillaG21, sillaG22, sillaG23,sillaG24, sillaG25, sillaG26, sillaG27, sillaG28, sillaG29, sillaG30,
				sillaG31, sillaG32, sillaG33,sillaG34, sillaG35, sillaG36, sillaG37, sillaG38, sillaG39, sillaG40};
		
	
		sillasP = new JCheckBox[] {	sillaP1, sillaP2, sillaP3,sillaP4, sillaP5, sillaP6, sillaP7, sillaP8, sillaP9, sillaP10,
				sillaP11, sillaP12, sillaP13,sillaP14, sillaP15, sillaP16, sillaP17, sillaP18, sillaP19, sillaP20};
		
	}
	public void paint(Graphics g) {
		
		g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);

		setOpaque(false);
		super.paint(g);
		
	}
	
	public JCheckBox[] getSillasG() {
		return sillasG;
	}

	public JCheckBox[] getSillasP() {
		return sillasP;
	}

}
