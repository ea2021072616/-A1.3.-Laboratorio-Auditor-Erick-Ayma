package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.exoplayer2.text.CaptionStyleCompat;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.util.Util;
/* loaded from: classes.dex */
final class SubtitlePainter {
    private static final float INNER_PADDING_RATIO = 0.125f;
    private static final String TAG = "SubtitlePainter";
    private boolean applyEmbeddedStyles;
    private int backgroundColor;
    private float bottomPaddingFraction;
    private final float cornerRadius;
    private float cueLine;
    private int cueLineAnchor;
    private int cueLineType;
    private float cuePosition;
    private int cuePositionAnchor;
    private float cueSize;
    private CharSequence cueText;
    private Layout.Alignment cueTextAlignment;
    private int edgeColor;
    private int edgeType;
    private int foregroundColor;
    private final RectF lineBounds = new RectF();
    private final float outlineWidth;
    private final Paint paint;
    private int parentBottom;
    private int parentLeft;
    private int parentRight;
    private int parentTop;
    private final float shadowOffset;
    private final float shadowRadius;
    private final float spacingAdd;
    private final float spacingMult;
    private StaticLayout textLayout;
    private int textLeft;
    private int textPaddingX;
    private final TextPaint textPaint;
    private float textSizePx;
    private int textTop;
    private int windowColor;

