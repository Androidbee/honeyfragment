package idig.za.net;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

public class ViewerActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.content);

		if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
			finish();
			return;
		}

		if (savedInstanceState == null) {
			ViewerFragment details = new ViewerFragment();
			details.setArguments(getIntent().getExtras());
			FragmentManager fragManager = getSupportFragmentManager();
			FragmentTransaction fragTransaction = fragManager
					.beginTransaction().add(R.id.content, details);
			fragTransaction.commit();
		}
	}
}
