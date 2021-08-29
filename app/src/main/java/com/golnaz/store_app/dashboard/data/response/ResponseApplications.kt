@file:Suppress("DEPRECATED_ANNOTATION")

package com.golnaz.store_app.dashboard.data.response

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize


@JsonClass(generateAdapter = true)
@Parcelize
data class ResponseApplications(

	@Json(name = "responses")
	val responses: Responses? = null,

	@Json(name = "status")
	val status: String? = null
) : Parcelable

@JsonClass(generateAdapter = true)
@Parcelize
data class Info(

	@Json(name = "time")
	val time: Time? = null,

	@Json(name = "status")
	val status: String? = null
) : Parcelable

@JsonClass(generateAdapter = true)
@Parcelize
data class Datasets(

	@Json(name = "all")
	val all: All? = null
) : Parcelable

@JsonClass(generateAdapter = true)
@Parcelize
data class Responses(

	@Json(name = "listApps")
	val listApps: ListApps? = null
) : Parcelable

@JsonClass(generateAdapter = true)
@Parcelize
data class ListApps(

	@Json(name = "datasets")
	val datasets: Datasets? = null,

	@Json(name = "info")
	val info: Info? = null
) : Parcelable

@JsonClass(generateAdapter = true)
@Parcelize
data class All(

	@Json(name = "data")
	val data: Data? = null,

	@Json(name = "info")
	val info: Info? = null
) : Parcelable

@JsonClass(generateAdapter = true)
@Parcelize
data class ListItem(

	@Json(name = "store_id")
	val storeId: Int? = null,

	@Json(name = "package")
	val jsonMemberPackage: String? = null,

	@Json(name = "pdownloads")
	val pdownloads: Int? = null,

	@Json(name = "added")
	val added: String? = null,

	@Json(name = "rating")
	val rating: Float? = null,

	@Json(name = "icon")
	val icon: String? = null,

	@Json(name = "apk_tags")
	val apkTags: List<String?>? = null,

	@Json(name = "uptype")
	val uptype: String? = null,

	@Json(name = "size")
	val size: Int? = null,

	@Json(name = "downloads")
	val downloads: Int? = null,

	@Json(name = "md5sum")
	val md5sum: String? = null,

	@Json(name = "name")
	val name: String? = null,

	@Json(name = "store_name")
	val storeName: String? = null,

	@Json(name = "modified")
	val modified: String? = null,

	@Json(name = "id")
	val id: Int? = null,

	@Json(name = "vername")
	val vername: String? = null,

	@Json(name = "vercode")
	val vercode: Int? = null,

	@Json(name = "updated")
	val updated: String? = null,

	@Json(name = "graphic")
	val graphic: String? = null
) : Parcelable

@JsonClass(generateAdapter = true)
@Parcelize
data class Data(

	@Json(name = "next")
	val next: Int? = null,

	@Json(name = "total")
	val total: Int? = null,

	@Json(name = "offset")
	val offset: Int? = null,

	@Json(name = "hidden")
	val hidden: Int? = null,

	@Json(name = "limit")
	val limit: Int? = null,

	@Json(name = "list")
	val list: List<ListItem?>? = null
) : Parcelable

@JsonClass(generateAdapter = true)
@Parcelize
data class Time(

	@Json(name = "seconds")
	val seconds: Double? = null,

	@Json(name = "human")
	val human: String? = null
) : Parcelable
