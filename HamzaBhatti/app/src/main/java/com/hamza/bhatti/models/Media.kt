package com.hamza.bhatti.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Media(
    @SerializedName("media-metadata") var mediaMetadata: ArrayList<MediaMetadata> = ArrayList()
):Serializable
