package invoice.scan.com.livedata.rxjavaoperation;

import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.ReplaySubject;

/**
 * Created by admin on 3/22/2018.
 */

public class RxSingleObject {
    private static RxSingleObject rxSingleObject;
    private BehaviorSubject<String> publishSubject;
// ReplaySubject
    //PublishSubject
    //AsyncSubject
    private RxSingleObject() {
        publishSubject = BehaviorSubject.create();
    }

    public static RxSingleObject getRxSingleObject() {
        if (rxSingleObject == null) {
            rxSingleObject = new RxSingleObject();
        }
        return rxSingleObject;
    }

    public BehaviorSubject<String> getPublishSubject() {
        return publishSubject;
    }

}
