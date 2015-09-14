package xavigil.com.jsinterface;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

/**
 * Created by xavi on 14/09/15.
 */
public class JSInterface {

    private Context mContext;

    public JSInterface(Context ctx){
        mContext = ctx;
    }

    @JavascriptInterface
    public String getWifiSSID() {
        WifiManager wifiManager = (WifiManager) mContext.getSystemService(Context.WIFI_SERVICE);
        WifiInfo info = wifiManager.getConnectionInfo ();
        String result = info.getSSID();
        if(result.equals("<unknown ssid>"))
            result = "<i>Wifi SSID is unknown</i>";
        return result;
    }

}
