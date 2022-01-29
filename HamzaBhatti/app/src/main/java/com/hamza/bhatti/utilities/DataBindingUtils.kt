package com.hamza.bhatti.utilities

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.hamza.bhatti.models.News

class DataBindingUtils {
    companion object {

        @BindingAdapter("load_image")
        @JvmStatic
        fun loadImage(view: ImageView, model: News?) {
            if (model!!.media.size>0){
                if (model.media[0].mediaMetadata.size>0){
                   val url = model.media[0].mediaMetadata[0].url
                    Glide.with(view.context)
                        .load(url)
                        .into(view)
                }
            }

        }

        @BindingAdapter("load_detail")
        @JvmStatic
        fun loadDetail(view: ImageView, model: News?) {
            if (model!!.media.size>0){
                if (model.media[0].mediaMetadata.size>0){
                   val url = model.media[0].mediaMetadata[2].url
                    Glide.with(view.context)
                        .load(url)
                        .into(view)
                }
            }

        }

    }
}