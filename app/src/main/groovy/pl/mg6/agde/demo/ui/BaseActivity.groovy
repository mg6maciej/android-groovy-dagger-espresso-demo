package pl.mg6.agde.demo.ui

import android.os.Bundle
import android.support.v7.app.ActionBarActivity
import groovy.transform.CompileStatic
import pl.mg6.agde.demo.dagger.Injector

@CompileStatic
public abstract class BaseActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState)
        Injector.inject(this)
    }
}
