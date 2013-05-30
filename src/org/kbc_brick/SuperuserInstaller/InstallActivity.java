package org.kbc_brick.SuperuserInstaller;

import java.util.List;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import android.view.Menu;

public class InstallActivity extends Activity {
	private static final String TAG="InstallActivity";

	private static final String SUPER_USER_URL="https://play.google.com/store/apps/details?id=com.koushikdutta.superuser";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Log.i(TAG, "onCreate");
		new AlertDialog.Builder(this)
		//.setIcon(R.drawable.ic_launcher)
		.setMessage("Superuserをインストールしますか？")
		.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int whichButton) {
				// TODO superuser install ( open google play )
	            Uri uri = Uri.parse(SUPER_USER_URL);
	            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
	            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	            startActivity(intent);
	            finish();
			}
		})
		.setNegativeButton("No", null)
		.show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
