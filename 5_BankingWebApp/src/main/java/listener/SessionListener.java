package listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


public class SessionListener implements HttpSessionListener {

    public SessionListener() {
        
    }
	
    public void sessionCreated(HttpSessionEvent se)  { 
        System.out.println("session got started");
    }

	
    public void sessionDestroyed(HttpSessionEvent se)  { 
    	 System.out.println("session got destroyed");
    }
	
}
