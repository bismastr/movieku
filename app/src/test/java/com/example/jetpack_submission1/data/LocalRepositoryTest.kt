package com.example.jetpack_submission1.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.paging.DataSource
import com.example.jetpack_submission1.data.local.FilmDao
import com.example.jetpack_submission1.data.local.LocalRepository
import com.example.jetpack_submission1.data.local.entity.FavoriteEntity
import com.nhaarman.mockitokotlin2.verify
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class LocalRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val mDao = mock(FilmDao::class.java)
    private val repository = LocalRepository(mDao)


    @Test
    fun favorite() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, FavoriteEntity>
        `when`(mDao.getFavorite(1)).thenReturn(dataSourceFactory)
        repository.getAllMovie(1)
        verify(mDao).getFavorite(anyInt())
    }

    @Test
    fun insert() {
        val favoriteEntity =
            FavoriteEntity(
                id = 1,
                poster = "/woqejwiq.com",
                title = "Best Film",
                rating = 8.4,
                from = 1
            )
        runBlocking {
            repository.insert(favoriteEntity)
            verify(mDao).insert(favoriteEntity)
        }
    }

    @Test
    fun delete() {
        val favoriteEntity =
            FavoriteEntity(
                id = 1,
                poster = "/woqejwiq.com",
                title = "Best Film",
                rating = 8.4,
                from = 1
            )
        runBlocking {
            repository.delete(favoriteEntity)
            verify(mDao).delete(favoriteEntity)
        }
    }


}