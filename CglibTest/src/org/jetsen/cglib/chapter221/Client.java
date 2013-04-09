package org.jetsen.cglib.chapter221;

public class Client {

	public static void main(String[] args) {
		Client c = new Client();
		c.anyonecanManager();
	}

	/**
	 * 模拟：没有任何权限要求，任何人都可以操作
	 */
	public void anyonecanManager() {
		System.out.println("any one can do manager");
		InfoManager manager = InfoManagerFactory.getInstance();
		doCRUD(manager);
		separatorLine();
	}

	/**
	 * 对Info做增加／更新／删除／查询操作
	 * 
	 * @param manager
	 */
	private void doCRUD(InfoManager manager) {
		manager.create();
		manager.update();
		manager.delete();
		manager.query();
	}

	/**
	 * 加一个分隔行，用于区分
	 */
	private void separatorLine() {
		System.out.println("################################");
	}

}
