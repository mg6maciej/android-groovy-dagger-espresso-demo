package pl.mg6.agde.demo;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import pl.mg6.agde.demo.api.GitHubApi;

@Module(library = true, overrides = true)
class ErrorGitHubApiModule {

    @Provides
    @Singleton
    public GitHubApi provideApi() {
        return FakeGitHubApi.error();
    }
}