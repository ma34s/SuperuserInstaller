/*
 * Copyright (C) 2013 ma34s <ma34s.sss@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final String SUPER_USER_URL = getString(R.string.superuser_url);

		Log.i(TAG, "onCreate");
		new AlertDialog.Builder(this)
		.setIcon(R.drawable.ic_launcher)
		.setMessage(R.string.install_check_dlg_msg)
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
