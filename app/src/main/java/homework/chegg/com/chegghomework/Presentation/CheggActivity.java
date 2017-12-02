package homework.chegg.com.chegghomework.Presentation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import homework.chegg.com.chegghomework.CheggApplication;
import homework.chegg.com.chegghomework.Presentation.CheggContract;
import homework.chegg.com.chegghomework.Presentation.CheggContract.Presenter;
import homework.chegg.com.chegghomework.Presentation.injection.CheggModule;
import homework.chegg.com.chegghomework.Presentation.injection.DaggerCheggComponent;
import homework.chegg.com.chegghomework.R;
import homework.chegg.com.chegghomework.data.entities.Item;
import java.util.List;
import javax.inject.Inject;

public class CheggActivity extends AppCompatActivity implements CheggContract.View {

    @Inject
    CheggContract.Presenter presenter;

    private Toolbar toolbar;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        buildUI();
    }

    private void setupToolbar() {

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initDaggerInjection();
        presenter.subscribe();

    }

    private void buildUI() {

        setContentView(R.layout.activity_main);
        setupToolbar();
        mRecyclerView = findViewById(R.id.my_recycler_view);
    }

    private void initDaggerInjection(){
        DaggerCheggComponent.builder().globalComponent(((CheggApplication)getApplication()).getGlobalComponent())
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

        Toast.makeText(this, "Fetch data aggregate and show on RecyclerView", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showLoadingProgress() {
        Toast.makeText(this,"hello",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void hideLoadingProgress() {

    }

    @Override
    public void showUpdatedData(List<Item> itemList) {

    }


}
