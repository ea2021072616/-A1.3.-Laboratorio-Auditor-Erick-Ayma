package com.google.android.gms.internal;
/* loaded from: classes2.dex */
final class zzefm {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static String zzai(zzedk zzedkVar) {
        zzefn zzefnVar = new zzefn(zzedkVar);
        StringBuilder sb = new StringBuilder(zzefnVar.size());
        for (int i = 0; i < zzefnVar.size(); i++) {
            byte zzgi = zzefnVar.zzgi(i);
            switch (zzgi) {
                case 7:
                    sb.append("\\a");
                    break;
                case 8:
                    sb.append("\\b");
                    break;
                case 9:
                    sb.append("\\t");
                    break;
                case 10:
                    sb.append("\\n");
                    break;
                case 11:
                    sb.append("\\v");
                    break;
                case 12:
                    sb.append("\\f");
                    break;
                case 13:
                    sb.append("\\r");
                    break;
                case 34:
                    sb.append("\\\"");
                    break;
                case 39:
                    sb.append("\\'");
                    break;
                case 92:
                    sb.append("\\\\");
                    break;
                default:
                    if (zzgi < 32 || zzgi > 126) {
                        sb.append('\\');
                        sb.append((char) (((zzgi >>> 6) & 3) + 48));
                        sb.append((char) (((zzgi >>> 3) & 7) + 48));
                        sb.append((char) ((zzgi & 7) + 48));
                        break;
                    } else {
                        sb.append((char) zzgi);
                        break;
                    }
            }
        }
        return sb.toString();
    }
}
