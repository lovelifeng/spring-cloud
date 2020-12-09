import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public class TestBingfa {
        //发送请求的url地址
	public static final String url ="http://192.168.32.36:8882/consumer/channel/69";
	//模拟的并发量
	private static final int BINGFA = 13500;
	
	private static CountDownLatch cdl = new CountDownLatch(BINGFA);

	public static void main(String[] args) {
		for (int i = 0; i < BINGFA; i++) {
			new Thread(new UserRequest()).start();
			cdl.countDown();
		}
	}
	
	public static class UserRequest implements Runnable{
		@Override
		public void run() {
			try {
				cdl.await();
			} catch (Exception e) {
				e.printStackTrace();
			}
			CloseableHttpClient httpClient = HttpClients.createDefault();
			HttpGet httpPost = new HttpGet(url);
			httpPost.addHeader("Content-Type", "application/json");
			CloseableHttpResponse response = null;
			try {
				response = httpClient.execute(httpPost);
				HttpEntity entity = response.getEntity();
				String responseContent = EntityUtils.toString(entity, "UTF-8");
				System.out.println(responseContent);
				response.close();
				httpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}finally {

			}

		}
		
	}

}