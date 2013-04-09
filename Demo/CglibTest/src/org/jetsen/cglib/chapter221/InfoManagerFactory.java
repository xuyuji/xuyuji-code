package org.jetsen.cglib.chapter221;

public class InfoManagerFactory {
    private static InfoManager manger = new InfoManager();
    /**
     * 创建原始的InfoManager
     * 
     * @return
     */
    public static InfoManager getInstance() {
        return manger;
    }
}