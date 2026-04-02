package com.fotoable.youtube.music.b;

import android.text.TextUtils;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.MusicApplication;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.util.HashMap;
import java.util.Map;
/* compiled from: GenresResManager.java */
/* loaded from: classes.dex */
public class b {
    private static final b d = new b();

    /* renamed from: a  reason: collision with root package name */
    private Map<String, Integer> f2241a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private Map<String, Integer> f2242b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private Map<String, Integer> f2243c = new HashMap();

    public static b a() {
        return d;
    }

    private b() {
        b();
        c();
        d();
    }

    private void b() {
        this.f2241a.put("Moods", Integer.valueOf((int) R.string.moods));
        this.f2241a.put("Scenes", Integer.valueOf((int) R.string.scenes));
        this.f2241a.put("Genres", Integer.valueOf((int) R.string.genres2));
        this.f2241a.put("Language", Integer.valueOf((int) R.string.language));
    }

    private void c() {
        this.f2242b.put("Sad", Integer.valueOf((int) R.string.sad));
        this.f2242b.put("Peaceful", Integer.valueOf((int) R.string.peaceful2));
        this.f2242b.put("Loneliness", Integer.valueOf((int) R.string.loneliness));
        this.f2242b.put("Inspiring", Integer.valueOf((int) R.string.inspiring));
        this.f2242b.put("Healing", Integer.valueOf((int) R.string.healing));
        this.f2242b.put("Boring", Integer.valueOf((int) R.string.boring));
        this.f2242b.put("Jogging", Integer.valueOf((int) R.string.jogging));
        this.f2242b.put("Sleep", Integer.valueOf((int) R.string.sleep));
        this.f2242b.put("Driving", Integer.valueOf((int) R.string.driving));
        this.f2242b.put("Travel", Integer.valueOf((int) R.string.travel));
        this.f2242b.put("Study", Integer.valueOf((int) R.string.study));
        this.f2242b.put("Party", Integer.valueOf((int) R.string.party));
        this.f2242b.put("Pop", Integer.valueOf((int) R.string.pop));
        this.f2242b.put("Classical", Integer.valueOf((int) R.string.classical));
        this.f2242b.put("Hip Hop & Rap", Integer.valueOf((int) R.string.hip_hop_rap));
        this.f2242b.put("Rock", Integer.valueOf((int) R.string.rock));
        this.f2242b.put("Country", Integer.valueOf((int) R.string.country));
        this.f2242b.put("Metal", Integer.valueOf((int) R.string.metal));
        this.f2242b.put("Soul", Integer.valueOf((int) R.string.soul));
        this.f2242b.put("EDM", Integer.valueOf((int) R.string.edm));
        this.f2242b.put("Dance", Integer.valueOf((int) R.string.dance));
        this.f2242b.put("Latin", Integer.valueOf((int) R.string.latin));
        this.f2242b.put("R&B", Integer.valueOf((int) R.string.r_b));
        this.f2242b.put("Indie", Integer.valueOf((int) R.string.indie));
        this.f2242b.put("Folk & Americana", Integer.valueOf((int) R.string.folk_americana));
        this.f2242b.put("Jazz", Integer.valueOf((int) R.string.jazz));
        this.f2242b.put("Funk", Integer.valueOf((int) R.string.funk));
        this.f2242b.put("Romance", Integer.valueOf((int) R.string.romance));
        this.f2242b.put("Blues", Integer.valueOf((int) R.string.blues));
        this.f2242b.put("Soundtrack", Integer.valueOf((int) R.string.soundtrack));
        this.f2242b.put("K-pop", Integer.valueOf((int) R.string.k_pop));
        this.f2242b.put("Reggae", Integer.valueOf((int) R.string.reggae));
        this.f2242b.put("English", Integer.valueOf((int) R.string.english));
        this.f2242b.put("French", Integer.valueOf((int) R.string.french));
        this.f2242b.put("Latin", Integer.valueOf((int) R.string.latin2));
        this.f2242b.put("Spanish", Integer.valueOf((int) R.string.spanish));
        this.f2242b.put("Portuguese", Integer.valueOf((int) R.string.portuguese));
        this.f2242b.put("Chinese", Integer.valueOf((int) R.string.chinese));
        this.f2242b.put("Arabic", Integer.valueOf((int) R.string.arabic));
        this.f2242b.put("Japanese", Integer.valueOf((int) R.string.japanese));
        this.f2242b.put("Korean", Integer.valueOf((int) R.string.korean));
        this.f2242b.put("Hindi", Integer.valueOf((int) R.string.hindi));
    }

