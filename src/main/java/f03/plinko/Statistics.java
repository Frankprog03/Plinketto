package f03.plinko;

import java.util.ArrayList;

/**
 *
 * @author GABRIELE MARIA
 */
public class Statistics {
    public static double media(ArrayList<Bidoncino> lista){
        int num=0,c=1;
        double den=0;
        for (Bidoncino b : lista) {
            num=num+b.getNpalline()*c;
            den=den+b.getNpalline();
            c++;
        }
        return num/den;
    }
    public static double varianza(ArrayList<Bidoncino> lista, double media){
        /*double num=0,den=0;
        for (Bidoncino b : lista){
            num=num+(b.getNpalline()*(media-b.getI())*(media-b.getI()));
            den=den+b.getNpalline();
        }
        return Math.sqrt(num/den);*/
        return 0;
    }
}
