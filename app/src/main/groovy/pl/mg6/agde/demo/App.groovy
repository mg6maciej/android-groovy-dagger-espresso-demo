package pl.mg6.agde.demo

import android.app.Application
import groovy.transform.CompileStatic
import pl.mg6.agde.demo.dagger.Injector

@CompileStatic
public final class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate()
        Injector.init(this)
    }
}
