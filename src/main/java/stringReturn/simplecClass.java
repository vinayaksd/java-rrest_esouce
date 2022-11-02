package stringReturn;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/vinayak")
public class simplecClass {

	    @GET 
	    @Produces("text/plain")
	    public String getIt() {
	        return "Hi ----vinayak s deshpande!----";
	    

    
  

    }
}

