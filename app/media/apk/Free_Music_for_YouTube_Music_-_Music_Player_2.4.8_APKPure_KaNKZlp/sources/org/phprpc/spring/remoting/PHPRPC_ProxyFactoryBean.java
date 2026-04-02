package org.phprpc.spring.remoting;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.util.ClassUtils;
/* loaded from: classes2.dex */
public class PHPRPC_ProxyFactoryBean extends PHPRPC_ClientInterceptor implements FactoryBean {
    private ClassLoader beanClassLoader = ClassUtils.getDefaultClassLoader();
    private Object serviceProxy;

    public void setBeanClassLoader(ClassLoader classLoader) {
        this.beanClassLoader = classLoader;
    }

    @Override // org.phprpc.spring.remoting.PHPRPC_ClientInterceptor
    public void afterPropertiesSet() {
        super.afterPropertiesSet();
        this.serviceProxy = new ProxyFactory(getServiceInterface(), this).getProxy(this.beanClassLoader);
    }

    public Object getObject() {
        return this.serviceProxy;
    }

    public Class getObjectType() {
        return getServiceInterface();
    }

    public boolean isSingleton() {
        return true;
    }
}
