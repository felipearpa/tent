package com.felipearpa.ui.column

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import io.mockk.every
import io.mockk.mockk
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test

class LazyColumnTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun given_a_lazy_paging_item_in_loading_status_when_LazyColumn_is_displayed_then_onLoadingContent_is_displayed() {
        composeTestRule.apply {
            var isOnLoadingContentExecuted = false

            setContent {
                val lazyItems = mockk<LazyPagingItems<Any>>()

                every { lazyItems.itemCount } returns 10
                every { lazyItems.loadState.refresh } returns LoadState.Loading

                LazyColumn(
                    lazyItems = lazyItems,
                    onLoadingAppendContent = { },
                    onErrorAppendContent = { },
                    onErrorContent = { },
                    onEmptyContent = { },
                    onLoadingContent = { isOnLoadingContentExecuted = true },
                    itemContent = { }
                )
            }

            assertTrue(isOnLoadingContentExecuted)
        }
    }

    @Test
    fun given_a_lazy_paging_item_in_loading_append_status_when_LazyColumn_is_displayed_then_onLoadingAppendContent_is_displayed() {
        composeTestRule.apply {
            var isOnLoadingAppendContentExecuted = false

            setContent {
                val lazyItems = mockk<LazyPagingItems<Any>>()

                every { lazyItems.itemCount } returns 10
                every { lazyItems.loadState.refresh } returns LoadState.NotLoading(true)
                every { lazyItems.loadState.append } returns LoadState.Loading

                LazyColumn(
                    lazyItems = lazyItems,
                    onLoadingAppendContent = { isOnLoadingAppendContentExecuted = true },
                    onErrorAppendContent = { },
                    onErrorContent = { },
                    onEmptyContent = { },
                    onLoadingContent = { },
                    itemContent = { }
                )
            }

            assertTrue(isOnLoadingAppendContentExecuted)
        }
    }

    @Test
    fun given_a_lazy_paging_item_in_error_status_when_LazyColumn_is_displayed_then_onErrorContent_is_displayed() {
        composeTestRule.apply {
            var isOnErrorContentExecuted = false

            setContent {
                val lazyItems = mockk<LazyPagingItems<Any>>()

                every { lazyItems.itemCount } returns 10
                every { lazyItems.loadState.refresh } returns LoadState.Error(Exception())

                LazyColumn(
                    lazyItems = lazyItems,
                    onLoadingAppendContent = { },
                    onErrorAppendContent = { },
                    onErrorContent = { isOnErrorContentExecuted = true },
                    onEmptyContent = { },
                    onLoadingContent = { },
                    itemContent = { }
                )
            }

            assertTrue(isOnErrorContentExecuted)
        }
    }

    @Test
    fun given_a_lazy_paging_item_in_error_append_status_when_LazyColumn_is_displayed_then_onErrorAppendContent_is_displayed() {
        composeTestRule.apply {
            var isOnErrorAppendContentExecuted = false

            setContent {
                val lazyItems = mockk<LazyPagingItems<Any>>()

                every { lazyItems.itemCount } returns 10
                every { lazyItems.loadState.refresh } returns LoadState.NotLoading(true)
                every { lazyItems.loadState.append } returns LoadState.Error(Exception())

                LazyColumn(
                    lazyItems = lazyItems,
                    onLoadingAppendContent = { },
                    onErrorAppendContent = { isOnErrorAppendContentExecuted = true },
                    onErrorContent = { },
                    onEmptyContent = { },
                    onLoadingContent = { },
                    itemContent = { }
                )
            }

            assertTrue(isOnErrorAppendContentExecuted)
        }
    }

    @Test
    fun given_a_empty_lazy_paging_item_when_LazyColumn_is_displayed_then_onEmptyContent_is_displayed() {
        composeTestRule.apply {
            var isOnEmptyContentExecuted = false

            setContent {
                val lazyItems = mockk<LazyPagingItems<Any>>()

                every { lazyItems.itemCount } returns 0
                every { lazyItems.loadState.refresh } returns LoadState.NotLoading(true)
                every { lazyItems.loadState.prepend.endOfPaginationReached } returns true
                every { lazyItems.loadState.append.endOfPaginationReached } returns true

                LazyColumn(
                    lazyItems = lazyItems,
                    onLoadingAppendContent = { },
                    onErrorAppendContent = { },
                    onErrorContent = { },
                    onEmptyContent = { isOnEmptyContentExecuted = true },
                    onLoadingContent = { },
                    itemContent = { }
                )
            }

            assertTrue(isOnEmptyContentExecuted)
        }
    }

}