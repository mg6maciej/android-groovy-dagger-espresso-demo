package pl.mg6.agde.demo.ui

import android.os.Bundle
import android.widget.TextView
import groovy.transform.CompileStatic
import groovy.transform.PackageScope
import groovy.transform.PackageScopeTarget
import pl.mg6.agde.demo.R
import pl.mg6.agde.demo.api.GitHubApi

import javax.inject.Inject

import static rx.android.schedulers.AndroidSchedulers.mainThread

@CompileStatic
@PackageScope(PackageScopeTarget.FIELDS)
public final class ReposActivity extends BaseActivity {

    @Inject
    GitHubApi api

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.repos_activity)
        api.getRepos("mg6maciej").observeOn(mainThread()).subscribe({
            def name = it.get(0).name
            def test = findViewById(R.id.repos_test) as TextView
            test.text = name
        }, {
            def test = findViewById(R.id.repos_test) as TextView
            test.text = "Error! " + it.getMessage()
        })
    }
}
