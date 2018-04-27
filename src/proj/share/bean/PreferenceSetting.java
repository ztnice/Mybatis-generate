package share.bean;

import java.io.Serializable;

public class PreferenceSetting implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8988011687523006271L;
	/**
	 * ��ѡ���
	 */
	private String[] preferences;
	/**
	 * ��ѡ����
	 */
	private String preferenceName;

	public PreferenceSetting() {
	}

	public String[] getPreferences() {
		return preferences;
	}

	public void setPreferences(String[] preferences) {
		this.preferences = preferences;
	}

	public String getPreferenceName() {
		return preferenceName;
	}

	public void setPreferenceName(String preferenceName) {
		this.preferenceName = preferenceName;
	}

}
