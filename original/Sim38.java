import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.EOFException;
import java.awt.Color;
import java.io.InputStream;
import java.awt.Graphics;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.awt.Font;
import java.applet.Applet;

// 
// Decompiled by Procyon v0.5.36
// 

public class Sim38 extends Applet
{
    Font f1;
    Font f2;
    Font f3;
    Font f4;
    FileInputStream FileR;
    FileInputStream FileW;
    FileInputStream FileQ;
    DataInputStream DataR;
    DataInputStream DataW;
    DataInputStream DataQ;
    double xtest;
    double max;
    double x2;
    double[] qs;
    double[] qd;
    int itest;
    int i2;
    int i3;
    int[] xa;
    int[] ya;
    int[] xs;
    int[] ys;
    int[][] yw;
    int[] yqs;
    int[] yqd;
    int i;
    int j;
    String stest;
    String s2;
    char[] b;
    char[] b2;
    char[] b3;
    
    public void init() {
        this.f1 = new Font("Helvetica", 0, 18);
        this.f2 = new Font("TimesRoman", 0, 18);
        this.f3 = new Font("Helvetica", 0, 12);
        this.f4 = new Font("TimesRoman", 0, 12);
    }
    
    public void paint(final Graphics graphics) {
        this.xa = new int[600];
        this.ya = new int[600];
        this.xs = new int[600];
        this.ys = new int[600];
        this.yw = new int[20][600];
        this.b = new char[7];
        this.b2 = new char[7];
        this.b3 = new char[7];
        this.yqs = new int[90];
        this.yqd = new int[90];
        this.qs = new double[90];
        this.qd = new double[90];
        try {
            this.FileR = new FileInputStream("rout.dat.38");
            this.DataR = new DataInputStream(this.FileR);
            this.FileW = new FileInputStream("wout.dat.38");
            this.DataW = new DataInputStream(this.FileW);
            this.FileQ = new FileInputStream("qout.dat.38");
            this.DataQ = new DataInputStream(this.FileQ);
            try {
                while (this.DataR.readLine() != null) {
                    this.DataW.readLine();
                    graphics.setFont(this.f2);
                    graphics.drawString("Rate", 30, 20);
                    graphics.drawString("Supply and Demand", 30, 300);
                    graphics.drawString("Weights of Factors", 200, 300);
                    graphics.setColor(Color.white);
                    graphics.fillRect(25, 25, 630, 250);
                    graphics.fillRect(25, 305, 150, 150);
                    graphics.fillRect(195, 305, 400, 150);
                    graphics.setColor(Color.black);
                    graphics.drawLine(195, 380, 595, 380);
                    graphics.drawLine(100, 305, 100, 455);
                    graphics.drawRect(25, 25, 630, 250);
                    graphics.drawRect(25, 305, 150, 150);
                    graphics.drawRect(195, 305, 400, 150);
                    this.i = 0;
                    while (this.i < 27) {
                        graphics.drawLine(25 + this.i * 24, 270, 25 + this.i * 24, 275);
                        ++this.i;
                    }
                    graphics.setFont(this.f4);
                    graphics.drawString("94", 27, 265);
                    graphics.drawString("95", 339, 265);
                    this.i = 1;
                    while (this.i < 18) {
                        graphics.drawString(this.stest = String.valueOf(this.i), 205 + (this.i - 1) * 23, 465);
                        ++this.i;
                    }
                    this.i = 313;
                    while (this.i < 416) {
                        this.DataR.readLine();
                        this.DataW.readLine();
                        ++this.i;
                    }
                    graphics.setColor(Color.red);
                    this.i = 416;
                    while (this.i < 522) {
                        this.stest = this.DataR.readLine();
                        if (this.stest != null) {
                            this.stest.getChars(12, 19, this.b, 0);
                            this.s2 = String.valueOf(this.b);
                            this.xtest = Double.valueOf(this.s2);
                            this.ya[this.i] = (int)(250.0 - (this.xtest - 4.42) / 0.00133333);
                            this.xa[this.i] = 25 + (this.i - 416) * 6;
                            this.stest.getChars(4, 11, this.b, 0);
                            this.s2 = String.valueOf(this.b);
                            this.xtest = Double.valueOf(this.s2);
                            this.ys[this.i] = (int)(250.0 - (this.xtest - 4.42) / 0.00133333);
                            this.xs[this.i] = this.xa[this.i];
                        }
                        this.stest = this.DataW.readLine();
                        if (this.stest != null) {
                            this.i2 = 0;
                            this.j = 0;
                            while (this.j < 17) {
                                this.itest = this.stest.indexOf("\t", this.i2 + 1);
                                this.i2 = this.stest.indexOf("\t", this.itest + 1);
                                this.stest.getChars(this.itest + 1, this.i2, this.b2, 0);
                                this.s2 = String.valueOf(this.b2);
                                this.xtest = Double.valueOf(this.s2);
                                this.yw[this.j][this.i] = (int)(this.xtest * 25.0);
                                ++this.j;
                            }
                        }
                        ++this.i;
                    }
                    this.i = 417;
                    while (this.i < 522) {
                        graphics.drawLine(this.xa[this.i - 1], this.ya[this.i - 1], this.xa[this.i], this.ya[this.i]);
                        ++this.i;
                    }
                    this.DataQ.readLine();
                    this.i = 417;
                    while (this.i < 522) {
                        graphics.setColor(Color.blue);
                        graphics.drawLine(this.xs[this.i - 1], this.ys[this.i - 1], this.xs[this.i], this.ys[this.i]);
                        graphics.setColor(Color.white);
                        graphics.fillRect(195, 305, 400, 150);
                        graphics.setColor(Color.black);
                        graphics.drawLine(195, 380, 595, 380);
                        graphics.drawRect(195, 305, 400, 150);
                        this.j = 0;
                        while (this.j < 17) {
                            if (this.yw[this.j][this.i] > 0) {
                                graphics.setColor(Color.red);
                                graphics.fillRect(201 + this.j * 23, 380 - this.yw[this.j][this.i], 20, this.yw[this.j][this.i]);
                            }
                            else {
                                graphics.setColor(Color.blue);
                                graphics.fillRect(201 + this.j * 23, 380, 20, -this.yw[this.j][this.i]);
                            }
                            ++this.j;
                        }
                        graphics.setColor(Color.white);
                        graphics.fillRect(25, 305, 150, 150);
                        graphics.setColor(Color.black);
                        graphics.drawLine(100, 305, 100, 455);
                        graphics.drawRect(25, 305, 150, 150);
                        this.j = 0;
                        while (this.j < 81) {
                            this.stest = this.DataQ.readLine();
                            if (this.stest != null) {
                                this.stest.getChars(0, 7, this.b3, 0);
                                this.s2 = String.valueOf(this.b3);
                                this.qs[this.j] = Double.valueOf(this.s2);
                                this.stest.getChars(9, 15, this.b3, 0);
                                this.s2 = String.valueOf(this.b3);
                                this.qd[this.j] = Double.valueOf(this.s2);
                            }
                            ++this.j;
                        }
                        this.DataQ.readLine();
                        if (this.qs[80] > this.qd[0]) {
                            this.max = this.qs[80];
                        }
                        else {
                            this.max = this.qd[0];
                        }
                        if (this.max < 7.0) {
                            this.max = 7.0;
                        }
                        this.j = 0;
                        while (this.j < 81) {
                            this.yqs[this.j] = (int)(455.0 - this.qs[this.j] / this.max * 145.0);
                            this.yqd[this.j] = (int)(455.0 - this.qd[this.j] / this.max * 145.0);
                            ++this.j;
                        }
                        this.j = 3;
                        while (this.j < 78) {
                            graphics.setColor(Color.red);
                            graphics.drawLine(19 + this.j * 2, this.yqs[this.j], 21 + this.j * 2, this.yqs[this.j + 1]);
                            graphics.setColor(Color.blue);
                            graphics.drawLine(19 + this.j * 2, this.yqd[this.j], 21 + this.j * 2, this.yqd[this.j + 1]);
                            ++this.j;
                        }
                        this.j = 0;
                        while (this.j < 5000) {
                            graphics.setColor(Color.black);
                            graphics.drawLine(195, 380, 595, 380);
                            ++this.j;
                        }
                        ++this.i;
                    }
                }
            }
            catch (EOFException ex) {
                System.out.println("Reached EOF");
            }
            catch (IOException ex2) {
                System.err.println("IO Error");
                System.exit(1);
            }
            finally {
                this.FileR.close();
                this.FileW.close();
                this.FileQ.close();
            }
        }
        catch (FileNotFoundException ex3) {
            System.err.println("Opening error");
            System.exit(1);
        }
        catch (IOException ex4) {
            System.err.println("Closing Error");
            System.exit(1);
        }
    }
}
