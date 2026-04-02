package com.fotoable.youtube.music.db.greendao.gen;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.facebook.share.internal.ShareConstants;
import com.fotoable.youtube.music.bean.RadioBean;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;
/* loaded from: classes.dex */
public class RadioBeanDao extends AbstractDao<RadioBean, Long> {
    public static final String TABLENAME = "RADIO_BEAN";

    /* loaded from: classes.dex */
    public static class Properties {

        /* renamed from: a  reason: collision with root package name */
        public static final Property f2703a = new Property(0, Long.class, "originalId", true, "_id");

        /* renamed from: b  reason: collision with root package name */
        public static final Property f2704b = new Property(1, Integer.TYPE, "id", false, "ID");

        /* renamed from: c  reason: collision with root package name */
        public static final Property f2705c = new Property(2, String.class, "countryCode", false, "COUNTRY_CODE");
        public static final Property d = new Property(3, String.class, "title", false, ShareConstants.TITLE);
        public static final Property e = new Property(4, String.class, "audioType", false, "AUDIO_TYPE");
        public static final Property f = new Property(5, String.class, "audioUrl", false, "AUDIO_URL");
        public static final Property g = new Property(6, String.class, "imgUrl", false, "IMG_URL");
    }

    public RadioBeanDao(DaoConfig daoConfig, b bVar) {
        super(daoConfig, bVar);
    }

    public static void a(Database database, boolean z) {
        database.execSQL("CREATE TABLE " + (z ? "IF NOT EXISTS " : "") + "\"RADIO_BEAN\" (\"_id\" INTEGER PRIMARY KEY ,\"ID\" INTEGER NOT NULL ,\"COUNTRY_CODE\" TEXT,\"TITLE\" TEXT,\"AUDIO_TYPE\" TEXT,\"AUDIO_URL\" TEXT,\"IMG_URL\" TEXT);");
    }

    public static void b(Database database, boolean z) {
        database.execSQL("DROP TABLE " + (z ? "IF EXISTS " : "") + "\"RADIO_BEAN\"");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: a */
    public final void bindValues(DatabaseStatement databaseStatement, RadioBean radioBean) {
        databaseStatement.clearBindings();
        Long originalId = radioBean.getOriginalId();
        if (originalId != null) {
            databaseStatement.bindLong(1, originalId.longValue());
        }
        databaseStatement.bindLong(2, radioBean.getId());
        String countryCode = radioBean.getCountryCode();
        if (countryCode != null) {
            databaseStatement.bindString(3, countryCode);
        }
        String title = radioBean.getTitle();
        if (title != null) {
            databaseStatement.bindString(4, title);
        }
        String audioType = radioBean.getAudioType();
        if (audioType != null) {
            databaseStatement.bindString(5, audioType);
        }
        String audioUrl = radioBean.getAudioUrl();
        if (audioUrl != null) {
            databaseStatement.bindString(6, audioUrl);
        }
        String imgUrl = radioBean.getImgUrl();
        if (imgUrl != null) {
            databaseStatement.bindString(7, imgUrl);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: a */
    public final void bindValues(SQLiteStatement sQLiteStatement, RadioBean radioBean) {
        sQLiteStatement.clearBindings();
        Long originalId = radioBean.getOriginalId();
        if (originalId != null) {
            sQLiteStatement.bindLong(1, originalId.longValue());
        }
        sQLiteStatement.bindLong(2, radioBean.getId());
        String countryCode = radioBean.getCountryCode();
        if (countryCode != null) {
            sQLiteStatement.bindString(3, countryCode);
        }
        String title = radioBean.getTitle();
        if (title != null) {
            sQLiteStatement.bindString(4, title);
        }
        String audioType = radioBean.getAudioType();
        if (audioType != null) {
            sQLiteStatement.bindString(5, audioType);
        }
        String audioUrl = radioBean.getAudioUrl();
        if (audioUrl != null) {
            sQLiteStatement.bindString(6, audioUrl);
        }
        String imgUrl = radioBean.getImgUrl();
        if (imgUrl != null) {
            sQLiteStatement.bindString(7, imgUrl);
        }
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: a */
    public Long readKey(Cursor cursor, int i) {
        if (cursor.isNull(i + 0)) {
            return null;
        }
        return Long.valueOf(cursor.getLong(i + 0));
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: b */
    public RadioBean readEntity(Cursor cursor, int i) {
        return new RadioBean(cursor.isNull(i + 0) ? null : Long.valueOf(cursor.getLong(i + 0)), cursor.getInt(i + 1), cursor.isNull(i + 2) ? null : cursor.getString(i + 2), cursor.isNull(i + 3) ? null : cursor.getString(i + 3), cursor.isNull(i + 4) ? null : cursor.getString(i + 4), cursor.isNull(i + 5) ? null : cursor.getString(i + 5), cursor.isNull(i + 6) ? null : cursor.getString(i + 6));
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: a */
    public void readEntity(Cursor cursor, RadioBean radioBean, int i) {
        radioBean.setOriginalId(cursor.isNull(i + 0) ? null : Long.valueOf(cursor.getLong(i + 0)));
        radioBean.setId(cursor.getInt(i + 1));
        radioBean.setCountryCode(cursor.isNull(i + 2) ? null : cursor.getString(i + 2));
        radioBean.setTitle(cursor.isNull(i + 3) ? null : cursor.getString(i + 3));
        radioBean.setAudioType(cursor.isNull(i + 4) ? null : cursor.getString(i + 4));
        radioBean.setAudioUrl(cursor.isNull(i + 5) ? null : cursor.getString(i + 5));
        radioBean.setImgUrl(cursor.isNull(i + 6) ? null : cursor.getString(i + 6));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: a */
    public final Long updateKeyAfterInsert(RadioBean radioBean, long j) {
        radioBean.setOriginalId(Long.valueOf(j));
        return Long.valueOf(j);
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: a */
    public Long getKey(RadioBean radioBean) {
        if (radioBean != null) {
            return radioBean.getOriginalId();
        }
        return null;
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: b */
    public boolean hasKey(RadioBean radioBean) {
        return radioBean.getOriginalId() != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    public final boolean isEntityUpdateable() {
        return true;
    }
}
