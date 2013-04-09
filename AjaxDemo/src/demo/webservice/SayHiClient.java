package demo.webservice;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;

import org.codehaus.xfire.client.Client;
import org.codehaus.xfire.client.XFireProxyFactory;
import org.codehaus.xfire.service.Service;
import org.codehaus.xfire.service.binding.ObjectServiceFactory;
import org.codehaus.xfire.transport.http.CommonsHttpMessageSender;
import org.mortbay.util.ajax.JSON;

/**
 * java调用webservice
 * @author xuyuji
 *
 */
public class SayHiClient {
	public static void main(String args[]) {
		SayHiClient shc = new SayHiClient();
//		shc.call1();
//		shc.call2();
		shc.call3();
	}
	/**
	 * 此方法需要提供接口。
	 */
	public void call1() {
		String serviceURL = "http://localhost:8080/AjaxDemo/services/SayHiService";
		Service serviceModel = new ObjectServiceFactory()
				.create(SayHiService.class);

		XFireProxyFactory serviceFactory = new XFireProxyFactory();

		try {
			SayHiService service = (SayHiService) serviceFactory.create(
					serviceModel, serviceURL);
			Client client = Client.getInstance(service);

			client.setProperty(CommonsHttpMessageSender.HTTP_TIMEOUT, "1");

			String hello = service.sayHi("张山疯");
			System.out.println("服务器对[张山疯] 的回答是：" + hello);

			hello = service.sayHi(null);
			System.out.println("服务器胡言乱语说：" + hello);

		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 此方法不需要接口，调用简单，但是无法传递null值（也可能是我不会）。 
	 */
	public void call2(){
		Client client;
		try {
			client = new Client(new URL("http://localhost:8080/AjaxDemo/services/SayHiService?wsdl"));
			Object[] result = client.invoke("sayHi", new String[]{"贾君鹏"});
			for(Object s : result){
				System.out.println(s);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 返回复杂结果
	 * 因为传递Map之类的复杂结构xfire要特殊处理，这里就使用网络传值常用的json形式
	 */
	public void call3(){
		try {
			SayHiService sayHi = (SayHiService) new XFireProxyFactory().create(
					new ObjectServiceFactory().create(SayHiService.class), "http://localhost:8080/AjaxDemo/services/SayHiService");
			Map<String,Object> map = (Map<String, Object>) JSON.parse(sayHi.sayHi2("贾君鹏"));
			System.out.println(map);
			Iterator<String> it = map.keySet().iterator();
			while(it.hasNext()){
				String key = it.next();
				Object value = map.get(key);
				if(value instanceof String){
					System.out.println(key + ":" + value);
				}else if(value instanceof Map){
					System.out.println(key + ":");
					Iterator<String> it2 = ((Map)value).keySet().iterator();
					while(it2.hasNext()){
						String key2 = it2.next();
						System.out.println("\t" + key2 + ":" + ((Map)value).get(key2));
					}
				}
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
}
