package homework.chegg.com.chegghomework.Presentation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import homework.chegg.com.chegghomework.CheggApplication;
import homework.chegg.com.chegghomework.Presentation.CheggContract.Presenter;
import homework.chegg.com.chegghomework.Presentation.injection.CheggModule;
import homework.chegg.com.chegghomework.Presentation.injection.DaggerCheggComponent;
import homework.chegg.com.chegghomework.R;
import homework.chegg.com.chegghomework.data.entities.Item;

import java.util.List;


import javax.inject.Inject;

public class CheggActivity extends AppCompatActivity implements CheggContract.View {

    public static final String TAG = CheggActivity.class.getSimpleName();
    @Inject
    CheggContract.Presenter presenter;

    private Toolbar toolbar;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        buildUI();
        initDaggerInjection();
    }


    private void buildUI() {
        setContentView(R.layout.activity_main);
        setupToolbar();
        setupRecycler();
    }

    private void setupRecycler() {
        mRecyclerView = findViewById(R.id.my_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        DividerItemDecoration decoration = new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL);
        mRecyclerView.addItemDecoration(decoration);
    }

    private void setupToolbar() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void initDaggerInjection() {
        DaggerCheggComponent.builder().globalComponent(((CheggApplication) getApplication()).getGlobalComponent())
                .cheggModule(new CheggModule(this))
                .build()
                .inject(this);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main_activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_refresh:
                onRefreshData();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // TODO fetch data from all data sources, aggregate data and display in RecyclerView
    private void onRefreshData() {
        presenter.subscribe();

    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }


    @Override
    public void showUpdatedData(List<Item> itemList) {
        Log.d(TAG, " called only once");
        mRecyclerView.setAdapter(new CheggAdapter(itemList));
        presenter.refreshData();
    }

    @Override
    public void showRefreshData(List<Item> itemList) {
        mRecyclerView.setAdapter(new CheggAdapter(itemList));
    }

    @Override
    protected void onDestroy() {
        presenter.unSubscribe();
        super.onDestroy();
    }
}
