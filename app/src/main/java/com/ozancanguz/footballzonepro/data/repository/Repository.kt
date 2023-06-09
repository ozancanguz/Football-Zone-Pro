package com.ozancanguz.footballzonepro.data.repository

import com.ozancanguz.footballzonepro.data.remote.RemoteDataSource
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class Repository@Inject constructor(private val remoteDataSource: RemoteDataSource) {

    val remote=remoteDataSource
}