package hearsilent.circularindicator;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.github.hearsilent.circularindicator.CircularIndicator;

public class MainActivity extends AppCompatActivity {

	private ViewPager mViewPager;
	private CircularIndicator mCircularIndicator;

	PagerAdapter mAdapter;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		findViews();
		setUpViews();
	}

	private void findViews() {
		mViewPager = (ViewPager) findViewById(R.id.viewPager);
		mCircularIndicator = (CircularIndicator) findViewById(R.id.indicator);
	}

	private void setUpViews() {
		mAdapter = new PagerAdapter(getSupportFragmentManager());
		mViewPager.setAdapter(mAdapter);
		mCircularIndicator.setupWithViewPager(mViewPager);
		mViewPager.setPageTransformer(false, new ViewPager.PageTransformer() {

			@Override
			public void transformPage(View page, float position) {
				int pageWidth = page.getWidth();
				View textView = page.findViewById(R.id.subTextView);
				textView.setTranslationX(position * pageWidth);
			}
		});
	}

	private class PagerAdapter extends FragmentPagerAdapter {

		private PagerAdapter(FragmentManager fragmentManager) {
			super(fragmentManager);
		}

		@Override
		public Fragment getItem(int position) {
			return new DemoFragment().newInstance(position);
		}

		@Override
		public int getCount() {
			return 5;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			return Integer.toString(position);
		}
	}
}
