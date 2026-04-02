package com.foto.indexlib.IndexBar.a;

import com.foto.indexlib.IndexBar.bean.BaseIndexBean;
import java.util.List;
/* compiled from: IndexBarDataHelperImpl.java */
/* loaded from: classes.dex */
public class b implements a {
    @Override // com.foto.indexlib.IndexBar.a.a
    public a a(List<? extends BaseIndexBean> list, List<String> list2) {
        if (list != null && !list.isEmpty()) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                String baseIndexTag = list.get(i).getBaseIndexTag();
                if (!list2.contains(baseIndexTag)) {
                    list2.add(baseIndexTag);
                }
            }
        }
        return this;
    }
}
