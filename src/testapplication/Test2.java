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
public class Test2 {
    
    public static void main(String[] args){
        updateFANTextView(S_REDUCE, "1");
    }
    
    private static float S_ADD = 1;
    private static float S_REDUCE = -1;
    
    private static void updateFANTextView(float state, String textValue){
        float value = Float.parseFloat(textValue);
        if ( value == 8 && state == S_ADD ){return;}
	if ( value == 0 && state == S_REDUCE ){return;}
        if ( value >= 1 && state == S_ADD ){
            System.out.println(value+state/2);
        }else if ( value >= 0 && state == S_ADD ){
            System.out.println(value+state);
        }else if ( value == 1 && state == S_REDUCE ){
            System.out.println(value+state);
        }
        
        if ( state == S_ADD ) {
            if ( value >= 1 ){
                System.out.println(value+state/2);
            }else if( value >= 0 ){
                System.out.println(value+state);
            }
        }else if( state == S_REDUCE ){
            if ( value > 1 ){
                System.out.println(value+state/2);
            }else if( value == 1 ){
                System.out.println(value+state);
            }
        }
    }

    private static void updateHEATTextView(float state, String textValue){
        float value = Float.parseFloat(textValue);
        if ( value == 10 && state == S_ADD ){return;}
        if ( value == 0 && state == S_REDUCE ){return;}
        System.out.println(value+state/2);
    }
    
}
