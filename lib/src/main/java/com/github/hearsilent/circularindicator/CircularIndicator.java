package com.github.hearsilent.circularindicator;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class CircularIndicator extends LinearLayout {

	private int mCount = 0;
	private int mPosition = 0;
	private List<ImageView> mDots = new ArrayList<>();

	private ViewPager mViewPager;

	public CircularIndicator(Context context) {
		super(context);
	}

	public CircularIndicator(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public CircularIndicator(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}

	private void setUpView(int count) {
		if (count == 0) {
			removeAllViews();
			return;
		}
		if (mCount == count) {
			return;
		}

		int width = (int) convertDpToPixel(10, getContext());
		int height = (int) convertDpToPixel(10, getContext());
		LayoutParams params = new LayoutParams(width, height);

		int radius = (int) convertDpToPixel(5, getContext());
		ShapeDrawable oval = new ShapeDrawable(new OvalShape());
		oval.setIntrinsicHeight(radius);
		oval.setIntrinsicWidth(radius);
		oval.getPaint().setColor(ContextCompat.getColor(getContext(), android.R.color.white));

		if (count > mCount) {
			for (int i = mCount; i < count; i++) {
				ImageView dot = new ImageView(getContext());
				mDots.add(i, dot);
				dot.setImageDrawable(oval);
				dot.setScaleType(ImageView.ScaleType.CENTER);
				addView(dot, params);
			}
		} else {
			for (int i = count; i < mCount; i++) {
				ImageView dot = mDots.get(i);
				removeView(dot);
			}
			mDots = mDots.subList(0, count);
		}

		if (mPosition < count) {
			mDots.get(mPosition).animate().scaleX(1f).scaleY(1f).start();
		}
		mDots.get(0).animate().scaleX(1.6f).scaleY(1.6f).start();
		mPosition = 0;
		mCount = count;
	}

	public void setCount(int count) {
		setUpView(count);
	}

	public void setupWithViewPager(@NonNull final ViewPager viewPager) {
		mViewPager = viewPager;
		setCount(viewPager.getAdapter().getCount());
		viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

			@Override
			public void onPageScrolled(int position, float positionOffset,
			                           int positionOffsetPixels) {
				if (mViewPager == null) {
					return;
				}
				int currentPos = mViewPager.getCurrentItem();
				if (positionOffset < 0.5f && currentPos > 0 && position != currentPos) {
					if (getSelection() != currentPos - 1) {
						setSelection(currentPos - 1);
					}
				} else if (positionOffset >= 0.5f && currentPos < mCount - 1 &&
						position == currentPos) {
					if (getSelection() != currentPos + 1) {
						setSelection(currentPos + 1);
					}
				} else {
					if (getSelection() != currentPos) {
						setSelection(currentPos);
					}
				}
			}

			@Override
			public void onPageSelected(int position) {
				if (getSelection() != position) {
					setSelection(position);
				}
			}

			@Override
			public void onPageScrollStateChanged(int state) {

			}
		});
	}

	public int getCount() {
		return mCount;
	}

	public void setSelection(int position) {
		position = position % mCount;
		mDots.get(mPosition).animate().scaleX(1f).scaleY(1f).start();
		mDots.get(position).animate().scaleX(1.6f).scaleY(1.6f).start();
		mPosition = position;
	}

	public int getSelection() {
		return mPosition;
	}

	public static DisplayMetrics getDisplayMetrics(Context context) {
		Resources resources = context.getResources();
		return resources.getDisplayMetrics();
	}

	/**
	 * This method converts dp unit to equivalent pixels, depending on device
	 * density.
	 *
	 * @param dp      A value in dp (density independent pixels) unit. Which we need
	 *                to convert into pixels
	 * @param context Context to get resources and device specific display metrics
	 * @return A float value to represent px equivalent to dp depending on
	 * device density
	 */
	public static float convertDpToPixel(float dp, Context context) {
		return dp * (getDisplayMetrics(context).densityDpi / 160f);
	}

}
