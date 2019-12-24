package com.info.assignment

import com.info.assignment.utils.Utility
import junit.framework.Assert.assertEquals
import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert
import org.junit.Test
import java.util.*


class UtilsTest {

    @Test
    fun testIsEmailValid() {
        val testEmail = "govind@gmail.com"
        Assert.assertThat(
            String.format("Email Validity Test failed for %s ", testEmail),
            Utility.checkEmailForValidity(testEmail),
            `is`(true)
        )
    }

    @Test
    fun testCheckDateWasConvertedCorrectly() {
        val inMillis = System.currentTimeMillis()
        val date: Date = Utility.calendarDate(inMillis)!!
        assertEquals(
            "Date time in millis is wrong",
            inMillis * 1000, date.time
        )
    }

    @Test
    fun testEmailValidityPartTwo() {
        val testEmail = "   govind@gmail.com  "
        Assert.assertThat(
            String.format("Email Validity Test failed for %s ", testEmail),
            Utility.checkEmailForValidity(testEmail),
            `is`(true)
        )
    }

    /*@Test
    fun emailStringNullCheck() {
        Assert.assertThat(Utils.emailStringChecker(null), `is`(""))
    }*/

    /*@Test
    fun emailStringEmptyCheck() {
        Assert.assertThat(Utils.emailStringChecker(""), `is`(""))
    }*/

}