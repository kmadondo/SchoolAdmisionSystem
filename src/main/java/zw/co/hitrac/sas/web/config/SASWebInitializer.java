package zw.co.hitrac.sas.web.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import org.apache.wicket.protocol.http.WicketFilter;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import zw.co.hitrac.sas.business.config.SaSBusinessConfiguration;



/**
 *
 * @pchikumba
 */
@WebFilter(value = "/*", initParams = {
   @WebInitParam(name = "applicationClassName", value = "zw.co.hitrac.sas.web.config.SASApplication"),
   @WebInitParam(name = "filterMappingUrlPattern", value = "/*")})
public class SASWebInitializer extends WicketFilter implements WebApplicationInitializer {

   public void onStartup(ServletContext servletContext) throws ServletException {
       AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
       servletContext.addListener(new ContextLoaderListener(ctx));
       ctx.register(SaSBusinessConfiguration.class);

   }

}
