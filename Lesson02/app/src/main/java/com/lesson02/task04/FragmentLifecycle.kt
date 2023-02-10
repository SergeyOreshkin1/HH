package com.lesson02.task04

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import com.lesson02.AppConstants
import com.lesson02.BaseFragment
import com.lesson02.R
import com.lesson02.databinding.MainFragmentContainerTask04Binding

class FragmentLifecycle : BaseFragment<MainFragmentContainerTask04Binding>(
    MainFragmentContainerTask04Binding::inflate
) {

    private fun logOnCreate() {
        Log.d(
            AppConstants.FRAGMENT_LIFECYCLE,
            resources.getString(R.string.fragment_on_create_called)
        )
    }

    private fun logOnCreateView() {
        Log.d(
            AppConstants.FRAGMENT_LIFECYCLE,
            resources.getString(R.string.fragment_on_create_view_called)
        )
    }

    private fun logOnViewCreated() {
        Log.d(
            AppConstants.FRAGMENT_LIFECYCLE,
            resources.getString(R.string.fragment_on_view_created_called)
        )
        binding.fragmentLifeCycleTextView.apply {
            this.text = String.format(
                resources.getString(R.string.lifecycle),
                this.text.toString(),
                resources.getString(R.string.fragment_on_view_created_called)
            )
        }
    }

    private fun logOnStart() {
        Log.d(
            AppConstants.FRAGMENT_LIFECYCLE,
            resources.getString(R.string.fragment_on_start_called)
        )
        binding.fragmentLifeCycleTextView.apply {
            this.text = String.format(
                resources.getString(R.string.lifecycle),
                this.text.toString(),
                resources.getString(R.string.fragment_on_start_called)
            )
        }
    }

    private fun logOnResume() {
        Log.d(
            AppConstants.FRAGMENT_LIFECYCLE,
            resources.getString(R.string.fragment_on_resume_called)
        )
        binding.fragmentLifeCycleTextView.apply {
            this.text = String.format(
                resources.getString(R.string.lifecycle),
                this.text.toString(),
                resources.getString(R.string.fragment_on_resume_called)
            )
        }
    }

    private fun logOnPause() {
        Log.d(
            AppConstants.FRAGMENT_LIFECYCLE,
            resources.getString(R.string.fragment_on_pause_called)
        )
        binding.fragmentLifeCycleTextView.apply {
            this.text = String.format(
                resources.getString(R.string.lifecycle),
                this.text.toString(),
                resources.getString(R.string.fragment_on_pause_called)
            )
        }
    }

    private fun logonStop() {
        Log.d(
            AppConstants.FRAGMENT_LIFECYCLE,
            resources.getString(R.string.fragment_on_stop_called)
        )
        binding.fragmentLifeCycleTextView.apply {
            this.text = String.format(
                resources.getString(R.string.lifecycle),
                this.text.toString(),
                resources.getString(R.string.fragment_on_stop_called)
            )
        }
    }

    private fun logOnDestroyView() {
        Log.d(
            AppConstants.FRAGMENT_LIFECYCLE,
            resources.getString(R.string.fragment_on_destroy_view_called)
        )
    }

    private fun logOnDestroy() {
        Log.d(
            AppConstants.FRAGMENT_LIFECYCLE,
            resources.getString(R.string.fragment_on_destroy_called)
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        logOnCreate()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        logOnCreateView()
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun initializeFragment() {
        logOnViewCreated()
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
        logonStop()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        logOnDestroyView()
    }

    override fun onDestroy() {
        super.onDestroy()
        logOnDestroy()
    }

    companion object {

        private const val ARGS_KEY = "ARGS_KEY"

        fun newInstance(fragmentArgs: String? = null): FragmentLifecycle {
            val args = bundleOf(
                ARGS_KEY to fragmentArgs,
            )
            val fragment = FragmentLifecycle()
            fragment.arguments = args
            return fragment
        }
    }
}
