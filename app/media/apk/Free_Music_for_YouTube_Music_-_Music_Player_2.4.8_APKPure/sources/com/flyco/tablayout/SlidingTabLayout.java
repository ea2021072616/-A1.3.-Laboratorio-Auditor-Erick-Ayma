package com.flyco.tablayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.flyco.tablayout.utils.UnreadMsgUtils;
import com.flyco.tablayout.widget.MsgView;
import java.util.ArrayList;
import java.util.Collections;
/* loaded from: classes.dex */
public class SlidingTabLayout extends HorizontalScrollView implements ViewPager.OnPageChangeListener {
    private static final int STYLE_BLOCK = 2;
    private static final int STYLE_NORMAL = 0;
    private static final int STYLE_TRIANGLE = 1;
    private static final int TEXT_BOLD_BOTH = 2;
    private static final int TEXT_BOLD_NONE = 0;
    private static final int TEXT_BOLD_WHEN_SELECT = 1;
    private Context mContext;
    private float mCurrentPositionOffset;
    private int mCurrentTab;
    private int mDividerColor;
    private float mDividerPadding;
    private Paint mDividerPaint;
    private float mDividerWidth;
    private int mHeight;
    private int mIndicatorColor;
    private float mIndicatorCornerRadius;
    private GradientDrawable mIndicatorDrawable;
    private int mIndicatorGravity;
    private float mIndicatorHeight;
    private float mIndicatorMarginBottom;
    private float mIndicatorMarginLeft;
    private float mIndicatorMarginRight;
    private float mIndicatorMarginTop;
    private Rect mIndicatorRect;
    private int mIndicatorStyle;
    private float mIndicatorWidth;
    private boolean mIndicatorWidthEqualTitle;
    private SparseArray<Boolean> mInitSetMap;
    private int mLastScrollX;
    private OnTabSelectListener mListener;
    private Paint mRectPaint;
    private boolean mSnapOnTabClick;
    private int mTabCount;
    private float mTabPadding;
    private Rect mTabRect;
    private boolean mTabSpaceEqual;
    private float mTabWidth;
    private LinearLayout mTabsContainer;
    private boolean mTextAllCaps;
    private int mTextBold;
    private Paint mTextPaint;
    private int mTextSelectColor;
    private int mTextUnselectColor;
    private float mTextsize;
    private ArrayList<String> mTitles;
    private Paint mTrianglePaint;
    private Path mTrianglePath;
    private int mUnderlineColor;
    private int mUnderlineGravity;
    private float mUnderlineHeight;
    private ViewPager mViewPager;
    private float margin;

    public SlidingTabLayout(Context context) {
        this(context, null, 0);
    }

