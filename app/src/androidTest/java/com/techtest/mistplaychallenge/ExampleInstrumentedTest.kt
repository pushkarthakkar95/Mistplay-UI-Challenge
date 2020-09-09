package com.techtest.mistplaychallenge

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.NoMatchingViewException
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.techtest.mistplaychallenge.view.MainActivity
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @get: Rule
    var activityScenarioRule =
        ActivityScenarioRule(
            MainActivity::class.java
        )

    @Test
    fun highLevelRecyclerViewCount() {
        Espresso.onView(ViewMatchers.withId(R.id.verticleRecyclerView)).check(RecyclerViewItemCountAssertion(6))
    }

    class RecyclerViewItemCountAssertion(val expectedCount:Int): ViewAssertion{

        override fun check(view: View?, noViewFoundException: NoMatchingViewException?) {
            if (noViewFoundException != null) {
                throw noViewFoundException
            }
            val recyclerView: RecyclerView = view as RecyclerView
            val adapter = recyclerView.adapter
            assertEquals(expectedCount,adapter!!.itemCount)
        }


    }
}
