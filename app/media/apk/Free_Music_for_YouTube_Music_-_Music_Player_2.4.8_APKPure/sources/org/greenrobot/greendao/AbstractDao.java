package org.greenrobot.greendao;

import android.database.CrossProcessCursor;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.greenrobot.greendao.annotation.apihint.Experimental;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.identityscope.IdentityScope;
import org.greenrobot.greendao.identityscope.IdentityScopeLong;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.internal.TableStatements;
import org.greenrobot.greendao.query.Query;
import org.greenrobot.greendao.query.QueryBuilder;
import org.greenrobot.greendao.rx.RxDao;
import rx.schedulers.Schedulers;
/* loaded from: classes2.dex */
public abstract class AbstractDao<T, K> {
    protected final DaoConfig config;
    protected final Database db;
    protected final IdentityScope<K, T> identityScope;
    protected final IdentityScopeLong<T> identityScopeLong;
    protected final boolean isStandardSQLite;
    protected final int pkOrdinal;
    private volatile RxDao<T, K> rxDao;
    private volatile RxDao<T, K> rxDaoPlain;
    protected final AbstractDaoSession session;
    protected final TableStatements statements;

    protected abstract void bindValues(SQLiteStatement sQLiteStatement, T t);

    protected abstract void bindValues(DatabaseStatement databaseStatement, T t);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract K getKey(T t);

    protected abstract boolean hasKey(T t);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean isEntityUpdateable();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract T readEntity(Cursor cursor, int i);

    protected abstract void readEntity(Cursor cursor, T t, int i);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract K readKey(Cursor cursor, int i);

    protected abstract K updateKeyAfterInsert(T t, long j);

    public AbstractDao(DaoConfig daoConfig) {
        this(daoConfig, null);
    }

    public AbstractDao(DaoConfig daoConfig, AbstractDaoSession abstractDaoSession) {
        this.config = daoConfig;
        this.session = abstractDaoSession;
        this.db = daoConfig.db;
        this.isStandardSQLite = this.db.getRawDatabase() instanceof SQLiteDatabase;
        this.identityScope = (IdentityScope<K, T>) daoConfig.getIdentityScope();
        if (this.identityScope instanceof IdentityScopeLong) {
            this.identityScopeLong = (IdentityScopeLong) this.identityScope;
        } else {
            this.identityScopeLong = null;
        }
        this.statements = daoConfig.statements;
        this.pkOrdinal = daoConfig.pkProperty != null ? daoConfig.pkProperty.ordinal : -1;
    }

