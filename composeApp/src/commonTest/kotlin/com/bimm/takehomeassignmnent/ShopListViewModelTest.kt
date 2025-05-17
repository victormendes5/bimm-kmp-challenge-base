package com.bimm.takehomeassignmnent

import com.bimm.takehomeassignmnent.domain.model.Shop
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.advanceUntilIdle
import kotlin.test.*
import com.bimm.takehomeassignmnent.presentation.shop.ShopListViewModel
import com.bimm.takehomeassignmnent.presentation.shop.ShopListState

@OptIn(ExperimentalCoroutinesApi::class)
class ShopListViewModelTest {

    private val dummyShop = Shop(
        name = "id",
        description = "Name",
        picture = "url",
        rating = 5.0,
        address = "Addr",
        coordinates = listOf(0.0, 0.0),
        googleMapsLink = "gmaps",
        website = "web"
    )

    private val sampleShops = listOf(dummyShop)

    @Test
    fun `initial state is Idle`() = runTest {
        // Given
        val vm = ShopListViewModel(FakeRepo(shops = emptyList()), this)

        // Then
        assertTrue(vm.state is ShopListState.Idle)
    }

    @Test
    fun `load success updates state to Success`() = runTest {
        // Given
        val vm = ShopListViewModel(FakeRepo(shops = sampleShops), this)

        // When
        vm.load()
        advanceUntilIdle()

        // Then
        assertTrue(vm.state is ShopListState.Success)
        assertEquals(sampleShops, (vm.state as ShopListState.Success).shops)
    }

    @Test
    fun `load error updates state to Error`() = runTest {
        // Given
        val vm = ShopListViewModel(FakeRepo(throwError = true), this)

        // When
        vm.load()
        advanceUntilIdle()

        // Then
        assertTrue(vm.state is ShopListState.Error)
        assertEquals("Test failure", (vm.state as ShopListState.Error).message)
    }
}