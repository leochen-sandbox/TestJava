/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testapplication;

import java.text.DecimalFormat;
import java.util.HashMap;

/**
 *
 * @author leo
 */
public class Test1 {
    
    public static void main(String[] args){
//        HashMap<String, Object> map = new HashMap();
//        map.put("data", "123");
//        map.put("type", "all");
//        map.put("locationId", 123);
//        System.out.println( APISelector( TYPE.LOCATION, ACTION_LOCATION.GET_LOCATION_DETAIL, map) );

       System.out.println(gps2d(31.21409463,121.3725772,31.226091,121.43549));
       System.out.println(getShortDistance(31.226080,121.43548,31.226091,121.43549));
    }
    
    static private double gps2d(double lat_a, double lng_a, double lat_b, double lng_b) {
        double d = 0;
        lat_a=lat_a*Math.PI/180;
        lng_a=lng_a*Math.PI/180;
        lat_b=lat_b*Math.PI/180;
        lng_b=lng_b*Math.PI/180;

        d=Math.sin(lat_a)*Math.sin(lat_b)+Math.cos(lat_a)*Math.cos(lat_b)*Math.cos(lng_b-lng_a);
        d=Math.sqrt(1-d*d);
        d=Math.cos(lat_b)*Math.sin(lng_b-lng_a)/d;
        d=Math.asin(d)*180/Math.PI;
        d=Math.abs(d);

// d = Math.round(d*10000);
        return d;
    }
    
    static private String getShortDistance(double lat_a, double lng_a, double lat_b, double lng_b){
        double DEF_PI = 3.14159265359; // PI  
        double DEF_2PI = 6.28318530712; // 2*PI  
        double DEF_PI180 = 0.01745329252; // PI/180.0  
        double DEF_R = 6370693.5; // radius of earth 
        
        double ew1, ns1, ew2, ns2;  
        double dx, dy, dew;  
        double distance;  
        // 角度转换为弧度  
        ns1 = lat_a * DEF_PI180; 
        ew1 = lng_a * DEF_PI180; 
        ns2 = lat_b * DEF_PI180;  
        ew2 = lng_b * DEF_PI180; 
        // 经度差  
        dew = ew1 - ew2;  
        // 若跨东经和西经180 度，进行调整  
        if (dew > DEF_PI)  
            dew = DEF_2PI - dew;  
        else if (dew < -DEF_PI)  
            dew = DEF_2PI + dew;  
        dx = DEF_R * Math.cos(ns1) * dew; // 东西方向长度(在纬度圈上的投影长度)  
        dy = DEF_R * (ns1 - ns2); // 南北方向长度(在经度圈上的投影长度)  
        // 勾股定理求斜边长  
        distance = Math.sqrt(dx * dx + dy * dy);  
        return trans(distance);  
    }
    static private String trans(double distance) {  
        boolean isBig = false; // 是否为大于等于1000m  
        if (distance >= 1000) {  
            distance /= 1000;  
            isBig = true;  
        }  
        return (new DecimalFormat(".00").format(distance)) + (isBig ? "千米" : "米");  
    }
    
    class TYPE{
        public static final String LOCATION = "location";
        public static final String ACCOUNT = "account";
        public static final String POST = "post";
        public static final String ADMIN = "admin";
        public static final String PET = "pet";
        public static final String RESOURCE = "res";
        public static final String REVIEW = "review";
    }
    class SYMBOL{
        public static final String EMPTY = "";
        public static final String SEP = "/";
        public static final String FAND = "?";
        public static final String AND = "&";
    }
    class ACTION_LOCATION{
        public static final String authLocationAlbum = "authLocationAlbum";
        
        public static final String GET_COVER = "getAuthLocationCover";
        public static final String SET_COVER = "setAuthLocationCover";
        
        public static final String DEL_ALBUM_PHOTO = "delLocationAlbum";
        public static final String ADD_ALBUM_PHOTO = "addLocationAlbum";
        public static final String GET_ALBUM_LIST = "GET_ALBUM_LIST";
        
        public static final String EDIT_LOCATION_INFO = "info";
        public static final String ADD_LOCATION = "ADD_LOCATION";
        public static final String GET_LOCATION_DETAIL = "GET_LOCATION_DETAIL";
        
