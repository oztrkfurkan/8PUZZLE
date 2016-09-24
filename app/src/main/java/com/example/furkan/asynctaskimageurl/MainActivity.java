package com.example.furkan.asynctaskimageurl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends Activity {


    String url = "https://www.netdata.com/UserFilesCenter8/c24b60d3-aa57-4787-a5fc-448a8edad548/" +
            "ProjectsCenter1/c32513b8-4592-49fd-b15c-a1f2af869cc4/FileCenter/1.jpg";
    String url2="https://www.netdata.com/UserFilesCenter8/c24b60d3-aa57-4787-a5fc-448a8edad548/" +
            "ProjectsCenter1/c32513b8-4592-49fd-b15c-a1f2af869cc4/FileCenter/2.jpg";
    String url3 ="https://www.netdata.com/UserFilesCenter8/c24b60d3-aa57-4787-a5fc-448a8edad548/" +
            "ProjectsCenter1/c32513b8-4592-49fd-b15c-a1f2af869cc4/FileCenter/3.jpg";
    String url4 ="https://www.netdata.com/UserFilesCenter8/c24b60d3-aa57-4787-a5fc-448a8edad548/" +
            "ProjectsCenter1/c32513b8-4592-49fd-b15c-a1f2af869cc4/FileCenter/4.jpg";
    String url5 ="https://www.netdata.com/UserFilesCenter8/c24b60d3-aa57-4787-a5fc-448a8edad548/" +
            "ProjectsCenter1/c32513b8-4592-49fd-b15c-a1f2af869cc4/FileCenter/5.jpg";
    String url6 ="https://www.netdata.com/UserFilesCenter8/c24b60d3-aa57-4787-a5fc-448a8edad548/" +
            "ProjectsCenter1/c32513b8-4592-49fd-b15c-a1f2af869cc4/FileCenter/6.jpg";
    String url7 ="https://www.netdata.com/UserFilesCenter8/c24b60d3-aa57-4787-a5fc-448a8edad548/" +
            "ProjectsCenter1/c32513b8-4592-49fd-b15c-a1f2af869cc4/FileCenter/7.jpg";
    String url8 ="https://www.netdata.com/UserFilesCenter8/c24b60d3-aa57-4787-a5fc-448a8edad548/" +
            "ProjectsCenter1/c32513b8-4592-49fd-b15c-a1f2af869cc4/FileCenter/8.jpg";
    String url9 ="https://www.netdata.com/UserFilesCenter8/c24b60d3-aa57-4787-a5fc-448a8edad548/" +
            "ProjectsCenter1/c32513b8-4592-49fd-b15c-a1f2af869cc4/FileCenter/9.jpg";


    public ImageView[] imageViews = new ImageView[9] ;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        imageViews[0]= (ImageView) findViewById(R.id.imageView);
        imageViews[1] = (ImageView) findViewById(R.id.imageView2);
        imageViews[2] = (ImageView) findViewById(R.id.imageView3);
        imageViews[3] = (ImageView) findViewById(R.id.imageView4);
        imageViews[4] = (ImageView) findViewById(R.id.imageView5);
        imageViews[5] = (ImageView) findViewById(R.id.imageView6);
        imageViews[6] = (ImageView) findViewById(R.id.imageView7);
        imageViews[7] = (ImageView) findViewById(R.id.imageView8);
        imageViews[8] = (ImageView) findViewById(R.id.imageView9);


        Picasso.with(getApplicationContext()).load(url).placeholder(R.drawable.placeholder).into(imageViews[0]);
        Picasso.with(getApplicationContext()).load(url2).placeholder(R.drawable.placeholder).into(imageViews[1]);
        Picasso.with(getApplicationContext()).load(url3).placeholder(R.drawable.placeholder).into(imageViews[2]);
        Picasso.with(getApplicationContext()).load(url4).placeholder(R.drawable.placeholder).into(imageViews[3]);
        Picasso.with(getApplicationContext()).load(url5).placeholder(R.drawable.placeholder).into(imageViews[4]);
        Picasso.with(getApplicationContext()).load(url6).placeholder(R.drawable.placeholder).into(imageViews[5]);
        Picasso.with(getApplicationContext()).load(url7).placeholder(R.drawable.placeholder).into(imageViews[6]);
        Picasso.with(getApplicationContext()).load(url8).placeholder(R.drawable.placeholder).into(imageViews[7]);
        Picasso.with(getApplicationContext()).load(url9).placeholder(R.drawable.placeholder).into(imageViews[8]);

        imageViews[1].setEnabled(false);
        imageViews[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(),DokuzHucre.class);
                intent.putExtra("strUrl", url);
                startActivity(intent);

            }
        });
        imageViews[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(),DokuzHucre.class);
                intent.putExtra("strUrl", url2);
                startActivity(intent);

            }
        });
        imageViews[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(),DokuzHucre.class);
                intent.putExtra("strUrl", url3);
                startActivity(intent);

            }
        });
        imageViews[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(),OnaltiHucre.class);
                intent.putExtra("strUrl", url4);
                startActivity(intent);

            }
        });
        imageViews[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
                Intent intent = new Intent(getApplicationContext(),OnaltiHucre.class);
                intent.putExtra("strUrl", url5);
                startActivity(intent);

            }
        });

        imageViews[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(),OnaltiHucre.class);
                intent.putExtra("strUrl", url6);
                startActivity(intent);

            }
        });
        imageViews[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(),OnaltiHucre.class);
                intent.putExtra("strUrl", url7);
                startActivity(intent);

            }
        });
        imageViews[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(),OnaltiHucre.class);
                intent.putExtra("strUrl", url7);
                startActivity(intent);

            }
        });
        imageViews[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(),OnaltiHucre.class);
                intent.putExtra("strUrl", url8);
                startActivity(intent);

            }
        });
        imageViews[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(),OnaltiHucre.class);
                intent.putExtra("strUrl", url9);
                startActivity(intent);

            }
        });
    }




}


