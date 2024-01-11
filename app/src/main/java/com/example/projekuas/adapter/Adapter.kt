package com.example.projekuas.adapter

import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.projekuas.Home
import com.example.projekuas.R
import com.example.projekuas.data.GempaItem
import com.example.projekuas.data.ModelListGempa

class Adapter(val data: ModelListGempa?, val fragment: Home, val _g : List<GempaItem?>)
    : ArrayAdapter<GempaItem>(fragment.requireContext(), R.layout.custom_listvew, _g){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        //return super.getView(position, convertView, parent)
        Log.d("Bariq ", "Adapter Mulai")

        val inflater = fragment.layoutInflater
        val rowView = inflater.inflate(R.layout.custom_listvew, null, true)


        //Definisi ui
        //indexing
        var _idx=rowView.findViewById<TextView>(R.id.lst_nomor)
        //tanggal
        var _tgl=rowView.findViewById<TextView>(R.id.lst_tanggal)
        //koordinat
        var _koordinat=rowView.findViewById<TextView>(R.id.lst_koordinat)
        //wilayah
        var _wilayah=rowView.findViewById<TextView>(R.id.lst_wilayah)

        //---------------------------------------------------
        //ISI DATA
        //Indexing
        _idx.setText((position+1).toString())
        Log.d("Bariq",  "posisi: " + (position + 1))
        //Tanggal
        _tgl.setText(data?.infogempa?.gempa?.get(position)?.tanggal)
        Log.d("Bariq",  "tanggal: " + data?.infogempa?.gempa?.get(position)?.coordinates)
        //koordinat
        _koordinat.setText(data?.infogempa?.gempa?.get(position)?.coordinates)
        Log.d("Bariq",  "Koordinat: " + data?.infogempa?.gempa?.get(position)?.coordinates)
        //wilayah
        _wilayah.setText(data?.infogempa?.gempa?.get(position)?.wilayah)
        Log.d("Bariq",  "Wilayah: " + data?.infogempa?.gempa?.get(position)?.wilayah)



        Log.d("Bariq ", "Adapter Finish")


        return rowView

    }

    }
