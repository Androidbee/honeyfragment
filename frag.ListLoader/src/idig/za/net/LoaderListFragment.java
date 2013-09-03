package idig.za.net;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract.Contacts;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.View;
import android.widget.ListView;

public class LoaderListFragment extends ListFragment implements
		LoaderManager.LoaderCallbacks<Cursor> {

	private SimpleCursorAdapter myCursorAdapter;
	String[] projection = new String[] { Contacts._ID, Contacts.DISPLAY_NAME,
			Contacts.CONTACT_STATUS };
	boolean landscape = false;
	private Cursor myCursor = null;
	private int currentPosition = 0;

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		myCursorAdapter = new SimpleCursorAdapter(getActivity(),
				R.layout.list_layout, null, new String[] {
						Contacts.DISPLAY_NAME, Contacts.CONTACT_STATUS },
				new int[] { R.id.textView1 }, 0);
		setListAdapter(myCursorAdapter);
		View detailsFragmentView = getActivity().findViewById(R.id.details);
		landscape = detailsFragmentView != null
				&& detailsFragmentView.getVisibility() == View.VISIBLE;
		if (savedInstanceState != null) {
			currentPosition = savedInstanceState.getInt("currentposition", 0);
		}
		setListShown(false);
		getLoaderManager().initLoader(0, null, this);
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putInt("currentposition", currentPosition);
	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		String selectedName = myCursor.getString(1);
		showSelectedItemDetails(position, selectedName);
	}

	void showSelectedItemDetails(int index, String selectedName) {
		currentPosition = index;

		if (landscape) {

			ViewerFragment details = (ViewerFragment) getFragmentManager()
					.findFragmentById(R.id.details);

			if (details == null || details.getShownIndex() != index) {
				details = ViewerFragment.newInstance(index, selectedName);
				FragmentTransaction fragTransaction = getFragmentManager()
						.beginTransaction();
				fragTransaction.replace(R.id.details, details);
				fragTransaction.commit();
			}

		} else {
			Intent intent = new Intent(getActivity(), ViewerActivity.class);
			Bundle b = new Bundle();
			b.putInt("index", index);
			b.putString("selectedName", selectedName);
			intent.putExtras(b);
			startActivity(intent);
		}
	}

	@Override
	public Loader<Cursor> onCreateLoader(int arg0, Bundle arg1) {
		Uri baseUri = Contacts.CONTENT_URI;

		String select = "((" + Contacts.DISPLAY_NAME + " NOTNULL) AND ("
				+ Contacts.HAS_PHONE_NUMBER + "=1) AND ("
				+ Contacts.DISPLAY_NAME + " != '' ))";

		return new CursorLoader(getActivity(), baseUri, projection, select,
				null, Contacts.DISPLAY_NAME + " COLLATE LOCALIZED ASC");
	}

	@Override
	public void onLoadFinished(Loader<Cursor> arg0, Cursor data) {
		myCursorAdapter.swapCursor(data);
		myCursor = data;
		if (isResumed()) {
			setListShown(true);
		} else {
			setListShownNoAnimation(true);
		}
	}

	@Override
	public void onLoaderReset(Loader<Cursor> arg0) {
		myCursorAdapter.swapCursor(null);
	}
}
