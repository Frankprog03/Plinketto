/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package f03.plinko.plots;

import f03.plinko.interfaccia;

/**
 *
 * @author GABRIELE MARIA
 */
public class Gauss implements interfaccia{
    double media, varianza;

    public double getMedia() {
        return media;
    }

    public double getVarianza() {
        return varianza;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public void setVarianza(double varianza) {
        this.varianza = varianza;
    }

    @Override
    public double calcola(int x) {
        return (1/(varianza*Math.sqrt(2*Math.PI)))*Math.exp(-0.5*((x-media)/varianza)*((x-media)/varianza));
    }
    
}
