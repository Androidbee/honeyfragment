package androidbee.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class FragmentStack extends Activity {
	int numberInStack = 1;
	private static String tag = "honey";
	static String[] names = { "Alfred", "Beatrix", "Cindy", "David", "Erick",
			"Frank", "George", "Harry", "Ingrid", "Jack" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.i(tag, "in Activity onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		Button nextButton = (Button) findViewById(R.id.nextButton);
		nextButton.setOnClickListener(new android.view.View.OnClickListener() {
			public void onClick(View v) {
				Log.i(tag, "next button clicked");
				addFragmentToStack();				
			}
		});

		if (savedInstanceState == null) {
			Fragment newFragment = StackFragment.newInstance(numberInStack);
			FragmentTransaction fragTransact = getFragmentManager()
					.beginTransaction();
			fragTransact.add(R.id.frameLayout, newFragment).commit();
			Log.i(tag, "first initialization - creating fragment");
		} else {
			numberInStack = savedInstanceState.getInt("numberInStack");
		}
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putInt("numberInStack", numberInStack);
		Log.i(tag, "saving state - in onSaveInstanceState");
	}

	void addFragmentToStack() {
		numberInStack++;
		Fragment newFragment = StackFragment.newInstance(numberInStack);
		FragmentTransaction fragTransact = getFragmentManager()
				.beginTransaction();
		fragTransact.replace(R.id.frameLayout, newFragment);
		fragTransact.addToBackStack(null);
		Log.i(tag,
				"in addFragmentToStack - replacing fragment and adding to stack");
		fragTransact.commit();
	}

	@Override
	public void onBackPressed() {
		Log.i(tag, "in BackPressed");
		super.onBackPressed();
	}

	@Override
	public void onStart() {
		super.onStart();
		Log.i(tag, "in onStart");
	}

	@Override
	public void onResume() {
		super.onResume();
		Log.i(tag, "in onResume");
	}

	@Override
	public void onDestroy() {
		Log.i(tag, "in onDestroy");
		super.onDestroy();
	}

	@Override
	public void onPause() {
		Log.i(tag, "in onPause");
		super.onPause();
	}

	public static class StackFragment extends Fragment {
		int mFragNumber;

		static StackFragment newInstance(int fragNumber) {
			Log.i(tag, "creating new instance of a fragment");
			StackFragment fragment = new StackFragment();
			Bundle args = new Bundle();
			args.putInt("fragNumber", fragNumber);
			fragment.setArguments(args);
			return fragment;
		}

		@Override
		public void onCreate(Bundle savedInstanceState) {
			Log.i(tag, "in fragment onCreate - geting arguments from savedInstanceState...");
			super.onCreate(savedInstanceState);
			mFragNumber = getArguments().getInt("fragNumber");
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			int arrayIndex = 0;
			Log.i(tag, "creating view");
			View v = inflater.inflate(R.layout.my_layout, container, false);
			View tv = v.findViewById(R.id.text);
			int number = mFragNumber - 1;
			if (number > 9) {
				Log.i(tag, "getArrayNumber(number) = " + getArrayNumber(number));
				arrayIndex = getArrayNumber(number);
			} else {
				arrayIndex = number;
			}
			((TextView) tv).setText(names[arrayIndex]);
			return v;
		}

		public int getArrayNumber(int number) {
			int startNum = 0;
			Log.i(tag, "number = " + number);
			String stringNumber = Integer.toString(number);
			Log.i(tag, "stringNumber = " + stringNumber);
			int stringLength = stringNumber.length();
			Log.i(tag, "stringLength = " + stringLength);
			switch (stringLength) {
			case 2:
				startNum = 1;
				break;
			case 3:
				startNum = 2;
				break;
			case 4:
				startNum = 3;
				break;
			}
			String substring = stringNumber.substring(startNum);
			Log.i(tag, "substring = " + substring);
			int arrayIndex = Integer.parseInt(substring);
			Log.i(tag, "arrayIndex = " + arrayIndex);
			return arrayIndex;
		}

		@Override
		public void onAttach(Activity activity) {
			super.onAttach(activity);
			Log.i(tag, "in onAttach - fragment attaching to activity");
		}

		@Override
		public void onActivityCreated(Bundle savedInstanceState) {
			super.onActivityCreated(savedInstanceState);
			Log.i(tag, "in onActivityCreated");
		}

		@Override
		public void onDetach() {
			Log.i(tag, "in onDetach");
			super.onDetach();
		}

		@Override
		public void onDestroyView() {
			Log.i(tag, "in onDestroyView");
			super.onDestroyView();
		}		
	}
}
