package com.andexert.expandablelayout.library;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
public class ExpandableLayout extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private Boolean f563a;

    /* renamed from: b  reason: collision with root package name */
    private Boolean f564b;

    /* renamed from: c  reason: collision with root package name */
    private Integer f565c;
    private RelativeLayout d;
    private RelativeLayout e;

    public ExpandableLayout(Context context) {
        super(context);
        this.f563a = false;
        this.f564b = false;
    }

    public ExpandableLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f563a = false;
        this.f564b = false;
        a(context, attributeSet);
    }

    public ExpandableLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f563a = false;
        this.f564b = false;
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        View inflate = View.inflate(context, R.layout.view_expandable, this);
        this.e = (RelativeLayout) inflate.findViewById(R.id.view_expandable_headerlayout);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandableLayout);
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        int resourceId2 = obtainStyledAttributes.getResourceId(1, -1);
        this.d = (RelativeLayout) inflate.findViewById(R.id.view_expandable_contentLayout);
        if (resourceId == -1 || resourceId2 == -1) {
            throw new IllegalArgumentException("HeaderLayout and ContentLayout cannot be null!");
        }
        this.f565c = Integer.valueOf(obtainStyledAttributes.getInt(2, getContext().getResources().getInteger(17694720)));
        View inflate2 = View.inflate(context, resourceId, null);
        inflate2.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.e.addView(inflate2);
        View inflate3 = View.inflate(context, resourceId2, null);
        inflate3.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        this.d.addView(inflate3);
        this.d.setVisibility(8);
        this.e.setOnClickListener(new View.OnClickListener() { // from class: com.andexert.expandablelayout.library.ExpandableLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!ExpandableLayout.this.f563a.booleanValue()) {
                    if (ExpandableLayout.this.d.getVisibility() == 0) {
                        ExpandableLayout.this.b(ExpandableLayout.this.d);
                    } else {
                        ExpandableLayout.this.a(ExpandableLayout.this.d);
                    }
                    ExpandableLayout.this.f563a = true;
                    new Handler().postDelayed(new Runnable() { // from class: com.andexert.expandablelayout.library.ExpandableLayout.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ExpandableLayout.this.f563a = false;
                        }
                    }, ExpandableLayout.this.f565c.intValue());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final View view) {
        view.measure(-1, -2);
        final int measuredHeight = view.getMeasuredHeight();
        view.getLayoutParams().height = 0;
        view.setVisibility(0);
        Animation animation = new Animation() { // from class: com.andexert.expandablelayout.library.ExpandableLayout.2
            @Override // android.view.animation.Animation
            protected void applyTransformation(float f, Transformation transformation) {
                if (f == 1.0f) {
                    ExpandableLayout.this.f564b = true;
                }
                view.getLayoutParams().height = f == 1.0f ? -2 : (int) (measuredHeight * f);
                view.requestLayout();
            }

            @Override // android.view.animation.Animation
            public boolean willChangeBounds() {
                return true;
            }
        };
        animation.setDuration(this.f565c.intValue());
        view.startAnimation(animation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final View view) {
        final int measuredHeight = view.getMeasuredHeight();
        Animation animation = new Animation() { // from class: com.andexert.expandablelayout.library.ExpandableLayout.3
            @Override // android.view.animation.Animation
            protected void applyTransformation(float f, Transformation transformation) {
                if (f == 1.0f) {
                    view.setVisibility(8);
                    ExpandableLayout.this.f564b = false;
                    return;
                }
                view.getLayoutParams().height = measuredHeight - ((int) (measuredHeight * f));
                view.requestLayout();
            }

            @Override // android.view.animation.Animation
            public boolean willChangeBounds() {
                return true;
            }
        };
        animation.setDuration(this.f565c.intValue());
        view.startAnimation(animation);
    }

    public Boolean a() {
        return this.f564b;
    }

    public void b() {
        if (!this.f563a.booleanValue()) {
            a(this.d);
            this.f563a = true;
            new Handler().postDelayed(new Runnable() { // from class: com.andexert.expandablelayout.library.ExpandableLayout.4
                @Override // java.lang.Runnable
                public void run() {
                    ExpandableLayout.this.f563a = false;
                }
            }, this.f565c.intValue());
        }
    }

    public RelativeLayout getHeaderRelativeLayout() {
        return this.e;
    }

    public RelativeLayout getContentRelativeLayout() {
        return this.d;
    }

    public void c() {
        if (!this.f563a.booleanValue()) {
            b(this.d);
            this.f563a = true;
            new Handler().postDelayed(new Runnable() { // from class: com.andexert.expandablelayout.library.ExpandableLayout.5
                @Override // java.lang.Runnable
                public void run() {
                    ExpandableLayout.this.f563a = false;
                }
            }, this.f565c.intValue());
        }
    }
}
