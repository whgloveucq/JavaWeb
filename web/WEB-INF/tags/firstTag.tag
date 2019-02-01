<%@ tag import="java.util.Date" import="java.text.DateFormat" %>
<%
    Date now=new Date(System.currentTimeMillis()) ;
    DateFormat dateFormat= DateFormat.getDateInstance(DateFormat.LONG);
    out.println(dateFormat.format(now)) ;
%>