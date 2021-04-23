package fritprfojects.example.barcode;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;


import com.google.zxing.BarcodeFormat;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


    public void clicked(View view) {
        String content=findViewById(R.id.name).toString();
        if(content==""){
            Toast.makeText(this,"Please enter something ",Toast.LENGTH_LONG).show();
        }
        try {
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            Bitmap bitmap = barcodeEncoder.encodeBitmap(content, BarcodeFormat.QR_CODE, 400, 400);
            ImageView imageViewQrCode = (ImageView) findViewById(R.id.imgview);
            imageViewQrCode.setImageBitmap(bitmap);
        } catch(Exception e) {
            Toast.makeText(this,"something wrong ",Toast.LENGTH_LONG).show();
        }
    }
}