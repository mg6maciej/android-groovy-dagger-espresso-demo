package pl.mg6.agde.demo.api

import groovy.transform.CompileStatic
import pl.mg6.agde.demo.dto.Repo
import retrofit.http.GET
import retrofit.http.Path
import rx.Observable

@CompileStatic
public interface GitHubApi {

    @GET("/users/{user_id}/repos")
    Observable<List<Repo>> getRepos(@Path("user_id") String userId)
}
