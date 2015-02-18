package makeinfo.com.getid;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.media.Image;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    EditText wifi,device,sim,imei,imsi,gsfid;
    boolean val =false;
    Button device_copy,sim_copy,wifi_copy,imei_copy,imsi_copy,gsf_copy;
    ImageView makeinfoapps;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wifi = (EditText) findViewById(R.id.wifi);
        device = (EditText) findViewById(R.id.deviceid);
        sim = (EditText) findViewById(R.id.simid);
        imei = (EditText) findViewById(R.id.imei);
        imsi = (EditText) findViewById(R.id.imsi);
        gsfid = (EditText) findViewById(R.id.gsfkey);


        //get = (Button) findViewById(R.id.get);
        device_copy = (Button) findViewById(R.id.device_copy);
        sim_copy = (Button) findViewById(R.id.sim_copy);
        wifi_copy = (Button) findViewById(R.id.wifi_copy);
        imei_copy = (Button) findViewById(R.id.imei_copy);
        imsi_copy= (Button) findViewById(R.id.imsi_b);
        gsf_copy = (Button) findViewById(R.id.gsf_b);

        makeinfoapps = (ImageView) findViewById(R.id.imageView);
        final int sdk = android.os.Build.VERSION.SDK_INT;

        TelephonyManager telemamanger = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        final String getSimSerialNumber = telemamanger.getSimSerialNumber();
     //   final String getSimNumber = telemamanger.getLine1Number();
        final String imsi_t = telemamanger.getSubscriberId();
        final String imei_t = telemamanger.getDeviceId();
        final String gsf_t = getGsfAndroidId(getApplicationContext());
        //final String gsf_t = " ";


         final String android_id = Settings.Secure.getString(getContentResolver(),
                Settings.Secure.ANDROID_ID);

        WifiManager manager = (WifiManager) getSystemService(Context.WIFI_SERVICE);
        WifiInfo info = manager.getConnectionInfo();
        final String address = info.getMacAddress();



        /*get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
         */       val = true;

              //  get.setEnabled(false);
                sim.setText(getSimSerialNumber);
                device.setText(android_id);
                gsfid.setText(gsf_t);
                wifi.setText(address);
                imei.setText(imei_t);
                imsi.setText(imsi_t);

                sim.setKeyListener(null);
                device.setKeyListener(null);
                wifi.setKeyListener(null);
                imei.setKeyListener(null);
                imsi.setKeyListener(null);
                gsfid.setKeyListener(null);

       /*     }
        });*/

        device_copy.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.HONEYCOMB)
            @Override
            public void onClick(View v) {
                if(val){
                    if(sdk < android.os.Build.VERSION_CODES.HONEYCOMB) {
                        android.text.ClipboardManager clipboard = (android.text.ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                        clipboard.setText(android_id);

                        Toast.makeText(getApplicationContext(), "Text Copied to Clipboard", Toast.LENGTH_SHORT).show();
                    } else {
                        android.content.ClipboardManager clipboard = (android.content.ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                        android.content.ClipData clip = android.content.ClipData.newPlainText("Clip",android_id);
                        Toast.makeText(getApplicationContext(), "Text Copied to Clipboard", Toast.LENGTH_SHORT).show();
                        clipboard.setPrimaryClip(clip);
                    }}else{
                    Toast.makeText(getApplicationContext(), "Nothing to Copy", Toast.LENGTH_SHORT).show();
                }

                       }
        });

        sim_copy.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.HONEYCOMB)
            @Override
            public void onClick(View v) {
                if(val){
                    if(sdk < android.os.Build.VERSION_CODES.HONEYCOMB) {
                        android.text.ClipboardManager clipboard = (android.text.ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                        clipboard.setText(getSimSerialNumber);
                        Toast.makeText(getApplicationContext(), "Text Copied to Clipboard", Toast.LENGTH_SHORT).show();
                    } else {
                        android.content.ClipboardManager clipboard = (android.content.ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                        android.content.ClipData clip = android.content.ClipData.newPlainText("Clip",getSimSerialNumber);
                        Toast.makeText(getApplicationContext(), "Text Copied to Clipboard", Toast.LENGTH_SHORT).show();
                        clipboard.setPrimaryClip(clip);
                    }}else{
                    Toast.makeText(getApplicationContext(), "Nothing to Copy", Toast.LENGTH_SHORT).show();
                }

            }
        });

        wifi_copy.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.HONEYCOMB)
            @Override
            public void onClick(View v) {
                if(val){
                    if(sdk < android.os.Build.VERSION_CODES.HONEYCOMB) {
                        android.text.ClipboardManager clipboard = (android.text.ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                        clipboard.setText(address);
                        Toast.makeText(getApplicationContext(), "Text Copied to Clipboard", Toast.LENGTH_SHORT).show();
                    } else {
                        android.content.ClipboardManager clipboard = (android.content.ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                        android.content.ClipData clip = android.content.ClipData.newPlainText("Clip",android_id);
                        Toast.makeText(getApplicationContext(), "Text Copied to Clipboard", Toast.LENGTH_SHORT).show();
                        clipboard.setPrimaryClip(clip);
                    }}else{
                    Toast.makeText(getApplicationContext(), "Nothing to Copy", Toast.LENGTH_SHORT).show();
                }

            }
        });

        imei_copy.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.HONEYCOMB)
            @Override
            public void onClick(View v) {
                if(val){
                    if(sdk < android.os.Build.VERSION_CODES.HONEYCOMB) {
                        android.text.ClipboardManager clipboard = (android.text.ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                        clipboard.setText(imei_t);
                        Toast.makeText(getApplicationContext(), "Text Copied to Clipboard", Toast.LENGTH_SHORT).show();
                    } else {
                        android.content.ClipboardManager clipboard = (android.content.ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                        android.content.ClipData clip = android.content.ClipData.newPlainText("Clip",imei_t);
                        Toast.makeText(getApplicationContext(), "Text Copied to Clipboard", Toast.LENGTH_SHORT).show();
                        clipboard.setPrimaryClip(clip);
                    }}else{
                    Toast.makeText(getApplicationContext(), "Nothing to Copy", Toast.LENGTH_SHORT).show();
                }

            }
        });
        imsi_copy.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.HONEYCOMB)
            @Override
            public void onClick(View v) {
                if(val){
                    if(sdk < android.os.Build.VERSION_CODES.HONEYCOMB) {
                        android.text.ClipboardManager clipboard = (android.text.ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                        clipboard.setText(imsi_t);
                        Toast.makeText(getApplicationContext(), "Text Copied to Clipboard", Toast.LENGTH_SHORT).show();
                    } else {
                        android.content.ClipboardManager clipboard = (android.content.ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                        android.content.ClipData clip = android.content.ClipData.newPlainText("Clip",imsi_t);
                        Toast.makeText(getApplicationContext(), "Text Copied to Clipboard", Toast.LENGTH_SHORT).show();
                        clipboard.setPrimaryClip(clip);
                    }}else{
                    Toast.makeText(getApplicationContext(), "Nothing to Copy", Toast.LENGTH_SHORT).show();
                }

            }
        });


        gsf_copy.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.HONEYCOMB)
            @Override
            public void onClick(View v) {
                if (val) {
                    if (sdk < android.os.Build.VERSION_CODES.HONEYCOMB) {
                        android.text.ClipboardManager clipboard = (android.text.ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                        clipboard.setText(gsf_t);
                        Toast.makeText(getApplicationContext(), "Text Copied to Clipboard", Toast.LENGTH_SHORT).show();
                    } else {
                        android.content.ClipboardManager clipboard = (android.content.ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                        android.content.ClipData clip = android.content.ClipData.newPlainText("Clip", gsf_t);
                        Toast.makeText(getApplicationContext(), "Text Copied to Clipboard", Toast.LENGTH_SHORT).show();
                        clipboard.setPrimaryClip(clip);
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Nothing to Copy", Toast.LENGTH_SHORT).show();
                }

            }
        });

        makeinfoapps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/search?q=pub:MakeInfo"));
                startActivity(browserIntent);
            }
        });
    }

    private static String getGsfAndroidId(Context context)
    {
        Uri URI = Uri.parse("content://com.google.android.gsf.gservices");
        String ID_KEY = "android_id";
        String params[] = {ID_KEY};
        Cursor c  = context.getContentResolver().query(URI, null, null, params, null);
        if (!c.moveToFirst() || c.getColumnCount() < 2)
            return null;
        try
        {
            return Long.toHexString(Long.parseLong(c.getString(1)));
        }
        catch (NumberFormatException e)
        {
            return null;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.help) {
            Intent help = new Intent(MainActivity.this,Help.class);
            startActivity(help);
            return true;
        }
        if (id == R.id.rate) {
             Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id=makeinfo.com.getid"));
            startActivity(browserIntent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
