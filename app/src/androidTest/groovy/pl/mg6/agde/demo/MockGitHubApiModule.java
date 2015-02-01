package pl.mg6.agde.demo;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import pl.mg6.agde.demo.api.GitHubApi;
import pl.mg6.agde.demo.ui.ReposActivity;

@Module(library = true, overrides = true)
class MockGitHubApiModule {

    @Provides
    @Singleton
    public GitHubApi provideApi() {
        return FakeGitHubApi.normal();
    }
}
