package com.demo.secondpdfdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.joanzapata.pdfview.PDFView;
import com.joanzapata.pdfview.listener.OnPageChangeListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PDFView pdfView= (PDFView)findViewById(R.id.PdfView);
        pdfView.fromAsset("sample.pdf")
                .defaultPage(1)
                .showMinimap(true)
                .enableSwipe(true)
                .swipeVertical( true )
                .onPageChange(new OnPageChangeListener() {
                    @Override
                    public void onPageChanged(int page, int pageCount) {
                        // 当用户在翻页时候将回调。
                        Toast.makeText(getApplicationContext(), page + " / " + pageCount, Toast.LENGTH_SHORT).show();
                    }
                }).load();
    }
}
