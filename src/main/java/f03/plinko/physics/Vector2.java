package f03.plinko.physics;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import static java.lang.Math.*;

/**
 *
 * @author Sollazzi
 */
public class Vector2 {
    public double x, y;
    
    public static final Vector2 VERSOR_X = new Vector2(1, 0);
    public static final Vector2 VERSOR_Y = new Vector2(0, 1);
    
    public Vector2(double x, double y){
        this.x = x;
        this.y = y;
    }
    
    public Vector2(Vector2 v){
        x = v.x;
        y = v.y;
    }

    public Vector2() {
        this(0, 0);
    }
    
    public Vector2 cpy(){
        return new Vector2(this);
    }
    
    public void set(double x, double y){
        this.x = x;
        this.y = y;
    }
    
    public void set(Vector2 v){
        x = v.x;
        y = v.y;
    }
    
    public double getX(){
        return x;
    }
    
    public double getY(){
        return y;
    }
    
    public Vector2 addLocal(Vector2 v){
        x += v.x;
        y += v.y;
        
        return this;
    }
    
    public Vector2 addLocal(double x, double y){
        this.x += x;
        this.y += y;
        
        return this;
    }
    
    public Vector2 add(Vector2 v){
        return cpy().addLocal(v);
    }
    
    public Vector2 add(double x, double y){
        return cpy().addLocal(x, y);
    }
    
    public Vector2 subLocal(Vector2 v){
        x -= v.x;
        y -= v.y;
        
        return this;
    }
    
    public Vector2 subLocal(double x, double y){
        this.x -= x;
        this.y -= y;
        
        return this;
    }
    
    public Vector2 sub(Vector2 v){
        return cpy().subLocal(v);
    }
    
    public Vector2 sub(double x, double y){
        return cpy().subLocal(x, y);
    }
    
    public Vector2 scaleLocal(double f){
        x *= f;
        y *= f;
        
        return this;
    }
    
    public Vector2 scale(double f){
        return cpy().scaleLocal(f);
    }
    
    public double dot(Vector2 v){
        return x*v.x + y*v.y;
    }
    
    public double cross(Vector2 v){
        return x*v.y - y*v.x;
    }

    public void cross(double a, Vector2 v) {
        x = -a * v.y;
        y = a * v.x;
    }
    
    public void conj(){
        y = -y;
    }
    
    public double length(){
        return sqrt(x*x + y*y);
    }
    
    public Vector2 norm(){
        scaleLocal(1.0/length());
        
        return this;
    }
    
    public Vector2 opposite(){
        return new Vector2(-x, -y);
    }
    
    public void zero(){
        set(0, 0);
    }
    
    public boolean isValid(){
        return Double.isFinite(x) && Double.isFinite(y);
    }
    
    public double angleBetween(Vector2 oth){
        double angle = Math.atan2(cross(oth), dot(oth));
        
        if(angle >= PI) angle -= 2.0*PI;
        
        return angle;
    }
    
    public double angleWithX(){
        return angleBetween(VERSOR_X);// % (PI / 2.0);
    }
    
    public double angleWithY(){
        return angleBetween(VERSOR_Y);// % (PI / 2.0);
    }
    
    @Override
    public String toString(){
        return "Vector2[x: " + x + ", y: " + y + "]";
    }
    
    public void debugDraw(double x, double y, Graphics2D g){
        Graphics2D g0 = (Graphics2D) g.create();
        g0.translate(x, y);
        g0.setColor(Color.red);
        Line2D.Double v = new Line2D.Double(0, 0, this.x, this.y);
        g0.draw(v);
        g0.dispose();
    }
    
    public static Vector2 getInvalidVector(){
        return new Vector2(Double.NaN, Double.NaN);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + (int) (Double.doubleToLongBits(this.x) ^ (Double.doubleToLongBits(this.x) >>> 32));
        hash = 23 * hash + (int) (Double.doubleToLongBits(this.y) ^ (Double.doubleToLongBits(this.y) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vector2 other = (Vector2) obj;
        if (Double.doubleToLongBits(this.x) != Double.doubleToLongBits(other.x)) {
            return false;
        }
        return Double.doubleToLongBits(this.y) == Double.doubleToLongBits(other.y);
    }
}
