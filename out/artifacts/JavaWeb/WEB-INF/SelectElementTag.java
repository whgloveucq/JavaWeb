package com.whg.sevlet;

/**
 * Created by whg at 19-1-30
 * Included in JavaWeb
 * Go ahead ,do what you say and say what you do .
 **/
import java.io.IOException;
import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SelectElementTag extends SimpleTagSupport{
    private String[] countries={"Australia","Brazil","China"};
    int count_num=countries.length;
    public void doTag() throws IOException,JspException{
        JspContext jspContext=getJspContext();
        JspWriter out=jspContext.getOut();
        out.print("国家的个数:"+count_num+"</br>");
        out.print("<select>\n");
        for(int i=0;i<count_num;i++)
        {
           jspContext.setAttribute("value",countries[i]);
           jspContext.setAttribute("text",countries[i]);
getJspBody().invoke(null);
        }
out.print("</select>\n") ;

    }
}
