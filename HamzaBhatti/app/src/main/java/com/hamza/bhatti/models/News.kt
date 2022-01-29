package com.hamza.bhatti.models

import java.io.Serializable

data class News(
     var published_date: String = "",
     var section: String= "",
     var source: String= "",
     var title: String= "",
     var abstract: String= "",
     var media: ArrayList<Media> = ArrayList()
): Serializable
