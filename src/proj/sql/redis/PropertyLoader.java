package sql.redis;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyLoader {
	/** 属性文件放在当前包下面即可，如果FTP服务器的位置改变了，需要改属性文件 */
	private final static String filePath = "redis.properties";
	private Properties Properties;

	public PropertyLoader() {
		try {
			defaultLoader();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/** 默认属性文件 */
	private boolean defaultLoader() throws IOException {
		Properties = new Properties();
		InputStream in = null;
		try {
			in = this.getClass().getResourceAsStream(filePath);
			Properties.load(in);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				in.close();
			}
		}
		return false;
	}

	public Properties getProperties() {
		return Properties;
	}
}
