/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testapplication;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * @author leo
 */
public class TestApplication {
    static List<Map<String, String>> list = new ArrayList();
    static Map<String, String> items;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        timeTool(1457077460000L);

        linkedList();
    }
    
    public static void getData(){
        items = new HashMap();
        items.put("id", "1");
        items.put("title", "中國");
        list.add(items);
        
        items = new HashMap();
        items.put("id", "2");
        items.put("title", "日本");
        list.add(items);
        
        items = new HashMap();
        items.put("id", "3");
        items.put("title", "美國");
        list.add(items);
        
//        System.out.println(list.size());
        
        for( Map it : list ){
            System.out.println(it.get("title"));
            System.out.println(it.get("id"));
        }
    }
    
    private static final Long MIN = 60*1000L;
    private static final Long HOUR = 60*MIN;
    private static final Long DAY = 24*HOUR;
    private static final Long WEEK = 7*DAY;
    private static final Long MONTH = 30*DAY;
    private static final Long YEAR = 365*DAY;
    public static String timeTool(Long input){
        System.out.println( (new Date(0)) );
        System.out.println( new Date(input) );
        System.out.println( new Date() );

        Long deltaTime = (new Date()).getTime() - new Date(input).getTime();

        if ( deltaTime < MIN ){
            return "just now";
        }else if ( deltaTime < HOUR ){
            return "before " + deltaTime/MIN+ " min(s)";
        }else if ( deltaTime < DAY ){
            return "before " + deltaTime/HOUR + " hour(s)";
        }else if ( deltaTime < WEEK ){
            return "before " + deltaTime/DAY + " day(s)";
        }else if ( deltaTime < MONTH ){
            return "before " + deltaTime/WEEK + " week(es)";
        }else if ( deltaTime < YEAR ){
            return "before " + deltaTime/MONTH + " month(s)";
        }else if ( deltaTime > YEAR ){
            return "before " + deltaTime/YEAR + " year(s)";
        }else{
            return "error";
        }
    }
    public static String timeTool(String input){
        return timeTool( Long.parseLong(input) );
    }
    
    public static void  printMap(Map<String, Object> map){
        for(Map.Entry entry : map.entrySet()){
            System.out.println( entry.getKey() + ":\n" + entry.getValue().getClass().getName() + ":" + entry.getValue()  );
        }
    }
    
    public static void linkedList(){
        LinkedList ll = new LinkedList();
        ll.add("one");
        ll.add("two");
        ll.add("three");
        ll.add("four");
        
        ll.remove("two");
        System.out.println(ll.contains("two"));
        for( Object item : ll ){
            System.out.println(item.toString());
        }
    }
    
}
