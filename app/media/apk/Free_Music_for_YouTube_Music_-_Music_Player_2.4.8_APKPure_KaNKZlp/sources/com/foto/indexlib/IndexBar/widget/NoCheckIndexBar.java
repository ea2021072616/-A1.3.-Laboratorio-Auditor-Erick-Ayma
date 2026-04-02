package com.foto.indexlib.IndexBar.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.foto.indexlib.IndexBar.a.b;
import com.foto.indexlib.IndexBar.bean.BaseIndexBean;
import com.foto.indexlib.R;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes.dex */
public class NoCheckIndexBar extends View {

    /* renamed from: a  reason: collision with root package name */
    public static String[] f2207a = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#"};

    /* renamed from: b  reason: collision with root package name */
    private boolean f2208b;

    /* renamed from: c  reason: collision with root package name */
    private List<String> f2209c;
    private int d;
    private int e;
    private int f;
    private Paint g;
    private Paint h;
    private com.foto.indexlib.IndexBar.a.a i;
    private TextView j;
    private List<? extends BaseIndexBean> k;
    private LinearLayoutManager l;
    private int m;
    private String n;
    private a o;

    /* loaded from: classes.dex */
    public interface a {
        void a();

        void a(int i, String str);
    }

    public NoCheckIndexBar(Context context) {
        this(context, null);
    }

    public NoCheckIndexBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NoCheckIndexBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.m = 0;
        this.n = "";
        a(context, attributeSet, i);
    }

    public int getHeaderViewCount() {
        return this.m;
    }

    public com.foto.indexlib.IndexBar.a.a getDataHelper() {
        return this.i;
    }

    private void a(Context context, AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.IndexBar, i, 0);
        int indexCount = obtainStyledAttributes.getIndexCount();
        int applyDimension = (int) TypedValue.applyDimension(2, 11.0f, getResources().getDisplayMetrics());
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = obtainStyledAttributes.getIndex(i2);
            if (index == R.styleable.IndexBar_indexBarTextSize) {
                applyDimension = obtainStyledAttributes.getDimensionPixelSize(index, applyDimension);
            }
        }
        a();
        Typeface typeface = null;
        try {
            typeface = Typeface.createFromAsset(context.getAssets(), "fonts/Lato-Bold.ttf");
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
        this.g = new Paint();
        this.g.setAntiAlias(true);
        this.g.setTextSize(applyDimension);
        this.g.setColor(Color.parseColor("#676767"));
        this.h = new Paint();
        this.h.setAntiAlias(true);
        this.h.setTextSize(applyDimension);
        this.h.setColor(Color.parseColor("#676767"));
        if (typeface != null) {
            this.g.setTypeface(typeface);
            this.h.setTypeface(typeface);
        }
        setmOnIndexPressedListener(new a() { // from class: com.foto.indexlib.IndexBar.widget.NoCheckIndexBar.1
            @Override // com.foto.indexlib.IndexBar.widget.NoCheckIndexBar.a
            public void a(int i3, String str) {
                int a2;
                if (NoCheckIndexBar.this.j != null) {
                    NoCheckIndexBar.this.j.setVisibility(0);
                    NoCheckIndexBar.this.j.setText(str);
                }
                if (NoCheckIndexBar.this.l != null && (a2 = NoCheckIndexBar.this.a(str)) != -1) {
                    NoCheckIndexBar.this.l.scrollToPositionWithOffset(a2, 0);
                }
            }

            @Override // com.foto.indexlib.IndexBar.widget.NoCheckIndexBar.a
            public void a() {
                if (NoCheckIndexBar.this.j != null) {
                    NoCheckIndexBar.this.j.setVisibility(8);
                }
            }
        });
        this.i = new b();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        Rect rect = new Rect();
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < this.f2209c.size(); i5++) {
            String str = this.f2209c.get(i5);
            this.g.getTextBounds(str, 0, str.length(), rect);
            i4 = Math.max(rect.width(), i4);
            i3 = Math.max(rect.height(), i3);
        }
        int size3 = this.f2209c.size() * i3;
        switch (mode) {
            case Integer.MIN_VALUE:
                i4 = Math.min(i4, size);
                break;
            case 1073741824:
                i4 = size;
                break;
        }
        switch (mode2) {
            case Integer.MIN_VALUE:
                size3 = Math.min(size3, size2);
                break;
            case 1073741824:
                size3 = size2;
                break;
        }
        setMeasuredDimension(i4, size3);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int paddingTop = getPaddingTop();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f2209c.size()) {
                String str = this.f2209c.get(i2);
                Paint.FontMetrics fontMetrics = this.g.getFontMetrics();
                int i3 = (int) (((this.f - fontMetrics.bottom) - fontMetrics.top) / 2.0f);
                if (str.equalsIgnoreCase(this.n)) {
                    canvas.drawText(str, (this.d / 2) - (this.g.measureText(str) / 2.0f), i3 + (this.f * i2) + paddingTop, this.h);
                } else {
                    canvas.drawText(str, (this.d / 2) - (this.g.measureText(str) / 2.0f), i3 + (this.f * i2) + paddingTop, this.g);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i;
        switch (motionEvent.getAction()) {
            case 0:
            case 2:
                int y = (int) ((motionEvent.getY() - getPaddingTop()) / this.f);
                if (y < 0) {
                    i = 0;
                } else {
                    i = y >= this.f2209c.size() ? this.f2209c.size() - 1 : y;
                }
                if (this.o != null && i > -1 && i < this.f2209c.size()) {
                    this.o.a(i, this.f2209c.get(i));
                    this.n = this.f2209c.get(i);
                    invalidate();
                    return true;
                }
                return true;
            case 1:
            default:
                if (this.o != null) {
                    this.o.a();
                    return true;
                }
                return true;
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.d = i;
        this.e = i2;
        if (this.f2209c != null && !this.f2209c.isEmpty()) {
            b();
        }
    }

    public a getmOnIndexPressedListener() {
        return this.o;
    }

    public void setmOnIndexPressedListener(a aVar) {
        this.o = aVar;
    }

    private void a() {
        if (this.f2208b) {
            this.f2209c = new ArrayList();
        } else {
            this.f2209c = Arrays.asList(f2207a);
        }
    }

    private void b() {
        this.f = ((this.e - getPaddingTop()) - getPaddingBottom()) / this.f2209c.size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(String str) {
        if (this.k == null || this.k.isEmpty()) {
            return -1;
        }
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.k.size()) {
                return -1;
            }
            if (!str.equals(this.k.get(i2).getBaseIndexTag())) {
                i = i2 + 1;
            } else {
                return getHeaderViewCount() + i2;
            }
        }
    }

    public void setCurrentIndex(String str) {
        this.n = str;
        invalidate();
    }
}
