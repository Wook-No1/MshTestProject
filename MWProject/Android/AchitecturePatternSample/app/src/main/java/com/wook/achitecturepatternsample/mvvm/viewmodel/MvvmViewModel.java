package com.wook.achitecturepatternsample.mvvm.viewmodel;

import android.databinding.Observable;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.RatingBar;

import com.wook.achitecturepatternsample.mvvm.model.IDataCallback;
import com.wook.achitecturepatternsample.mvvm.model.MvvmModel;

public class MvvmViewModel implements BaseViewModel {
    private final ObservableField<String> name = new ObservableField<>();
    private final ObservableField<String> email = new ObservableField<>();
    private final ObservableField<String> sucessMsg = new ObservableField<>();
    private final ObservableInt score = new ObservableInt();
    private final ObservableBoolean isValid = new ObservableBoolean();

    @Override
    public void run() {
        score.set(0);
        isValid.set(false);

        name.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable observable, int i) {
                validation();
            }
        });

        email.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable observable, int i) {
                validation();
            }
        });
    }

    @Override
    public void release() {

    }

    public RatingBar.OnRatingBarChangeListener scoreChangeListener = new RatingBar.OnRatingBarChangeListener() {
        @Override
        public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
            score.set((int) v);
            validation();
        }
    };

    public View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            MvvmModel.getInstance().getData(new IDataCallback<MvvmModel>() {
                @Override
                public void getResponse(MvvmModel object) {
                    sucessMsg.set(object.getDisplayName() + object.getDisplaySubName());
                    reset();
                }

                @Override
                public void failure() {
                    sucessMsg.set("");
                }
            });
        }
    };

    private void reset() {
        name.set("");
        email.set("");
        score.set(0);
        isValid.set(false);
    }

    private void validation() {
        boolean isValidName = !TextUtils.isEmpty(name.get());
        boolean isValidEmail = !TextUtils.isEmpty(email.get()) && Patterns.EMAIL_ADDRESS.matcher(email.get()).matches();
        boolean isValidScore = score.get() > 0;
        isValid.set(isValidName && isValidEmail && isValidScore);
    }
}
