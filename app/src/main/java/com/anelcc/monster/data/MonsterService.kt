package com.anelcc.monster.data

import retrofit2.Response
import retrofit2.http.GET

interface MonsterService {
    //Add the keyword suspend.
    // That means that this function is designed to be called from with a coroutine.
    // Coroutines can run either on the UI thread or in a background thread,
    // but for a function to be part of a coroutine call,
    // it must have the suspend keyword at the beginning of the function declaration.
    @GET("/feed/monster_data.json")
    suspend fun getMonsterData(): Response<List<Monster>>
}