package org.phprpc;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import org.phprpc.util.Cast;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PHPRPC_Client.java */
/* loaded from: classes2.dex */
public final class PHPRPC_InvocationHandler implements InvocationHandler {
    private PHPRPC_Client rpc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PHPRPC_InvocationHandler(PHPRPC_Client pHPRPC_Client) {
        this.rpc = pHPRPC_Client;
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        Class<?>[] parameterTypes = method.getParameterTypes();
        int length = parameterTypes.length;
        String name = method.getName();
        if (length > 0 && parameterTypes[length - 1] == PHPRPC_Callback.class) {
            Object[] objArr2 = new Object[length - 1];
            System.arraycopy(objArr, 0, objArr2, 0, length - 1);
            this.rpc.invoke(name, objArr2, (PHPRPC_Callback) objArr[length - 1]);
            return null;
        } else if (length > 1 && parameterTypes[length - 2] == PHPRPC_Callback.class && parameterTypes[length - 1] == Boolean.TYPE) {
            boolean booleanValue = ((Boolean) objArr[length - 1]).booleanValue();
            Object[] objArr3 = new Object[length - 2];
            System.arraycopy(objArr, 0, objArr3, 0, length - 2);
            this.rpc.invoke(name, objArr3, (PHPRPC_Callback) objArr[length - 2], booleanValue);
            return null;
        } else if (length > 2 && parameterTypes[length - 3] == PHPRPC_Callback.class && parameterTypes[length - 2] == Boolean.TYPE && parameterTypes[length - 1] == Integer.TYPE) {
            boolean booleanValue2 = ((Boolean) objArr[length - 2]).booleanValue();
            int intValue = ((Integer) objArr[length - 1]).intValue();
            Object[] objArr4 = new Object[length - 3];
            System.arraycopy(objArr, 0, objArr4, 0, length - 3);
            this.rpc.invoke(name, objArr4, (PHPRPC_Callback) objArr[length - 3], booleanValue2, intValue);
            return null;
        } else {
            Object invoke = this.rpc.invoke(name, objArr);
            if (invoke instanceof PHPRPC_Error) {
                throw ((PHPRPC_Error) invoke);
            }
            return Cast.cast(invoke, method.getReturnType(), this.rpc.getCharset());
        }
    }
}
