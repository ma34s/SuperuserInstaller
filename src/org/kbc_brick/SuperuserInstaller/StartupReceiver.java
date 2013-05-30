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

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.util.Log;

public class StartupReceiver extends BroadcastReceiver {
	private static final String TAG="StartupReceiver";

	@Override
	public void onReceive(Context context, Intent intent) {
		Log.i(TAG, "Start up");

		final String SUPER_USER_PACKAGE = context.getString(R.string.superuser_package);

		if( !checkAPP(context,SUPER_USER_PACKAGE) )
		{
			Intent targetIntent = new Intent(Intent.ACTION_MAIN, null);
			//targetIntent.setClassName( context, context.getPackageName()+".InstallActivity" );
			targetIntent.setClassName("org.kbc_brick.SuperuserInstaller","org.kbc_brick.SuperuserInstaller.InstallActivity");
			targetIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			context.startActivity(targetIntent);
			Log.i(TAG, "StartActivity :InstallActivity");
		}
		else
		{
			Log.i(TAG, "Detect superuser -> do nothing");
		}
	}

	private boolean checkAPP(Context context,String pkgName)
	{
		PackageManager packageManager = context.getPackageManager();
		Intent intent = new Intent(Intent.ACTION_MAIN, null);
		intent.addCategory(Intent.CATEGORY_LAUNCHER);
		List<ApplicationInfo> applicationInfo = packageManager.getInstalledApplications(PackageManager.GET_META_DATA);

		for (ApplicationInfo info : applicationInfo) {
			if(info.packageName.equals(pkgName))
			{
				return true;
			}
		}
		return false;
	}

}
