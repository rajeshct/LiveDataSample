package invoice.scan.com.livedata;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import invoice.scan.com.livedata.activity.Activity1;
import invoice.scan.com.livedata.rxjavaoperation.RxSingleObject;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    CustomLiveData mModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
     /*   CustomLiveData.get(MainActivity.class.getSimpleName())
                .observe(this, new Observer<String>() {
                    @Override
                    public void onChanged(@Nullable String newName) {
                        ((TextView) findViewById(R.id.tv)).setText(newName);
                    }
                });*/
        RxSingleObject.getRxSingleObject()
                .getPublishSubject()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String newName) {
                        ((TextView) findViewById(R.id.tv)).append(newName);
                    }
                });

    }

    public void updateData(View view) {
        //CustomLiveData.get("").changeValue("Main act");
        RxSingleObject.getRxSingleObject().getPublishSubject().onNext("hello4");
        RxSingleObject.getRxSingleObject().getPublishSubject().onNext("hello111");
        RxSingleObject.getRxSingleObject().getPublishSubject().onNext("hello1111");
        startActivity(new Intent(this, Activity1.class));
    }
}
