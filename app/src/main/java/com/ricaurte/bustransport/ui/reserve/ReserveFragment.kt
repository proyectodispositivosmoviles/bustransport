package com.ricaurte.bustransport.ui.reserve

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.ricaurte.bustransport.databinding.FragmentReserveBinding
import com.ricaurte.bustransport.ui.profile.ProfileViewModel

class ReserveFragment : Fragment() {

    companion object {
        fun newInstance() = ReserveFragment()
    }

    private lateinit var idReservedone:String
    private lateinit var reserveBinding: FragmentReserveBinding
    private lateinit var reserveViewModel: ReserveViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        reserveBinding = FragmentReserveBinding.inflate(inflater, container, false)
        reserveViewModel = ViewModelProvider(this)[ReserveViewModel::class.java]
        reserveViewModel.msgDone.observe(viewLifecycleOwner) { result ->
            onMsgDoneSubscribe(result)}
        return reserveBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        reserveViewModel.IdReserveCreated .observe(viewLifecycleOwner) { result ->
            onIdReserveCreated(result)
        }

        with(reserveBinding) {
            //seatingSpinner.onItemSelectedListener(AdapterView<?>parente, View view, int position,long id){
             //  reserveViewModel.showSeatAvailable(seatingSpinner.selectedItem.toString())
           // }


            val oneRadioButtonState=oneRouteRadioButton.isChecked
            val twoRadioButtonState=oneRouteRadioButton.isChecked
            val hour=seatingSpinner.selectedItem.toString()
            val numberSeat=reserveChairsSpinner.selectedItem.toString()
           reserveBinding.continueButton.setOnClickListener {
                if (twoRouteRadioButton.isChecked) {

                    onDataValideted(oneRadioButtonState,twoRadioButtonState,hour,
                       numberSeat                     )

                    findNavController().navigate(ReserveFragmentDirections.actionReserveFragmentToApprochlocationFragment())
                }
                if (oneRouteRadioButton.isChecked) {
                    onDataValideted(oneRadioButtonState,twoRadioButtonState,hour,
                        numberSeat)

                    findNavController().navigate(ReserveFragmentDirections.actionReserveFragmentToApprochlocation2Fragment())
                } else {
                    reserveViewModel.enviarMensaje()

                }
            }

        }
    }

    private fun onIdReserveCreated(result: String?) {
        if (result != null) {
            idReservedone=result
        }

    }

    private fun onDataValideted(
        oneRadioButtonState: Boolean,
        twoRadioButtonState: Boolean,
        hour: String,
        numberSeat: String,

    ) {
       reserveViewModel.loadDates(oneRadioButtonState,twoRadioButtonState,hour,numberSeat)


        }
    private fun onMsgDoneSubscribe(msg: String?) {
        Toast.makeText(
            requireContext(),
            msg,
            Toast.LENGTH_SHORT
        ).show()

    }
    fun onItemSelected(parent: AdapterView<*>, view: View?, pos: Int, id: Long): Any? {
        // An item was selected. You can retrieve the selected item using
         return parent.getItemAtPosition(pos)
    }
}






