/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package f03.plinko;

/**
 *
 * @author GABRIELE MARIA
 */
public class Bidoncino {
    private int npalline;
    private int i; //numero del bidoncino
    public int getNpalline() {
        return npalline;
    }
    public void setNpalline(int npalline) {
        this.npalline = npalline;
    }
    public int getI() {
        return i;
    }
    public void setI(int i) {
        this.i = i;
    }
    public void aggiungipallina(){npalline++;}
}
