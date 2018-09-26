package com.example.mrzhang.jfpdfdemo;

import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.mrzhang.jfpdfdemo.listener.OnDrawListener;
import com.example.mrzhang.jfpdfdemo.listener.OnLoadCompleteListener;
import com.example.mrzhang.jfpdfdemo.listener.OnPageChangeListener;

public class MainActivity extends AppCompatActivity implements OnPageChangeListener
        ,OnLoadCompleteListener, OnDrawListener {
    private PDFView pdfView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pdfView = (PDFView) findViewById( R.id.pdfView );
//        pdfView.fromAsset("moby.pdf").load();
        displayFromFile1("http://file.chmsp.com.cn/colligate/file/00100000224821.pdf", "00100000224821.pdf");

    }

    /**
     * 获取打开网络的pdf文件
     * @param fileUrl
     * @param fileName
     */
    private void displayFromFile1( String fileUrl ,String fileName) {
        pdfView.fileFromLocalStorage(this,this,this,fileUrl,fileName,false,true,true);   //设置pdf文件地址
    }

    /**
     * 翻页回调
     * @param page
     * @param pageCount
     */
    @Override
    public void onPageChanged(int page, int pageCount) {
        Toast.makeText( MainActivity.this , "page= " + page +
                " pageCount= " + pageCount , Toast.LENGTH_SHORT).show();
    }

    /**
     * 加载完成回调
     * @param nbPages  总共的页数
     */
    @Override
    public void loadComplete(int nbPages) {
        Toast.makeText( MainActivity.this ,  "加载完成" + nbPages  , Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLayerDrawn(Canvas canvas, float pageWidth, float pageHeight, int displayedPage) {
        // Toast.makeText( MainActivity.this ,  "pageWidth= " + pageWidth + "
        // pageHeight= " + pageHeight + " displayedPage="  + displayedPage , Toast.LENGTH_SHORT).show();
    }
}
