package com.example.spashactivitykotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class MainActivity : AppCompatActivity() {

    /**
     * Properties in Kotlin classes can be declared either as mutable using the var keyword.
     * Mutable object – You can change the states and fields after the object is created
     */

    /**
     * For a variable to hold a null value, it must be of a nullable type (?).
     */
    private var mDelayHandler: Handler? = null;

    /**
     * val is same as the final modifier in java.
     * As you should probably know that we can not assign to a final variable again
     * but can change its properties.
     */
    private val splashDelay: Long = 3000;

    /**
     * If you mark it internal, it is visible everywhere in the same module;
     */
    internal val mRunnable: Runnable = Runnable {
        if (!isFinishing){
            val intent = Intent(this,HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Initialize the handler
        mDelayHandler = Handler()

        //Navigate with delay
        mDelayHandler!!.postDelayed(mRunnable,splashDelay)
    }

    /**
     * To declare a function, use the fun keyword followed by the function name.
     */
    override fun onDestroy() {

        /**
         * The third option is for NPE-lovers: the not-null assertion operator (!!)
         * converts any value to a non-null type and throws an exception if the value is null.
         */

        //Remove any pending posts of Runnable mRunnable that are in the message queue
        if (mDelayHandler != null)
        {
            mDelayHandler!!.removeCallbacks(mRunnable)
        }
        super.onDestroy()
    }
}
