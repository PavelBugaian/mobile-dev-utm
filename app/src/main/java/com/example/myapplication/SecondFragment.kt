package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.core.os.bundleOf
import com.example.myapplication.core.BaseFragment
import com.example.myapplication.databinding.FragmentSecondBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : BaseFragment<MainViewModel, FragmentSecondBinding>(
    MainViewModel::class.java
) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding.textview.text = arguments?.getString("second_argument") ?: ""

        viewBinding.buttonSecond.setOnClickListener {
            val text : String = viewBinding.editText.text.toString()
            val bundle = bundleOf("first_argument" to text)

            navigationListener.navigate(R.id.action_SecondFragment_to_FirstFragment, bundle)
        }
    }

    override fun getLayoutResId(): Int = R.layout.fragment_second
}
