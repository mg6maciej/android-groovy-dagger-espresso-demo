package pl.mg6.agde.demo.dagger

import android.content.Context
import dagger.ObjectGraph
import groovy.transform.CompileStatic

@CompileStatic
public final class Injector {

    private static Context context
    private static List<Object> testModules = new ArrayList<>()
    private static ObjectGraph graph

    public static void init(Context context) {
        this.context = context
    }

    public static void testModules(Object... modules) {
        testModules.clear()
        testModules.addAll(modules)
        graph = null
    }

    public static void inject(Object root) {
        if (graph == null) {
            List<Object> allModules = new ArrayList<>()
            allModules.add(new MyModule(context))
            allModules.addAll(testModules)
            graph = ObjectGraph.create(allModules.toArray())
        }
        graph.inject(root)
    }
}
