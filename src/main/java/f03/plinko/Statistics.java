package f03.plinko;

import java.util.ArrayList;

/**
 *
 * @author GABRIELE MARIA
 */
public class Statistics {
    public static double media(int P[]){
        int num=0,c=1;
        double den=0;
        for (int b : P) {
            num=num+b*c;
            den=den+b;
            c++;
        }
        return num/den;
    }
    public static double varianza(int P[], double media){
        double num=0,den=0;
        for (int i=0;i<P.length;i++){
            num=num+(P[i]*(media-i)*(media-i));
            den=den+P[i];
        }
        return Math.sqrt(num/den);
    }
}
