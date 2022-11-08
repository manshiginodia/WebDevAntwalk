package listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;


public class RequestResponseLisnr implements ServletRequestListener {

    
    public RequestResponseLisnr() {
       
    }

    public void requestDestroyed(ServletRequestEvent sre)  { 
         System.out.println("Response went off from server");
    }

	
    public void requestInitialized(ServletRequestEvent sre)  { 
    	System.out.println("server recived a request");
    }
	
}
