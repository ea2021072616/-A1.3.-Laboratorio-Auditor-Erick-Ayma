package com.andexert.expandablelayout.library;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
public class ExpandableLayoutItem extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private Boolean f576a;

    /* renamed from: b  reason: collision with root package name */
    private Boolean f577b;

    /* renamed from: c  reason: collision with root package name */
    private Integer f578c;
    private RelativeLayout d;
    private RelativeLayout e;
    private Boolean f;

    public ExpandableLayoutItem(Context context) {
        super(context);
        this.f576a = false;
        this.f577b = false;
        this.f = true;
    }

    public ExpandableLayoutItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f576a = false;
        this.f577b = false;
        this.f = true;
        a(context, attributeSet);
    }

    public ExpandableLayoutItem(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f576a = false;
        this.f577b = false;
        this.f = true;
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
        this.f578c = Integer.valueOf(obtainStyledAttributes.getInt(2, getContext().getResources().getInteger(17694720)));
        View inflate2 = View.inflate(context, resourceId, null);
        inflate2.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.e.addView(inflate2);
        setTag(ExpandableLayoutItem.class.getName());
        View inflate3 = View.inflate(context, resourceId2, null);
        inflate3.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        this.d.addView(inflate3);
        this.d.setVisibility(8);
        this.e.setOnTouchListener(new View.OnTouchListener() { // from class: com.andexert.expandablelayout.library.ExpandableLayoutItem.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (ExpandableLayoutItem.this.c().booleanValue() && motionEvent.getAction() == 1) {
                    ExpandableLayoutItem.this.e();
                    ExpandableLayoutItem.this.f = true;
                }
                return ExpandableLayoutItem.this.c().booleanValue() && motionEvent.getAction() == 0;
            }
        });
    }

    private void a(final View view) {
        this.f577b = true;
        view.measure(-1, -2);
        final int measuredHeight = view.getMeasuredHeight();
        view.getLayoutParams().height = 0;
        view.setVisibility(0);
        Animation animation = new Animation() { // from class: com.andexert.expandablelayout.library.ExpandableLayoutItem.2
            @Override // android.view.animation.Animation
            protected void applyTransformation(float f, Transformation transformation) {
                view.getLayoutParams().height = f == 1.0f ? -2 : (int) (measuredHeight * f);
                view.requestLayout();
            }

            @Override // android.view.animation.Animation
            public boolean willChangeBounds() {
                return true;
            }
        };
        animation.setDuration(this.f578c.intValue());
        view.startAnimation(animation);
    }

    private void b(final View view) {
        this.f577b = false;
        final int measuredHeight = view.getMeasuredHeight();
        Animation animation = new Animation() { // from class: com.andexert.expandablelayout.library.ExpandableLayoutItem.3
            @Override // android.view.animation.Animation
            protected void applyTransformation(float f, Transformation transformation) {
                if (f == 1.0f) {
                    view.setVisibility(8);
                    ExpandableLayoutItem.this.f577b = false;
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
        animation.setDuration(this.f578c.intValue());
        view.startAnimation(animation);
    }

    public void a() {
        this.d.getLayoutParams().height = 0;
        this.d.invalidate();
        this.d.setVisibility(8);
        this.f577b = false;
    }

    public void b() {
        if (!c().booleanValue()) {
            this.d.setVisibility(0);
            this.f577b = true;
            this.d.getLayoutParams().height = -2;
            this.d.invalidate();
        }
    }

    public Boolean c() {
        return this.f577b;
    }

    public void d() {
        if (!this.f576a.booleanValue()) {
            a(this.d);
            this.f576a = true;
            new Handler().postDelayed(new Runnable() { // from class: com.andexert.expandablelayout.library.ExpandableLayoutItem.4
                @Override // java.lang.Runnable
                public void run() {
                    ExpandableLayoutItem.this.f576a = false;
                }
            }, this.f578c.intValue());
        }
    }

    public RelativeLayout getHeaderRelativeLayout() {
        return this.e;
    }

    public RelativeLayout getContentRelativeLayout() {
        return this.d;
    }

    public void e() {
        if (!this.f576a.booleanValue()) {
            b(this.d);
            this.f576a = true;
            new Handler().postDelayed(new Runnable() { // from class: com.andexert.expandablelayout.library.ExpandableLayoutItem.5
                @Override // java.lang.Runnable
                public void run() {
                    ExpandableLayoutItem.this.f576a = false;
                }
            }, this.f578c.intValue());
        }
        this.f = false;
    }

    public Boolean getCloseByUser() {
        return this.f;
    }
}
