package com.whg.filter;

/**
 * Created by whg at 19-3-6
 * Included in JavaWeb
 * Go ahead ,do what you say and say what you do .
 **/
import java.io.IOException;
import java.util.*;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

@WebFilter(filterName = "AutoCorrectFilter" ,urlPatterns = {"/*"})
public class AutoCorrectFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
          HttpServletRequest httpServletRequest=(HttpServletRequest)request;
          AutoCorrectHttpServletRequestWrapper wrapper= new AutoCorrectHttpServletRequestWrapper(httpServletRequest) ;
          filterChain.doFilter(wrapper,response);
    }
    class AutoCorrectHttpServletRequestWrapper extends HttpServletRequestWrapper{
        private HttpServletRequest httpservletRequest;
        public AutoCorrectHttpServletRequestWrapper(HttpServletRequest request){
            super(request);
            this.httpservletRequest=request;
        }

        @Override
        public String getParameter(String name) {
            return autoCorrect(httpservletRequest.getParameter(name));
        }

        @Override
        public String[] getParameterValues(String name) {
            return autoCorrect(httpservletRequest.getParameterValues(name));
        }

        @Override
        public Map<String, String[]> getParameterMap() {
            final Map<String,String[]> parameterMap=httpservletRequest.getParameterMap();
            Map<String,String[]> newMap=new Map<String, String[]>() {
                @Override
                public int size() {
                    return parameterMap.size();
                }

                @Override
                public boolean isEmpty() {
                    return parameterMap.isEmpty();
                }

                @Override
                public boolean containsKey(Object key) {
                    return parameterMap.containsKey(key) ;
                }

                @Override
                public boolean containsValue(Object value) {
                    return parameterMap.containsValue(value);
                }

                @Override
                public String[] get(Object key) {
                    return  autoCorrect(parameterMap.get(key));
                }

                @Override
                public String[] put(String key, String[] value) {
                    //this will throw an IllegalStateException, but let the user get the original exception
                    return parameterMap.put(key,value);
               }

              @Override
               public String[] remove(Object key) {
                    //this will throw an IllegalStateException,but let the user get the original exception
                    return parameterMap.remove(key);
                }

                @Override
                public void putAll(Map<? extends String, ? extends String[]> map) {
//  this will throw an IllegalStateException,but the user get the original exception
                    parameterMap.putAll(map);
                }

                @Override
                public void clear() {
/* this will throw an IllegalStateException, but let the user get the original exception */
parameterMap.clear();
                }

                @Override
                public Set<String> keySet() {
                    return parameterMap.keySet();
                }

                @Override
                public Collection<String[]> values() {
                    return autoCorrect(parameterMap.values());
                }

                @Override
                public Set<Entry<String, String[]>> entrySet() {
                    return autoCorrect(parameterMap.entrySet());
                }
            } ;
            return  newMap;

        }
    }
    private String autoCorrect(String value){
        if(value==null){
            return  null;
        }
        value=value.trim();
        int length=value.length();
        StringBuilder temp=new StringBuilder();
        boolean lastCharWasSpace=false ;
        for(int i=0 ;i<length;i++){
        char c=value.charAt(i);
        if(c==' '){
            if(!lastCharWasSpace){
             temp.append(c);
            }
            lastCharWasSpace=true;
        }else{

            temp.append(c) ;
            lastCharWasSpace=false;
        }

        }
        return temp.toString();
    }
    private String[] autoCorrect(String[] values){

        if(values!=null){
            int length=values.length;
            for(int i=0;i<length;i++){
                values[i]=autoCorrect(values[i]);
            }
        return values;
        }
        return null;
    }
    private Collection<String[]> autoCorrect(Collection<String[]> valueCollection){
            Collection<String[]> newCollection= new ArrayList<String[]>();
            for(String[] values:valueCollection){
                newCollection.add(autoCorrect(values));
            }
          return newCollection ;

    }
    private Set<Map.Entry<String,String[]>> autoCorrect(Set<Map.Entry<String,String[]>> entrySet){

         Set<Map.Entry<String,String[]>> newSet=new HashSet<Map.Entry<String, String[]>>() ;

         for(final Map.Entry<String,String[]> entry:entrySet ){
             Map.Entry<String,String[]> newEntry=new Map.Entry<String, String[]>() {
                 @Override
                 public String getKey() {
                     return entry.getKey();
                 }

                 @Override
                 public String[] getValue() {
                     return autoCorrect(entry.getValue()) ;
                 }

                 @Override
                 public String[] setValue(String[] value) {
                     return entry.setValue(value);
                 }
             };
newSet.add(newEntry) ;
         }
         return newSet;
    }
}
