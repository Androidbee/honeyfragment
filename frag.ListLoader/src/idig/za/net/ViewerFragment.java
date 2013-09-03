package idig.za.net;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;

public class ViewerFragment extends Fragment {

	static int currentposition = 0;

	public static ViewerFragment newInstance(int index, String selectedName) {
		ViewerFragment fragment = new ViewerFragment();
		Bundle args = new Bundle();
		currentposition = index;
		args.putString("selectedName", selectedName);
		args.putInt("index", index);
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		String selectedName = "This string is empty";
		Bundle myBundle = this.getArguments();
		if (myBundle != null){
			selectedName = myBundle.getString("selectedName");
		}
		
		ScrollView scroller = new ScrollView(getActivity());
		TextView text = new TextView(getActivity());
		scroller.addView(text);
		text.setText(selectedName);
		text.setTextColor(Color.BLUE);
		scroller.setBackgroundColor(Color.RED);
		text.setTextSize(35);
		return scroller;
	}

	public int getShownIndex() {
		return getArguments().getInt("index", 0);
	}
	
}
