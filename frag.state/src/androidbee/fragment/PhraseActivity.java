package androidbee.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import androidbee.fragment.FragmentStack.StackFragment;



public class PhraseActivity extends Activity{

	private String tag = "honey";
	private int numberInStack;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.i(tag , "in PhraseActivity");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.phrase_layout);
		addFragmentToStack(R.layout.phrase_layout);
		
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
	
	
	void addFragmentToStack(int layout) {
		numberInStack++;
		Fragment newFragment = StackFragment.newInstance(numberInStack);
		FragmentTransaction fragTransact = getFragmentManager()
				.beginTransaction();
		fragTransact.replace(layout, newFragment);
		fragTransact.addToBackStack(null);
		Log.i(tag,
				"in addFragmentToStack - replacing fragment and adding to stack");
		fragTransact.commit();
	}
}
