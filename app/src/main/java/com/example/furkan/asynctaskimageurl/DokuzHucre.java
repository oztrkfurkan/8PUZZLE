package com.example.furkan.asynctaskimageurl;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.ToggleButton;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;

public class DokuzHucre extends AppCompatActivity {

    AbsoluteLayout abs,abs2 ;

    Button[] button = new Button[9];

    public static ImageView im;

    private TextView moveCounter, status;
    private Boolean bad_move = false;
    private static final Integer[] goal = new Integer[]{0,1,2,3,4,5,6,7,8};
    private ArrayList<Integer> cells = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dokuz_hucre);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        final String url= extras.getString("strUrl");

        new ImageDownloader().execute(url);


        button = findButtons();
        abs = (AbsoluteLayout)findViewById(R.id.GameField);
        abs2 =(AbsoluteLayout)findViewById(R.id.imageLayout);
        abs2.setVisibility(View.GONE);



        for (int i=0 ; i<9 ; i++){
            this.cells.add(i);
        }
        Collections.shuffle(this.cells);

        fillGrid();

        moveCounter = (TextView) findViewById(R.id.textViewMoveCounter);
        status = (TextView) findViewById(R.id.textViewStatus);

        for(int i=1 ; i<9 ; i++){
            button[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    makeMove((Button) view);
                }
            });
        }

        moveCounter.setText("0");

    }

    public  void changeState(View view){
        boolean checked =((ToggleButton)view).isChecked();
        if(checked){
            abs.setVisibility(View.GONE);
            abs2.setVisibility(View.VISIBLE);

        }
        else{
            abs.setVisibility(View.VISIBLE);
            abs2.setVisibility(View.GONE);
        }
    }

    public Button[] findButtons()  {

        Button [] b = new Button[9];

        b[0] = (Button) findViewById(R.id.button);
        b[1] = (Button) findViewById(R.id.button2);
        b[2] = (Button) findViewById(R.id.button3);
        b[3] = (Button) findViewById(R.id.button4);
        b[4] = (Button) findViewById(R.id.button5);
        b[5] = (Button) findViewById(R.id.button6);
        b[6] = (Button) findViewById(R.id.button7);
        b[7] = (Button) findViewById(R.id.button8);
        b[8] = (Button) findViewById(R.id.button9);


        return b;
    }

    private class ImageDownloader extends AsyncTask<String,Void,Bitmap> {

        @Override
        protected Bitmap doInBackground(String... param) {
            // TODO Auto-generated method stub
            return downloadBitmap(param[0]);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected void onPostExecute(Bitmap result) {
            Log.i("Async-Example", "onPostExecute Called");


            splitImage(result,9);

        }

        private Bitmap downloadBitmap(String url) {
            // initilize the default HTTP client object
            final DefaultHttpClient client = new DefaultHttpClient();

            //forming a HttoGet request
            final HttpGet getRequest = new HttpGet(url);
            try {

                HttpResponse response = client.execute(getRequest);

                //check 200 OK for success
                final int statusCode = response.getStatusLine().getStatusCode();

                if (statusCode != HttpStatus.SC_OK) {
                    Log.w("ImageDownloader", "Error " + statusCode +
                            " while retrieving bitmap from " + url);
                    return null;

                }

                final HttpEntity entity = response.getEntity();
                if (entity != null) {
                    InputStream inputStream = null;
                    try {
                        // getting contents from the stream
                        inputStream = entity.getContent();

                        // decoding stream data back into image Bitmap that android understands
                        final Bitmap bitmap = BitmapFactory.decodeStream(inputStream);

                        return bitmap;
                    } finally {
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        entity.consumeContent();
                    }
                }
            } catch (Exception e) {
                // You Could provide a more explicit error message for IOException
                getRequest.abort();
                Log.e("ImageDownloader", "Something went wrong while" +
                        " retrieving bitmap from " + url + e.toString());
            }

            return null;
        }
    }


    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public void splitImage(Bitmap bitmap, int chunkNumbers) {

        //For the number of rows and columns of the grid to be displayed
        int rows, cols;

        //For height and width of the small image chunks
        int chunkHeight, chunkWidth;

        //To store all the small image chunks in bitmap format in this list
        ArrayList<Bitmap> chunkedImages = new ArrayList<Bitmap>(chunkNumbers);

        //Getting the scaled bitmap of the source image
        ;
        Bitmap scaledBitmap = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth(), bitmap.getHeight(), true);

        rows = cols = (int) Math.sqrt(chunkNumbers);
        chunkHeight = bitmap.getHeight() / rows;
        chunkWidth = bitmap.getWidth() / cols;

        //xCoord and yCoord are the pixel positions of the image chunks
        int yCoord = 0;
        for (int x = 0; x < rows; x++) {
            int xCoord = 0;
            for (int y = 0; y < cols; y++) {
                chunkedImages.add(Bitmap.createBitmap(scaledBitmap, xCoord, yCoord, chunkWidth, chunkHeight));
                xCoord += chunkWidth;
            }
            yCoord += chunkHeight;
        }
       // BitmapDrawable bmp= new BitmapDrawable(chunkedImages.get(0));
        BitmapDrawable bmp2= new BitmapDrawable(chunkedImages.get(1));
        BitmapDrawable bmp3= new BitmapDrawable(chunkedImages.get(2));
        BitmapDrawable bmp4= new BitmapDrawable(chunkedImages.get(3));
        BitmapDrawable bmp5= new BitmapDrawable(chunkedImages.get(4));
        BitmapDrawable bmp6= new BitmapDrawable(chunkedImages.get(5));
        BitmapDrawable bmp7= new BitmapDrawable(chunkedImages.get(6));
        BitmapDrawable bmp8= new BitmapDrawable(chunkedImages.get(7));
        BitmapDrawable bmp9= new BitmapDrawable(chunkedImages.get(8));

        BitmapDrawable ref= new BitmapDrawable(bitmap);

        //button[0].setBackground(bmp);
        button[1].setBackground(bmp2);
        button[2].setBackground(bmp3);
        button[3].setBackground(bmp4);
        button[4].setBackground(bmp5);
        button[5].setBackground(bmp6);
        button[6].setBackground(bmp7);
        button[7].setBackground(bmp8);
        button[8].setBackground(bmp9);

        //------------
        abs2.setBackground(ref);
    }



    public void makeMove(final Button b) {
        bad_move = true;
        int bText,bPos,zukPos;
        bText = Integer.parseInt((String) b.getText());
        bPos = findPos(bText);
        zukPos = findPos(0);
        switch (zukPos) {

            case  (0):
                if(bPos == 1 || bPos == 3)
                    bad_move = false;
                break;

            case  (1):
                if(bPos == 0 || bPos == 2 || bPos == 4)
                    bad_move = false;
                break;

            case  (2):
                if(bPos == 1 || bPos == 5)
                    bad_move = false;
                break;

            case  (3):
                if(bPos == 0 || bPos == 4 || bPos == 6)
                    bad_move = false;
                break;

            case  (4):
                if(bPos == 1 || bPos == 3 || bPos == 5 || bPos == 7)
                    bad_move = false;
                break;

            case  (5):
                if(bPos == 2 || bPos == 4 || bPos == 8)
                    bad_move = false;
                break;

            case  (6):
                if(bPos == 3 || bPos == 7)
                    bad_move = false;
                break;

            case  (7):
                if(bPos == 4 || bPos == 6 || bPos == 8)
                    bad_move = false;
                break;

            case  (8):
                if(bPos == 5 || bPos == 7)
                    bad_move = false;
                break;
        }
        if(bad_move == true) {
            return;
        }
        cells.remove(bPos);
        cells.add(bPos,0);
        cells.remove(zukPos);
        cells.add(zukPos,bText);

        fillGrid();
        moveCounter.setText(Integer.toString(Integer.parseInt((String) moveCounter.getText())+1));

        for (int i=0 ; i<9 ; i++ ){
            if(cells.get(i) != goal[i]){
                return;
            }
        }
        status.setText("YOU WON!");
    }

    public void fillGrid () {

        for (int i=0 ; i<9 ; i++){
            int text = cells.get(i);
            AbsoluteLayout.LayoutParams absParams =
                    (AbsoluteLayout.LayoutParams) button[text].getLayoutParams();
            switch (i) {
                case (0):

                    absParams.x = 5;
                    absParams.y = 5;
                    button[text].setLayoutParams(absParams);
                    break;
                case (1):

                    absParams.x = 220;
                    absParams.y = 5;
                    button[text].setLayoutParams(absParams);
                    break;
                case (2):

                    absParams.x = 440;
                    absParams.y = 5;
                    button[text].setLayoutParams(absParams);
                    break;
                case (3):

                    absParams.x = 5;
                    absParams.y = 220;
                    button[text].setLayoutParams(absParams);
                    break;
                case (4):

                    absParams.x = 220;
                    absParams.y = 220;
                    button[text].setLayoutParams(absParams);
                    break;
                case (5):

                    absParams.x = 440;
                    absParams.y = 220;
                    button[text].setLayoutParams(absParams);
                    break;
                case (6):

                    absParams.x = 5;
                    absParams.y = 440;
                    button[text].setLayoutParams(absParams);
                    break;
                case (7):

                    absParams.x = 220;
                    absParams.y = 440;
                    button[text].setLayoutParams(absParams);
                    break;
                case (8):

                    absParams.x = 440;
                    absParams.y = 440;
                    button[text].setLayoutParams(absParams);
                    break;
            }
        }

    }
    public int findPos(int element) {
        int i;
        for (i =0 ; i<9 ; i++){
            if(cells.get(i) == element){
                break;
            }
        }
        return  i;
    }


}
