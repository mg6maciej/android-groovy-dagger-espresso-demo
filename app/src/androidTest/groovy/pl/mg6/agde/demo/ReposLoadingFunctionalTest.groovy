package pl.mg6.agde.demo

import dagger.Module
import dagger.Provides
import groovy.transform.CompileStatic
import pl.mg6.agde.demo.api.GitHubApi
import pl.mg6.agde.demo.dagger.Injector
import pl.mg6.agde.demo.dto.Repo
import pl.mg6.agde.demo.ui.ReposActivity
import rx.Observable

import javax.inject.Singleton
import java.util.concurrent.TimeUnit

import static android.support.test.espresso.Espresso.onView
import static android.support.test.espresso.assertion.ViewAssertions.matches
import static android.support.test.espresso.matcher.ViewMatchers.withId
import static android.support.test.espresso.matcher.ViewMatchers.withText

@CompileStatic
final class ReposLoadingFunctionalTest extends BaseFunctionalTest {

    @Override
    protected void setUp() {
        super.setUp()
    }

    public void testShouldShowRepos() {
        Injector.testModules(new MockGitHubApiModule())
        getActivity()
        onView withId(R.id.repos_test) check matches(withText("name"))
    }

    public void testShouldShowError() {
        Injector.testModules(new ErrorGitHubApiModule())
        getActivity()
        onView withId(R.id.repos_test) check matches(withText("Error! reason"))
    }
}
