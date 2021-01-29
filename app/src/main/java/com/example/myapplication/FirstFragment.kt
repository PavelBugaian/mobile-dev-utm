package com.example.myapplication

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import com.example.myapplication.core.BaseFragment
import com.example.myapplication.databinding.FragmentFirstBinding

class FirstFragment : BaseFragment<MainViewModel, FragmentFirstBinding>(
    MainViewModel::class.java
) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding.textview.text = arguments?.getString("first_argument") ?: ""

        viewBinding.buttonFirst.setOnClickListener {
            val text : String = viewBinding.editText.text.toString()
            val bundle = bundleOf("second_argument" to text)

            navigationListener.navigate(R.id.action_FirstFragment_to_SecondFragment, bundle)
        }
    }

    override fun getLayoutResId(): Int = R.layout.fragment_first
}
