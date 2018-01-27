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
public class PhisicsFunc {
    
    private double const1;
    private double const2;
    private double mass;
    private double Gravity = 9.80665;
    private double AirResist;
    
    public PhisicsFunc(double m, double k, double v0){
        this.mass = m;
        this.AirResist = k;
        this.const1 = v0 - m * this.Gravity / this.AirResist;
        this.const2 = m / this.AirResist * this.const1;
    }
    
    public double f(double x){
        return this.const1 * Math.exp( -1 * this.AirResist / this.mass * x) + this.mass * this.Gravity / this.AirResist;
    }
    
    private double run(double a, double b){
        double pivot = (a + b) / 2;
        return ((b - a) * (this.f(a) + 4.0 * this.f(pivot) + this.f(b))) / 6.0;
    }
    
    public double getAnsSimp(double t,int count){
        double div = t / count;
        double ans = 0;
        for(int i = 0; i < count ; i++){
            double a = div * i;
            double b = div * (i + 1);
            if(b > t)
                b = t;
            ans += this.run(a, b);
        }
        return ans;
    }
    
    public double getAns(double t, int count){
        double width = t /(double)count;
        double ans=0;
        for(int i = 0; i<count; i++){
            if(width*(i+1) > t){
                ans += (f(width*i) + f(t)) * (t - width*i) * 0.5;
            }else{
                ans += (f(width * i) + f(width*(i+1))) * width * 0.5;
            }
        }
        return ans;
    }
    
    public double theoryValue(double t){
        double D1 = (-1) * this.mass / this.AirResist * this.const1 * Math.exp( -1 * this.AirResist / this.mass * t);//第一項
        double D2 = this.mass * this.Gravity / this.AirResist * t;                                                   //第二項
        double D3 = this.const2;                                                                                     //第三項
        return D1 + D2 + D3;
    }
    
    
}
