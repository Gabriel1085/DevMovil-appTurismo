package com.devmovil.appTurismo.data

import com.devmovil.appTurismo.model.ListaLugares
import retrofit2.http.GET

interface ApiService {
    @GET("DevMovil-appTurismo/Lugares")
    suspend fun getLugares(): ListaLugares
}