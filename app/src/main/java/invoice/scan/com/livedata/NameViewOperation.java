package invoice.scan.com.livedata;

import android.os.Handler;
import android.util.Log;

/**
 * Created by admin on 3/22/2018.
 */

public class NameViewOperation {


    NameViewOperation(String symbol) {

    }

    void requestPriceUpdates(final SimpleDataChange mListener) {
//api hit String price=api();
       mListener.onPriceChanged("price");
        Log.e("update","called");
    }

    void removeUpdates(SimpleDataChange mListener) {
        Log.e("remove","called");
    }

    interface SimpleDataChange {
        void onPriceChanged(String price);
    }
}
