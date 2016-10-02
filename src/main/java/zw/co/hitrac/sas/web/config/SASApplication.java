package zw.co.hitrac.sas.web.config;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;
import zw.co.hitrac.sas.web.pages.HomePage;


/**
 *
 * @author hitrac
 *
 */
public class SASApplication extends WebApplication {

    @Override
    public Class<? extends Page> getHomePage() {
        return HomePage.class;
    }

    @Override
    protected void init() {
        super.init();
        this.getComponentInstantiationListeners().add(new SpringComponentInjector(this));
      
}
    
}
    
    
