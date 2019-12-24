@file:Suppress("RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS", "DEPRECATION",
    "NAME_SHADOWING"
)

package com.info.assignment.utils

import android.content.Context
import android.net.ConnectivityManager
import android.widget.Toast
import java.util.*
import java.util.regex.Matcher
import java.util.regex.Pattern

object Utility {

    fun isOnline(context: Context): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
        return cm!!.activeNetworkInfo != null && cm.activeNetworkInfo.isConnectedOrConnecting
    }

    fun showToast(context: Context, msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }

    private val MILLIS = 1000

    /**
     * @param email
     * @return
     */
    fun checkEmailForValidity(email: String): Boolean {
        var email = email
        email = email.trim { it <= ' ' }
        val matcher: Matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email)
        return matcher.find()
    }

   /* fun emailStringChecker(email: String?): String? {
        return null
    }*/

    private val VALID_EMAIL_ADDRESS_REGEX: Pattern =
        Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE)


    fun calendarDate(epocSeconds: Long): Date? {
        val c: Calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"))
        c.timeInMillis = epocSeconds * MILLIS
        return c.time
    }
}