package invoice.scan.com.livedata;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;

/**
 * Created by admin on 3/22/2018.
 */

public class CommonObservable {
    private static CommonObservable commonObservable;
    private Observer<String> stringObserver;

    private CommonObservable() {
    }

    public static CommonObservable getCommonObservable() {
        if (commonObservable == null) commonObservable = new CommonObservable();
        return commonObservable;
    }

    public Observer<String> getObservable(final GetData getData) {
        if (stringObserver == null) {
            stringObserver = new Observer<String>() {
                @Override
                public void onChanged(@Nullable String s) {
                    getData.getData(s);
                }
            };
        }
        return stringObserver;
    }

    public interface GetData {
        void getData(String value);
    }

}
