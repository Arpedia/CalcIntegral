/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex6;

/**
 *
 * @author plane
 */
public class CubicFunc {
    private double a;
    private double b;
    private double c;
    private double d;
    private double max;
    private double width;
    
    public CubicFunc(double a, double b, double c, double d){
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    public String getFunction(){
        String equation = "";
        if(this.a != 0)
            equation += this.a + "x^3 + ";
        if(this.b != 0)
            equation += this.b + "x^2 + ";
        if(this.c != 0)
            equation += this.c + "x + ";
        if(this.d != 0)
            equation += this.d + " + ";
        
        if(equation != null && equation.length() > 0)
            equation = equation.substring(0, equation.length() - 2 );
        else
            equation = "0";
        return equation;       
    }
    
    public double function(double x){
        return (this.a * Math.pow(x, 3)) + (this.b * x * x) + (this.c * x) + this.d;
    }
    
    public double dfunction(double x){
        return (3 * this.a * Math.pow(x, 2)) + (2 * this.b * x) + this.c;
    }
    
    public double Integrate1(double min, double max, int div){
        this.max = max;
        this.width = (max - min) / div;
        return rowTrapezoid(min, 0);        
    }
    
    public double rowTrapezoid(double p, double ans){
        double q = p + this.width;
        if ( q > this.max )
            return ans + (function(p) + function(this.max)) * (this.max - p) * 0.5;
        
        double area = (function(p) + function(q)) * this.width * 0.5;
        
        return this.rowTrapezoid(q, ans + area);        
    }
    
}
