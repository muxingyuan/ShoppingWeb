package com.class5;

import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionIdListener;
import javax.servlet.http.HttpSessionListener;


@WebListener
public class listeners implements ServletContextListener, ServletContextAttributeListener, HttpSessionListener, HttpSessionAttributeListener, HttpSessionActivationListener, HttpSessionBindingListener, HttpSessionIdListener, ServletRequestListener, ServletRequestAttributeListener, AsyncListener {


    public listeners() {
        // TODO Auto-generated constructor stub
    }


    public void sessionCreated(HttpSessionEvent arg0)  { 
         // TODO Auto-generated method stub
    }


    public void attributeRemoved(ServletContextAttributeEvent arg0)  { 
         // TODO Auto-generated method stub
    }


    public void onError(AsyncEvent arg0) throws java.io.IOException { 
         // TODO Auto-generated method stub
    }


    public void sessionIdChanged(HttpSessionEvent arg0, String arg1)  { 
         // TODO Auto-generated method stub
    }


    public void attributeAdded(ServletRequestAttributeEvent arg0)  { 
         // TODO Auto-generated method stub
    	System.out.println("attribute " + arg0.getName()+ " added, value: " + arg0.getValue());
    }


    public void onTimeout(AsyncEvent arg0) throws java.io.IOException { 
         // TODO Auto-generated method stub
    }


    public void attributeReplaced(HttpSessionBindingEvent arg0)  { 
         // TODO Auto-generated method stub
    }


    public void sessionWillPassivate(HttpSessionEvent arg0)  { 
         // TODO Auto-generated method stub
    }


    public void contextInitialized(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    	System.out.println("Servlet Context Listener created.");
    }


    public void attributeAdded(ServletContextAttributeEvent arg0)  { 
         // TODO Auto-generated method stub
       	System.out.println("Servlet Context Attribute "+arg0.getName()+" value: "+arg0.getValue());
           	
    }


    public void onComplete(AsyncEvent arg0) throws java.io.IOException { 
         // TODO Auto-generated method stub
    }


    public void requestDestroyed(ServletRequestEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletRequestAttributeListener#attributeRemoved(ServletRequestAttributeEvent)
     */
    public void attributeRemoved(ServletRequestAttributeEvent arg0)  { 
         // TODO Auto-generated method stub
    }


    public void onStartAsync(AsyncEvent arg0) throws java.io.IOException { 
         // TODO Auto-generated method stub
    }


    public void valueBound(HttpSessionBindingEvent arg0)  { 
         // TODO Auto-generated method stub
    }


    public void requestInitialized(ServletRequestEvent arg0)  { 
         // TODO Auto-generated method stub
    }


    public void sessionDestroyed(HttpSessionEvent arg0)  { 
         // TODO Auto-generated method stub
    }


    public void sessionDidActivate(HttpSessionEvent arg0)  { 
         // TODO Auto-generated method stub
    }


    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    	System.out.println("Servlet request destroy");
    }


    public void attributeReplaced(ServletRequestAttributeEvent arg0)  { 
         // TODO Auto-generated method stub
    	
    }


    public void attributeAdded(HttpSessionBindingEvent arg0)  { 
         // TODO Auto-generated method stub
    	System.out.println("session attribute: " + arg0.getName() + " with value: " +arg0.getValue());
    }


    public void attributeRemoved(HttpSessionBindingEvent arg0)  { 
         // TODO Auto-generated method stub
    }


    public void attributeReplaced(ServletContextAttributeEvent arg0)  { 
         // TODO Auto-generated method stub
    }


    public void valueUnbound(HttpSessionBindingEvent arg0)  { 
         // TODO Auto-generated method stub
    	System.out.println("indisde MyCat name: " + arg0.getName() + " value: " + arg0.getValue());
    }
	
}
