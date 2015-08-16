package info.androidhive.slidingmenu;

import info.androidhive.slidingmenu.adapter.NavDrawerListAdapter;
import info.androidhive.slidingmenu.model.NavDrawerItem;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
//import org.apache.commons.io.FilenameUtils;
import javax.xml.datatype.Duration;




import java.util.concurrent.TimeUnit;
import java.util.regex.*;





import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends Activity {
	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;
	private ActionBarDrawerToggle mDrawerToggle;
	final Context context = this;
	//private ImageView clock;
	// nav drawer title
	private CharSequence mDrawerTitle;
	private int mYear, mMonth, mDay, mHour, mMinute;
	String url1;
	String title1;
	private ProgressDialog pDialog;
	public static final int progress_bar_type = 0; 
	// used to store app title
	private CharSequence mTitle;

	// slide menu items
	private String[] navMenuTitles;
	private TypedArray navMenuIcons;

	private ArrayList<NavDrawerItem> navDrawerItems;
	private NavDrawerListAdapter adapter;

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	//	File direct = new File(Environment.getExternalStorageDirectory()+"/folder");
		File direct = new File("/sdcard/Android Download Manager");
		File images = new File("/sdcard/Android Download Manager/Images");
		File music = new File("/sdcard/Android Download Manager/Music");
		File videos = new File("/sdcard/Android Download Manager/Videos");
		File archives = new File("/sdcard/Android Download Manager/Archives");
		File documents = new File("/sdcard/Android Download Manager/Documents");
		File programs = new File("/sdcard/Android Download Manager/Programs");
		File others = new File("/sdcard/Android Download Manager/Others");
		if(!direct.exists()) {
		     if(direct.mkdir()); //directory is created;
		     if(images.mkdir());
		     if(music.mkdir());
		     if(videos.mkdir());
		     if(archives.mkdir());
		     if(documents.mkdir());
		     if(programs.mkdir());
		     if(others.mkdir());
		}
		
		
		
		
		
		
		mTitle = mDrawerTitle = getTitle();

		// load slide menu items
		navMenuTitles = getResources().getStringArray(R.array.nav_drawer_items);

		// nav drawer icons from resources
		navMenuIcons = getResources()
				.obtainTypedArray(R.array.nav_drawer_icons);

		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerList = (ListView) findViewById(R.id.list_slidermenu);

		navDrawerItems = new ArrayList<NavDrawerItem>();

		// adding nav drawer items to array
		// Home
		navDrawerItems.add(new NavDrawerItem(navMenuTitles[0], navMenuIcons.getResourceId(0, -1),true,getall()));
		// Find People
		navDrawerItems.add(new NavDrawerItem(navMenuTitles[1], navMenuIcons.getResourceId(1, -1),true,getimg()));
		// Photos
		navDrawerItems.add(new NavDrawerItem(navMenuTitles[2], navMenuIcons.getResourceId(2, -1),true,getaud()));
		// Communities, Will add a counter here
		navDrawerItems.add(new NavDrawerItem(navMenuTitles[3], navMenuIcons.getResourceId(3, -1),true,getvid()));
		// Pages
		navDrawerItems.add(new NavDrawerItem(navMenuTitles[4], navMenuIcons.getResourceId(4, -1),true,getarc()));
		// What's hot, We  will add a counter here
		navDrawerItems.add(new NavDrawerItem(navMenuTitles[5], navMenuIcons.getResourceId(5, -1),true,getdoc()));
		navDrawerItems.add(new NavDrawerItem(navMenuTitles[6], navMenuIcons.getResourceId(6, -1),true,getprg()));
		navDrawerItems.add(new NavDrawerItem(navMenuTitles[7], navMenuIcons.getResourceId(7, -1),true,getoth()));


		// Recycle the typed array
		navMenuIcons.recycle();

		mDrawerList.setOnItemClickListener(new SlideMenuClickListener());

		// setting the nav drawer list adapter
		adapter = new NavDrawerListAdapter(getApplicationContext(),
				navDrawerItems);
		mDrawerList.setAdapter(adapter);

		// enabling action bar app icon and behaving it as toggle button
		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setHomeButtonEnabled(true);

		mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
				R.drawable.ic_drawer, //nav menu toggle icon
				R.string.app_name, // nav drawer open - description for accessibility
				R.string.app_name // nav drawer close - description for accessibility
		) {
			public void onDrawerClosed(View view) {
				getActionBar().setTitle(mTitle);
				// calling onPrepareOptionsMenu() to show action bar icons
				invalidateOptionsMenu();
			}

			public void onDrawerOpened(View drawerView) {
				getActionBar().setTitle(mDrawerTitle);
				// calling onPrepareOptionsMenu() to hide action bar icons
				invalidateOptionsMenu();
			}
		};
		mDrawerLayout.setDrawerListener(mDrawerToggle);

		if (savedInstanceState == null) {
			// on first time display view for first nav item
			displayView(0);
		}
	}
	int all;
	public String getimg() {
		// TODO Auto-generated method stub
		String path = "/sdcard/Android Download Manager/Images";
        File f = new File(path);        
        File file[] = f.listFiles();
        all=file.length;
       
		return ""+file.length;
	}
	public String getvid() {
		// TODO Auto-generated method stub
		String path = "/sdcard/Android Download Manager/Videos";
        File f = new File(path);        
        File file[] = f.listFiles();
        all=all+file.length;
       
		return ""+file.length;
	}
	public String getaud() {
		// TODO Auto-generated method stub
		String path = "/sdcard/Android Download Manager/Music";
        File f = new File(path);        
        File file[] = f.listFiles();
        all=all+file.length;
		return ""+file.length;
	}
	public String getprg() {
		// TODO Auto-generated method stub
		String path = "/sdcard/Android Download Manager/Programs";
        File f = new File(path);        
        File file[] = f.listFiles();
        all=all+file.length;
		return ""+file.length;
	}
	public String getdoc() {
		// TODO Auto-generated method stub
		String path = "/sdcard/Android Download Manager/Documents";
        File f = new File(path);        
        File file[] = f.listFiles();
        all=all+file.length;
		return ""+file.length;
	}
	public String getoth() {
		// TODO Auto-generated method stub
		String path = "/sdcard/Android Download Manager/Others";
        File f = new File(path);        
        File file[] = f.listFiles();
        all=all+file.length;
        
		return ""+file.length;
	}
	public String getarc() {
		// TODO Auto-generated method stub
		String path = "/sdcard/Android Download Manager/Archives";
        File f = new File(path);        
        File file[] = f.listFiles();
        all=all+file.length;
		return ""+file.length;
	}
	public String getall() {
		int a=Integer.parseInt(getarc())+Integer.parseInt(getaud())+Integer.parseInt(getvid())+Integer.parseInt(getimg())+Integer.parseInt(getdoc())+Integer.parseInt(getprg())+Integer.parseInt(getoth());
	return ""+a;
	}

	/**
	 * Slide menu item click listener
	 * */
	private class SlideMenuClickListener implements
			ListView.OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			// display view for selected nav drawer item
			displayView(position);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// toggle nav drawer on selecting action bar app icon/title
		if (mDrawerToggle.onOptionsItemSelected(item)) {
			return true;
		}
		// Handle action bar actions click
		switch (item.getItemId()) {
		case R.id.action_settings:
			return true;
		case R.id.addoption:
			
			
			LayoutInflater layoutInflater = LayoutInflater.from(context);
			
			View promptView = layoutInflater.inflate(R.layout.prompt, null);

			AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

			// set prompts.xml to be the layout file of the alertdialog builder
			alertDialogBuilder.setView(promptView);

			final EditText input = (EditText) promptView.findViewById(R.id.userInput);
			final EditText title = (EditText) promptView.findViewById(R.id.editText1);
			ImageView clock=(ImageView) promptView.findViewById(R.id.imageView1);
			clock.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					url1=input.getText().toString();
					title1=title.getText().toString();
					// TODO Auto-generated method stub
					/*Toast.makeText(getApplicationContext(), 
                            "These Passwords dont match. Try Again", Toast.LENGTH_LONG).show();*/
					final Calendar c = Calendar.getInstance();
					mHour = c.get(Calendar.HOUR_OF_DAY);
					mMinute = c.get(Calendar.MINUTE);

					// Launch Time Picker Dialog
					TimePickerDialog tpd = new TimePickerDialog(MainActivity.this,
							new TimePickerDialog.OnTimeSetListener() {

								@Override
								public void onTimeSet(TimePicker view, int hourOfDay,
										int minute) {
									// Display Selected time in textbox
									//txtTime.setText(hourOfDay + ":" + minute);
									/*SimpleDateFormat sd=new SimpleDateFormat("HH:mm");
									Calendar cal=Calendar.getInstance();
									String test=sd.format(cal.getTime());
									Date test1=sd.parse(test);*/
									SimpleDateFormat sd=new SimpleDateFormat("HH:mm");
									final Calendar c = Calendar.getInstance();
								int hour1 = c.get(Calendar.HOUR_OF_DAY);
								int	minute1 = c.get(Calendar.MINUTE);
								Date start=null;
								Date end=null;
								try {
									 start=sd.parse(hour1+":"+minute1);
									 end=sd.parse(hourOfDay+":"+minute);
									
									
									
									
								} catch (ParseException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
								Intent nintent=new Intent(context,AlarmReceiver.class);
								nintent.putExtra("url", url1);
								nintent.putExtra("title", title1);
								long diff=end.getTime() - start.getTime();
								long min=TimeUnit.MILLISECONDS.toMinutes(diff);
								Toast.makeText(getApplicationContext(),"Your Download will start after "+min+"minutes", Toast.LENGTH_LONG).show();
								AlarmManager am=(AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
								am.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+diff, PendingIntent.getBroadcast(context,1, nintent, PendingIntent.FLAG_UPDATE_CURRENT));
								}
							}, mHour, mMinute, false);
					tpd.show();
				}
			});
			// setup a dialog window
			alertDialogBuilder
					.setCancelable(false)
					.setPositiveButton("OK", new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog, int id) {
									Log.d("dw_str","------Download Started------");
									// get user input and set it to result
									url1=input.getText().toString();
									title1=title.getText().toString();
									//url1="http://api.androidhive.info/progressdialog/hive.jpg";
									//Toast.makeText(getApplicationContext(), url1,Toast.LENGTH_LONG ).show();
									
										new DownloadFileFromURL().execute(url1);
									
									
									
									
									
									
								}
							})
					.setNegativeButton("Cancel",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,	int id) {
									dialog.cancel();
								}
							});

			// create an alert dialog
			AlertDialog alertD = alertDialogBuilder.create();

			alertD.show();
			
			
			
			
			
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	/* *
	 * Called when invalidateOptionsMenu() is triggered
	 */
	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		// if nav drawer is opened, hide the action items
		boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
		menu.findItem(R.id.action_settings).setVisible(!drawerOpen);
		return super.onPrepareOptionsMenu(menu);
	}

	/**
	 * Diplaying fragment view for selected nav drawer list item
	 * */
	private void displayView(int position) {
		// update the main content by replacing fragments
		Fragment fragment = null;
		switch (position) {
		case 0:
			fragment = new All();
			break;
		case 1:
			fragment = new Images();
			break;
		case 2:
			fragment = new Music();
			break;
		case 3:
			fragment = new Videos();
			break;
		case 4:
			fragment = new Archives();
			break;
		case 5:
			fragment = new Documents();
			break;
		case 6:
			fragment = new Programs();
			break;
		case 7:
			fragment = new Others();
			break;
		default:
			break;
		}

		if (fragment != null) {
			FragmentManager fragmentManager = getFragmentManager();
			fragmentManager.beginTransaction()
					.replace(R.id.frame_container, fragment).commit();

			// update selected item and title, then close the drawer
			mDrawerList.setItemChecked(position, true);
			mDrawerList.setSelection(position);
			setTitle(navMenuTitles[position]);
			mDrawerLayout.closeDrawer(mDrawerList);
		} else {
			// error in creating fragment
			Log.e("MainActivity", "Error in creating fragment");
		}
	}

	@Override
	public void setTitle(CharSequence title) {
		mTitle = title;
		getActionBar().setTitle(mTitle);
	}

	/**
	 * When using the ActionBarDrawerToggle, you must call it during
	 * onPostCreate() and onConfigurationChanged()...
	 */

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		// Sync the toggle state after onRestoreInstanceState has occurred.
		mDrawerToggle.syncState();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		// Pass any configuration change to the drawer toggls
		mDrawerToggle.onConfigurationChanged(newConfig);
	}
	
	
	
	protected Dialog onCreateDialog(int id) {
		switch (id) {
		case progress_bar_type:
			pDialog = new ProgressDialog(this);
			pDialog.setMessage("Downloading file. Please wait...");
			pDialog.setIndeterminate(false);
			pDialog.setMax(100);
			pDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
			pDialog.setCancelable(true);
			pDialog.show();
			return pDialog;
		default:
			return null;
		}
	}

	/**
	 * Background Async Task to download file
	 * */
	class DownloadFileFromURL extends AsyncTask<String, String, String> {

		/**
		 * Before starting background thread
		 * Show Progress Bar Dialog
		 * */
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			showDialog(progress_bar_type);
		}

		/**
		 * Downloading file in background thread
		 * */
		@Override
		protected String doInBackground(String... f_url) {
			int count;
	        try {
	            URL url = new URL(f_url[0]);
	            URLConnection conection = url.openConnection();
	            conection.connect();
	            // getting file length
	            int lenghtOfFile = conection.getContentLength();

	            // input stream to read file - with 8k buffer
	            InputStream input = new BufferedInputStream(url.openStream(), 8192);
	            
	            // Output stream to write file
	        /*    String basename = FilenameUtils.getBaseName(url1);
	            String extension = FilenameUtils.getExtension(url1);
				Toast.makeText(getApplicationContext(), extension,Toast.LENGTH_LONG ).show();*/
	          //  EditText title = (EditText) promptView.findViewById(R.id.editText1);
	            String[] tokens = url1.split("\\.(?=[^\\.]+$)");
	            String path;
	            if(tokens[1].equals("jpg") | tokens[1].equals("png") | tokens[1].equals("gif") | tokens[1].equals("jpeg") | tokens[1].equals("bmp") | tokens[1].equals("tif"))
	            {
	            	path="Images";
	            }
	            else if(tokens[1].equals("mkv") | tokens[1].equals("mp4") | tokens[1].equals("3gp") | tokens[1].equals("avi") | tokens[1].equals("vob")|tokens[1].equals("aac") | tokens[1].equals("mov"))
	            {
	            	path="Videos";
	            }
	            else if(tokens[1].equals("mp3") | tokens[1].equals("wav"))
	            {
	            	path="Music";
	            }
	            else if(tokens[1].equals("tar") | tokens[1].equals("zip") |tokens[1].equals("gz"))
	            {
	            	path="Archives";
	            }
	            else if(tokens[1].equals("exe")|tokens[1].equals("apk"))
	            {
	            	path="Programs";
	            }
	            else if(tokens[1].equals("txt") | tokens[1].equals("doc") | tokens[1].equals("pdf") | tokens[1].equals("oda") | tokens[1].equals("csv") | tokens[1].equals("pptx")|tokens[1].equals("xls")|tokens[1].equals("rtf"))
	            {
	            	path="Documents";
	            }
	            else
	            {
	            	path="Others";
	            }
	            
	          OutputStream output = new FileOutputStream("/sdcard/Android Download Manager/"+path+"/"+title1+"."+tokens[1]);
	          //  OutputStream output = new FileOutputStream("/sdcard/abc.pdf");

	            byte data[] = new byte[1024];

	            long total = 0;

	            while ((count = input.read(data)) != -1) {
	                total += count;
	                // publishing the progress....
	                // After this onProgressUpdate will be called
	                publishProgress(""+(int)((total*100)/lenghtOfFile));
	                
	                // writing data to file
	                output.write(data, 0, count);
	            }

	            // flushing output
	            output.flush();
	            
	            // closing streams
	            output.close();
	            input.close();
	            
	        
	        

	        
	        
	        
	        
	        }catch (Exception e) {
	        	Log.e("Error: ", e.getMessage());
	        }
	        
	        return null;
		}
		
		/**
		 * Updating progress bar
		 * */
		protected void onProgressUpdate(String... progress) {
			// setting progress percentage
            pDialog.setProgress(Integer.parseInt(progress[0]));
       }

		/**
		 * After completing background task
		 * Dismiss the progress dialog
		 * **/
		@Override
		protected void onPostExecute(String file_url) {
			// dismiss the dialog after the file was downloaded
			dismissDialog(progress_bar_type);
			
			
			Intent intent=new Intent(context,MainActivity.class);
			PendingIntent pIntent = PendingIntent.getActivity(context, 0, intent, Intent.FLAG_ACTIVITY_NEW_TASK);
			
			NotificationManager notificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
			
			 Notification mNotification = new Notification.Builder(context) 
				            .setAutoCancel(true).setContentTitle("Android Download Manager")
			 	            .setContentText("Download Successfull")
			 	            .setSmallIcon(R.drawable.ic_launcher)
			 	            .setContentIntent(pIntent)
			 	           
			 	      //      .addAction(R.drawable.ic_launcher,"View", pIntent)
			 	            .build();
			 
			 
			 
			    
			    	notificationManager.notify(1, mNotification);
			
			// Displaying downloaded image into image view
			// Reading image path from sdcard
			//String imagePath = Environment.getExternalStorageDirectory().toString() + "/downloadedfile.jpg";
			// setting downloaded into image view
			//my_image.setImageDrawable(Drawable.createFromPath(imagePath));
		}

	}
}


