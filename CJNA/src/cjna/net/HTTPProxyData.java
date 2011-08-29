package cjna.net;

/**
 * @author Pree
 *
 */
public class HTTPProxyData {

	private boolean isProxy;
	private int proxyPort;
	private String proxyHost;
	private String proxyDomain;
	private String proxyUserName;
	private String proxyPassword;
	
	private static class HTTPProxyDataHolder {
        private static final HTTPProxyData INSTANCE = new HTTPProxyData();
   
	}
	public HTTPProxyData() {}

	/**
    *
    * @return the instance
    */
   public static HTTPProxyData getInstance() {
       return HTTPProxyDataHolder.INSTANCE;
   }

	public void setProxyPort(int proxyPort) {
		this.proxyPort = proxyPort;
	}

	/*
	 * getter and setter methods.
	 */
	public int getProxyPort() {
		return proxyPort;
	}

	public void setProxyHost(String proxyHost) {
		this.proxyHost = proxyHost;
	}

	public String getProxyHost() {
		return proxyHost;
	}

	public void setProxy(boolean isProxy) {
		this.isProxy = isProxy;
	}

	public boolean isProxy() {
		return isProxy;
	}

	public void setProxyUserName(String proxyUserName) {
		this.proxyUserName = proxyUserName;
	}

	public String getProxyUserName() {
		return proxyUserName;
	}

	public void setProxyDomain(String proxyDomain) {
		this.proxyDomain = proxyDomain;
	}

	public String getProxyDomain() {
		return proxyDomain;
	}

	public void setProxyPassword(String proxyPassword) {
		this.proxyPassword = proxyPassword;
	}

	public String getProxyPassword() {
		return proxyPassword;
	}
}// end class HTTPProxyData
