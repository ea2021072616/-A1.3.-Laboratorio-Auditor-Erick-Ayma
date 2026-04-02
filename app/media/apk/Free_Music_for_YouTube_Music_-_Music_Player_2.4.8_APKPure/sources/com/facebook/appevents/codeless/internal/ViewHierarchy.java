package com.facebook.appevents.codeless.internal;

import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v4.view.NestedScrollingChild;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.Utility;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ViewHierarchy {
    private static final int ADAPTER_VIEW_ITEM_BITMASK = 9;
    private static final int BUTTON_BITMASK = 2;
    private static final int CHECKBOX_BITMASK = 15;
    private static final String CHILDREN_VIEW_KEY = "childviews";
    private static final String CLASS_NAME_KEY = "classname";
    private static final String CLASS_RCTROOTVIEW = "com.facebook.react.ReactRootView";
    private static final String CLASS_RCTTEXTVIEW = "com.facebook.react.views.view.ReactTextView";
    private static final String CLASS_RCTVIEWGROUP = "com.facebook.react.views.view.ReactViewGroup";
    private static final String CLASS_TOUCHTARGETHELPER = "com.facebook.react.uimanager.TouchTargetHelper";
    private static final String CLASS_TYPE_BITMASK_KEY = "classtypebitmask";
    private static final int CLICKABLE_VIEW_BITMASK = 5;
    private static final String DESC_KEY = "description";
    private static final String DIMENSION_HEIGHT_KEY = "height";
    private static final String DIMENSION_KEY = "dimension";
    private static final String DIMENSION_LEFT_KEY = "left";
    private static final String DIMENSION_SCROLL_X_KEY = "scrollx";
    private static final String DIMENSION_SCROLL_Y_KEY = "scrolly";
    private static final String DIMENSION_TOP_KEY = "top";
    private static final String DIMENSION_VISIBILITY_KEY = "visibility";
    private static final String DIMENSION_WIDTH_KEY = "width";
    private static final String GET_ACCESSIBILITY_METHOD = "getAccessibilityDelegate";
    private static final String HINT_KEY = "hint";
    private static final String ICON_BITMAP = "icon_image";
    private static final int ICON_MAX_EDGE_LENGTH = 44;
    private static final String ID_KEY = "id";
    private static final int IMAGEVIEW_BITMASK = 1;
    private static final int INPUT_BITMASK = 11;
    private static final int LABEL_BITMASK = 10;
    private static final String METHOD_FIND_TOUCHTARGET_VIEW = "findTouchTargetView";
    private static final int PICKER_BITMASK = 12;
    private static final int RADIO_GROUP_BITMASK = 14;
    private static final int RATINGBAR_BITMASK = 16;
    private static final int REACT_NATIVE_BUTTON_BITMASK = 6;
    private static final int SWITCH_BITMASK = 13;
    private static final String TAG_KEY = "tag";
    private static final int TEXTVIEW_BITMASK = 0;
    private static final String TEXT_IS_BOLD = "is_bold";
    private static final String TEXT_IS_ITALIC = "is_italic";
    private static final String TEXT_KEY = "text";
    private static final String TEXT_SIZE = "font_size";
    private static final String TEXT_STYLE = "text_style";
    private static final String TAG = ViewHierarchy.class.getCanonicalName();
    private static WeakReference<View> RCTRootViewReference = new WeakReference<>(null);
    @Nullable
    private static Method methodFindTouchTargetView = null;

    @Nullable
    public static ViewGroup getParentOfView(View view) {
        if (view == null) {
            return null;
        }
        ViewParent parent = view.getParent();
        if (parent == null || !(parent instanceof ViewGroup)) {
            return null;
        }
        return (ViewGroup) parent;
    }

    public static List<View> getChildrenOfView(View view) {
        ArrayList arrayList = new ArrayList();
        if (view != null && (view instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                arrayList.add(viewGroup.getChildAt(i));
            }
        }
        return arrayList;
    }

    public static JSONObject setBasicInfoOfView(View view, JSONObject jSONObject) {
        try {
            String textOfView = getTextOfView(view);
            String hintOfView = getHintOfView(view);
            Object tag = view.getTag();
            CharSequence contentDescription = view.getContentDescription();
            jSONObject.put(CLASS_NAME_KEY, view.getClass().getCanonicalName());
            jSONObject.put(CLASS_TYPE_BITMASK_KEY, getClassTypeBitmask(view));
            jSONObject.put("id", view.getId());
            if (!SensitiveUserDataUtils.isSensitiveUserData(view)) {
                jSONObject.put("text", textOfView);
            } else {
                jSONObject.put("text", "");
            }
            jSONObject.put(HINT_KEY, hintOfView);
            if (tag != null) {
                jSONObject.put(TAG_KEY, tag.toString());
            }
            if (contentDescription != null) {
                jSONObject.put("description", contentDescription.toString());
            }
            jSONObject.put(DIMENSION_KEY, getDimensionOfView(view));
        } catch (JSONException e) {
            Utility.logd(TAG, e);
        }
        return jSONObject;
    }

    public static JSONObject setAppearanceOfView(View view, JSONObject jSONObject, float f) {
        Bitmap bitmap;
        TextView textView;
        Typeface typeface;
        try {
            JSONObject jSONObject2 = new JSONObject();
            if ((view instanceof TextView) && (typeface = (textView = (TextView) view).getTypeface()) != null) {
                jSONObject2.put(TEXT_SIZE, textView.getTextSize());
                jSONObject2.put(TEXT_IS_BOLD, typeface.isBold());
                jSONObject2.put(TEXT_IS_ITALIC, typeface.isItalic());
                jSONObject.put(TEXT_STYLE, jSONObject2);
            }
            if (view instanceof ImageView) {
                Drawable drawable = ((ImageView) view).getDrawable();
                if ((drawable instanceof BitmapDrawable) && view.getHeight() / f <= 44.0f && view.getWidth() / f <= 44.0f && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                    jSONObject.put(ICON_BITMAP, Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0));
                }
            }
        } catch (JSONException e) {
            Utility.logd(TAG, e);
        }
        return jSONObject;
    }

    public static JSONObject getDictionaryOfView(View view) {
        JSONObject jSONObject;
        JSONException jSONException;
        if (view.getClass().getName().equals(CLASS_RCTROOTVIEW)) {
            RCTRootViewReference = new WeakReference<>(view);
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            JSONObject basicInfoOfView = setBasicInfoOfView(view, jSONObject2);
            try {
                JSONArray jSONArray = new JSONArray();
                List<View> childrenOfView = getChildrenOfView(view);
                for (int i = 0; i < childrenOfView.size(); i++) {
                    jSONArray.put(getDictionaryOfView(childrenOfView.get(i)));
                }
                basicInfoOfView.put(CHILDREN_VIEW_KEY, jSONArray);
                return basicInfoOfView;
            } catch (JSONException e) {
                jSONObject = basicInfoOfView;
                jSONException = e;
                Log.e(TAG, "Failed to create JSONObject for view.", jSONException);
                return jSONObject;
            }
        } catch (JSONException e2) {
            jSONObject = jSONObject2;
            jSONException = e2;
        }
    }

    private static int getClassTypeBitmask(View view) {
        int i = 0;
        if (view instanceof ImageView) {
            i = 2;
        }
        if (isClickableView(view)) {
            i |= 32;
        }
        int i2 = isAdapterViewItem(view) ? i | 512 : i;
        if (view instanceof TextView) {
            int i3 = i2 | 1024 | 1;
            if (view instanceof Button) {
                i3 |= 4;
                if (view instanceof Switch) {
                    i3 |= 8192;
                } else if (view instanceof CheckBox) {
                    i3 |= 32768;
                }
            }
            return view instanceof EditText ? i3 | 2048 : i3;
        } else if ((view instanceof Spinner) || (view instanceof DatePicker)) {
            return i2 | 4096;
        } else {
            if (view instanceof RatingBar) {
                return i2 | 65536;
            }
            if (view instanceof RadioGroup) {
                return i2 | 16384;
            }
            if ((view instanceof ViewGroup) && isRCTButton(view, RCTRootViewReference.get())) {
                return i2 | 64;
            }
            return i2;
        }
    }

    public static boolean isClickableView(View view) {
        try {
            Field declaredField = Class.forName("android.view.View").getDeclaredField("mListenerInfo");
            if (declaredField != null) {
                declaredField.setAccessible(true);
            }
            Object obj = declaredField.get(view);
            if (obj == null) {
                return false;
            }
            View.OnClickListener onClickListener = null;
            Field declaredField2 = Class.forName("android.view.View$ListenerInfo").getDeclaredField("mOnClickListener");
            if (declaredField2 != null) {
                onClickListener = (View.OnClickListener) declaredField2.get(obj);
            }
            return onClickListener != null;
        } catch (Exception e) {
            Log.e(TAG, "Failed to check if the view is clickable.", e);
            return false;
        }
    }

    private static boolean isAdapterViewItem(View view) {
        ViewParent parent = view.getParent();
        return parent != null && ((parent instanceof AdapterView) || (parent instanceof NestedScrollingChild));
    }

    public static String getTextOfView(View view) {
        CharSequence charSequence;
        Object selectedItem;
        CharSequence charSequence2 = null;
        if (view instanceof TextView) {
            charSequence = ((TextView) view).getText();
            if (view instanceof Switch) {
                charSequence = ((Switch) view).isChecked() ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO;
            }
        } else if (view instanceof Spinner) {
            charSequence = (((Spinner) view).getCount() <= 0 || (selectedItem = ((Spinner) view).getSelectedItem()) == null) ? null : selectedItem.toString();
        } else if (view instanceof DatePicker) {
            DatePicker datePicker = (DatePicker) view;
            charSequence = String.format("%04d-%02d-%02d", Integer.valueOf(datePicker.getYear()), Integer.valueOf(datePicker.getMonth()), Integer.valueOf(datePicker.getDayOfMonth()));
        } else if (view instanceof TimePicker) {
            TimePicker timePicker = (TimePicker) view;
            charSequence = String.format("%02d:%02d", Integer.valueOf(timePicker.getCurrentHour().intValue()), Integer.valueOf(timePicker.getCurrentMinute().intValue()));
        } else if (view instanceof RadioGroup) {
            RadioGroup radioGroup = (RadioGroup) view;
            int checkedRadioButtonId = radioGroup.getCheckedRadioButtonId();
            int childCount = radioGroup.getChildCount();
            int i = 0;
            while (true) {
                if (i >= childCount) {
                    break;
                }
                View childAt = radioGroup.getChildAt(i);
                if (childAt.getId() != checkedRadioButtonId || !(childAt instanceof RadioButton)) {
                    i++;
                } else {
                    charSequence2 = ((RadioButton) childAt).getText();
                    break;
                }
            }
            charSequence = charSequence2;
        } else if (!(view instanceof RatingBar)) {
            charSequence = null;
        } else {
            charSequence = String.valueOf(((RatingBar) view).getRating());
        }
        return charSequence == null ? "" : charSequence.toString();
    }

    public static String getHintOfView(View view) {
        CharSequence charSequence = null;
        if (view instanceof TextView) {
            charSequence = ((TextView) view).getHint();
        } else if (view instanceof EditText) {
            charSequence = ((EditText) view).getHint();
        }
        return charSequence == null ? "" : charSequence.toString();
    }

    private static JSONObject getDimensionOfView(View view) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(DIMENSION_TOP_KEY, view.getTop());
            jSONObject.put("left", view.getLeft());
            jSONObject.put("width", view.getWidth());
            jSONObject.put("height", view.getHeight());
            jSONObject.put(DIMENSION_SCROLL_X_KEY, view.getScrollX());
            jSONObject.put(DIMENSION_SCROLL_Y_KEY, view.getScrollY());
            jSONObject.put(DIMENSION_VISIBILITY_KEY, view.getVisibility());
        } catch (JSONException e) {
            Log.e(TAG, "Failed to create JSONObject for dimension.", e);
        }
        return jSONObject;
    }

    @Nullable
    public static View.AccessibilityDelegate getExistingDelegate(View view) {
        try {
            return (View.AccessibilityDelegate) view.getClass().getMethod(GET_ACCESSIBILITY_METHOD, new Class[0]).invoke(view, new Object[0]);
        } catch (IllegalAccessException e) {
            return null;
        } catch (NoSuchMethodException e2) {
            return null;
        } catch (NullPointerException e3) {
            return null;
        } catch (SecurityException e4) {
            return null;
        } catch (InvocationTargetException e5) {
            return null;
        }
    }

    @Nullable
    public static View.OnTouchListener getExistingOnTouchListener(View view) {
        View.OnTouchListener onTouchListener;
        try {
            Field declaredField = Class.forName("android.view.View").getDeclaredField("mListenerInfo");
            if (declaredField != null) {
                declaredField.setAccessible(true);
            }
            Object obj = declaredField.get(view);
            if (obj == null) {
                return null;
            }
            Field declaredField2 = Class.forName("android.view.View$ListenerInfo").getDeclaredField("mOnTouchListener");
            if (declaredField2 != null) {
                declaredField2.setAccessible(true);
                onTouchListener = (View.OnTouchListener) declaredField2.get(obj);
            } else {
                onTouchListener = null;
            }
            return onTouchListener;
        } catch (ClassNotFoundException e) {
            Utility.logd(TAG, e);
            return null;
        } catch (IllegalAccessException e2) {
            Utility.logd(TAG, e2);
            return null;
        } catch (NoSuchFieldException e3) {
            Utility.logd(TAG, e3);
            return null;
        }
    }

    @Nullable
    public static View getTouchReactView(float[] fArr, @Nullable View view) {
        initTouchTargetHelperMethods();
        if (methodFindTouchTargetView == null || view == null) {
            return null;
        }
        try {
            View view2 = (View) methodFindTouchTargetView.invoke(null, fArr, view);
            if (view2 != null && view2.getId() > 0) {
                View view3 = (View) view2.getParent();
                if (view3 != null) {
                    return view3;
                }
            }
        } catch (IllegalAccessException e) {
            Utility.logd(TAG, e);
        } catch (InvocationTargetException e2) {
            Utility.logd(TAG, e2);
        }
        return null;
    }

    public static boolean isRCTButton(View view, @Nullable View view2) {
        View touchReactView;
        return view.getClass().getName().equals(CLASS_RCTVIEWGROUP) && (touchReactView = getTouchReactView(getViewLocationOnScreen(view), view2)) != null && touchReactView.getId() == view.getId();
    }

    public static boolean isRCTRootView(View view) {
        return view.getClass().getName().equals(CLASS_RCTROOTVIEW);
    }

    public static boolean isRCTTextView(View view) {
        return view.getClass().getName().equals(CLASS_RCTTEXTVIEW);
    }

    public static boolean isRCTViewGroup(View view) {
        return view.getClass().getName().equals(CLASS_RCTVIEWGROUP);
    }

    @Nullable
    public static View findRCTRootView(View view) {
        View view2 = view;
        while (view2 != null) {
            if (!isRCTRootView(view2)) {
                ViewParent parent = view2.getParent();
                if (parent == null || !(parent instanceof View)) {
                    break;
                }
                view2 = (View) parent;
            } else {
                return view2;
            }
        }
        return null;
    }

    private static float[] getViewLocationOnScreen(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return new float[]{iArr[0], iArr[1]};
    }

    private static void initTouchTargetHelperMethods() {
        if (methodFindTouchTargetView == null) {
            try {
                methodFindTouchTargetView = Class.forName(CLASS_TOUCHTARGETHELPER).getDeclaredMethod(METHOD_FIND_TOUCHTARGET_VIEW, float[].class, ViewGroup.class);
                methodFindTouchTargetView.setAccessible(true);
            } catch (ClassNotFoundException e) {
                Utility.logd(TAG, e);
            } catch (NoSuchMethodException e2) {
                Utility.logd(TAG, e2);
            }
        }
    }
}
