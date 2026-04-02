package com.zhy.view.flowlayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.zhy.view.flowlayout.TagAdapter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
/* loaded from: classes2.dex */
public class TagFlowLayout extends FlowLayout implements TagAdapter.OnDataChangedListener {
    private static final String KEY_CHOOSE_POS = "key_choose_pos";
    private static final String KEY_DEFAULT = "key_default";
    private static final String TAG = "TagFlowLayout";
    private boolean mAutoSelectEffect;
    private MotionEvent mMotionEvent;
    private OnSelectListener mOnSelectListener;
    private OnTagClickListener mOnTagClickListener;
    private int mSelectedMax;
    private Set<Integer> mSelectedView;
    private TagAdapter mTagAdapter;

    /* loaded from: classes2.dex */
    public interface OnSelectListener {
        void onSelected(Set<Integer> set);
    }

    /* loaded from: classes2.dex */
    public interface OnTagClickListener {
        boolean onTagClick(View view, int i, FlowLayout flowLayout);
    }

    public TagFlowLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mAutoSelectEffect = true;
        this.mSelectedMax = -1;
        this.mSelectedView = new HashSet();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TagFlowLayout);
        this.mAutoSelectEffect = obtainStyledAttributes.getBoolean(R.styleable.TagFlowLayout_auto_select_effect, true);
        this.mSelectedMax = obtainStyledAttributes.getInt(R.styleable.TagFlowLayout_max_select, -1);
        obtainStyledAttributes.recycle();
        if (this.mAutoSelectEffect) {
            setClickable(true);
        }
    }

    public TagFlowLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TagFlowLayout(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.zhy.view.flowlayout.FlowLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            TagView tagView = (TagView) getChildAt(i3);
            if (tagView.getVisibility() != 8 && tagView.getTagView().getVisibility() == 8) {
                tagView.setVisibility(8);
            }
        }
        super.onMeasure(i, i2);
    }

    public void setOnSelectListener(OnSelectListener onSelectListener) {
        this.mOnSelectListener = onSelectListener;
        if (this.mOnSelectListener != null) {
            setClickable(true);
        }
    }

    public void setOnTagClickListener(OnTagClickListener onTagClickListener) {
        this.mOnTagClickListener = onTagClickListener;
        if (onTagClickListener != null) {
            setClickable(true);
        }
    }

    public void setAdapter(TagAdapter tagAdapter) {
        this.mTagAdapter = tagAdapter;
        this.mTagAdapter.setOnDataChangedListener(this);
        this.mSelectedView.clear();
        changeAdapter();
    }

    private void changeAdapter() {
        removeAllViews();
        TagAdapter tagAdapter = this.mTagAdapter;
        HashSet<Integer> preCheckedList = this.mTagAdapter.getPreCheckedList();
        for (int i = 0; i < tagAdapter.getCount(); i++) {
            View view = tagAdapter.getView(this, i, tagAdapter.getItem(i));
            TagView tagView = new TagView(getContext());
            view.setDuplicateParentStateEnabled(true);
            if (view.getLayoutParams() != null) {
                tagView.setLayoutParams(view.getLayoutParams());
            } else {
                ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
                marginLayoutParams.setMargins(dip2px(getContext(), 5.0f), dip2px(getContext(), 5.0f), dip2px(getContext(), 5.0f), dip2px(getContext(), 5.0f));
                tagView.setLayoutParams(marginLayoutParams);
            }
            tagView.addView(view);
            addView(tagView);
            if (preCheckedList.contains(Integer.valueOf(i))) {
                tagView.setChecked(true);
            }
            if (this.mTagAdapter.setSelected(i, tagAdapter.getItem(i))) {
                this.mSelectedView.add(Integer.valueOf(i));
                tagView.setChecked(true);
            }
        }
        this.mSelectedView.addAll(preCheckedList);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.mMotionEvent = MotionEvent.obtain(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean performClick() {
        if (this.mMotionEvent == null) {
            return super.performClick();
        }
        this.mMotionEvent = null;
        TagView findChild = findChild((int) this.mMotionEvent.getX(), (int) this.mMotionEvent.getY());
        int findPosByView = findPosByView(findChild);
        if (findChild != null) {
            doSelect(findChild, findPosByView);
            if (this.mOnTagClickListener != null) {
                return this.mOnTagClickListener.onTagClick(findChild.getTagView(), findPosByView, this);
            }
        }
        return true;
    }

    public void setMaxSelectCount(int i) {
        if (this.mSelectedView.size() > i) {
            Log.w(TAG, "you has already select more than " + i + " views , so it will be clear .");
            this.mSelectedView.clear();
        }
        this.mSelectedMax = i;
    }

    public Set<Integer> getSelectedList() {
        return new HashSet(this.mSelectedView);
    }

    private void doSelect(TagView tagView, int i) {
        if (this.mAutoSelectEffect) {
            if (!tagView.isChecked()) {
                if (this.mSelectedMax == 1 && this.mSelectedView.size() == 1) {
                    Integer next = this.mSelectedView.iterator().next();
                    ((TagView) getChildAt(next.intValue())).setChecked(false);
                    tagView.setChecked(true);
                    this.mSelectedView.remove(next);
                    this.mSelectedView.add(Integer.valueOf(i));
                } else if (this.mSelectedMax <= 0 || this.mSelectedView.size() < this.mSelectedMax) {
                    tagView.setChecked(true);
                    this.mSelectedView.add(Integer.valueOf(i));
                } else {
                    return;
                }
            } else {
                tagView.setChecked(false);
                this.mSelectedView.remove(Integer.valueOf(i));
            }
            if (this.mOnSelectListener != null) {
                this.mOnSelectListener.onSelected(new HashSet(this.mSelectedView));
            }
        }
    }

    public TagAdapter getAdapter() {
        return this.mTagAdapter;
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Iterator<Integer> it;
        String str;
        Bundle bundle = new Bundle();
        bundle.putParcelable(KEY_DEFAULT, super.onSaveInstanceState());
        String str2 = "";
        if (this.mSelectedView.size() > 0) {
            while (true) {
                str = str2;
                if (!this.mSelectedView.iterator().hasNext()) {
                    break;
                }
                str2 = str + it.next().intValue() + "|";
            }
            str2 = str.substring(0, str.length() - 1);
        }
        bundle.putString(KEY_CHOOSE_POS, str2);
        return bundle;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            String string = bundle.getString(KEY_CHOOSE_POS);
            if (!TextUtils.isEmpty(string)) {
                for (String str : string.split("\\|")) {
                    int parseInt = Integer.parseInt(str);
                    this.mSelectedView.add(Integer.valueOf(parseInt));
                    TagView tagView = (TagView) getChildAt(parseInt);
                    if (tagView != null) {
                        tagView.setChecked(true);
                    }
                }
            }
            super.onRestoreInstanceState(bundle.getParcelable(KEY_DEFAULT));
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    private int findPosByView(View view) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (getChildAt(i) == view) {
                return i;
            }
        }
        return -1;
    }

    private TagView findChild(int i, int i2) {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            TagView tagView = (TagView) getChildAt(i3);
            if (tagView.getVisibility() != 8) {
                Rect rect = new Rect();
                tagView.getHitRect(rect);
                if (rect.contains(i, i2)) {
                    return tagView;
                }
            }
        }
        return null;
    }

    @Override // com.zhy.view.flowlayout.TagAdapter.OnDataChangedListener
    public void onChanged() {
        this.mSelectedView.clear();
        changeAdapter();
    }

    public static int dip2px(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }
}
