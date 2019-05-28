package com.whg.sevlet;
import java.util.Set;
import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.HandlesTypes;
@HandlesTypes({UsefulServlet.class})
public class ServletContainerInitializer implements javax.servlet.ServletContainerInitializer {

    @Override
    public void onStartup(Set<Class<?>> classes, ServletContext servletContext) throws ServletException {
        System.out.println("onStartup");
        ServletRegistration registration=servletContext.addServlet("usefulServlet","servlet.UsefulServlet" );
        registration.addMapping("/useful");
        System.out.println("leaving onStartup");
    }
}
