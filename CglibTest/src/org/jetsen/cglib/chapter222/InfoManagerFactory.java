package org.jetsen.cglib.chapter222;

import net.sf.cglib.proxy.Enhancer;

public class InfoManagerFactory {

    /**
     * 创建带有权限检验的InfoManager
     * 
     * @param auth
     * @return
     */
    public static InfoManager getAuthInstance(AuthProxy auth) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(InfoManager.class);
        enhancer.setCallback(auth);
        return (InfoManager) enhancer.create();
    }

    
}