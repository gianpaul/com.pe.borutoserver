package com.pe.di

import com.pe.repository.HeroRepository
import com.pe.repository.HeroRepositoryImpl
import org.koin.dsl.module

val koinModule = module {
    single<HeroRepository> {
        HeroRepositoryImpl()
    }
}