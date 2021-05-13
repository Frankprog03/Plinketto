package f03.plinko.math;

import static java.lang.Math.*;

/**
 *
 * @author Sollazzi
 */
public class Gaussian implements Function{
    private double var;
    private double mean;
    
    private static final double SQRT_2PI = sqrt(2.0*PI);
    
    public Gaussian(double var, double mean){
        this.var = var;
        this.mean = mean;
    }
    
    @Override
    public double eval(double x) {
        double A = 1.0/(var*SQRT_2PI);
        double B = (x-mean)/var;
        double exp = -B*B/2.0;
        
        return A*exp(exp);
    }
    
    public void setStandardDeviation(double var){
        this.var = var;
    }
    
    public void setMean(double mean){
        this.mean = mean;
    }
    
    public double getStandardDeviation(){
        return var;
    }
    
    public double getMean(){
        return mean;
    }
}
