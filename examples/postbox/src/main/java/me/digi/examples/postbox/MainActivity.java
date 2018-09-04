package me.digi.examples.postbox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import me.digi.examples.postbox.ActivityUtils;
import me.digi.examples.postbox.R;
import me.digi.sdk.core.DigiMeClient;
import me.digi.sdk.core.SDKCallback;
import me.digi.sdk.core.SDKException;
import me.digi.sdk.core.SDKResponse;
import me.digi.sdk.core.session.CASession;

public class MainActivity extends AppCompatActivity {

    private View progressBar;
    private View dimScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dimScreen = findViewById(R.id.dim_screen);
        progressBar = findViewById(R.id.progress_bar);

        View createPostboxButton = findViewById(R.id.create_postbox_button);
        createPostboxButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showProgressBar();
                createPostbox();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        DigiMeClient.getInstance().getPostboxAuthManager().onActivityResult(requestCode, resultCode, data);
    }

    private void createPostbox() {
        DigiMeClient.getInstance().createPostbox(this, new SDKCallback<CASession>() {
            @Override
            public void succeeded(SDKResponse<CASession> result) {
                System.out.println("hmac create postbox success");
                hideProgressBar();
            }

            @Override
            public void failed(SDKException exception) {
                System.out.println("hmac create postbox failure");
                hideProgressBar();
            }
        });
    }

    public void showProgressBar() {
        ActivityUtils.showProgressAndDimScreen(progressBar, dimScreen);
    }

    public void hideProgressBar() {
        ActivityUtils.hideProgressAndRemoveDimScreen(progressBar, dimScreen, null);
    }
}