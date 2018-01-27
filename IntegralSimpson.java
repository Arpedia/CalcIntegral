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
public class IntegralSimpson {
    
    private double start;
    private double end;
    
    public IntegralSimpson(){
        this.start = 0.0;
        this.end = 1.0;
    }
    
    private double func(double x){
        double ans = Math.pow(1.0 - x*x, 0.5);
        return ans;
    }
    
    private double run(double a, double b){
        double pivot = (a + b) / 2;
        return ((b - a) * (this.func(a) + 4.0 * this.func(pivot) + this.func(b))) / 6.0;
    }
    
    public double setDiv(double count){
        double div = (this.start + this.end) / count;
        double ans = 0;
        for(int i = 0; i < count ; i++){
            ans += this.run(div * i, div * (i+1));
        }
        return ans;
    }
    
    
}
