package info.androidhive.slidingmenu;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;






import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentTransaction;
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
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Images extends Fragment {
	
	public Images(){}
	ListView mainListView ;
	ArrayAdapter<String> listAdapter ;
	String[] planets;
	String[] names;
	File myFile;
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.images, container, false);
		mainListView = (ListView)rootView.findViewById( R.id.mainListView );
		abc();
	/*	mainListView = (ListView)rootView.findViewById( R.id.mainListView );
       // planets = new String[] { };  
		 planets = new String[]{};  
		
		 ArrayList<String> planetList = new ArrayList<String>();
        planetList.addAll( Arrays.asList(planets) );

// Create ArrayAdapter using the planet list.
        listAdapter = new ArrayAdapter<String>(getActivity(), R.layout.all_row, planetList);


        String path = "/sdcard/Android Download Manager/Images";
        Log.d("Files", "Path: " + path);
        File f = new File(path);        
        File file[] = f.listFiles();
        Log.d("Files", "Size: "+ file.length);
        names=new String[file.length];
        for (int i=0; i < file.length; i++)
        {
        	Log.d("Files", "FileName:" + file[i].getName());
        	listAdapter.add(file[i].getName());
        	names[i]=file[i].getName();
        }



// Add more planets. If you passed a String[] instead of a List<String> 
// into the ArrayAdapter constructor, you must not add more items. 
// Otherwise an exception will occur.


// Set the ArrayAdapter as the ListView's adapter.
        mainListView.setAdapter( listAdapter );   
        registerForContextMenu(mainListView);
 
     */
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
				/*Intent intentquick = new Intent(Intent.ACTION_VIEW);
				intentquick.setDataAndType(Uri.parse("/sdcard/Android Download Manager/Images/"+listItemName),"image/*");

				intentquick.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				startActivity(intentquick);*/
				Intent intent = new Intent();
				intent.setAction(Intent.ACTION_VIEW);
				intent.setDataAndType(Uri.parse("file:///sdcard/Android Download Manager/Images/"+listItemName), "image/*");
				startActivity(intent);
				break;
			/*case 1:
				Toast.makeText(getActivity(), "its delete", Toast.LENGTH_LONG).show();
				break;*/
			case 1:
				// File folder = Environment.getExternalStorageDirectory();
				 String fileName ="/sdcard/Android Download Manager/Images/"+listItemName;
				   myFile = new File(fileName);
				      
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
	    	
	    	
	        // planets = new String[] { };  
	 		 planets = new String[]{};  
	 		
	 		 ArrayList<String> planetList = new ArrayList<String>();
	         planetList.addAll( Arrays.asList(planets) );

	 // Create ArrayAdapter using the planet list.
	         listAdapter = new ArrayAdapter<String>(getActivity(), R.layout.all_row, planetList);


	         String path = "/sdcard/Android Download Manager/Images";
	         Log.d("Files", "Path: " + path);
	         File f = new File(path);        
	         File file[] = f.listFiles();
	         Log.d("Files", "Size: "+ file.length);
	         names=new String[file.length];
	         for (int i=0; i < file.length; i++)
	         {
	         	Log.d("Files", "FileName:" + file[i].getName());
	         	listAdapter.add(file[i].getName());
	         	names[i]=file[i].getName();
	         }



	 // Add more planets. If you passed a String[] instead of a List<String> 
	 // into the ArrayAdapter constructor, you must not add more items. 
	 // Otherwise an exception will occur.


	 // Set the ArrayAdapter as the ListView's adapter.
	         mainListView.setAdapter( listAdapter );   
	         registerForContextMenu(mainListView);
	  
	      
	         
	    	
	    	
	    }
	}

	
	
