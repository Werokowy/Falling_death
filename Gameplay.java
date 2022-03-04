package com.company;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Gameplay extends JPanel implements KeyListener, ActionListener {
  private int xgracza = 376;
  
  private int punkty = 0;
  
  public int sekundy = 0;
  
  public int minuty = 0;
  
  public int godziny = 0;
  
  private boolean jestpauza = false;
  
  private Timer time;
  
  private Timer czas;
  
  private int speed = 23;
  
  private int ex = 10;
  
  private String przegr = "";
  
  private int espeed = 4;
  
  private int ey = 10;
  
  private Random rn = new Random();
  
  private int wrogx1 = this.rn.nextInt(8) * 100;
  
  private int wrogx2 = this.rn.nextInt(8) * 100;
  
  private int wrogx3 = this.rn.nextInt(8) * 100;
  
  public Gameplay() {
    this.time = new Timer(10, this);
    this.time.start();
    setFocusable(true);
    setFocusTraversalKeysEnabled(false);
    addKeyListener(this);
  }
  
  public void paint(Graphics g) {
    g.setColor(Color.blue);
    g.fillRect(0, 0, 800, 600);
    g.setColor(Color.BLACK);
    g.fillRect(this.xgracza, 500, 75, 76);
    g.setColor(Color.red);
    g.fillRect(this.wrogx1, this.ey, 100, 100);
    g.fillRect(this.wrogx2, this.ey, 100, 100);
    g.fillRect(this.wrogx3, this.ey, 100, 100);
    g.setColor(Color.white);
    g.setFont(new Font("serif", 1, 20));
    g.drawString("Punkty: " + this.punkty, 570, 20);
    g.setColor(Color.white);
    g.setFont(new Font("serif", 1, 20));
    g.drawString(this.przegr, 4, 20);
  }
  
  public void actionPerformed(ActionEvent e) {
    repaint();
    this.ey += this.espeed;
    if (this.punkty == 10 || (this.punkty > 10 && this.punkty < 20))
      this.espeed = 6; 
    if (this.punkty == 20 || (this.punkty > 20 && this.punkty < 30)) {
      this.espeed = 8;
      this.speed = 15;
    } 
    if (this.punkty == 30 || (this.punkty > 30 && this.punkty < 40)) {
      this.espeed = 10;
      this.speed = 12;
    } 
    if (this.punkty == 40 || (this.punkty > 40 && this.punkty < 50)) {
      this.espeed = 12;
      this.speed = 10;
    } 
    if (this.punkty == 50 || (this.punkty > 50 && this.punkty < 60)) {
      this.espeed = 14;
      this.speed = 8;
    } 
    if (this.punkty == 60 || (this.punkty > 60 && this.punkty < 70)) {
      this.espeed = 18;
      this.speed = 9;
    } 
    if (this.punkty == 70 || (this.punkty > 70 && this.punkty < 80)) {
      this.espeed = 18;
      this.speed = 9;
    } 
    if (this.punkty == 80 || (this.punkty > 80 && this.punkty < 90)) {
      this.espeed = 18;
      this.speed = 9;
    } 
    if (this.punkty == 90 || (this.punkty > 90 && this.punkty < 100)) {
      this.espeed = 18;
      this.speed = 9;
    } 
    if (this.punkty == 100) {
      this.espeed = 20;
      this.speed = 15;
    } 
    if (this.ey == 499 || this.ey > 499) {
      this.punkty++;
      this.ey = 10;
      this.wrogx1 = this.rn.nextInt(8) * 100;
      this.wrogx2 = this.rn.nextInt(8) * 100;
      this.wrogx3 = this.rn.nextInt(8) * 100;
    } 
    Rectangle gracz = new Rectangle(this.xgracza, 500, 75, 75);
    Rectangle wrog1 = new Rectangle(this.wrogx1, this.ey, 100, 100);
    Rectangle wrog2 = new Rectangle(this.wrogx2, this.ey, 100, 100);
    Rectangle wrog3 = new Rectangle(this.wrogx3, this.ey, 100, 100);
    if (gracz.intersects(wrog1) || gracz.intersects(wrog2) || gracz.intersects(wrog3)) {
      this.time.stop();
      this.przegr = "NaciEnter aby wznowigr;
      this.espeed = 4;
      this.speed = 23;
    } 
  }
  
  public void keyTyped(KeyEvent e) {}
  
  public void keyPressed(KeyEvent e) {
    if (e.getKeyCode() == 65)
      if (this.xgracza == -4 || this.xgracza < -4) {
        this.xgracza = -4;
      } else {
        this.xgracza -= this.speed;
      }  
    if (e.getKeyCode() == 68)
      if (this.xgracza == 716 || this.xgracza > 716) {
        this.xgracza = 726;
      } else if (this.xgracza == 726) {
        this.xgracza = 726;
      } else {
        this.xgracza += this.speed;
      }  
    if (e.getKeyCode() == 10)
      reset(); 
  }
  
  private void reset() {
    this.ey = 10;
    this.espeed = 4;
    this.speed = 23;
    this.punkty = 0;
    this.wrogx1 = this.rn.nextInt(8) * 100;
    this.wrogx2 = this.rn.nextInt(8) * 100;
    this.wrogx3 = this.rn.nextInt(8) * 100;
    this.xgracza = 376;
    this.przegr = "";
    this.time.start();
  }
  
  public void keyReleased(KeyEvent e) {}
}
