package pl.mg6.agde.demo

import android.test.ActivityInstrumentationTestCase2
import groovy.transform.CompileStatic
import pl.mg6.agde.demo.ui.ReposActivity

@CompileStatic
abstract class BaseFunctionalTest extends ActivityInstrumentationTestCase2<ReposActivity> {

    BaseFunctionalTest() {
        super(ReposActivity)
    }
}
