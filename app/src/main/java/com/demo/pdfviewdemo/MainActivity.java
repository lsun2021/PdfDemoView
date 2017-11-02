package com.demo.pdfviewdemo;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.github.barteksc.pdfviewer.listener.OnPageErrorListener;

public class MainActivity extends AppCompatActivity  {

    private static final String TAG = "MainActivity.class.getSimpleName()";

    public static final String SAMPLE_FILE = "sample.pdf";

    private PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pdfView = (PDFView)findViewById(R.id.PDFView);

        pdfView.fromAsset("sample.pdf")
                .defaultPage(0)
                .onPageChange(new OnPageChangeListener() {
                    @Override
                    public void onPageChanged(int page, int pageCount) {
                          setTitle(String.format("%s %s /%s",SAMPLE_FILE,page+1,pageCount));
                    }
                })
                .enableAnnotationRendering(true)
                .swipeHorizontal(false)
                .spacing(10)
                .onPageError(new OnPageErrorListener() {
                    @SuppressLint("LongLogTag")
                    @Override
                    public void onPageError(int page, Throwable t) {
                        Log.e(TAG, "onPageError: Cannot load page"+page );
                    }
                })
                .load();

    }

}
