package com.foto.indexlib.IndexBar.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.support.v4.internal.view.SupportMenu;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.foto.indexlib.IndexBar.bean.BaseIndexBean;
import com.foto.indexlib.R;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes.dex */
public class NewIndexBar extends View {

    /* renamed from: a  reason: collision with root package name */
    public static String[] f2203a = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#"};

    /* renamed from: b  reason: collision with root package name */
    a f2204b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f2205c;
    private List<String> d;
    private int e;
    private int f;
    private int g;
    private int h;
    private Paint i;
    private Paint j;
    private com.foto.indexlib.IndexBar.a.a k;
    private TextView l;
    private List<? extends BaseIndexBean> m;
    private LinearLayoutManager n;
    private int o;
    private String p;
    private b q;

    /* loaded from: classes.dex */
    public interface a {
        void a();
    }

    /* loaded from: classes.dex */
    public interface b {
        void a();

        void a(int i, String str);
    }

    public NewIndexBar(Context context) {
        this(context, null);
    }

    public NewIndexBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NewIndexBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.o = 0;
        this.p = "";
        a(context, attributeSet, i);
    }

    public int getHeaderViewCount() {
        return this.o;
    }

    public NewIndexBar a(int i) {
        this.o = i;
        return this;
    }

    public com.foto.indexlib.IndexBar.a.a getDataHelper() {
        return this.k;
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
        this.i = new Paint();
        this.i.setAntiAlias(true);
        this.i.setTextSize(applyDimension);
        this.i.setColor(Color.parseColor("#676767"));
        this.j = new Paint();
        this.j.setAntiAlias(true);
        this.j.setTextSize(applyDimension);
        this.j.setColor(SupportMenu.CATEGORY_MASK);
        if (typeface != null) {
            this.i.setTypeface(typeface);
            this.j.setTypeface(typeface);
        }
        setmOnIndexPressedListener(new b() { // from class: com.foto.indexlib.IndexBar.widget.NewIndexBar.1
            @Override // com.foto.indexlib.IndexBar.widget.NewIndexBar.b
            public void a(int i3, String str) {
                int a2;
                if (NewIndexBar.this.l != null) {
                    NewIndexBar.this.l.setVisibility(0);
                    NewIndexBar.this.l.setText(str);
                }
                if (NewIndexBar.this.n != null && (a2 = NewIndexBar.this.a(str)) != -1) {
                    NewIndexBar.this.n.scrollToPositionWithOffset(a2, 0);
                }
            }

            @Override // com.foto.indexlib.IndexBar.widget.NewIndexBar.b
            public void a() {
                if (NewIndexBar.this.l != null) {
                    NewIndexBar.this.l.setVisibility(8);
                }
            }
        });
        this.k = new com.foto.indexlib.IndexBar.a.b();
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
        for (int i5 = 0; i5 < this.d.size(); i5++) {
            String str = this.d.get(i5);
            this.i.getTextBounds(str, 0, str.length(), rect);
            i4 = Math.max(rect.width(), i4);
            i3 = Math.max(rect.height(), i3);
        }
        int size3 = this.d.size() * i3;
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
            if (i2 < this.d.size()) {
                String str = this.d.get(i2);
                Paint.FontMetrics fontMetrics = this.i.getFontMetrics();
                int i3 = (int) (((this.h - fontMetrics.bottom) - fontMetrics.top) / 2.0f);
                if (str.equalsIgnoreCase(this.p)) {
                    canvas.drawText(str, (this.e / 2) - (this.i.measureText(str) / 2.0f), i3 + (this.h * i2) + paddingTop, this.j);
                } else {
                    canvas.drawText(str, (this.e / 2) - (this.i.measureText(str) / 2.0f), i3 + (this.h * i2) + paddingTop, this.i);
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
                int y = (int) ((motionEvent.getY() - getPaddingTop()) / this.h);
                if (y < 0) {
                    i = 0;
                } else {
                    i = y >= this.d.size() ? this.d.size() - 1 : y;
                }
                if (this.q != null && i > -1 && i < this.d.size()) {
                    this.q.a(i, this.d.get(i));
                    this.p = this.d.get(i);
                    invalidate();
                    return true;
                }
                return true;
            case 1:
            default:
                if (this.q != null) {
                    this.q.a();
                    return true;
                }
                return true;
        }
    }

    public void setOnSizeChangedListener(a aVar) {
        this.f2204b = aVar;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.e = i;
        this.f = i2;
        if (this.f > this.g) {
            this.g = this.f;
        }
        if (this.d != null && !this.d.isEmpty()) {
            c();
            if (this.f2204b != null) {
                this.f2204b.a();
            }
        }
    }

    public b getmOnIndexPressedListener() {
        return this.q;
    }

    public void setmOnIndexPressedListener(b bVar) {
        this.q = bVar;
    }

    public NewIndexBar a(TextView textView) {
        this.l = textView;
        return this;
    }

    public NewIndexBar a(LinearLayoutManager linearLayoutManager) {
        this.n = linearLayoutManager;
        return this;
    }

    public NewIndexBar a(boolean z) {
        this.f2205c = z;
        a();
        return this;
    }

    private void a() {
        if (this.f2205c) {
            this.d = new ArrayList();
        } else {
            this.d = Arrays.asList(f2203a);
        }
    }

    public NewIndexBar a(List<? extends BaseIndexBean> list) {
        this.m = list;
        if (list != null && list.size() > 0) {
            this.p = list.get(0).getSuspensionTag();
        }
        b();
        return this;
    }

    public int getMeasureHeight() {
        return ((((this.g - getPaddingTop()) - getPaddingBottom()) / f2203a.length) * this.d.size()) + getPaddingTop() + getPaddingBottom();
    }

    private void b() {
        if (this.m != null && !this.m.isEmpty() && this.f2205c) {
            this.k.a(this.m, this.d);
            c();
        }
    }

    private void c() {
        this.h = ((this.f - getPaddingTop()) - getPaddingBottom()) / this.d.size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(String str) {
        if (this.m == null || this.m.isEmpty()) {
            return -1;
        }
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.m.size()) {
                return -1;
            }
            if (!str.equals(this.m.get(i2).getBaseIndexTag())) {
                i = i2 + 1;
            } else {
                return getHeaderViewCount() + i2;
            }
        }
    }

    public void setCurrentIndex(String str) {
        this.p = str;
        invalidate();
    }
}
