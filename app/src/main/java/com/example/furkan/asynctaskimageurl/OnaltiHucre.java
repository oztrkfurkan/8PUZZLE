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
import android.view.View;
import android.widget.AbsoluteLayout;
import android.widget.Button;
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

public class OnaltiHucre extends AppCompatActivity {

    Button[] button = new Button[16];
    AbsoluteLayout abs,abs2 ;

    private TextView moveCounter, status;
    private Boolean bad_move = false;
    private static final Integer[] goal = new Integer[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
    private ArrayList<Integer> cells = new ArrayList<Integer>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onalti_hucre);
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String url= extras.getString("strUrl");


        new ImageDownloader().execute(url);
        button = findButtons();
        abs = (AbsoluteLayout)findViewById(R.id.GameField);
        abs2 =(AbsoluteLayout)findViewById(R.id.imageLayout);
        abs2.setVisibility(View.GONE);

        for (int i=0 ; i<16; i++){
            this.cells.add(i);
        }
        Collections.shuffle(this.cells);

        fillGrid();

         moveCounter = (TextView) findViewById(R.id.textViewMoveCounter);
         status = (TextView) findViewById(R.id.textViewStatus);

        for(int i=1 ; i<16 ; i++){
            button[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    makeMove((Button) view);
                }
            });
        }

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


            splitImage(result,16);

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
        BitmapDrawable bmp10= new BitmapDrawable(chunkedImages.get(9));
        BitmapDrawable bmp11= new BitmapDrawable(chunkedImages.get(10));
        BitmapDrawable bmp12= new BitmapDrawable(chunkedImages.get(11));
        BitmapDrawable bmp13= new BitmapDrawable(chunkedImages.get(12));
        BitmapDrawable bmp14= new BitmapDrawable(chunkedImages.get(13));
        BitmapDrawable bmp15= new BitmapDrawable(chunkedImages.get(14));
        BitmapDrawable bmp16= new BitmapDrawable(chunkedImages.get(15));

        BitmapDrawable ref= new BitmapDrawable(bitmap);
        abs2.setBackground(ref);


        //button[0].setBackground(bmp);
        button[1].setBackground(bmp2);
        button[2].setBackground(bmp3);
        button[3].setBackground(bmp4);
        button[4].setBackground(bmp5);
        button[5].setBackground(bmp6);
        button[6].setBackground(bmp7);
        button[7].setBackground(bmp8);
        button[8].setBackground(bmp9);
        button[9].setBackground(bmp10);
        button[10].setBackground(bmp11);
        button[11].setBackground(bmp12);
        button[12].setBackground(bmp13);
        button[13].setBackground(bmp14);
        button[14].setBackground(bmp15);
        button[15].setBackground(bmp16);
    }



    public Button[] findButtons()  {

        Button [] b = new Button[16];

        b[0] = (Button) findViewById(R.id.button);
        b[1] = (Button) findViewById(R.id.button2);
        b[2] = (Button) findViewById(R.id.button3);
        b[3] = (Button) findViewById(R.id.button4);
        b[4] = (Button) findViewById(R.id.button5);
        b[5] = (Button) findViewById(R.id.button6);
        b[6] = (Button) findViewById(R.id.button7);
        b[7] = (Button) findViewById(R.id.button8);
        b[8] = (Button) findViewById(R.id.button9);
        b[9] = (Button) findViewById(R.id.button10);
        b[10] = (Button) findViewById(R.id.button11);
        b[11] = (Button) findViewById(R.id.button12);
        b[12] = (Button) findViewById(R.id.button13);
        b[13] = (Button) findViewById(R.id.button14);
        b[14] = (Button) findViewById(R.id.button15);
        b[15] = (Button) findViewById(R.id.button16);




        return b;
    }

    public void makeMove(final Button b) {
        bad_move = true;
        int bText,bPos,zukPos;
        bText = Integer.parseInt((String) b.getText());
        bPos = findPos(bText);
        zukPos = findPos(0);
        switch (zukPos) {

            case  (0):
                if(bPos == 1 || bPos == 4)
                    bad_move = false;
                break;

            case  (1):
                if(bPos == 0 || bPos == 2 || bPos == 5)
                    bad_move = false;
                break;

            case  (2):
                if(bPos ==1 || bPos == 3 || bPos == 6)
                    bad_move = false;
                break;

            case  (3):
                if(bPos == 2 || bPos == 7 )
                    bad_move = false;
                break;

            case  (4):
                if(bPos == 0 || bPos == 5 || bPos == 8 )
                    bad_move = false;
                break;

            case  (5):
                if(bPos == 1 || bPos == 4 || bPos == 6 || bPos == 9)
                    bad_move = false;
                break;

            case  (6):
                if(bPos == 2 || bPos == 5 || bPos == 7 || bPos == 10)
                    bad_move = false;
                break;

            case  (7):
                if(bPos == 3 || bPos == 6 || bPos == 11)
                    bad_move = false;
                break;

            case  (8):
                if(bPos == 4 || bPos == 9 || bPos == 12)
                    bad_move = false;
                break;
            case  (9):
                if(bPos == 5 || bPos == 8 || bPos == 10 || bPos == 13)
                    bad_move = false;
                break;
            case  (10):
                if(bPos ==6 || bPos == 9 || bPos == 11 || bPos == 14)
                    bad_move = false;
                break;
            case  (11):
                if(bPos == 7 || bPos == 10 || bPos == 15)
                    bad_move = false;
                break;
            case  (12):
                if(bPos == 8 || bPos == 13)
                    bad_move = false;
                break;
            case  (13):
                if(bPos == 9 || bPos == 12 || bPos == 14)
                    bad_move = false;
                break;
            case  (14):
                if(bPos == 10 || bPos == 13 || bPos == 15)
                    bad_move = false;
                break;
            case  (15):
                if(bPos == 11 || bPos == 14)
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

        for (int i=0 ; i<16 ; i++ ){
            if(cells.get(i) != goal[i]){
                return;
            }
        }
        status.setText("YOU WON!");
    }
    public void fillGrid () {

        for (int i=0 ; i<16 ; i++){
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

                    absParams.x = 170;
                    absParams.y = 5;
                    button[text].setLayoutParams(absParams);
                    break;
                case (2):

                    absParams.x = 340;
                    absParams.y = 5;
                    button[text].setLayoutParams(absParams);
                    break;
                case (3):

                    absParams.x = 510;
                    absParams.y = 5;
                    button[text].setLayoutParams(absParams);
                    break;
                case (4):

                    absParams.x = 5;
                    absParams.y = 170;
                    button[text].setLayoutParams(absParams);
                    break;
                case (5):

                    absParams.x = 170;
                    absParams.y = 170;
                    button[text].setLayoutParams(absParams);
                    break;
                case (6):

                    absParams.x =340;
                    absParams.y = 170;
                    button[text].setLayoutParams(absParams);
                    break;
                case (7):

                    absParams.x = 510;
                    absParams.y = 170;
                    button[text].setLayoutParams(absParams);
                    break;
                case (8):

                    absParams.x = 5;
                    absParams.y = 340;
                    button[text].setLayoutParams(absParams);
                    break;
                case(9):
                    absParams.x = 170;
                    absParams.y = 340;
                    button[text].setLayoutParams(absParams);
                    break;
                case(10):
                    absParams.x = 340;
                    absParams.y = 340;
                    button[text].setLayoutParams(absParams);
                    break;
                case(11):
                    absParams.x = 510;
                    absParams.y = 340;
                    button[text].setLayoutParams(absParams);
                    break;
                case(12):
                    absParams.x = 5;
                    absParams.y = 510;
                    button[text].setLayoutParams(absParams);
                    break;
                case(13):
                    absParams.x = 170;
                    absParams.y = 510;
                    button[text].setLayoutParams(absParams);
                    break;
                case(14):
                    absParams.x = 340;
                    absParams.y = 510;
                    button[text].setLayoutParams(absParams);
                    break;
                case(15):
                    absParams.x = 510;
                    absParams.y = 510;
                    button[text].setLayoutParams(absParams);
                    break;
            }
        }

    }
    public int findPos(int element) {
        int i;
        for (i =0 ; i<16 ; i++){
            if(cells.get(i) == element){
                break;
            }
        }
        return  i;
    }

}
