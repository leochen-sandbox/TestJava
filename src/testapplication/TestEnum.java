/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testapplication;


/**
 *
 * @author leo
 */
public class TestEnum {
    
    public static enum DayEnum {SUNDAY, MONDAY, TUESDAY, WEDNESDAY,THURSDAY, FRIDAY, SATURDAY }
    
    public static void main(String[] args){
        tellItLikeItIs( DayEnum.WEDNESDAY );
    }
    
    public static void tellItLikeItIs(DayEnum day) {
        switch (day) {
            case MONDAY: 
                System.out.println("Mondays are bad.");
                break;
            case FRIDAY:
                System.out.println("Fridays are better.");
                break;  
            case SATURDAY: case SUNDAY:
                System.out.println("Weekends are best.");
                break;  
            default:
                System.out.println("Midweek days are so-so.");
                break;
        }
    }
    
}
