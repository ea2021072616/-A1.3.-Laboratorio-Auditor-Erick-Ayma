package w1;

import androidx.appcompat.widget.b0;
/* loaded from: classes.dex */
public final class i extends a {

    /* renamed from: a  reason: collision with root package name */
    public final Integer f5346a;

    /* renamed from: b  reason: collision with root package name */
    public final String f5347b;

    /* renamed from: c  reason: collision with root package name */
    public final String f5348c;

    /* renamed from: d  reason: collision with root package name */
    public final String f5349d;

    /* renamed from: e  reason: collision with root package name */
    public final String f5350e;

    /* renamed from: f  reason: collision with root package name */
    public final String f5351f;

    /* renamed from: g  reason: collision with root package name */
    public final String f5352g;

    /* renamed from: h  reason: collision with root package name */
    public final String f5353h;

    /* renamed from: i  reason: collision with root package name */
    public final String f5354i;

    /* renamed from: j  reason: collision with root package name */
    public final String f5355j;

    /* renamed from: k  reason: collision with root package name */
    public final String f5356k;

    /* renamed from: l  reason: collision with root package name */
    public final String f5357l;

    public i(Integer num, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        this.f5346a = num;
        this.f5347b = str;
        this.f5348c = str2;
        this.f5349d = str3;
        this.f5350e = str4;
        this.f5351f = str5;
        this.f5352g = str6;
        this.f5353h = str7;
        this.f5354i = str8;
        this.f5355j = str9;
        this.f5356k = str10;
        this.f5357l = str11;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            Integer num = this.f5346a;
            if (num != null ? num.equals(((i) aVar).f5346a) : ((i) aVar).f5346a == null) {
                String str = this.f5347b;
                if (str != null ? str.equals(((i) aVar).f5347b) : ((i) aVar).f5347b == null) {
                    String str2 = this.f5348c;
                    if (str2 != null ? str2.equals(((i) aVar).f5348c) : ((i) aVar).f5348c == null) {
                        String str3 = this.f5349d;
                        if (str3 != null ? str3.equals(((i) aVar).f5349d) : ((i) aVar).f5349d == null) {
                            String str4 = this.f5350e;
                            if (str4 != null ? str4.equals(((i) aVar).f5350e) : ((i) aVar).f5350e == null) {
                                String str5 = this.f5351f;
                                if (str5 != null ? str5.equals(((i) aVar).f5351f) : ((i) aVar).f5351f == null) {
                                    String str6 = this.f5352g;
                                    if (str6 != null ? str6.equals(((i) aVar).f5352g) : ((i) aVar).f5352g == null) {
                                        String str7 = this.f5353h;
                                        if (str7 != null ? str7.equals(((i) aVar).f5353h) : ((i) aVar).f5353h == null) {
                                            String str8 = this.f5354i;
                                            if (str8 != null ? str8.equals(((i) aVar).f5354i) : ((i) aVar).f5354i == null) {
                                                String str9 = this.f5355j;
                                                if (str9 != null ? str9.equals(((i) aVar).f5355j) : ((i) aVar).f5355j == null) {
                                                    String str10 = this.f5356k;
                                                    if (str10 != null ? str10.equals(((i) aVar).f5356k) : ((i) aVar).f5356k == null) {
                                                        String str11 = this.f5357l;
                                                        if (str11 == null) {
                                                            if (((i) aVar).f5357l == null) {
                                                                return true;
                                                            }
                                                        } else if (str11.equals(((i) aVar).f5357l)) {
                                                            return true;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        Integer num = this.f5346a;
        int hashCode = ((num == null ? 0 : num.hashCode()) ^ 1000003) * 1000003;
        String str = this.f5347b;
        int hashCode2 = (hashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.f5348c;
        int hashCode3 = (hashCode2 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f5349d;
        int hashCode4 = (hashCode3 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.f5350e;
        int hashCode5 = (hashCode4 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        String str5 = this.f5351f;
        int hashCode6 = (hashCode5 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        String str6 = this.f5352g;
        int hashCode7 = (hashCode6 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
        String str7 = this.f5353h;
        int hashCode8 = (hashCode7 ^ (str7 == null ? 0 : str7.hashCode())) * 1000003;
        String str8 = this.f5354i;
        int hashCode9 = (hashCode8 ^ (str8 == null ? 0 : str8.hashCode())) * 1000003;
        String str9 = this.f5355j;
        int hashCode10 = (hashCode9 ^ (str9 == null ? 0 : str9.hashCode())) * 1000003;
        String str10 = this.f5356k;
        int hashCode11 = (hashCode10 ^ (str10 == null ? 0 : str10.hashCode())) * 1000003;
        String str11 = this.f5357l;
        return (str11 != null ? str11.hashCode() : 0) ^ hashCode11;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("AndroidClientInfo{sdkVersion=");
        sb.append(this.f5346a);
        sb.append(", model=");
        sb.append(this.f5347b);
        sb.append(", hardware=");
        sb.append(this.f5348c);
        sb.append(", device=");
        sb.append(this.f5349d);
        sb.append(", product=");
        sb.append(this.f5350e);
        sb.append(", osBuild=");
        sb.append(this.f5351f);
        sb.append(", manufacturer=");
        sb.append(this.f5352g);
        sb.append(", fingerprint=");
        sb.append(this.f5353h);
        sb.append(", locale=");
        sb.append(this.f5354i);
        sb.append(", country=");
        sb.append(this.f5355j);
        sb.append(", mccMnc=");
        sb.append(this.f5356k);
        sb.append(", applicationBuild=");
        return b0.i(sb, this.f5357l, "}");
    }
}
