package com.ironelder.mvpgallerybygoogle.ImageViewList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.ironelder.mvpgallerybygoogle.R;
import com.ironelder.mvpgallerybygoogle.component.ImageViewAdapter;
import com.ironelder.mvpgallerybygoogle.data.source.ImageDataSourceHelper;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ImageViewListActivity extends AppCompatActivity implements ImageViewListContract.View {

    @BindView(R.id.recycler_view)
    RecyclerView mImageRecyclerView;
    private ImageViewAdapter mImageAdapter;
    private ImageViewListPresenter mImageViewListPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        mImageAdapter = new ImageViewAdapter(this);
        mImageRecyclerView.setAdapter(mImageAdapter);

        mImageViewListPresenter = new ImageViewListPresenter();
        mImageViewListPresenter.attachView(this);
        mImageViewListPresenter.setImageAdapterModel(mImageAdapter);
        mImageViewListPresenter.setImageAdapterView(mImageAdapter);
        mImageViewListPresenter.setSampleImageData(ImageDataSourceHelper.getInstance());

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mImageRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mImageViewListPresenter.loadItems(this, false);
    }

    @Override
    public void showImageTitle(String title) {
        Toast.makeText(this, title, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mImageViewListPresenter.detachView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_reload) {
            mImageViewListPresenter.loadItems(this, true);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
