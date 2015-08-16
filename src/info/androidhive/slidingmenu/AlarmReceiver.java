package info.androidhive.slidingmenu;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

public class AlarmReceiver extends BroadcastReceiver{

	@Override
	public void onReceive(Context arg0, Intent arg1) {
		// TODO Auto-generated method stub
		String url=arg1.getExtras().getString("url");
		String title=arg1.getExtras().getString("title");
		//Toast.makeText(arg0, url+"   "+title,Toast.LENGTH_LONG ).show();
		
		  DownloadManager mgr = (DownloadManager) arg0.getSystemService(Context.DOWNLOAD_SERVICE);

	        Uri downloadUri = Uri.parse(url);
	        DownloadManager.Request request = new DownloadManager.Request(
	                downloadUri);

	        request.setAllowedNetworkTypes(
	                DownloadManager.Request.NETWORK_WIFI
	                        | DownloadManager.Request.NETWORK_MOBILE)
	                .setAllowedOverRoaming(false).setTitle("ADM")
	                .setDescription("Downloading..")
	                .setDestinationInExternalPublicDir("/sdcard/Android Download Manager/Images/", title+".jpg");

	        mgr.enqueue(request);
	}

}
