package f03.plinko;

/**
 *
 * @author GABRIELE MARIA
 */
public class Statistics {
    
    public static double mean(int P[]){
        int num=0, c=1;
        double den=0;
        
        for (int b : P) {
            num=num+b*c;
            den=den+b;
            c++;
        }
        
        return num/den;
    }
    
    /*public static double meanmean(int P[]){
        int num=0, c=0;
        double den=0;
        
        for (int b : P) {
            num=num+b*c;
            den=den+b;
            c++;
        }
        
        return num/den;
    }*/
    
    public static double stdev(int P[], double mean){
        double num=0, den=0;
        
        for (int i=0;i<P.length;i++){
            num=num+(P[i]*(mean-i-1)*(mean-i-1));
            den=den+P[i];
        }
        
        return Math.sqrt(num/den);
    }
    
    public static double corstdev(int P[], double mean){
        double num=0, den=0;
        
        for (int i=0;i<P.length;i++){
            num=num+(P[i]*(mean-i-1)*(mean-i-1));
            den=den+P[i];
        }
        
        return Math.sqrt(num/(den-1));
    }
}
