package com.example.tz_workmate.ui.user_generator.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.domain.local_data.model.Gender
import com.example.tz_workmate.R
import com.example.tz_workmate.presentation.user_generator.mapper.GenderIconMapper

class GenderAdapter(context: Context, genders: List<Gender>) :
    ArrayAdapter<Gender>(context, 0, genders) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return createCustomView(position, convertView, parent)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View? {
        return createCustomView(position, convertView, parent)
    }

    private fun createCustomView(position: Int, convertView: View?, parent: ViewGroup): View {

        val gender = getItem(position)

        val view =
            LayoutInflater.from(context).inflate(R.layout.item_spinner_gender, parent, false)

        val genderIcon = view.findViewById<ImageView>(R.id.imgGenderIcon)
        val genderName = view.findViewById<TextView>(R.id.tvGenderName)

        gender?.let {
            val iconResource = GenderIconMapper.map(it.thumbnail)
            genderIcon.setImageResource(iconResource)
            genderName.text = it.gender
        }
        return view
    }

}