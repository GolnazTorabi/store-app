object Versions {
    const val robolectricVersion = "4.4"
    const val hiltVersion = "2.35"
    const val retrofitVersion = "2.9.0"
    const val picassoVersion = "2.71828"
    const val interceptorVersion = "4.9.0"
    const val moshiVersion = "1.12.0"
    const val moshiConverter = "2.7.2"
    const val lifecycleLiveDataVersion = "2.2.0"
    const val lifecycleViewModelVersion = "2.3.0-beta01"
    const val archVersion = "1.1.1"
    const val navigationVersion = "2.3.1"
    const val retrofit2_rx_adapter_version = "1.0.0"
    const val rxandroid_version = "2.1.1"
    const val rxbinding_version = "2.2.0"
    const val rxjava_version = "2.2.20"
}
object Robolectric {
    const val robolectricBaseLibrary = "org.robolectric:robolectric:${Versions.robolectricVersion}"
}
object Hilt {
    const val hilt = "com.google.dagger:hilt-android:${Versions.hiltVersion}"
    const val hiltKapt = "com.google.dagger:hilt-compiler:${Versions.hiltVersion}"
}

object Retrofit {
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}"
    const val moshiConverter = "com.squareup.retrofit2:converter-moshi:${Versions.moshiConverter}"
    const val moshi = "com.squareup.moshi:moshi-kotlin:${Versions.moshiVersion}"
    const val moshiKapt = "com.squareup.moshi:moshi-kotlin-codegen:${Versions.moshiVersion}"
    const val interceptor =
        "com.squareup.okhttp3:logging-interceptor:${Versions.interceptorVersion}"
    const val rxAdapterRetrofit = "com.jakewharton.retrofit:retrofit2-rxjava2-adapter:${Versions.retrofit2_rx_adapter_version}"

}
object Navigation {
    const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navigationVersion}"
    const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.navigationVersion}"
}

object Picasso {
    const val picasso = "com.squareup.picasso:picasso:${Versions.picassoVersion}"
}
object ViewModel {
    const val lifeCycleExt =
        "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycleLiveDataVersion}"
    const val lifeCycleViewModel =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycleViewModelVersion}"
    const val lifeCycleLiveData =
        "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycleViewModelVersion}"
    const val arch = "android.arch.lifecycle:extensions:${Versions.archVersion}"
}
object RxJava {
    const val rxLibrary = "io.reactivex.rxjava2:rxjava:${Versions.rxjava_version}"
    const val rxandroidLibrary = "io.reactivex.rxjava2:rxandroid:${Versions.rxandroid_version}"
    const val rxBinding = "com.jakewharton.rxbinding2:rxbinding:${Versions.rxbinding_version}"

}