        public static final String SEARCH = "search";
    }
    
    class ACTION_POST{
        public static final String GET_POST = "GET_POST";
        public static final String ADD_POST = "ADD_POST";
        public static final String DELETE_POST = "DELETE_POST";
        public static final String LIKE_POST = "LIKE_POST";
        public static final String UNLIKE_POST = "UNLIKE_POST";
        public static final String SHARE_POST = "sharePostToThirdParty";
        
        public static final String ADD_COMMENT = "ADD_COMMENT";
        public static final String GET_COMMENT = "GET_COMMENT";
        public static final String DELETE_COMMENT = "DELETE_COMMENT";
    }

    protected static final String SERVER = "http://54.222.140.4";
    protected static final String APIURL = SERVER+":8080/PetWSV1/";
    public static Object APISelector(String type, String action, HashMap<String, Object> map){
        String result = APIURL;
        switch (type){
            case TYPE.ACCOUNT :
                break;
            case TYPE.ADMIN :
                break;
            case TYPE.LOCATION :
                result += TYPE.LOCATION+SYMBOL.SEP;
                switch (action){
                    case ACTION_LOCATION.GET_COVER:
                        result += ACTION_LOCATION.GET_COVER;
                        break;
                    case ACTION_LOCATION.SET_COVER:
                        result += ACTION_LOCATION.SET_COVER;
                        break;
                    case ACTION_LOCATION.GET_ALBUM_LIST:
                        result += ACTION_LOCATION.authLocationAlbum;
                        break;
                    case ACTION_LOCATION.DEL_ALBUM_PHOTO:
                        result += ACTION_LOCATION.DEL_ALBUM_PHOTO;
                        break;
                    case ACTION_LOCATION.ADD_ALBUM_PHOTO:
                        result += ACTION_LOCATION.ADD_ALBUM_PHOTO;
                        break;
                    case ACTION_LOCATION.ADD_LOCATION:
                        result += "";
                        break;
                    case ACTION_LOCATION.GET_LOCATION_DETAIL:
                        result += map.get("locationId");
                        break;
                    case ACTION_LOCATION.EDIT_LOCATION_INFO:
                        result += ACTION_LOCATION.EDIT_LOCATION_INFO;
                        break;
                    case ACTION_LOCATION.SEARCH:
                        result += ACTION_LOCATION.SEARCH;
                        break;
                }
                break;
            case TYPE.PET :
                break;
            case TYPE.POST :
                result += TYPE.POST;
                switch (action){
                    case ACTION_POST.GET_POST:
                        result += GET_Handler(map);
                        break;
                    case ACTION_POST.ADD_POST:
                        result += ACTION_LOCATION.GET_COVER;
                        break;
                    case ACTION_POST.DELETE_POST:
                        result += ACTION_LOCATION.GET_COVER;
                        break;
                    case ACTION_POST.LIKE_POST:
                        result += ACTION_LOCATION.GET_COVER;
                        break;
                    case ACTION_POST.UNLIKE_POST:
                        result += ACTION_LOCATION.GET_COVER;
                        break;
                    case ACTION_POST.SHARE_POST:
                        result += ACTION_LOCATION.GET_COVER;
                        break;
                    case ACTION_POST.ADD_COMMENT:
                        result += ACTION_LOCATION.GET_COVER;
                        break;
                    case ACTION_POST.GET_COMMENT:
                        result += ACTION_LOCATION.GET_COVER;
                        break;
                    case ACTION_POST.DELETE_COMMENT:
                        result += ACTION_LOCATION.GET_COVER;
                        break;
                }
                break;
            case TYPE.RESOURCE :
                break;
            case TYPE.REVIEW :
                break;
            default:
                result = "";
        }

        return result;
    }
    
    private static String GET_Handler(HashMap<String, Object> map){
        String result = "";
        
        boolean firstFlag = true;
        for(String key : map.keySet()){
            if(firstFlag){
                result += "?"+key+"="+map.get(key);
                firstFlag = false;
            }else{
                result += "&"+key+"="+map.get(key);
            }
        }
        return result;
    }
    
    
    
}
