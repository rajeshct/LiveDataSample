package invoice.scan.com.livedata.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import invoice.scan.com.livedata.CustomLiveData;
import invoice.scan.com.livedata.R;
import invoice.scan.com.livedata.rxjavaoperation.RxSingleObject;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class Activity1 extends AppCompatActivity {
    CustomLiveData mModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);
        /*CustomLiveData.get(Activity1.class.getSimpleName()).observe(this, new Observer<String>() {
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
        // CustomLiveData.get("").changeValue("Activity1");
        RxSingleObject.getRxSingleObject().getPublishSubject().onNext("hello");
        startActivity(new Intent(this, Activity2.class));
    }
}
