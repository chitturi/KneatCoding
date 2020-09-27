package apiEngine;

public class ReqeustRoutes {
	 
    private static final String PETSTORE = "/pet";
    private static final String VERSION = "v2";
   
 
    public static String pet(){ 
    	return VERSION + PETSTORE;
    }
 
    public static String petid(int petid){
    	return VERSION  + PETSTORE + "/" + petid; 
    }
}
