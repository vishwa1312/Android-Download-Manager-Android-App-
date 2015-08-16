package info.androidhive.slidingmenu;



import java.io.File;

import java.util.ArrayList;
import java.util.Arrays;






import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class All extends Fragment {

	public All(){}
	ListView mainListView ;
	ArrayAdapter<String> listAdapter ;
	String[] names;
	File myFile;
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.all, container, false);
   
        mainListView = (ListView)rootView.findViewById( R.id.mainListView );
        abc();
    /*    String[] planets = new String[] { };  
ArrayList<String> planetList = new ArrayList<String>();
planetList.addAll( Arrays.asList(planets) );

// Create ArrayAdapter using the planet list.
listAdapter = new ArrayAdapter<String>(getActivity(), R.layout.all_row, planetList);


String path = "/sdcard/Android Download Manager/Images";
Log.d("Files", "Path: " + path);
File f = new File(path);        
File file[] = f.listFiles();
Log.d("Files", "Size: "+ file.length);
String[] names1=new String[file.length];
for (int i=0; i < file.length; i++)
{
    Log.d("Files", "FileName:" + file[i].getName());
    listAdapter.add(file[i].getName());
    names1[i]=file[i].getName();
}

String path1 = "/sdcard/Android Download Manager/Music";
File f1 = new File(path1);
File file1[] = f1.listFiles();
String[] names2=new String[file1.length];
for (int i=0; i < file1.length; i++)
{
    Log.d("Files", "FileName:" + file1[i].getName());
    listAdapter.add(file1[i].getName());
    names2[i]=file1[i].getName();
}

String path2 = "/sdcard/Android Download Manager/Videos";
File f2 = new File(path2);
File file2[] = f2.listFiles();
String[] names3=new String[file2.length];
for (int i=0; i < file2.length; i++)
{
    Log.d("Files", "FileName:" + file2[i].getName());
    listAdapter.add(file2[i].getName());
    names3[i]=file2[i].getName();
}

String path3 = "/sdcard/Android Download Manager/Archives";
File f3 = new File(path3);
File file3[] = f3.listFiles();
String[] names4=new String[file3.length];
for (int i=0; i < file3.length; i++)
{
    Log.d("Files", "FileName:" + file3[i].getName());
    listAdapter.add(file3[i].getName());
    names4[i]=file3[i].getName();
}

String path4 = "/sdcard/Android Download Manager/Programs";
File f4 = new File(path4);
File file4[] = f4.listFiles();
String[] names5=new String[file4.length];
for (int i=0; i < file4.length; i++)
{
    Log.d("Files", "FileName:" + file4[i].getName());
    listAdapter.add(file4[i].getName());
    names5[i]=file4[i].getName();
}

String path5 = "/sdcard/Android Download Manager/Archives";
File f5 = new File(path5);
File file5[] = f5.listFiles();
String[] names6=new String[file5.length];
for (int i=0; i < file5.length; i++)
{
    Log.d("Files", "FileName:" + file5[i].getName());
    listAdapter.add(file5[i].getName());
    names6[i]=file5[i].getName();
}

String path6 = "/sdcard/Android Download Manager/Documents";
File f6 = new File(path6);
File file6[] = f6.listFiles();
String[] names7=new String[file6.length];
for (int i=0; i < file6.length; i++)
{
    Log.d("Files", "FileName:" + file6[i].getName());
    listAdapter.add(file6[i].getName());
    names7[i]=file6[i].getName();
}

String path7 = "/sdcard/Android Download Manager/Others";
File f7 = new File(path7);
File file7[] = f7.listFiles();
String[] names8=new String[file7.length];
for (int i=0; i < file7.length; i++)
{
    Log.d("Files", "FileName:" + file7[i].getName());
    listAdapter.add(file7[i].getName());
    names8[i]=file7[i].getName();
}
int n=names1.length+names2.length+names3.length+names4.length+names5.length+names6.length+names7.length+names8.length;
int j,k,count=0;
names=new String[n];
for(j=0;j<names1.length;j++){
	names[count]=names1[j];
	count++;
}

for(j=0;j<names2.length;j++){
	names[count]=names2[j];
	count++;
}
for(j=0;j<names3.length;j++){
	names[count]=names3[j];
	count++;
}
for(j=0;j<names4.length;j++){
	names[count]=names4[j];
	count++;
}
for(j=0;j<names5.length;j++){
	names[count]=names5[j];
	count++;
}
for(j=0;j<names6.length;j++){
	names[count]=names6[j];
	count++;
}
for(j=0;j<names7.length;j++){
	names[count]=names7[j];
	count++;
}
for(j=0;j<names8.length;j++){
	names[count]=names8[j];
	count++;
}

//String[] names = ArrayUtils.addAll(names1,names2,names3,names4,names5,names6,names7,names8);
// Add more planets. If you passed a String[] instead of a List<String> 
// into the ArrayAdapter constructor, you must not add more items. 
// Otherwise an exception will occur.


// Set the ArrayAdapter as the ListView's adapter.
mainListView.setAdapter( listAdapter ); 
registerForContextMenu(mainListView);*/
        
        return rootView;
    }
	

	 @Override
	    public void onCreateContextMenu(ContextMenu menu, View v,
	    		ContextMenuInfo menuInfo) {
		 super.onCreateContextMenu(menu, v, menuInfo);
	    	if (v.getId()==R.id.mainListView) {
	    	    AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)menuInfo;
	    		//AdapterContextMenuInfo info=(AdapterContextMenuInfo)menuInfo;
	    		menu.setHeaderTitle(names[info.position]);
	    	    
	    	
	    		//Toast.makeText(getActivity(), listPosition, Toast.LENGTH_LONG).show();
	    		String[] menuItems = getResources().getStringArray(R.array.menu); 
	    		for (int i = 0; i<menuItems.length; i++) {
	    			menu.add(Menu.NONE, i, i, menuItems[i]);
				}//Toast.makeText(getActivity(), "true", Toast.LENGTH_LONG).show();
	    	}
	    }
	    
	    @Override
	    public boolean onContextItemSelected(MenuItem item) {
		    AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
		    int menuItemIndex = item.getItemId();
			String[] menuItems = getResources().getStringArray(R.array.menu);
			String menuItemName = menuItems[menuItemIndex];
		    String listItemName = names[info.position];
		    
		   // Toast.makeText(getActivity(), menuItemName, Toast.LENGTH_LONG).show();
		    switch (menuItemIndex) {
			case 0:
				if(listItemName.endsWith(".jpg") || listItemName.endsWith(".png")){
				Intent intent = new Intent();
				intent.setAction(Intent.ACTION_VIEW);
				intent.setDataAndType(Uri.parse("file:///sdcard/Android Download Manager/Images/"+listItemName), "image/*");
				startActivity(intent);}
				else if(listItemName.endsWith(".pdf") || listItemName.endsWith(".docx") || listItemName.endsWith(".ppt") || listItemName.endsWith(".pptx")){
					Intent intent = new Intent();
					intent.setAction(Intent.ACTION_VIEW);
					intent.setDataAndType(Uri.parse("file:///sdcard/Android Download Manager/Documents/"+listItemName), "application/pdf");
					startActivity(intent);
				}
				else if(listItemName.endsWith(".mp3") || listItemName.endsWith(".wav")){
					Intent intent = new Intent();
					intent.setAction(Intent.ACTION_VIEW);
					intent.setDataAndType(Uri.parse("file:///sdcard/Android Download Manager/Music/"+listItemName), "audio/*");
					startActivity(intent);
					
				}
				else if(listItemName.endsWith(".mp4") || listItemName.endsWith(".3gp") || listItemName.endsWith(".avi") || listItemName.endsWith(".mkv")){
					Intent intent = new Intent();
					intent.setAction(Intent.ACTION_VIEW);
					intent.setDataAndType(Uri.parse("file:///sdcard/Android Download Manager/Videos/"+listItemName), "video/*");
					startActivity(intent);
				}
				else if(listItemName.endsWith(".zip") || listItemName.endsWith(".rar")){
					Intent intent = new Intent();
					intent.setAction(Intent.ACTION_VIEW);
					intent.setDataAndType(Uri.parse("file:///sdcard/Android Download Manager/Archives/"+listItemName), "*/*");
					startActivity(intent);
				}
				else if(listItemName.endsWith(".apk") || listItemName.endsWith(".exe") || listItemName.endsWith(".deb")){
					Intent intent = new Intent();
					intent.setAction(Intent.ACTION_VIEW);
					intent.setDataAndType(Uri.parse("file:///sdcard/Android Download Manager/Programs/"+listItemName), "*/*");
					startActivity(intent);
				}
				else{
					Intent intent = new Intent();
					intent.setAction(Intent.ACTION_VIEW);
					intent.setDataAndType(Uri.parse("file:///sdcard/Android Download Manager/Others/"+listItemName), "*/*");
					startActivity(intent);
					
				}
				break;
			/*case 1:
				Toast.makeText(getActivity(), "its delete", Toast.LENGTH_LONG).show();
				break;*/
			case 1:
				// File 11folder = Environment.getExternalStorageDirectory();
				if(listItemName.endsWith(".jpg") || listItemName.endsWith(".png")){
				 String fileName ="/sdcard/Android Download Manager/Images/"+listItemName;
				   myFile = new File(fileName);
				}   
				else if(listItemName.endsWith(".pdf") || listItemName.endsWith(".docx") || listItemName.endsWith(".ppt") || listItemName.endsWith(".pptx")){
					String fileName ="/sdcard/Android Download Manager/Documents/"+listItemName;
					   myFile = new File(fileName);	
				}
				else if(listItemName.endsWith(".mp3") || listItemName.endsWith(".wav")){
					String fileName ="/sdcard/Android Download Manager/Music/"+listItemName;
					   myFile = new File(fileName);	
				}
				else if(listItemName.endsWith(".mp4") || listItemName.endsWith(".3gp") || listItemName.endsWith(".avi") || listItemName.endsWith(".mkv")){
					String fileName ="/sdcard/Android Download Manager/Videos/"+listItemName;
					   myFile = new File(fileName);	
				}
				else if(listItemName.endsWith(".zip") || listItemName.endsWith(".rar")){
					String fileName ="/sdcard/Android Download Manager/Archives/"+listItemName;
					   myFile = new File(fileName);
				}
				else if(listItemName.endsWith(".apk") || listItemName.endsWith(".exe") || listItemName.endsWith(".deb")){
					String fileName ="/sdcard/Android Download Manager/Programs/"+listItemName;
					   myFile = new File(fileName);
				}
				else{
					String fileName ="/sdcard/Android Download Manager/Others/"+listItemName;
					   myFile = new File(fileName);
				}
				
				   
				   
				   
				   
				   
				   
				   
				   
				   
				   
				   
				   
				   
				   
				   
				   AlertDialog.Builder builder1 = new AlertDialog.Builder(getActivity());
				builder1.setTitle("Delete File");
				builder1.setMessage("Are you sure you want to delete "+listItemName+"?");
				builder1.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
				        public void onClick(DialogInterface dialog, int which) { 
				        	if(myFile.exists())
						        myFile.delete();
				        	abc();
				       		        	
				        	
				        }
				     })
				    .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
				        public void onClick(DialogInterface dialog, int which) { 
				            // do nothing
				        }
				     })
				    .setIcon(android.R.drawable.ic_dialog_alert)
				     .show();
				      
				      
				      
				      
				break;
			default:
				break;
			}
	    	return true;
	    }

	public void abc(){
		
		String[] planets = new String[] { };  
		ArrayList<String> planetList = new ArrayList<String>();
		planetList.addAll( Arrays.asList(planets) );

		// Create ArrayAdapter using the planet list.
		listAdapter = new ArrayAdapter<String>(getActivity(), R.layout.all_row, planetList);


		String path = "/sdcard/Android Download Manager/Images";
		Log.d("Files", "Path: " + path);
		File f = new File(path);        
		File file[] = f.listFiles();
		Log.d("Files", "Size: "+ file.length);
		String[] names1=new String[file.length];
		for (int i=0; i < file.length; i++)
		{
		    Log.d("Files", "FileName:" + file[i].getName());
		    listAdapter.add(file[i].getName());
		    names1[i]=file[i].getName();
		}

		String path1 = "/sdcard/Android Download Manager/Music";
		File f1 = new File(path1);
		File file1[] = f1.listFiles();
		String[] names2=new String[file1.length];
		for (int i=0; i < file1.length; i++)
		{
		    Log.d("Files", "FileName:" + file1[i].getName());
		    listAdapter.add(file1[i].getName());
		    names2[i]=file1[i].getName();
		}

		String path2 = "/sdcard/Android Download Manager/Videos";
		File f2 = new File(path2);
		File file2[] = f2.listFiles();
		String[] names3=new String[file2.length];
		for (int i=0; i < file2.length; i++)
		{
		    Log.d("Files", "FileName:" + file2[i].getName());
		    listAdapter.add(file2[i].getName());
		    names3[i]=file2[i].getName();
		}

		String path3 = "/sdcard/Android Download Manager/Archives";
		File f3 = new File(path3);
		File file3[] = f3.listFiles();
		String[] names4=new String[file3.length];
		for (int i=0; i < file3.length; i++)
		{
		    Log.d("Files", "FileName:" + file3[i].getName());
		    listAdapter.add(file3[i].getName());
		    names4[i]=file3[i].getName();
		}

		String path4 = "/sdcard/Android Download Manager/Programs";
		File f4 = new File(path4);
		File file4[] = f4.listFiles();
		String[] names5=new String[file4.length];
		for (int i=0; i < file4.length; i++)
		{
		    Log.d("Files", "FileName:" + file4[i].getName());
		    listAdapter.add(file4[i].getName());
		    names5[i]=file4[i].getName();
		}

		String path5 = "/sdcard/Android Download Manager/Archives";
		File f5 = new File(path5);
		File file5[] = f5.listFiles();
		String[] names6=new String[file5.length];
		for (int i=0; i < file5.length; i++)
		{
		    Log.d("Files", "FileName:" + file5[i].getName());
		    listAdapter.add(file5[i].getName());
		    names6[i]=file5[i].getName();
		}

		String path6 = "/sdcard/Android Download Manager/Documents";
		File f6 = new File(path6);
		File file6[] = f6.listFiles();
		String[] names7=new String[file6.length];
		for (int i=0; i < file6.length; i++)
		{
		    Log.d("Files", "FileName:" + file6[i].getName());
		    listAdapter.add(file6[i].getName());
		    names7[i]=file6[i].getName();
		}

		String path7 = "/sdcard/Android Download Manager/Others";
		File f7 = new File(path7);
		File file7[] = f7.listFiles();
		String[] names8=new String[file7.length];
		for (int i=0; i < file7.length; i++)
		{
		    Log.d("Files", "FileName:" + file7[i].getName());
		    listAdapter.add(file7[i].getName());
		    names8[i]=file7[i].getName();
		}
		int n=names1.length+names2.length+names3.length+names4.length+names5.length+names6.length+names7.length+names8.length;
		int j,k,count=0;
		names=new String[n];
		for(j=0;j<names1.length;j++){
			names[count]=names1[j];
			count++;
		}

		for(j=0;j<names2.length;j++){
			names[count]=names2[j];
			count++;
		}
		for(j=0;j<names3.length;j++){
			names[count]=names3[j];
			count++;
		}
		for(j=0;j<names4.length;j++){
			names[count]=names4[j];
			count++;
		}
		for(j=0;j<names5.length;j++){
			names[count]=names5[j];
			count++;
		}
		for(j=0;j<names6.length;j++){
			names[count]=names6[j];
			count++;
		}
		for(j=0;j<names7.length;j++){
			names[count]=names7[j];
			count++;
		}
		for(j=0;j<names8.length;j++){
			names[count]=names8[j];
			count++;
		}

		//String[] names = ArrayUtils.addAll(names1,names2,names3,names4,names5,names6,names7,names8);
		// Add more planets. If you passed a String[] instead of a List<String> 
		// into the ArrayAdapter constructor, you must not add more items. 
		// Otherwise an exception will occur.


		// Set the ArrayAdapter as the ListView's adapter.
		mainListView.setAdapter( listAdapter ); 
		registerForContextMenu(mainListView);
		
	}
	
}
