package pl.mg6.agde.demo.dagger;

import android.content.Context;
import android.os.AsyncTask;

import java.util.concurrent.ThreadPoolExecutor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import pl.mg6.agde.demo.api.GitHubApi;
import pl.mg6.agde.demo.ui.ReposActivity;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.android.MainThreadExecutor;

@Module(
        injects = {
                ReposActivity.class,
        },
        library = true
)
public final class MyModule {

    private final Context context;

    public MyModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    public Context provideContext() {
        return context;
    }

    @Provides
    @Singleton
    public GitHubApi provideApi() {
        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint("https://api.github.com")
                .setExecutors(AsyncTask.THREAD_POOL_EXECUTOR, new MainThreadExecutor())
                .setRequestInterceptor(new RequestInterceptor() {
                    @Override
                    public void intercept(RequestFacade request) {
                        request.addHeader("User-Agent", "https://github.com/mg6maciej/android-groovy-dagger-espresso-demo");
                    }
                })
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();
        return adapter.create(GitHubApi.class);
    }
}
