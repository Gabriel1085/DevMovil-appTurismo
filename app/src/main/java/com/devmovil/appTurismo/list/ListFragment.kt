package com.devmovil.appTurismo.list

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.devmovil.appTurismo.R
import com.devmovil.appTurismo.databinding.FragmentListBinding
import com.devmovil.appTurismo.main.TurismoAdapter
import com.devmovil.appTurismo.model.ListaLugares
import com.devmovil.appTurismo.model.Lugar
import com.devmovil.appTurismo.preferences.SettingsActivity
import com.google.gson.Gson

class ListFragment : Fragment() {

    private lateinit var listBinding: FragmentListBinding
    private lateinit var listLugares : ArrayList<Lugar>
    private lateinit var turismoAdapter : TurismoAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        listBinding = FragmentListBinding.inflate(inflater,container,false)
        return listBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listLugares = loadMockLugares()
        turismoAdapter = TurismoAdapter(listLugares, onItemClicked = { onLugarClicked(it) })
        listBinding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = turismoAdapter
            setHasFixedSize(false)
        }
    }

    private fun loadMockLugares() : ArrayList<Lugar>{
        val lugaresString : String = context?.assets?.open("lugares.json")?.bufferedReader().use {it!!.readText()} //TODO Fix!!
        val gson = Gson()
        val data = gson.fromJson(lugaresString, ListaLugares::class.java)
        return data
    }

    private fun onLugarClicked(lugar: Lugar) {
        findNavController().navigate(ListFragmentDirections.actionListFragmentToDetallesFragment(lugar))
    }

    /*
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var id=item.itemId

        if(id== R.id.btnConfg){
            toSettings()
            return true
        }
        return super.onOptionsItemSelected(item)
    }*/

    /*private fun toSettings() {
        val intent = Intent(this, SettingsActivity::class.java)
        startActivity(intent)
    }*/

}