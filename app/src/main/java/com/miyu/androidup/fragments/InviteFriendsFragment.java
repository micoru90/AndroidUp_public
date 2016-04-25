package com.miyu.androidup.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.miyu.androidup.R;

/**
 * Created by Mireia on 25/04/2016.
 */
public class InviteFriendsFragment extends Fragment {

    private EditText message;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.invitefriends_layout,container,false);

        message = (EditText) v.findViewById(R.id.message);
        Button button = (Button) v.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                sendMessage(v);
            }
        });

        return v;
    }


    public void sendMessage(View v) {

        String whatsAppMessage = message.getText().toString();

        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, whatsAppMessage);
        sendIntent.setType("text/plain");

        // Do not forget to add this to open whatsApp App specifically
        sendIntent.setPackage("com.whatsapp");
        startActivity(sendIntent);

    }

}
