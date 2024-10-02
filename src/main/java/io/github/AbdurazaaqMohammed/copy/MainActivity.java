package io.github.AbdurazaaqMohammed.copy;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(null);

        Intent openIntent = getIntent();
        String text;
        Uri uri;
        text = Intent.ACTION_SEND.equals(openIntent.getAction()) ?
                openIntent.getStringExtra(Intent.EXTRA_TEXT) :
                ((uri = openIntent.getData()) == null) ? null : uri.toString();
        boolean fail = text == null;
        Toast.makeText(this, fail ? "Could not copy" : "Copied to clipboard", Toast.LENGTH_LONG).show();
        if(!fail) ((android.text.ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE)).setText(text);
        finish();
    }
}