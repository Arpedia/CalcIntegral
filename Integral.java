package ex6;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author plane
 */
public class Integral {
    
    private double min;
    private double max;
    
    public Integral(){
        this.min = 0.0;
        this.max = 1.0;
    }
    
    private double func(double x){
        double ans = Math.pow(this.max - x*x, 0.5);
        return ans;
    }
    
    private double calc(int count){
        double width = (this.max-this.min)/(double)count;
        double ans=0;
        for(int i = 0; i<count; i++){
            if(width*(i+1) > 1){
                ans += (func(width*i) + func(this.max)) * (this.max - width*i) * 0.5;
            }else{
                ans += (func(width * i) + func(width*(i+1))) * width * 0.5;
            }
        }
        return ans;
    }
    
    public double setDiv(int count){
        return this.calc(count);
    }
}
