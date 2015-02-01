package pl.mg6.agde.demo.dto

import groovy.transform.CompileStatic
import groovy.transform.Immutable
import groovy.transform.Sortable
import groovy.transform.builder.Builder

@CompileStatic
@Immutable
@Builder
@Sortable(excludes = "id")
public final class Repo {

    long id
    String name
    String description
}
