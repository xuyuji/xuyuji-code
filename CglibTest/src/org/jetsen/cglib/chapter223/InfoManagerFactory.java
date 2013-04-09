package org.jetsen.cglib.chapter223;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

public class InfoManagerFactory {

    /**
     * 创建不同权限要求的InfoManager
     * 
     * @param auth
     * @return
     */
    public static InfoManager getSelectivityAuthInstance(AuthProxy auth) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(InfoManager.class);
        enhancer.setCallbacks(new Callback[] { auth, NoOp.INSTANCE });
        enhancer.setCallbackFilter(new AuthProxyFilter());
        return (InfoManager) enhancer.create();
    }
}