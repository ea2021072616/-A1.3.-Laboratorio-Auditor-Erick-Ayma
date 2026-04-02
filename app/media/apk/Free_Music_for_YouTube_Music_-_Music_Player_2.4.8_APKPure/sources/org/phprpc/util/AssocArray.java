package org.phprpc.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class AssocArray implements java.io.Serializable, Cloneable {
    private int arrayLength;
    private ArrayList arrayList;
    private LinkedHashMap hashMap;
    private int maxNumber;

    public AssocArray() {
        this.arrayList = new ArrayList();
        this.hashMap = new LinkedHashMap();
        this.arrayLength = 0;
        this.maxNumber = -1;
    }

    public AssocArray(int i) {
        this.arrayList = new ArrayList(i);
        this.hashMap = new LinkedHashMap(i);
        this.arrayLength = 0;
        this.maxNumber = -1;
    }

    public AssocArray(int i, float f) {
        this.arrayList = new ArrayList(i);
        this.hashMap = new LinkedHashMap(i, f);
        this.arrayLength = 0;
        this.maxNumber = -1;
    }

    public AssocArray(Collection collection) {
        this.arrayList = new ArrayList(collection);
        this.arrayLength = this.arrayList.size();
        this.maxNumber = this.arrayLength - 1;
        this.hashMap = new LinkedHashMap(this.arrayLength);
        for (int i = 0; i < this.arrayLength; i++) {
            this.hashMap.put(new Integer(i), this.arrayList.get(i));
        }
    }

    public AssocArray(Map map) {
        int size = map.size();
        this.arrayList = new ArrayList(size);
        this.hashMap = new LinkedHashMap(size);
        this.arrayLength = 0;
        this.maxNumber = -1;
        for (Object obj : map.keySet()) {
            if ((obj instanceof Integer) || (obj instanceof Short) || (obj instanceof Byte)) {
                int intValue = ((Number) obj).intValue();
                if (intValue > -1) {
                    this.arrayLength++;
                    if (this.maxNumber < intValue) {
                        this.maxNumber = intValue;
                    }
                }
                this.hashMap.put(new Integer(intValue), map.get(obj));
            } else if (obj instanceof String) {
                this.hashMap.put(obj, map.get(obj));
            }
        }
        setArrayList();
    }

    private void setArrayList() {
        int size = this.arrayList.size();
        if (size < this.arrayLength) {
            if (this.maxNumber + 1 == this.arrayLength) {
                while (size < this.arrayLength) {
                    this.arrayList.add(this.hashMap.get(new Integer(size)));
                    size++;
                }
                return;
            }
            int i = size;
            Integer num = new Integer(size);
            while (this.hashMap.containsKey(num)) {
                this.arrayList.add(this.hashMap.get(num));
                i++;
                num = new Integer(i);
            }
        }
    }

    public ArrayList toArrayList() {
        setArrayList();
        return this.arrayList;
    }

    public HashMap toHashMap() {
        return this.hashMap;
    }

    public LinkedHashMap toLinkedHashMap() {
        return this.hashMap;
    }

    public int size() {
        return this.hashMap.size();
    }

    public boolean isEmpty() {
        return this.hashMap.isEmpty();
    }

    public boolean add(Object obj) {
        int size = this.arrayList.size();
        boolean add = this.arrayList.add(obj);
        if (add) {
            Integer num = new Integer(size);
            if (!this.hashMap.containsKey(num)) {
                this.arrayLength++;
                if (this.maxNumber < size) {
                    this.maxNumber = size;
                }
            }
            this.hashMap.put(num, obj);
        }
        return add;
    }

    public boolean addAll(Collection collection) {
        int size = collection.size();
        int size2 = this.arrayList.size() - 1;
        boolean addAll = this.arrayList.addAll(collection);
        if (addAll) {
            for (int i = 0; i < size; i++) {
                size2++;
                Integer num = new Integer(size2);
                if (!this.hashMap.containsKey(num)) {
                    this.arrayLength++;
                }
                this.hashMap.put(num, this.arrayList.get(size2));
            }
            if (this.maxNumber < size2) {
                this.maxNumber = size2;
            }
        }
        return addAll;
    }

    public void putAll(Map map) {
        for (Object obj : map.keySet()) {
            if ((obj instanceof Integer) || (obj instanceof Short) || (obj instanceof Byte)) {
                int intValue = ((Number) obj).intValue();
                Integer num = new Integer(intValue);
                if (intValue > -1 && !this.hashMap.containsKey(num)) {
                    this.arrayLength++;
                    if (this.maxNumber < intValue) {
                        this.maxNumber = intValue;
                    }
                }
                this.hashMap.put(num, map.get(num));
            } else if (obj instanceof String) {
                this.hashMap.put(obj, map.get(obj));
            }
        }
        setArrayList();
    }

    public Object get(int i) {
        return i < this.arrayList.size() ? this.arrayList.get(i) : this.hashMap.get(new Integer(i));
    }

    public Object get(Byte b2) {
        return get(b2.intValue());
    }

    public Object get(Short sh) {
        return get(sh.intValue());
    }

    public Object get(Integer num) {
        return get(num.intValue());
    }

    public Object get(String str) {
        return this.hashMap.get(str);
    }

    public Object set(int i, Object obj) {
        Integer num = new Integer(i);
        if (i > -1) {
            int size = this.arrayList.size();
            if (size > i) {
                this.arrayList.set(i, obj);
            } else {
                if (size == i) {
                    this.arrayList.add(obj);
                }
                if (!this.hashMap.containsKey(num)) {
                    this.arrayLength++;
                    if (this.maxNumber < i) {
                        this.maxNumber = i;
                    }
                }
            }
        }
        return this.hashMap.put(num, obj);
    }

    public Object set(Byte b2, Object obj) {
        return set(b2.intValue(), obj);
    }

    public Object set(Short sh, Object obj) {
        return set(sh.intValue(), obj);
    }

    public Object set(Integer num, Object obj) {
        return set(num.intValue(), obj);
    }

    public Object set(String str, Object obj) {
        return this.hashMap.put(str, obj);
    }

    public Object remove(int i) {
        Integer num = new Integer(i);
        if (i > -1) {
            if (this.hashMap.containsKey(num)) {
                this.arrayLength--;
                int size = this.arrayList.size() - 1;
                if (i <= size) {
                    while (size >= i) {
                        this.arrayList.remove(size);
                        size--;
                    }
                    if (this.maxNumber == i) {
                        this.maxNumber--;
                    }
                } else if (this.maxNumber == i) {
                    do {
                        i--;
                        if (i <= size) {
                            break;
                        }
                    } while (!this.hashMap.containsKey(new Integer(i)));
                    this.maxNumber = i;
                }
            } else {
                return null;
            }
        }
        return this.hashMap.remove(num);
    }

    public Object remove(Byte b2) {
        return remove(b2.intValue());
    }

    public Object remove(Short sh) {
        return remove(sh.intValue());
    }

    public Object remove(Integer num) {
        return remove(num.intValue());
    }

    public Object remove(String str) {
        return this.hashMap.remove(str);
    }

    public void clear() {
        this.arrayList.clear();
        this.hashMap.clear();
        this.arrayLength = 0;
        this.maxNumber = -1;
    }

    public Object clone() throws CloneNotSupportedException {
        AssocArray assocArray = (AssocArray) super.clone();
        assocArray.arrayList = (ArrayList) this.arrayList.clone();
        assocArray.hashMap = (LinkedHashMap) this.hashMap.clone();
        assocArray.arrayLength = this.arrayLength;
        assocArray.maxNumber = this.maxNumber;
        return assocArray;
    }
}
