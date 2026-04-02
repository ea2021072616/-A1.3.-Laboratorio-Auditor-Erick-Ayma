package org.phprpc;

import java.lang.reflect.Method;
/* compiled from: PHPRPC_Server.java */
/* loaded from: classes2.dex */
final class RemoteFunction {
    public Method[] functions;
    public Object obj;

    public RemoteFunction(Object obj, Method[] methodArr) {
        this.obj = obj;
        this.functions = methodArr;
    }
}
