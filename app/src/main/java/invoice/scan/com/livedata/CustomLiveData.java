package invoice.scan.com.livedata;

import android.arch.lifecycle.LiveData;
import android.support.annotation.MainThread;

public class CustomLiveData extends LiveData<String> {
    private static CustomLiveData sInstance;
    private NameViewOperation mNameViewOperation;

    private NameViewOperation.SimpleDataChange mListener = new NameViewOperation.SimpleDataChange() {
        @Override
        public void onPriceChanged(String price) {
            setValue(price);
        }
    };

    private CustomLiveData(String symbol) {
        mNameViewOperation = new NameViewOperation(symbol);
    }




    @MainThread
    public static CustomLiveData get(String symbol) {
        if (sInstance == null) {
            sInstance = new CustomLiveData(symbol);
        }
        return sInstance;
    }

    @Override
    protected void onActive() {
        mNameViewOperation.requestPriceUpdates(mListener);
    }

    @Override
    protected void onInactive() {
        mNameViewOperation.removeUpdates(mListener);
    }

    public void changeValue(String activity1) {
//        mListener.onPriceChanged(activity1);
    }
}
