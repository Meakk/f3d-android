package app.f3d.F3D.android

import androidx.test.core.app.ActivityScenario.ActivityAction
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.facebook.testing.screenshot.Screenshot
import com.facebook.testing.screenshot.ViewHelpers
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @Rule
    var activityRule: ActivityScenarioRule<MainActivity?> =
        ActivityScenarioRule<MainActivity?>(MainActivity::class.java)

    @Test
    fun testTakeScreenshot() {
        activityRule.getScenario().onActivity(ActivityAction { activity: MainActivity? ->
            val view = activity!!.window.decorView
            ViewHelpers.setupView(view)
                .setExactWidthDp(300)
                .setExactHeightDp(500)
                .layout()
            Screenshot.snap(view).record()
        })
    }
}