    public SubtitlePainter(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, new int[]{16843287, 16843288}, 0, 0);
        this.spacingAdd = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.spacingMult = obtainStyledAttributes.getFloat(1, 1.0f);
        obtainStyledAttributes.recycle();
        int round = Math.round((context.getResources().getDisplayMetrics().densityDpi * 2.0f) / 160.0f);
        this.cornerRadius = round;
        this.outlineWidth = round;
        this.shadowRadius = round;
        this.shadowOffset = round;
        this.textPaint = new TextPaint();
        this.textPaint.setAntiAlias(true);
        this.textPaint.setSubpixelText(true);
        this.paint = new Paint();
        this.paint.setAntiAlias(true);
        this.paint.setStyle(Paint.Style.FILL);
    }

    public void draw(Cue cue, boolean z, CaptionStyleCompat captionStyleCompat, float f, float f2, Canvas canvas, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int round;
        CharSequence charSequence = cue.text;
        if (!TextUtils.isEmpty(charSequence)) {
            if (!z) {
                charSequence = charSequence.toString();
            }
            if (areCharSequencesEqual(this.cueText, charSequence) && Util.areEqual(this.cueTextAlignment, cue.textAlignment) && this.cueLine == cue.line && this.cueLineType == cue.lineType && Util.areEqual(Integer.valueOf(this.cueLineAnchor), Integer.valueOf(cue.lineAnchor)) && this.cuePosition == cue.position && Util.areEqual(Integer.valueOf(this.cuePositionAnchor), Integer.valueOf(cue.positionAnchor)) && this.cueSize == cue.size && this.applyEmbeddedStyles == z && this.foregroundColor == captionStyleCompat.foregroundColor && this.backgroundColor == captionStyleCompat.backgroundColor && this.windowColor == captionStyleCompat.windowColor && this.edgeType == captionStyleCompat.edgeType && this.edgeColor == captionStyleCompat.edgeColor && Util.areEqual(this.textPaint.getTypeface(), captionStyleCompat.typeface) && this.textSizePx == f && this.bottomPaddingFraction == f2 && this.parentLeft == i && this.parentTop == i2 && this.parentRight == i3 && this.parentBottom == i4) {
                drawLayout(canvas);
                return;
            }
            this.cueText = charSequence;
            this.cueTextAlignment = cue.textAlignment;
            this.cueLine = cue.line;
            this.cueLineType = cue.lineType;
            this.cueLineAnchor = cue.lineAnchor;
            this.cuePosition = cue.position;
            this.cuePositionAnchor = cue.positionAnchor;
            this.cueSize = cue.size;
            this.applyEmbeddedStyles = z;
            this.foregroundColor = captionStyleCompat.foregroundColor;
            this.backgroundColor = captionStyleCompat.backgroundColor;
            this.windowColor = captionStyleCompat.windowColor;
            this.edgeType = captionStyleCompat.edgeType;
            this.edgeColor = captionStyleCompat.edgeColor;
            this.textPaint.setTypeface(captionStyleCompat.typeface);
            this.textSizePx = f;
            this.bottomPaddingFraction = f2;
            this.parentLeft = i;
            this.parentTop = i2;
            this.parentRight = i3;
            this.parentBottom = i4;
            int i8 = this.parentRight - this.parentLeft;
            int i9 = this.parentBottom - this.parentTop;
            this.textPaint.setTextSize(f);
            int i10 = (int) ((INNER_PADDING_RATIO * f) + 0.5f);
            int i11 = i8 - (i10 * 2);
            if (this.cueSize != Float.MIN_VALUE) {
                i11 = (int) (i11 * this.cueSize);
            }
            if (i11 <= 0) {
                Log.w(TAG, "Skipped drawing subtitle cue (insufficient space)");
                return;
            }
            Layout.Alignment alignment = this.cueTextAlignment == null ? Layout.Alignment.ALIGN_CENTER : this.cueTextAlignment;
            this.textLayout = new StaticLayout(charSequence, this.textPaint, i11, alignment, this.spacingMult, this.spacingAdd, true);
            int height = this.textLayout.getHeight();
            int lineCount = this.textLayout.getLineCount();
            int i12 = 0;
            int i13 = 0;
            while (i13 < lineCount) {
                int max = Math.max((int) Math.ceil(this.textLayout.getLineWidth(i13)), i12);
                i13++;
                i12 = max;
            }
            if (this.cueSize == Float.MIN_VALUE || i12 >= i11) {
                i11 = i12;
            }
            int i14 = i11 + (i10 * 2);
            if (this.cuePosition != Float.MIN_VALUE) {
                int round2 = Math.round(i8 * this.cuePosition) + this.parentLeft;
                if (this.cuePositionAnchor == 2) {
                    round2 -= i14;
                } else if (this.cuePositionAnchor == 1) {
                    round2 = ((round2 * 2) - i14) / 2;
                }
                int max2 = Math.max(round2, this.parentLeft);
                i5 = Math.min(max2 + i14, this.parentRight);
                i6 = max2;
            } else {
                int i15 = (i8 - i14) / 2;
                i5 = i15 + i14;
                i6 = i15;
            }
            if (this.cueLine != Float.MIN_VALUE) {
                if (this.cueLineType == 0) {
                    round = Math.round(i9 * this.cueLine) + this.parentTop;
                } else {
                    int lineBottom = this.textLayout.getLineBottom(0) - this.textLayout.getLineTop(0);
                    if (this.cueLine >= 0.0f) {
                        round = Math.round(lineBottom * this.cueLine) + this.parentTop;
                    } else {
                        round = Math.round(lineBottom * this.cueLine) + this.parentBottom;
                    }
                }
                if (this.cueLineAnchor == 2) {
                    round -= height;
                } else if (this.cueLineAnchor == 1) {
                    round = ((round * 2) - height) / 2;
                }
                if (round + height > this.parentBottom) {
                    round = this.parentBottom - height;
                } else if (round < this.parentTop) {
                    round = this.parentTop;
                }
                i7 = round;
            } else {
                i7 = (this.parentBottom - height) - ((int) (i9 * f2));
            }
            this.textLayout = new StaticLayout(charSequence, this.textPaint, i5 - i6, alignment, this.spacingMult, this.spacingAdd, true);
            this.textLeft = i6;
            this.textTop = i7;
            this.textPaddingX = i10;
            drawLayout(canvas);
        }
    }

    private void drawLayout(Canvas canvas) {
        StaticLayout staticLayout = this.textLayout;
        if (staticLayout != null) {
            int save = canvas.save();
            canvas.translate(this.textLeft, this.textTop);
            if (Color.alpha(this.windowColor) > 0) {
                this.paint.setColor(this.windowColor);
                canvas.drawRect(-this.textPaddingX, 0.0f, staticLayout.getWidth() + this.textPaddingX, staticLayout.getHeight(), this.paint);
            }
            if (Color.alpha(this.backgroundColor) > 0) {
                this.paint.setColor(this.backgroundColor);
                int lineCount = staticLayout.getLineCount();
                float lineTop = staticLayout.getLineTop(0);
                for (int i = 0; i < lineCount; i++) {
                    this.lineBounds.left = staticLayout.getLineLeft(i) - this.textPaddingX;
                    this.lineBounds.right = staticLayout.getLineRight(i) + this.textPaddingX;
                    this.lineBounds.top = lineTop;
                    this.lineBounds.bottom = staticLayout.getLineBottom(i);
                    lineTop = this.lineBounds.bottom;
                    canvas.drawRoundRect(this.lineBounds, this.cornerRadius, this.cornerRadius, this.paint);
                }
            }
            if (this.edgeType == 1) {
                this.textPaint.setStrokeJoin(Paint.Join.ROUND);
                this.textPaint.setStrokeWidth(this.outlineWidth);
                this.textPaint.setColor(this.edgeColor);
                this.textPaint.setStyle(Paint.Style.FILL_AND_STROKE);
                staticLayout.draw(canvas);
            } else if (this.edgeType == 2) {
                this.textPaint.setShadowLayer(this.shadowRadius, this.shadowOffset, this.shadowOffset, this.edgeColor);
            } else if (this.edgeType == 3 || this.edgeType == 4) {
                boolean z = this.edgeType == 3;
                int i2 = z ? -1 : this.edgeColor;
                int i3 = z ? this.edgeColor : -1;
                float f = this.shadowRadius / 2.0f;
                this.textPaint.setColor(this.foregroundColor);
                this.textPaint.setStyle(Paint.Style.FILL);
                this.textPaint.setShadowLayer(this.shadowRadius, -f, -f, i2);
                staticLayout.draw(canvas);
                this.textPaint.setShadowLayer(this.shadowRadius, f, f, i3);
            }
            this.textPaint.setColor(this.foregroundColor);
            this.textPaint.setStyle(Paint.Style.FILL);
            staticLayout.draw(canvas);
            this.textPaint.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            canvas.restoreToCount(save);
        }
    }

    private static boolean areCharSequencesEqual(CharSequence charSequence, CharSequence charSequence2) {
        return charSequence == charSequence2 || (charSequence != null && charSequence.equals(charSequence2));
    }
}
