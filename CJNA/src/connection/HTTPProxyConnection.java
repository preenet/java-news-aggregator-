package connection;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NTCredentials;
import org.apache.commons.httpclient.auth.AuthPolicy;
import org.apache.commons.httpclient.auth.AuthScope;
import org.apache.commons.httpclient.methods.GetMethod;

import cjna.Global;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Pree
 *
 */
public class HTTPProxyConnection {
	
	public HTTPProxyConnection() {
		
	}
	
	public int execute() throws HttpException, IOException {
		HttpClient proxyClient = new HttpClient();
		
		proxyClient.getHostConfiguration().setHost("www.sesolution.com");
		proxyClient.getHostConfiguration().setProxy(Global.proxyHost, Global.proxyPort);
		
		List<String> authPrefs = new ArrayList<String>(3);
		authPrefs.add(AuthPolicy.DIGEST);
		authPrefs.add(AuthPolicy.BASIC);
		authPrefs.add(AuthPolicy.NTLM);

        proxyClient.getState().setProxyCredentials(
            new AuthScope(null, 8080, null),
            new NTCredentials(Global.proxyUserName, Global.proxyPassword, "", Global.proxyDomain));

        proxyClient.getParams().setParameter(AuthPolicy.AUTH_SCHEME_PRIORITY, authPrefs);

        GetMethod get = new GetMethod("/");
        int status = proxyClient.executeMethod(get);
        
        return status;
	}
}
