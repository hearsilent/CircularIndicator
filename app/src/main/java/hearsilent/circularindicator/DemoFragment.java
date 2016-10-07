package hearsilent.circularindicator;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Locale;

public class DemoFragment extends Fragment {

	private View mRootView;

	private TextView mTextView, mSubTextView;

	private int mIndex;

	public DemoFragment newInstance(int index) {
		DemoFragment fragment = new DemoFragment();
		Bundle args = new Bundle();
		args.putInt("index", index);
		fragment.setArguments(args);

		return fragment;
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
	                         @Nullable Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);

		if (mRootView != null) {
			return mRootView;
		}

		mRootView = inflater.inflate(R.layout.fragment_demo, container, false);

		restoreArgs();
		findViews();
		setUpViews();

		return mRootView;
	}

	private void restoreArgs() {
		Bundle args = getArguments();
		mIndex = args.getInt("index");
	}

	private void findViews() {
		mTextView = (TextView) mRootView.findViewById(R.id.textView);
		mSubTextView = (TextView) mRootView.findViewById(R.id.subTextView);
	}

	private void setUpViews() {
		mTextView.setText(String.format(Locale.getDefault(), "Title %d", mIndex));
		mSubTextView.setText(String.format(Locale.getDefault(), "Subtitle %d", mIndex));
	}
}