    public SlidingTabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlidingTabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mIndicatorRect = new Rect();
        this.mTabRect = new Rect();
        this.mIndicatorDrawable = new GradientDrawable();
        this.mRectPaint = new Paint(1);
        this.mDividerPaint = new Paint(1);
        this.mTrianglePaint = new Paint(1);
        this.mTrianglePath = new Path();
        this.mIndicatorStyle = 0;
        this.mTextPaint = new Paint(1);
        this.mInitSetMap = new SparseArray<>();
        setFillViewport(true);
        setWillNotDraw(false);
        setClipChildren(false);
        setClipToPadding(false);
        this.mContext = context;
        this.mTabsContainer = new LinearLayout(context);
        addView(this.mTabsContainer);
        obtainAttributes(context, attributeSet);
        String attributeValue = attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "layout_height");
        if (!attributeValue.equals("-1") && !attributeValue.equals("-2")) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16842997});
            this.mHeight = obtainStyledAttributes.getDimensionPixelSize(0, -2);
            obtainStyledAttributes.recycle();
        }
    }

    private void obtainAttributes(Context context, AttributeSet attributeSet) {
        float f;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SlidingTabLayout);
        this.mIndicatorStyle = obtainStyledAttributes.getInt(R.styleable.SlidingTabLayout_tl_indicator_style, 0);
        this.mIndicatorColor = obtainStyledAttributes.getColor(R.styleable.SlidingTabLayout_tl_indicator_color, Color.parseColor(this.mIndicatorStyle == 2 ? "#4B6A87" : "#ffffff"));
        int i = R.styleable.SlidingTabLayout_tl_indicator_height;
        if (this.mIndicatorStyle == 1) {
            f = 4.0f;
        } else {
            f = this.mIndicatorStyle == 2 ? -1 : 2;
        }
        this.mIndicatorHeight = obtainStyledAttributes.getDimension(i, dp2px(f));
        this.mIndicatorWidth = obtainStyledAttributes.getDimension(R.styleable.SlidingTabLayout_tl_indicator_width, dp2px(this.mIndicatorStyle == 1 ? 10.0f : -1.0f));
        this.mIndicatorCornerRadius = obtainStyledAttributes.getDimension(R.styleable.SlidingTabLayout_tl_indicator_corner_radius, dp2px(this.mIndicatorStyle == 2 ? -1.0f : 0.0f));
        this.mIndicatorMarginLeft = obtainStyledAttributes.getDimension(R.styleable.SlidingTabLayout_tl_indicator_margin_left, dp2px(0.0f));
        this.mIndicatorMarginTop = obtainStyledAttributes.getDimension(R.styleable.SlidingTabLayout_tl_indicator_margin_top, dp2px(this.mIndicatorStyle == 2 ? 7.0f : 0.0f));
        this.mIndicatorMarginRight = obtainStyledAttributes.getDimension(R.styleable.SlidingTabLayout_tl_indicator_margin_right, dp2px(0.0f));
        this.mIndicatorMarginBottom = obtainStyledAttributes.getDimension(R.styleable.SlidingTabLayout_tl_indicator_margin_bottom, dp2px(this.mIndicatorStyle != 2 ? 0.0f : 7.0f));
        this.mIndicatorGravity = obtainStyledAttributes.getInt(R.styleable.SlidingTabLayout_tl_indicator_gravity, 80);
        this.mIndicatorWidthEqualTitle = obtainStyledAttributes.getBoolean(R.styleable.SlidingTabLayout_tl_indicator_width_equal_title, false);
        this.mUnderlineColor = obtainStyledAttributes.getColor(R.styleable.SlidingTabLayout_tl_underline_color, Color.parseColor("#ffffff"));
        this.mUnderlineHeight = obtainStyledAttributes.getDimension(R.styleable.SlidingTabLayout_tl_underline_height, dp2px(0.0f));
        this.mUnderlineGravity = obtainStyledAttributes.getInt(R.styleable.SlidingTabLayout_tl_underline_gravity, 80);
        this.mDividerColor = obtainStyledAttributes.getColor(R.styleable.SlidingTabLayout_tl_divider_color, Color.parseColor("#ffffff"));
        this.mDividerWidth = obtainStyledAttributes.getDimension(R.styleable.SlidingTabLayout_tl_divider_width, dp2px(0.0f));
        this.mDividerPadding = obtainStyledAttributes.getDimension(R.styleable.SlidingTabLayout_tl_divider_padding, dp2px(12.0f));
        this.mTextsize = obtainStyledAttributes.getDimension(R.styleable.SlidingTabLayout_tl_textsize, sp2px(14.0f));
        this.mTextSelectColor = obtainStyledAttributes.getColor(R.styleable.SlidingTabLayout_tl_textSelectColor, Color.parseColor("#ffffff"));
        this.mTextUnselectColor = obtainStyledAttributes.getColor(R.styleable.SlidingTabLayout_tl_textUnselectColor, Color.parseColor("#AAffffff"));
        this.mTextBold = obtainStyledAttributes.getInt(R.styleable.SlidingTabLayout_tl_textBold, 0);
        this.mTextAllCaps = obtainStyledAttributes.getBoolean(R.styleable.SlidingTabLayout_tl_textAllCaps, false);
        this.mTabSpaceEqual = obtainStyledAttributes.getBoolean(R.styleable.SlidingTabLayout_tl_tab_space_equal, false);
        this.mTabWidth = obtainStyledAttributes.getDimension(R.styleable.SlidingTabLayout_tl_tab_width, dp2px(-1.0f));
        this.mTabPadding = obtainStyledAttributes.getDimension(R.styleable.SlidingTabLayout_tl_tab_padding, (this.mTabSpaceEqual || this.mTabWidth > 0.0f) ? dp2px(0.0f) : dp2px(20.0f));
        obtainStyledAttributes.recycle();
    }

    public void setViewPager(ViewPager viewPager) {
        if (viewPager == null || viewPager.getAdapter() == null) {
            throw new IllegalStateException("ViewPager or ViewPager adapter can not be NULL !");
        }
        this.mViewPager = viewPager;
        this.mViewPager.removeOnPageChangeListener(this);
        this.mViewPager.addOnPageChangeListener(this);
        notifyDataSetChanged();
    }

    public void setViewPager(ViewPager viewPager, String[] strArr) {
        if (viewPager == null || viewPager.getAdapter() == null) {
            throw new IllegalStateException("ViewPager or ViewPager adapter can not be NULL !");
        }
        if (strArr == null || strArr.length == 0) {
            throw new IllegalStateException("Titles can not be EMPTY !");
        }
        if (strArr.length != viewPager.getAdapter().getCount()) {
            throw new IllegalStateException("Titles length must be the same as the page count !");
        }
        this.mViewPager = viewPager;
        this.mTitles = new ArrayList<>();
        Collections.addAll(this.mTitles, strArr);
        this.mViewPager.removeOnPageChangeListener(this);
        this.mViewPager.addOnPageChangeListener(this);
        notifyDataSetChanged();
    }

    public void setViewPager(ViewPager viewPager, String[] strArr, FragmentActivity fragmentActivity, ArrayList<Fragment> arrayList) {
        if (viewPager == null) {
            throw new IllegalStateException("ViewPager can not be NULL !");
        }
        if (strArr == null || strArr.length == 0) {
            throw new IllegalStateException("Titles can not be EMPTY !");
        }
        this.mViewPager = viewPager;
        this.mViewPager.setAdapter(new InnerPagerAdapter(fragmentActivity.getSupportFragmentManager(), arrayList, strArr));
        this.mViewPager.removeOnPageChangeListener(this);
        this.mViewPager.addOnPageChangeListener(this);
        notifyDataSetChanged();
    }

    public void notifyDataSetChanged() {
        this.mTabsContainer.removeAllViews();
        this.mTabCount = this.mTitles == null ? this.mViewPager.getAdapter().getCount() : this.mTitles.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mTabCount) {
                addTab(i2, (this.mTitles == null ? this.mViewPager.getAdapter().getPageTitle(i2) : this.mTitles.get(i2)).toString(), View.inflate(this.mContext, R.layout.layout_tab, null));
                i = i2 + 1;
            } else {
                updateTabStyles();
                return;
            }
        }
    }

    public void addNewTab(String str) {
        View inflate = View.inflate(this.mContext, R.layout.layout_tab, null);
        if (this.mTitles != null) {
            this.mTitles.add(str);
        }
        addTab(this.mTabCount, (this.mTitles == null ? this.mViewPager.getAdapter().getPageTitle(this.mTabCount) : this.mTitles.get(this.mTabCount)).toString(), inflate);
        this.mTabCount = this.mTitles == null ? this.mViewPager.getAdapter().getCount() : this.mTitles.size();
        updateTabStyles();
    }

    private void addTab(int i, String str, View view) {
        TextView textView = (TextView) view.findViewById(R.id.tv_tab_title);
        if (textView != null && str != null) {
            textView.setText(str);
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.flyco.tablayout.SlidingTabLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int indexOfChild = SlidingTabLayout.this.mTabsContainer.indexOfChild(view2);
                if (indexOfChild != -1) {
                    if (SlidingTabLayout.this.mViewPager.getCurrentItem() != indexOfChild) {
                        if (SlidingTabLayout.this.mSnapOnTabClick) {
                            SlidingTabLayout.this.mViewPager.setCurrentItem(indexOfChild, false);
                        } else {
                            SlidingTabLayout.this.mViewPager.setCurrentItem(indexOfChild);
                        }
                        if (SlidingTabLayout.this.mListener != null) {
                            SlidingTabLayout.this.mListener.onTabSelect(indexOfChild);
                        }
                    } else if (SlidingTabLayout.this.mListener != null) {
                        SlidingTabLayout.this.mListener.onTabReselect(indexOfChild);
                    }
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = this.mTabSpaceEqual ? new LinearLayout.LayoutParams(0, -1, 1.0f) : new LinearLayout.LayoutParams(-2, -1);
        if (this.mTabWidth > 0.0f) {
            layoutParams = new LinearLayout.LayoutParams((int) this.mTabWidth, -1);
        }
        this.mTabsContainer.addView(view, i, layoutParams);
    }

    private void updateTabStyles() {
        int i = 0;
        while (i < this.mTabCount) {
            TextView textView = (TextView) this.mTabsContainer.getChildAt(i).findViewById(R.id.tv_tab_title);
            if (textView != null) {
                textView.setTextColor(i == this.mCurrentTab ? this.mTextSelectColor : this.mTextUnselectColor);
                textView.setTextSize(0, this.mTextsize);
                textView.setPadding((int) this.mTabPadding, 0, (int) this.mTabPadding, 0);
                if (this.mTextAllCaps) {
                    textView.setText(textView.getText().toString().toUpperCase());
                }
                if (this.mTextBold == 2) {
                    textView.getPaint().setFakeBoldText(true);
                } else if (this.mTextBold == 0) {
                    textView.getPaint().setFakeBoldText(false);
                }
            }
            i++;
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        this.mCurrentTab = i;
        this.mCurrentPositionOffset = f;
        scrollToCurrentTab();
        invalidate();
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        updateTabSelection(i);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    private void scrollToCurrentTab() {
        if (this.mTabCount > 0) {
            int width = (int) (this.mCurrentPositionOffset * this.mTabsContainer.getChildAt(this.mCurrentTab).getWidth());
            int left = this.mTabsContainer.getChildAt(this.mCurrentTab).getLeft() + width;
            if (this.mCurrentTab > 0 || width > 0) {
                calcIndicatorRect();
                left = (left - ((getWidth() / 2) - getPaddingLeft())) + ((this.mTabRect.right - this.mTabRect.left) / 2);
            }
            if (left != this.mLastScrollX) {
                this.mLastScrollX = left;
                scrollTo(left, 0);
            }
        }
    }

    private void updateTabSelection(int i) {
        int i2 = 0;
        while (i2 < this.mTabCount) {
            View childAt = this.mTabsContainer.getChildAt(i2);
            boolean z = i2 == i;
            TextView textView = (TextView) childAt.findViewById(R.id.tv_tab_title);
            if (textView != null) {
                textView.setTextColor(z ? this.mTextSelectColor : this.mTextUnselectColor);
                if (this.mTextBold == 1) {
                    textView.getPaint().setFakeBoldText(z);
                }
            }
            i2++;
        }
    }

    private void calcIndicatorRect() {
        View childAt = this.mTabsContainer.getChildAt(this.mCurrentTab);
        float left = childAt.getLeft();
        float right = childAt.getRight();
        if (this.mIndicatorStyle == 0 && this.mIndicatorWidthEqualTitle) {
            this.mTextPaint.setTextSize(this.mTextsize);
            this.margin = ((right - left) - this.mTextPaint.measureText(((TextView) childAt.findViewById(R.id.tv_tab_title)).getText().toString())) / 2.0f;
        }
        if (this.mCurrentTab < this.mTabCount - 1) {
            View childAt2 = this.mTabsContainer.getChildAt(this.mCurrentTab + 1);
            float left2 = childAt2.getLeft();
            float right2 = childAt2.getRight();
            left += this.mCurrentPositionOffset * (left2 - left);
            right += this.mCurrentPositionOffset * (right2 - right);
            if (this.mIndicatorStyle == 0 && this.mIndicatorWidthEqualTitle) {
                this.mTextPaint.setTextSize(this.mTextsize);
                this.margin = (((((right2 - left2) - this.mTextPaint.measureText(((TextView) childAt2.findViewById(R.id.tv_tab_title)).getText().toString())) / 2.0f) - this.margin) * this.mCurrentPositionOffset) + this.margin;
            }
        }
        float f = right;
        float f2 = left;
        this.mIndicatorRect.left = (int) f2;
        this.mIndicatorRect.right = (int) f;
        if (this.mIndicatorStyle == 0 && this.mIndicatorWidthEqualTitle) {
            this.mIndicatorRect.left = (int) ((this.margin + f2) - 1.0f);
            this.mIndicatorRect.right = (int) ((f - this.margin) - 1.0f);
        }
        this.mTabRect.left = (int) f2;
        this.mTabRect.right = (int) f;
        if (this.mIndicatorWidth >= 0.0f) {
            float left3 = childAt.getLeft() + ((childAt.getWidth() - this.mIndicatorWidth) / 2.0f);
            if (this.mCurrentTab < this.mTabCount - 1) {
                View childAt3 = this.mTabsContainer.getChildAt(this.mCurrentTab + 1);
                left3 += ((childAt3.getWidth() / 2) + (childAt.getWidth() / 2)) * this.mCurrentPositionOffset;
            }
            this.mIndicatorRect.left = (int) left3;
            this.mIndicatorRect.right = (int) (this.mIndicatorRect.left + this.mIndicatorWidth);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.mTabCount > 0) {
            int height = getHeight();
            int paddingLeft = getPaddingLeft();
            if (this.mDividerWidth > 0.0f) {
                this.mDividerPaint.setStrokeWidth(this.mDividerWidth);
                this.mDividerPaint.setColor(this.mDividerColor);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.mTabCount - 1) {
                        break;
                    }
                    View childAt = this.mTabsContainer.getChildAt(i2);
                    canvas.drawLine(childAt.getRight() + paddingLeft, this.mDividerPadding, childAt.getRight() + paddingLeft, height - this.mDividerPadding, this.mDividerPaint);
                    i = i2 + 1;
                }
            }
            if (this.mUnderlineHeight > 0.0f) {
                this.mRectPaint.setColor(this.mUnderlineColor);
                if (this.mUnderlineGravity == 80) {
                    canvas.drawRect(paddingLeft, height - this.mUnderlineHeight, this.mTabsContainer.getWidth() + paddingLeft, height, this.mRectPaint);
                } else {
                    canvas.drawRect(paddingLeft, 0.0f, this.mTabsContainer.getWidth() + paddingLeft, this.mUnderlineHeight, this.mRectPaint);
                }
            }
            calcIndicatorRect();
            if (this.mIndicatorStyle == 1) {
                if (this.mIndicatorHeight > 0.0f) {
                    this.mTrianglePaint.setColor(this.mIndicatorColor);
                    this.mTrianglePath.reset();
                    this.mTrianglePath.moveTo(this.mIndicatorRect.left + paddingLeft, height);
                    this.mTrianglePath.lineTo((this.mIndicatorRect.left / 2) + paddingLeft + (this.mIndicatorRect.right / 2), height - this.mIndicatorHeight);
                    this.mTrianglePath.lineTo(this.mIndicatorRect.right + paddingLeft, height);
                    this.mTrianglePath.close();
                    canvas.drawPath(this.mTrianglePath, this.mTrianglePaint);
                }
            } else if (this.mIndicatorStyle == 2) {
                if (this.mIndicatorHeight < 0.0f) {
                    this.mIndicatorHeight = (height - this.mIndicatorMarginTop) - this.mIndicatorMarginBottom;
                }
                if (this.mIndicatorHeight > 0.0f) {
                    if (this.mIndicatorCornerRadius < 0.0f || this.mIndicatorCornerRadius > this.mIndicatorHeight / 2.0f) {
                        this.mIndicatorCornerRadius = this.mIndicatorHeight / 2.0f;
                    }
                    this.mIndicatorDrawable.setColor(this.mIndicatorColor);
                    this.mIndicatorDrawable.setBounds(((int) this.mIndicatorMarginLeft) + paddingLeft + this.mIndicatorRect.left, (int) this.mIndicatorMarginTop, (int) ((this.mIndicatorRect.right + paddingLeft) - this.mIndicatorMarginRight), (int) (this.mIndicatorMarginTop + this.mIndicatorHeight));
                    this.mIndicatorDrawable.setCornerRadius(this.mIndicatorCornerRadius);
                    this.mIndicatorDrawable.draw(canvas);
                }
            } else if (this.mIndicatorHeight > 0.0f) {
                this.mIndicatorDrawable.setColor(this.mIndicatorColor);
                if (this.mIndicatorGravity == 80) {
                    this.mIndicatorDrawable.setBounds(((int) this.mIndicatorMarginLeft) + paddingLeft + this.mIndicatorRect.left, (height - ((int) this.mIndicatorHeight)) - ((int) this.mIndicatorMarginBottom), (this.mIndicatorRect.right + paddingLeft) - ((int) this.mIndicatorMarginRight), height - ((int) this.mIndicatorMarginBottom));
                } else {
                    this.mIndicatorDrawable.setBounds(((int) this.mIndicatorMarginLeft) + paddingLeft + this.mIndicatorRect.left, (int) this.mIndicatorMarginTop, (this.mIndicatorRect.right + paddingLeft) - ((int) this.mIndicatorMarginRight), ((int) this.mIndicatorHeight) + ((int) this.mIndicatorMarginTop));
                }
                this.mIndicatorDrawable.setCornerRadius(this.mIndicatorCornerRadius);
                this.mIndicatorDrawable.draw(canvas);
            }
        }
    }

    public void setCurrentTab(int i) {
        this.mCurrentTab = i;
        this.mViewPager.setCurrentItem(i);
    }

    public void setCurrentTab(int i, boolean z) {
        this.mCurrentTab = i;
        this.mViewPager.setCurrentItem(i, z);
    }

    public void setIndicatorStyle(int i) {
        this.mIndicatorStyle = i;
        invalidate();
    }

    public void setTabPadding(float f) {
        this.mTabPadding = dp2px(f);
        updateTabStyles();
    }

    public void setTabSpaceEqual(boolean z) {
        this.mTabSpaceEqual = z;
        updateTabStyles();
    }

    public void setTabWidth(float f) {
        this.mTabWidth = dp2px(f);
        updateTabStyles();
    }

    public void setIndicatorColor(int i) {
        this.mIndicatorColor = i;
        invalidate();
    }

    public void setIndicatorHeight(float f) {
        this.mIndicatorHeight = dp2px(f);
        invalidate();
    }

    public void setIndicatorWidth(float f) {
        this.mIndicatorWidth = dp2px(f);
        invalidate();
    }

    public void setIndicatorCornerRadius(float f) {
        this.mIndicatorCornerRadius = dp2px(f);
        invalidate();
    }

    public void setIndicatorGravity(int i) {
        this.mIndicatorGravity = i;
        invalidate();
    }

    public void setIndicatorMargin(float f, float f2, float f3, float f4) {
        this.mIndicatorMarginLeft = dp2px(f);
        this.mIndicatorMarginTop = dp2px(f2);
        this.mIndicatorMarginRight = dp2px(f3);
        this.mIndicatorMarginBottom = dp2px(f4);
        invalidate();
    }

    public void setIndicatorWidthEqualTitle(boolean z) {
        this.mIndicatorWidthEqualTitle = z;
        invalidate();
    }

    public void setUnderlineColor(int i) {
        this.mUnderlineColor = i;
        invalidate();
    }

    public void setUnderlineHeight(float f) {
        this.mUnderlineHeight = dp2px(f);
        invalidate();
    }

    public void setUnderlineGravity(int i) {
        this.mUnderlineGravity = i;
        invalidate();
    }

    public void setDividerColor(int i) {
        this.mDividerColor = i;
        invalidate();
    }

    public void setDividerWidth(float f) {
        this.mDividerWidth = dp2px(f);
        invalidate();
    }

    public void setDividerPadding(float f) {
        this.mDividerPadding = dp2px(f);
        invalidate();
    }

    public void setTextsize(float f) {
        this.mTextsize = sp2px(f);
        updateTabStyles();
    }

    public void setTextSelectColor(int i) {
        this.mTextSelectColor = i;
        updateTabStyles();
    }

    public void setTextUnselectColor(int i) {
        this.mTextUnselectColor = i;
        updateTabStyles();
    }

    public void setTextBold(int i) {
        this.mTextBold = i;
        updateTabStyles();
    }

    public void setTextAllCaps(boolean z) {
        this.mTextAllCaps = z;
        updateTabStyles();
    }

    public void setSnapOnTabClick(boolean z) {
        this.mSnapOnTabClick = z;
    }

    public int getTabCount() {
        return this.mTabCount;
    }

    public int getCurrentTab() {
        return this.mCurrentTab;
    }

    public int getIndicatorStyle() {
        return this.mIndicatorStyle;
    }

    public float getTabPadding() {
        return this.mTabPadding;
    }

    public boolean isTabSpaceEqual() {
        return this.mTabSpaceEqual;
    }

    public float getTabWidth() {
        return this.mTabWidth;
    }

    public int getIndicatorColor() {
        return this.mIndicatorColor;
    }

    public float getIndicatorHeight() {
        return this.mIndicatorHeight;
    }

    public float getIndicatorWidth() {
        return this.mIndicatorWidth;
    }

    public float getIndicatorCornerRadius() {
        return this.mIndicatorCornerRadius;
    }

    public float getIndicatorMarginLeft() {
        return this.mIndicatorMarginLeft;
    }

    public float getIndicatorMarginTop() {
        return this.mIndicatorMarginTop;
    }

    public float getIndicatorMarginRight() {
        return this.mIndicatorMarginRight;
    }

    public float getIndicatorMarginBottom() {
        return this.mIndicatorMarginBottom;
    }

    public int getUnderlineColor() {
        return this.mUnderlineColor;
    }

    public float getUnderlineHeight() {
        return this.mUnderlineHeight;
    }

    public int getDividerColor() {
        return this.mDividerColor;
    }

    public float getDividerWidth() {
        return this.mDividerWidth;
    }

    public float getDividerPadding() {
        return this.mDividerPadding;
    }

    public float getTextsize() {
        return this.mTextsize;
    }

    public int getTextSelectColor() {
        return this.mTextSelectColor;
    }

    public int getTextUnselectColor() {
        return this.mTextUnselectColor;
    }

    public int getTextBold() {
        return this.mTextBold;
    }

    public boolean isTextAllCaps() {
        return this.mTextAllCaps;
    }

    public TextView getTitleView(int i) {
        return (TextView) this.mTabsContainer.getChildAt(i).findViewById(R.id.tv_tab_title);
    }

    public void showMsg(int i, int i2) {
        if (i >= this.mTabCount) {
            i = this.mTabCount - 1;
        }
        MsgView msgView = (MsgView) this.mTabsContainer.getChildAt(i).findViewById(R.id.rtv_msg_tip);
        if (msgView != null) {
            UnreadMsgUtils.show(msgView, i2);
            if (this.mInitSetMap.get(i) == null || !this.mInitSetMap.get(i).booleanValue()) {
                setMsgMargin(i, 4.0f, 2.0f);
                this.mInitSetMap.put(i, true);
            }
        }
    }

    public void showDot(int i) {
        if (i >= this.mTabCount) {
            i = this.mTabCount - 1;
        }
        showMsg(i, 0);
    }

    public void hideMsg(int i) {
        if (i >= this.mTabCount) {
            i = this.mTabCount - 1;
        }
        MsgView msgView = (MsgView) this.mTabsContainer.getChildAt(i).findViewById(R.id.rtv_msg_tip);
        if (msgView != null) {
            msgView.setVisibility(8);
        }
    }

    public void setMsgMargin(int i, float f, float f2) {
        if (i >= this.mTabCount) {
            i = this.mTabCount - 1;
        }
        View childAt = this.mTabsContainer.getChildAt(i);
        MsgView msgView = (MsgView) childAt.findViewById(R.id.rtv_msg_tip);
        if (msgView != null) {
            this.mTextPaint.setTextSize(this.mTextsize);
            float measureText = this.mTextPaint.measureText(((TextView) childAt.findViewById(R.id.tv_tab_title)).getText().toString());
            float descent = this.mTextPaint.descent() - this.mTextPaint.ascent();
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) msgView.getLayoutParams();
            marginLayoutParams.leftMargin = this.mTabWidth >= 0.0f ? (int) ((measureText / 2.0f) + (this.mTabWidth / 2.0f) + dp2px(f)) : (int) (measureText + this.mTabPadding + dp2px(f));
            marginLayoutParams.topMargin = this.mHeight > 0 ? (((int) (this.mHeight - descent)) / 2) - dp2px(f2) : 0;
            msgView.setLayoutParams(marginLayoutParams);
        }
    }

    public MsgView getMsgView(int i) {
        if (i >= this.mTabCount) {
            i = this.mTabCount - 1;
        }
        return (MsgView) this.mTabsContainer.getChildAt(i).findViewById(R.id.rtv_msg_tip);
    }

    public void setOnTabSelectListener(OnTabSelectListener onTabSelectListener) {
        this.mListener = onTabSelectListener;
    }

    /* loaded from: classes.dex */
    class InnerPagerAdapter extends FragmentPagerAdapter {
        private ArrayList<Fragment> fragments;
        private String[] titles;

        public InnerPagerAdapter(FragmentManager fragmentManager, ArrayList<Fragment> arrayList, String[] strArr) {
            super(fragmentManager);
            this.fragments = new ArrayList<>();
            this.fragments = arrayList;
            this.titles = strArr;
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.fragments.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public CharSequence getPageTitle(int i) {
            return this.titles[i];
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return this.fragments.get(i);
        }

        @Override // android.support.v4.app.FragmentPagerAdapter, android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getItemPosition(Object obj) {
            return -2;
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    protected Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("instanceState", super.onSaveInstanceState());
        bundle.putInt("mCurrentTab", this.mCurrentTab);
        return bundle;
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.mCurrentTab = bundle.getInt("mCurrentTab");
            parcelable = bundle.getParcelable("instanceState");
            if (this.mCurrentTab != 0 && this.mTabsContainer.getChildCount() > 0) {
                updateTabSelection(this.mCurrentTab);
                scrollToCurrentTab();
            }
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected int dp2px(float f) {
        return (int) ((this.mContext.getResources().getDisplayMetrics().density * f) + 0.5f);
    }

    protected int sp2px(float f) {
        return (int) ((this.mContext.getResources().getDisplayMetrics().scaledDensity * f) + 0.5f);
    }
}
