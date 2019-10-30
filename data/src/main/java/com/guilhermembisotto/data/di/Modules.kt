package com.guilhermembisotto.data.di

import com.guilhermembisotto.data.RetrofitInitializer
import com.guilhermembisotto.data.characters.CharactersRepositoryImpl
import com.guilhermembisotto.data.characters.remote.datasource.CharactersRemoteDataSource
import org.koin.core.module.Module
import org.koin.dsl.module

private val apiServiceModule = module {
    single { RetrofitInitializer().charactersApiService() }
}

private val repositoryModule = module {
    single { CharactersRepositoryImpl(get() as CharactersRemoteDataSource) }
}

private val dataSourceModule = module {
    single { CharactersRemoteDataSource(get()) }
}

fun getDataModules(): List<Module> {
    return listOf(apiServiceModule, repositoryModule, dataSourceModule)
}