package com.felipearpa.ui.paging

import androidx.paging.PagingSource
import com.felipearpa.core.paging.OffsetPagingQuery
import com.felipearpa.core.paging.emptyOffsetPage
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import kotlin.test.assertTrue

class OffsetPagingSourceTest {
    private val offsetPagingQuery = mockk<OffsetPagingQuery<String>>()
    private val offsetPagingSource = OffsetPagingSource(pagingQuery = offsetPagingQuery, limit = 10)

    @Before
    fun setUp() {
        clearAllMocks()
    }

    @Test
    fun `given an OffsetPage when an action to load is performed then the OffsetPage is returned`() =
        runTest {
            coEvery {
                offsetPagingQuery.execute(
                    offset = any(),
                    limit = any()
                )
            } returns Result.success(emptyOffsetPage())

            val response = offsetPagingSource.load(
                params = PagingSource.LoadParams.Refresh(
                    key = null,
                    loadSize = 10,
                    placeholdersEnabled = true
                )
            )

            coVerify {
                offsetPagingQuery.execute(
                    offset = any(),
                    limit = any()
                )
            }

            assertTrue(actual = response is PagingSource.LoadResult.Page)
        }

    @Test
    fun `given an api response error when an action to load is performed then error is returned`() =
        runTest {
            coEvery {
                offsetPagingQuery.execute(
                    offset = any(),
                    limit = any()
                )
            } returns Result.failure(Exception())

            val response = offsetPagingSource.load(
                params = PagingSource.LoadParams.Refresh(
                    key = null,
                    loadSize = 10,
                    placeholdersEnabled = true
                )
            )

            coVerify {
                offsetPagingQuery.execute(
                    offset = any(),
                    limit = any()
                )
            }

            assertTrue(actual = response is PagingSource.LoadResult.Error)
        }
}