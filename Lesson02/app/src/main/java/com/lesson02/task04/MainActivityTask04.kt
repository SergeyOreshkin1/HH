package com.lesson02.task04

import android.os.Bundle
import android.util.Log
import com.lesson02.AppConstants
import com.lesson02.BaseActivity
import com.lesson02.R
import com.lesson02.databinding.ActivityMainTask04Binding

class MainActivityTask04 : BaseActivity() {

    private lateinit var binding: ActivityMainTask04Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainTask04Binding.inflate(layoutInflater)
        setContentView(binding.root)

        initialize(savedInstanceState)
        logOnCreate()

        navigateBack(
            context = this@MainActivityTask04,
            backBtn = binding.backBtn
        )
    }

    private fun initialize(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            navigateToFragment(
                FragmentLifecycle.newInstance(),
                containerViewId = R.id.fragmentContainerViewFragmentLifeCycle
            )
        }
    }

    private fun logOnCreate() {
        Log.d(
            AppConstants.ACTIVITY_LIFECYCLE,
            resources.getString(R.string.activity_on_create_called)
        )

        binding.activityLifeCycle.apply {
            this.text = String.format(
                resources.getString(R.string.lifecycle),
                this.text.toString(),
                resources.getString(R.string.activity_on_create_called)
            )
        }
    }

    private fun logOnStart() {
        Log.d(
            AppConstants.ACTIVITY_LIFECYCLE,
            resources.getString(R.string.activity_on_start_called)
        )
        binding.activityLifeCycle.apply {
            this.text = String.format(
                resources.getString(R.string.lifecycle),
                this.text.toString(),
                resources.getString(R.string.activity_on_start_called)
            )
        }
    }

    private fun logOnResume() {
        Log.d(
            AppConstants.ACTIVITY_LIFECYCLE,
            resources.getString(R.string.activity_on_resume_called)
        )
        binding.activityLifeCycle.apply {
            this.text = String.format(
                resources.getString(R.string.lifecycle),
                this.text.toString(),
                resources.getString(R.string.activity_on_resume_called)
            )
        }
    }

    private fun logOnPause() {
        Log.d(
            AppConstants.ACTIVITY_LIFECYCLE,
            resources.getString(R.string.activity_on_pause_called)
        )
        binding.activityLifeCycle.apply {
            this.text = String.format(
                resources.getString(R.string.lifecycle),
                this.text.toString(),
                resources.getString(R.string.activity_on_pause_called)
            )
        }
    }

    private fun logOnStop() {
        Log.d(
            AppConstants.ACTIVITY_LIFECYCLE,
            resources.getString(R.string.activity_on_stop_called)
        )
        binding.activityLifeCycle.apply {
            this.text = String.format(
                resources.getString(R.string.lifecycle),
                this.text.toString(),
                resources.getString(R.string.activity_on_stop_called)
            )
        }
    }

    private fun logOnRestart() {
        Log.d(
            AppConstants.ACTIVITY_LIFECYCLE,
            resources.getString(R.string.activity_on_restart_called)
        )
        binding.activityLifeCycle.apply {
            this.text = String.format(
                resources.getString(R.string.lifecycle),
                this.text.toString(),
                resources.getString(R.string.activity_on_restart_called)
            )
        }
    }

    private fun logOnDestroy() {
        Log.d(
            AppConstants.ACTIVITY_LIFECYCLE,
            resources.getString(R.string.activity_on_destroy_called)
        )
        binding.activityLifeCycle.apply {
            this.text = String.format(
                resources.getString(R.string.lifecycle),
                this.text.toString(),
                resources.getString(R.string.activity_on_destroy_called)
            )
        }
    }

    override fun onStart() {
        super.onStart()
        logOnStart()
    }

    override fun onResume() {
        super.onResume()
        logOnResume()
    }

    override fun onPause() {
        super.onPause()
        logOnPause()
    }

    override fun onStop() {
        super.onStop()
        logOnStop()
    }

    override fun onRestart() {
        super.onRestart()
        logOnRestart()
    }

    override fun onDestroy() {
        super.onDestroy()
        logOnDestroy()
    }
}