    public AbstractDaoSession getSession() {
        return this.session;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TableStatements getStatements() {
        return this.config.statements;
    }

    public String getTablename() {
        return this.config.tablename;
    }

    public Property[] getProperties() {
        return this.config.properties;
    }

    public Property getPkProperty() {
        return this.config.pkProperty;
    }

    public String[] getAllColumns() {
        return this.config.allColumns;
    }

    public String[] getPkColumns() {
        return this.config.pkColumns;
    }

    public String[] getNonPkColumns() {
        return this.config.nonPkColumns;
    }

    public T load(K k) {
        T t;
        assertSinglePk();
        if (k == null) {
            return null;
        }
        return (this.identityScope == null || (t = this.identityScope.get(k)) == null) ? loadUniqueAndCloseCursor(this.db.rawQuery(this.statements.getSelectByKey(), new String[]{k.toString()})) : t;
    }

    public T loadByRowId(long j) {
        return loadUniqueAndCloseCursor(this.db.rawQuery(this.statements.getSelectByRowId(), new String[]{Long.toString(j)}));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public T loadUniqueAndCloseCursor(Cursor cursor) {
        try {
            return loadUnique(cursor);
        } finally {
            cursor.close();
        }
    }

    protected T loadUnique(Cursor cursor) {
        if (!cursor.moveToFirst()) {
            return null;
        }
        if (!cursor.isLast()) {
            throw new DaoException("Expected unique result, but count was " + cursor.getCount());
        }
        return loadCurrent(cursor, 0, true);
    }

    public List<T> loadAll() {
        return loadAllAndCloseCursor(this.db.rawQuery(this.statements.getSelectAll(), null));
    }

    public boolean detach(T t) {
        if (this.identityScope != null) {
            return this.identityScope.detach(getKeyVerified(t), t);
        }
        return false;
    }

    public void detachAll() {
        if (this.identityScope != null) {
            this.identityScope.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public List<T> loadAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }

    public void insertInTx(Iterable<T> iterable) {
        insertInTx(iterable, isEntityUpdateable());
    }

    public void insertInTx(T... tArr) {
        insertInTx(Arrays.asList(tArr), isEntityUpdateable());
    }

    public void insertInTx(Iterable<T> iterable, boolean z) {
        executeInsertInTx(this.statements.getInsertStatement(), iterable, z);
    }

    public void insertOrReplaceInTx(Iterable<T> iterable, boolean z) {
        executeInsertInTx(this.statements.getInsertOrReplaceStatement(), iterable, z);
    }

    public void insertOrReplaceInTx(Iterable<T> iterable) {
        insertOrReplaceInTx(iterable, isEntityUpdateable());
    }

    public void insertOrReplaceInTx(T... tArr) {
        insertOrReplaceInTx(Arrays.asList(tArr), isEntityUpdateable());
    }

    private void executeInsertInTx(DatabaseStatement databaseStatement, Iterable<T> iterable, boolean z) {
        this.db.beginTransaction();
        try {
            synchronized (databaseStatement) {
                if (this.identityScope != null) {
                    this.identityScope.lock();
                }
                if (this.isStandardSQLite) {
                    SQLiteStatement sQLiteStatement = (SQLiteStatement) databaseStatement.getRawStatement();
                    for (T t : iterable) {
                        bindValues(sQLiteStatement, (SQLiteStatement) t);
                        if (z) {
                            updateKeyAfterInsertAndAttach(t, sQLiteStatement.executeInsert(), false);
                        } else {
                            sQLiteStatement.execute();
                        }
                    }
                } else {
                    for (T t2 : iterable) {
                        bindValues(databaseStatement, (DatabaseStatement) t2);
                        if (z) {
                            updateKeyAfterInsertAndAttach(t2, databaseStatement.executeInsert(), false);
                        } else {
                            databaseStatement.execute();
                        }
                    }
                }
                if (this.identityScope != null) {
                    this.identityScope.unlock();
                }
            }
            this.db.setTransactionSuccessful();
        } finally {
            this.db.endTransaction();
        }
    }

    public long insert(T t) {
        return executeInsert(t, this.statements.getInsertStatement(), true);
    }

    public long insertWithoutSettingPk(T t) {
        return executeInsert(t, this.statements.getInsertOrReplaceStatement(), false);
    }

    public long insertOrReplace(T t) {
        return executeInsert(t, this.statements.getInsertOrReplaceStatement(), true);
    }

    private long executeInsert(T t, DatabaseStatement databaseStatement, boolean z) {
        long insertInsideTx;
        if (this.db.isDbLockedByCurrentThread()) {
            insertInsideTx = insertInsideTx(t, databaseStatement);
        } else {
            this.db.beginTransaction();
            try {
                insertInsideTx = insertInsideTx(t, databaseStatement);
                this.db.setTransactionSuccessful();
            } finally {
                this.db.endTransaction();
            }
        }
        if (z) {
            updateKeyAfterInsertAndAttach(t, insertInsideTx, true);
        }
        return insertInsideTx;
    }

    private long insertInsideTx(T t, DatabaseStatement databaseStatement) {
        long executeInsert;
        synchronized (databaseStatement) {
            if (this.isStandardSQLite) {
                SQLiteStatement sQLiteStatement = (SQLiteStatement) databaseStatement.getRawStatement();
                bindValues(sQLiteStatement, (SQLiteStatement) t);
                executeInsert = sQLiteStatement.executeInsert();
            } else {
                bindValues(databaseStatement, (DatabaseStatement) t);
                executeInsert = databaseStatement.executeInsert();
            }
        }
        return executeInsert;
    }

    protected void updateKeyAfterInsertAndAttach(T t, long j, boolean z) {
        if (j != -1) {
            attachEntity(updateKeyAfterInsert(t, j), t, z);
        } else {
            DaoLog.w("Could not insert row (executeInsert returned -1)");
        }
    }

    public void save(T t) {
        if (hasKey(t)) {
            update(t);
        } else {
            insert(t);
        }
    }

    public void saveInTx(T... tArr) {
        saveInTx(Arrays.asList(tArr));
    }

    public void saveInTx(Iterable<T> iterable) {
        int i = 0;
        int i2 = 0;
        for (T t : iterable) {
            if (hasKey(t)) {
                i2++;
            } else {
                i++;
            }
        }
        if (i2 > 0 && i > 0) {
            ArrayList arrayList = new ArrayList(i2);
            ArrayList arrayList2 = new ArrayList(i);
            for (T t2 : iterable) {
                if (hasKey(t2)) {
                    arrayList.add(t2);
                } else {
                    arrayList2.add(t2);
                }
            }
            this.db.beginTransaction();
            try {
                updateInTx(arrayList);
                insertInTx(arrayList2);
                this.db.setTransactionSuccessful();
            } finally {
                this.db.endTransaction();
            }
        } else if (i > 0) {
            insertInTx(iterable);
        } else if (i2 > 0) {
            updateInTx(iterable);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected java.util.List<T> loadAllFromCursor(android.database.Cursor r8) {
        /*
            r7 = this;
            r1 = 0
            int r4 = r8.getCount()
            if (r4 != 0) goto Ld
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
        Lc:
            return r0
        Ld:
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>(r4)
            r0 = 0
            boolean r2 = r8 instanceof android.database.CrossProcessCursor
            if (r2 == 0) goto L99
            r0 = r8
            android.database.CrossProcessCursor r0 = (android.database.CrossProcessCursor) r0
            android.database.CursorWindow r2 = r0.getWindow()
            if (r2 == 0) goto L7b
            int r0 = r2.getNumRows()
            if (r0 != r4) goto L57
            org.greenrobot.greendao.internal.FastCursor r8 = new org.greenrobot.greendao.internal.FastCursor
            r8.<init>(r2)
            r0 = 1
            r1 = r2
        L2d:
            boolean r2 = r8.moveToFirst()
            if (r2 == 0) goto L55
            org.greenrobot.greendao.identityscope.IdentityScope<K, T> r2 = r7.identityScope
            if (r2 == 0) goto L41
            org.greenrobot.greendao.identityscope.IdentityScope<K, T> r2 = r7.identityScope
            r2.lock()
            org.greenrobot.greendao.identityscope.IdentityScope<K, T> r2 = r7.identityScope
            r2.reserveRoom(r4)
        L41:
            if (r0 != 0) goto L7e
            if (r1 == 0) goto L7e
            org.greenrobot.greendao.identityscope.IdentityScope<K, T> r0 = r7.identityScope     // Catch: java.lang.Throwable -> L8e
            if (r0 == 0) goto L7e
            r7.loadAllUnlockOnWindowBounds(r8, r1, r3)     // Catch: java.lang.Throwable -> L8e
        L4c:
            org.greenrobot.greendao.identityscope.IdentityScope<K, T> r0 = r7.identityScope
            if (r0 == 0) goto L55
            org.greenrobot.greendao.identityscope.IdentityScope<K, T> r0 = r7.identityScope
            r0.unlock()
        L55:
            r0 = r3
            goto Lc
        L57:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r5 = "Window vs. result size: "
            java.lang.StringBuilder r0 = r0.append(r5)
            int r5 = r2.getNumRows()
            java.lang.StringBuilder r0 = r0.append(r5)
            java.lang.String r5 = "/"
            java.lang.StringBuilder r0 = r0.append(r5)
            java.lang.StringBuilder r0 = r0.append(r4)
            java.lang.String r0 = r0.toString()
            org.greenrobot.greendao.DaoLog.d(r0)
        L7b:
            r0 = r1
            r1 = r2
            goto L2d
        L7e:
            r0 = 0
            r1 = 0
            java.lang.Object r0 = r7.loadCurrent(r8, r0, r1)     // Catch: java.lang.Throwable -> L8e
            r3.add(r0)     // Catch: java.lang.Throwable -> L8e
            boolean r0 = r8.moveToNext()     // Catch: java.lang.Throwable -> L8e
            if (r0 != 0) goto L7e
            goto L4c
        L8e:
            r0 = move-exception
            org.greenrobot.greendao.identityscope.IdentityScope<K, T> r1 = r7.identityScope
            if (r1 == 0) goto L98
            org.greenrobot.greendao.identityscope.IdentityScope<K, T> r1 = r7.identityScope
            r1.unlock()
        L98:
            throw r0
        L99:
            r6 = r1
            r1 = r0
            r0 = r6
            goto L2d
        */
        throw new UnsupportedOperationException("Method not decompiled: org.greenrobot.greendao.AbstractDao.loadAllFromCursor(android.database.Cursor):java.util.List");
    }

    private void loadAllUnlockOnWindowBounds(Cursor cursor, CursorWindow cursorWindow, List<T> list) {
        int startPosition = cursorWindow.getStartPosition() + cursorWindow.getNumRows();
        int i = 0;
        while (true) {
            list.add(loadCurrent(cursor, 0, false));
            int i2 = i + 1;
            if (i2 >= startPosition) {
                CursorWindow moveToNextUnlocked = moveToNextUnlocked(cursor);
                if (moveToNextUnlocked != null) {
                    startPosition = moveToNextUnlocked.getNumRows() + moveToNextUnlocked.getStartPosition();
                } else {
                    return;
                }
            } else if (!cursor.moveToNext()) {
                return;
            }
            i = i2 + 1;
        }
    }

    private CursorWindow moveToNextUnlocked(Cursor cursor) {
        this.identityScope.unlock();
        try {
            if (cursor.moveToNext()) {
                return ((CrossProcessCursor) cursor).getWindow();
            }
            return null;
        } finally {
            this.identityScope.lock();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final T loadCurrent(Cursor cursor, int i, boolean z) {
        if (this.identityScopeLong != null) {
            if (i == 0 || !cursor.isNull(this.pkOrdinal + i)) {
                long j = cursor.getLong(this.pkOrdinal + i);
                T t = z ? this.identityScopeLong.get2(j) : this.identityScopeLong.get2NoLock(j);
                if (t == null) {
                    T readEntity = readEntity(cursor, i);
                    attachEntity(readEntity);
                    if (z) {
                        this.identityScopeLong.put2(j, readEntity);
                        return readEntity;
                    }
                    this.identityScopeLong.put2NoLock(j, readEntity);
                    return readEntity;
                }
                return t;
            }
            return null;
        } else if (this.identityScope != null) {
            K readKey = readKey(cursor, i);
            if (i == 0 || readKey != null) {
                T noLock = z ? this.identityScope.get(readKey) : this.identityScope.getNoLock(readKey);
                if (noLock == null) {
                    T readEntity2 = readEntity(cursor, i);
                    attachEntity(readKey, readEntity2, z);
                    return readEntity2;
                }
                return noLock;
            }
            return null;
        } else if (i == 0 || readKey(cursor, i) != null) {
            T readEntity3 = readEntity(cursor, i);
            attachEntity(readEntity3);
            return readEntity3;
        } else {
            return null;
        }
    }

    protected final <O> O loadCurrentOther(AbstractDao<O, ?> abstractDao, Cursor cursor, int i) {
        return abstractDao.loadCurrent(cursor, i, true);
    }

    public List<T> queryRaw(String str, String... strArr) {
        return loadAllAndCloseCursor(this.db.rawQuery(this.statements.getSelectAll() + str, strArr));
    }

    public Query<T> queryRawCreate(String str, Object... objArr) {
        return queryRawCreateListArgs(str, Arrays.asList(objArr));
    }

    public Query<T> queryRawCreateListArgs(String str, Collection<Object> collection) {
        return Query.internalCreate(this, this.statements.getSelectAll() + str, collection.toArray());
    }

    public void deleteAll() {
        this.db.execSQL("DELETE FROM '" + this.config.tablename + "'");
        if (this.identityScope != null) {
            this.identityScope.clear();
        }
    }

    public void delete(T t) {
        assertSinglePk();
        deleteByKey(getKeyVerified(t));
    }

    public void deleteByKey(K k) {
        assertSinglePk();
        DatabaseStatement deleteStatement = this.statements.getDeleteStatement();
        if (this.db.isDbLockedByCurrentThread()) {
            synchronized (deleteStatement) {
                deleteByKeyInsideSynchronized(k, deleteStatement);
            }
        } else {
            this.db.beginTransaction();
            try {
                synchronized (deleteStatement) {
                    deleteByKeyInsideSynchronized(k, deleteStatement);
                }
                this.db.setTransactionSuccessful();
            } finally {
                this.db.endTransaction();
            }
        }
        if (this.identityScope != null) {
            this.identityScope.remove((IdentityScope<K, T>) k);
        }
    }

    private void deleteByKeyInsideSynchronized(K k, DatabaseStatement databaseStatement) {
        if (k instanceof Long) {
            databaseStatement.bindLong(1, ((Long) k).longValue());
        } else if (k == null) {
            throw new DaoException("Cannot delete entity, key is null");
        } else {
            databaseStatement.bindString(1, k.toString());
        }
        databaseStatement.execute();
    }

    private void deleteInTxInternal(Iterable<T> iterable, Iterable<K> iterable2) {
        assertSinglePk();
        DatabaseStatement deleteStatement = this.statements.getDeleteStatement();
        ArrayList arrayList = null;
        this.db.beginTransaction();
        try {
            synchronized (deleteStatement) {
                if (this.identityScope != null) {
                    this.identityScope.lock();
                    arrayList = new ArrayList();
                }
                if (iterable != null) {
                    for (T t : iterable) {
                        K keyVerified = getKeyVerified(t);
                        deleteByKeyInsideSynchronized(keyVerified, deleteStatement);
                        if (arrayList != null) {
                            arrayList.add(keyVerified);
                        }
                    }
                }
                if (iterable2 != null) {
                    for (K k : iterable2) {
                        deleteByKeyInsideSynchronized(k, deleteStatement);
                        if (arrayList != null) {
                            arrayList.add(k);
                        }
                    }
                }
                if (this.identityScope != null) {
                    this.identityScope.unlock();
                }
            }
            this.db.setTransactionSuccessful();
            if (arrayList != null && this.identityScope != null) {
                this.identityScope.remove((Iterable) arrayList);
            }
        } finally {
            this.db.endTransaction();
        }
    }

    public void deleteInTx(Iterable<T> iterable) {
        deleteInTxInternal(iterable, null);
    }

    public void deleteInTx(T... tArr) {
        deleteInTxInternal(Arrays.asList(tArr), null);
    }

    public void deleteByKeyInTx(Iterable<K> iterable) {
        deleteInTxInternal(null, iterable);
    }

    public void deleteByKeyInTx(K... kArr) {
        deleteInTxInternal(null, Arrays.asList(kArr));
    }

    public void refresh(T t) {
        assertSinglePk();
        K keyVerified = getKeyVerified(t);
        Cursor rawQuery = this.db.rawQuery(this.statements.getSelectByKey(), new String[]{keyVerified.toString()});
        try {
            if (!rawQuery.moveToFirst()) {
                throw new DaoException("Entity does not exist in the database anymore: " + t.getClass() + " with key " + keyVerified);
            }
            if (!rawQuery.isLast()) {
                throw new DaoException("Expected unique result, but count was " + rawQuery.getCount());
            }
            readEntity(rawQuery, t, 0);
            attachEntity(keyVerified, t, true);
        } finally {
            rawQuery.close();
        }
    }

    public void update(T t) {
        assertSinglePk();
        DatabaseStatement updateStatement = this.statements.getUpdateStatement();
        if (this.db.isDbLockedByCurrentThread()) {
            synchronized (updateStatement) {
                if (this.isStandardSQLite) {
                    updateInsideSynchronized((AbstractDao<T, K>) t, (SQLiteStatement) updateStatement.getRawStatement(), true);
                } else {
                    updateInsideSynchronized((AbstractDao<T, K>) t, updateStatement, true);
                }
            }
            return;
        }
        this.db.beginTransaction();
        try {
            synchronized (updateStatement) {
                updateInsideSynchronized((AbstractDao<T, K>) t, updateStatement, true);
            }
            this.db.setTransactionSuccessful();
        } finally {
            this.db.endTransaction();
        }
    }

    public QueryBuilder<T> queryBuilder() {
        return QueryBuilder.internalCreate(this);
    }

    protected void updateInsideSynchronized(T t, DatabaseStatement databaseStatement, boolean z) {
        bindValues(databaseStatement, (DatabaseStatement) t);
        int length = this.config.allColumns.length + 1;
        K key = getKey(t);
        if (key instanceof Long) {
            databaseStatement.bindLong(length, ((Long) key).longValue());
        } else if (key == null) {
            throw new DaoException("Cannot update entity without key - was it inserted before?");
        } else {
            databaseStatement.bindString(length, key.toString());
        }
        databaseStatement.execute();
        attachEntity(key, t, z);
    }

    protected void updateInsideSynchronized(T t, SQLiteStatement sQLiteStatement, boolean z) {
        bindValues(sQLiteStatement, (SQLiteStatement) t);
        int length = this.config.allColumns.length + 1;
        K key = getKey(t);
        if (key instanceof Long) {
            sQLiteStatement.bindLong(length, ((Long) key).longValue());
        } else if (key == null) {
            throw new DaoException("Cannot update entity without key - was it inserted before?");
        } else {
            sQLiteStatement.bindString(length, key.toString());
        }
        sQLiteStatement.execute();
        attachEntity(key, t, z);
    }

    protected final void attachEntity(K k, T t, boolean z) {
        attachEntity(t);
        if (this.identityScope != null && k != null) {
            if (z) {
                this.identityScope.put(k, t);
            } else {
                this.identityScope.putNoLock(k, t);
            }
        }
    }

    protected void attachEntity(T t) {
    }

    public void updateInTx(Iterable<T> iterable) {
        DatabaseStatement updateStatement = this.statements.getUpdateStatement();
        this.db.beginTransaction();
        try {
            synchronized (updateStatement) {
                if (this.identityScope != null) {
                    this.identityScope.lock();
                }
                if (this.isStandardSQLite) {
                    SQLiteStatement sQLiteStatement = (SQLiteStatement) updateStatement.getRawStatement();
                    for (T t : iterable) {
                        updateInsideSynchronized((AbstractDao<T, K>) t, sQLiteStatement, false);
                    }
                } else {
                    for (T t2 : iterable) {
                        updateInsideSynchronized((AbstractDao<T, K>) t2, updateStatement, false);
                    }
                }
                if (this.identityScope != null) {
                    this.identityScope.unlock();
                }
            }
            this.db.setTransactionSuccessful();
            try {
                this.db.endTransaction();
            } catch (RuntimeException e) {
                if (0 == 0) {
                    throw e;
                }
                DaoLog.w("Could not end transaction (rethrowing initial exception)", e);
                throw null;
            }
        } catch (RuntimeException e2) {
            try {
                this.db.endTransaction();
            } catch (RuntimeException e3) {
                if (e2 == null) {
                    throw e3;
                }
                DaoLog.w("Could not end transaction (rethrowing initial exception)", e3);
                throw e2;
            }
        } catch (Throwable th) {
            try {
                this.db.endTransaction();
                throw th;
            } catch (RuntimeException e4) {
                if (0 == 0) {
                    throw e4;
                }
                DaoLog.w("Could not end transaction (rethrowing initial exception)", e4);
                throw null;
            }
        }
    }

    public void updateInTx(T... tArr) {
        updateInTx(Arrays.asList(tArr));
    }

    protected void assertSinglePk() {
        if (this.config.pkColumns.length != 1) {
            throw new DaoException(this + " (" + this.config.tablename + ") does not have a single-column primary key");
        }
    }

    public long count() {
        return this.statements.getCountStatement().simpleQueryForLong();
    }

    protected K getKeyVerified(T t) {
        K key = getKey(t);
        if (key == null) {
            if (t == null) {
                throw new NullPointerException("Entity may not be null");
            }
            throw new DaoException("Entity has no key");
        }
        return key;
    }

    @Experimental
    public RxDao<T, K> rxPlain() {
        if (this.rxDaoPlain == null) {
            this.rxDaoPlain = new RxDao<>(this);
        }
        return this.rxDaoPlain;
    }

    @Experimental
    public RxDao<T, K> rx() {
        if (this.rxDao == null) {
            this.rxDao = new RxDao<>(this, Schedulers.io());
        }
        return this.rxDao;
    }

    public Database getDatabase() {
        return this.db;
    }
}
