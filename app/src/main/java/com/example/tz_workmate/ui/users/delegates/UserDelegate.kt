package com.example.tz_workmate.ui.users.delegates

import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.domain.user_generator.model.User
import com.example.tz_workmate.R
import com.example.tz_workmate.databinding.ItemUserBinding
import com.example.tz_workmate.presentation.user_generator.mapper.CountryImageMapper
import com.example.tz_workmate.ui.mapper.FullNameMapper
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

fun userDelegate(onItemClicked: (user: User) -> Unit, onRemoveClicked: (user: User) -> Unit) =
    adapterDelegateViewBinding<User, User, ItemUserBinding>(
        { inflater, root -> ItemUserBinding.inflate(inflater, root, false) }
    ) {

        itemView.setOnClickListener {
            onItemClicked.invoke(item)
        }

        bind {
            Glide
                .with(context)
                .load(item.img)
                .placeholder(R.drawable.ic_random)
                .transform(CenterCrop(), RoundedCorners(16))
                .into(binding.imgUser)

            binding.tvUserName.text = FullNameMapper.map(item.firstName, item.lastName)
            binding.tvUserPhone.text = item.phone
            binding.tvUserCountry.text = item.country
            binding.imgUserCountry.setImageResource(CountryImageMapper.mapCodeToResourceId(item.nat))
            binding.btnRemove.setOnClickListener {
                onRemoveClicked.invoke(item)
            }
        }
    }
