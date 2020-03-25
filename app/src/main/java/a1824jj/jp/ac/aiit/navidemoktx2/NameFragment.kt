package a1824jj.jp.ac.aiit.navidemoktx2

import a1824jj.jp.ac.aiit.navidemoktx2.databinding.FragmentNameBinding
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController

/**
 * A simple [Fragment] subclass.
 * Use the [NameFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NameFragment : Fragment() {

    private lateinit var binding: FragmentNameBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_name, container, false)
        binding.nextButton.setOnClickListener {
         if(!TextUtils.isEmpty(binding.nameEditText.text.toString())){
             val bundle = bundleOf("input_text" to binding.nameEditText.text.toString())
             it.findNavController().navigate(R.id.action_nameFragment_to_emailFragment, bundle)
         }else{
             Toast.makeText(activity, "User Name Cannot be empty", Toast.LENGTH_LONG).show()
         }
        }
        return binding.root
    }


}
