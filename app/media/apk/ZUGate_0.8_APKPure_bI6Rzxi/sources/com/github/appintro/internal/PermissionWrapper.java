package com.github.appintro.internal;

import e4.e;
import j4.d;
import java.io.Serializable;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class PermissionWrapper implements Serializable {
    private String[] permissions;
    private int position;
    private boolean required;

    public PermissionWrapper(String[] strArr, int i5, boolean z4) {
        e.f(strArr, "permissions");
        this.permissions = strArr;
        this.position = i5;
        this.required = z4;
    }

    public static /* synthetic */ PermissionWrapper copy$default(PermissionWrapper permissionWrapper, String[] strArr, int i5, boolean z4, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            strArr = permissionWrapper.permissions;
        }
        if ((i6 & 2) != 0) {
            i5 = permissionWrapper.position;
        }
        if ((i6 & 4) != 0) {
            z4 = permissionWrapper.required;
        }
        return permissionWrapper.copy(strArr, i5, z4);
    }

    public final String[] component1() {
        return this.permissions;
    }

    public final int component2() {
        return this.position;
    }

    public final boolean component3() {
        return this.required;
    }

    public final PermissionWrapper copy(String[] strArr, int i5, boolean z4) {
        e.f(strArr, "permissions");
        return new PermissionWrapper(strArr, i5, z4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!e.a(PermissionWrapper.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        if (obj != null) {
            PermissionWrapper permissionWrapper = (PermissionWrapper) obj;
            return Arrays.equals(this.permissions, permissionWrapper.permissions) && this.position == permissionWrapper.position && this.required == permissionWrapper.required;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.github.appintro.internal.PermissionWrapper");
    }

    public final String[] getPermissions() {
        return this.permissions;
    }

    public final int getPosition() {
        return this.position;
    }

    public final boolean getRequired() {
        return this.required;
    }

    public int hashCode() {
        return Boolean.valueOf(this.required).hashCode() + (((Arrays.hashCode(this.permissions) * 31) + this.position) * 31);
    }

    public final void setPermissions(String[] strArr) {
        e.f(strArr, "<set-?>");
        this.permissions = strArr;
    }

    public final void setPosition(int i5) {
        this.position = i5;
    }

    public final void setRequired(boolean z4) {
        this.required = z4;
    }

    public String toString() {
        return "PermissionWrapper(permissions=" + Arrays.toString(this.permissions) + ", position=" + this.position + ", required=" + this.required + ")";
    }

    public /* synthetic */ PermissionWrapper(String[] strArr, int i5, boolean z4, int i6, d dVar) {
        this(strArr, i5, (i6 & 4) != 0 ? true : z4);
    }
}
