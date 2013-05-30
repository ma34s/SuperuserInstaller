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

	private static final String SUPER_USER_PACKAGE="com.koushikdutta.superuser";

	@Override
	public void onReceive(Context context, Intent intent) {
		Log.i(TAG, "Start up");

		final Context con = context;
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
