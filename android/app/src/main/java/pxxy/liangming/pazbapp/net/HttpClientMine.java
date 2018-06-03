package pxxy.liangming.pazbapp.net;

import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HttpClientMine {
	public static int STATUS = -1;
	private static CookieStore cookies = new BasicCookieStore();
	private static String cookie_str;
	private static boolean useCookie = true;
	/**
	 *
	 * @param url
	 * @param args form表单的name
	 * @param values form表单name的值
	 * @return 页面内容
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public static String post(String url, String args[], String values[]) throws ConnectTimeoutException, IOException {
		DefaultHttpClient httpClient = new DefaultHttpClient();
		if(cookies != null && useCookie)
			httpClient.setCookieStore(cookies);
		HttpPost httpPost = new HttpPost(url);
		if(args != null && values != null){
			List<BasicNameValuePair> params = new ArrayList<BasicNameValuePair>();
			for(int i=0;i<args.length;i++){
				params.add(new BasicNameValuePair(args[i],values[i]));
			}
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(params,"utf-8");
			httpPost.setEntity(entity);
		}

		HttpResponse httpResponse = httpClient.execute(httpPost);
		if((STATUS=httpResponse.getStatusLine().getStatusCode()) == 200){
			HttpEntity httpEntity = httpResponse.getEntity();
			String html = EntityUtils.toString(httpEntity);
			cookies = httpClient.getCookieStore();
			return html;
		}
		return null;
	}

	public static String post(String url) throws ConnectTimeoutException, IOException {
		return post(url,null,null);
	}

	/*public static void main(String[] args) throws ClientProtocolException, IOException {
		String httpresult = post("http://xyht.lrxzl.cn/UserAction!login"
				,new String[]{"user.user_id","user.password"},new String[]{"admin","123"});

		String httpresult1 = post("http://xyht.lrxzl.cn/PostActionJson!ajax_load?from_id=9999");
		System.out.println(httpresult1);
	}*/

	public static void useCookie(boolean bo){
		useCookie = bo;
	}

	/**
	 *
	 * @param url
	 * @return 页面内容
	 * @throws ClientProtocolException
	 * @throws IOException
	 */

	public static String get(String url) throws ClientProtocolException, IOException {
		DefaultHttpClient httpClient = new DefaultHttpClient();
		if(cookies != null && useCookie)
			httpClient.setCookieStore(cookies);
		HttpGet httpGet = new HttpGet(url);
		HttpResponse res = httpClient.execute(httpGet);
		if((STATUS=res.getStatusLine().getStatusCode()) == 200){
			HttpEntity httpEntity = res.getEntity();
			String html = EntityUtils.toString(httpEntity);
			cookies = httpClient.getCookieStore();
			return html;
		}
		return null;
	}


	/**
	 *
	 * @param url
	 * @param args get的参数
	 * @param values get参数的值
	 * @return 页面内容
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public static String get(String url, String args[], String values[]) throws ClientProtocolException, IOException {
		if(args == null || values == null)
			return get(url);
		StringBuilder s = new StringBuilder(url+"?");
		for(int i=0;i<args.length-1;i++){
			s.append(args[i]);
			s.append("=");
			s.append(values[i]);
			s.append("&");
		}
		s.append(args[args.length]);
		s.append("=");
		s.append(values[values.length]);
		return s.toString();
	}

	public static void cleanCookie(){
		cookies.clear();
	}

	public static String getDomainString() {
		List<Cookie> li =  cookies.getCookies();
		for(Cookie cookie : li) {
			if(cookie.getName().equalsIgnoreCase("JSESSIONID")){
				return cookie.getDomain();
			}
		}
		return null;
	}

	public static String getCookieString() {
		List<Cookie> li =  cookies.getCookies();
		for(Cookie cookie : li) {
			if(cookie.getName().equalsIgnoreCase("JSESSIONID")){
				String cookiestr =  cookie.getName()+"="+cookie.getValue()
						+";domain=" + cookie.getDomain()
						+";path=" + cookie.getPath();
				Log.i("getCookieString",cookiestr);
				return cookiestr;
			}
		}
		return null;
	}

	public static void setCookieString(String cks){
		if(cks == null) return;
		cookie_str = cks;
		Log.i("setCookieString", cks);
		String string[] = cks.split(";");
		String t1[] = string[0].split("=");
		BasicClientCookie bcc = new BasicClientCookie(t1[0],t1[1]);
		bcc.setDomain(string[1].split("=")[1]);
		bcc.setPath(string[2].split("=")[1]);
		cookies.addCookie(bcc);
	}

}
