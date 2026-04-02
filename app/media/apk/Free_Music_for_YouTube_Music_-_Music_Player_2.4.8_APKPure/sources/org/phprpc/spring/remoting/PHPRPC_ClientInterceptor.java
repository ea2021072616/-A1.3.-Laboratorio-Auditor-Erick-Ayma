package org.phprpc.spring.remoting;

import com.facebook.ads.AudienceNetworkActivity;
import com.google.android.exoplayer2.DefaultLoadControl;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.phprpc.PHPRPC_Client;
import org.springframework.remoting.RemoteProxyFailureException;
import org.springframework.remoting.support.UrlBasedRemoteAccessor;
/* loaded from: classes2.dex */
public class PHPRPC_ClientInterceptor extends UrlBasedRemoteAccessor implements MethodInterceptor {
    private PHPRPC_Client proxyFactory = null;
    private String proxy = null;
    private String charset = AudienceNetworkActivity.WEBVIEW_ENCODING;
    private int keyLength = 128;
    private int encryptMode = 0;
    private int timeout = DefaultLoadControl.DEFAULT_MAX_BUFFER_MS;
    private Object phprpcProxy = null;

    public void setWebProxy(String str) {
        this.proxy = str;
    }

    public void setCharset(String str) {
        this.charset = str;
    }

    public void setKeyLength(int i) {
        this.keyLength = i;
    }

    public void setEncryptMode(int i) {
        this.encryptMode = i;
    }

    public void setTimeout(int i) {
        this.timeout = i;
    }

    public void setProxyFactory(PHPRPC_Client pHPRPC_Client) {
        this.proxyFactory = pHPRPC_Client;
    }

    public void afterPropertiesSet() {
        super.afterPropertiesSet();
        prepare();
    }

    public void prepare() {
        this.proxyFactory = new PHPRPC_Client(getServiceUrl());
        try {
            this.proxyFactory.setProxy(this.proxy);
        } catch (MalformedURLException e) {
            this.proxy = null;
        }
        this.proxyFactory.setCharset(this.charset);
        this.proxyFactory.setKeyLength(this.keyLength);
        this.proxyFactory.setEncryptMode(this.encryptMode);
        this.proxyFactory.setTimeout(this.timeout);
        this.phprpcProxy = this.proxyFactory.useService(getServiceInterface());
    }

    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        if (this.phprpcProxy == null) {
            throw new IllegalStateException("PHPRPC_ClientInterceptor is not properly initialized - invoke 'prepare' before attempting any operations");
        }
        try {
            return methodInvocation.getMethod().invoke(this.phprpcProxy, methodInvocation.getArguments());
        } catch (InvocationTargetException e) {
            throw e.getTargetException();
        } catch (Throwable th) {
            throw new RemoteProxyFailureException("Failed to invoke PHPRPC proxy for remote service [" + getServiceUrl() + "]", th);
        }
    }
}