    private void d() {
        this.f2243c.put("Sad", Integer.valueOf((int) R.string.sad_word));
        this.f2243c.put("Peaceful", Integer.valueOf((int) R.string.peaceful2_word));
        this.f2243c.put("Loneliness", Integer.valueOf((int) R.string.loneliness_word));
        this.f2243c.put("Inspiring", Integer.valueOf((int) R.string.inspiring_word));
        this.f2243c.put("Healing", Integer.valueOf((int) R.string.healing_word));
        this.f2243c.put("Boring", Integer.valueOf((int) R.string.boring_word));
        this.f2243c.put("Jogging", Integer.valueOf((int) R.string.jogging_word));
        this.f2243c.put("Sleep", Integer.valueOf((int) R.string.sleep_word));
        this.f2243c.put("Driving", Integer.valueOf((int) R.string.drive_word));
        this.f2243c.put("Travel", Integer.valueOf((int) R.string.travel_word));
        this.f2243c.put("Study", Integer.valueOf((int) R.string.study_word));
        this.f2243c.put("Party", Integer.valueOf((int) R.string.party_word));
        this.f2243c.put("Pop", Integer.valueOf((int) R.string.pop_word));
        this.f2243c.put("Classical", Integer.valueOf((int) R.string.classical_word));
        this.f2243c.put("Hip Hop & Rap", Integer.valueOf((int) R.string.hip_hop_rap_word));
        this.f2243c.put("Rock", Integer.valueOf((int) R.string.rock_word));
        this.f2243c.put("Country", Integer.valueOf((int) R.string.country_word));
        this.f2243c.put("Metal", Integer.valueOf((int) R.string.metal_word));
        this.f2243c.put("Soul", Integer.valueOf((int) R.string.soul_word));
        this.f2243c.put("EDM", Integer.valueOf((int) R.string.edm_word));
        this.f2243c.put("Dance", Integer.valueOf((int) R.string.dance_word));
        this.f2243c.put("Latin", Integer.valueOf((int) R.string.latin_word));
        this.f2243c.put("R&B", Integer.valueOf((int) R.string.r_b_word));
        this.f2243c.put("Indie", Integer.valueOf((int) R.string.indie_word));
        this.f2243c.put("Folk & Americana", Integer.valueOf((int) R.string.folk_americana_word));
        this.f2243c.put("Jazz", Integer.valueOf((int) R.string.jazz_word));
        this.f2243c.put("Funk", Integer.valueOf((int) R.string.funk_word));
        this.f2243c.put("Romance", Integer.valueOf((int) R.string.romance_word));
        this.f2243c.put("Blues", Integer.valueOf((int) R.string.blues_word));
        this.f2243c.put("Soundtrack", Integer.valueOf((int) R.string.soundtrack_word));
        this.f2243c.put("K-pop", Integer.valueOf((int) R.string.k_pop_word));
        this.f2243c.put("Reggae", Integer.valueOf((int) R.string.reggae_word));
        this.f2243c.put("English", Integer.valueOf((int) R.string.english_word));
        this.f2243c.put("French", Integer.valueOf((int) R.string.french_word));
        this.f2243c.put("Latin", Integer.valueOf((int) R.string.latin2_word));
        this.f2243c.put("Spanish", Integer.valueOf((int) R.string.spanish_word));
        this.f2243c.put("Portuguese", Integer.valueOf((int) R.string.portuguese_word));
        this.f2243c.put("Chinese", Integer.valueOf((int) R.string.chinese_word));
        this.f2243c.put("Arabic", Integer.valueOf((int) R.string.arabic_word));
        this.f2243c.put("Japanese", Integer.valueOf((int) R.string.japanese_word));
        this.f2243c.put("Korean", Integer.valueOf((int) R.string.korean_word));
        this.f2243c.put("Hindi", Integer.valueOf((int) R.string.hindi_word));
    }

    public String a(String str) {
        Integer num;
        try {
            if (!TextUtils.isEmpty(str) && this.f2241a != null && (num = this.f2241a.get(str)) != null) {
                return MusicApplication.c().getResources().getString(num.intValue());
            }
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
        return "null";
    }

    public String b(String str) {
        Integer num;
        try {
            if (!TextUtils.isEmpty(str) && this.f2242b != null && (num = this.f2242b.get(str)) != null) {
                return MusicApplication.c().getResources().getString(num.intValue());
            }
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
        return "null";
    }

    public String c(String str) {
        Integer num;
        try {
            if (!TextUtils.isEmpty(str) && this.f2243c != null && (num = this.f2243c.get(str)) != null) {
                return MusicApplication.c().getResources().getString(num.intValue());
            }
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
        return "null";
    }
}
