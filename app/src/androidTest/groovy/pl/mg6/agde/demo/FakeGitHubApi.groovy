package pl.mg6.agde.demo

import groovy.transform.CompileStatic
import pl.mg6.agde.demo.api.GitHubApi
import pl.mg6.agde.demo.dto.Repo

import javax.net.ssl.SSLHandshakeException

@CompileStatic
public final class FakeGitHubApi {

    static GitHubApi normal() {
        return {
            def repo = new Repo(id: 1, name: "name")
            return rx.Observable.just(Arrays.asList(repo))
        } as GitHubApi
    }

    static GitHubApi error() {
        return {
            return rx.Observable.error(new SSLHandshakeException("reason"))
        } as GitHubApi
    }
}
