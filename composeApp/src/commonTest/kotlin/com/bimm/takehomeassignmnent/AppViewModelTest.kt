package com.bimm.takehomeassignmnent

import com.bimm.takehomeassignmnent.domain.model.Shop
import kotlin.test.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.advanceUntilIdle
import com.bimm.takehomeassignmnent.presentation.shop.ShopListState
import com.bimm.takehomeassignmnent.presentation.shop.ShopListViewModel

@OptIn(ExperimentalCoroutinesApi::class)
class AppViewModelTest {

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
    fun `initial screen is list`() = runTest {
        // Given
        val listVM = ShopListViewModel(FakeRepo(), this)
        val vm = AppViewModel(listVM, autoLoad = false, scope = this)

        // Then
        assertEquals(Screen.List, vm.currentScreen)
        assertTrue(listVM.state is ShopListState.Idle)
    }

    @Test
    fun `autoLoad true loads data`() = runTest {
        // Given
        val listVM = ShopListViewModel(FakeRepo(sampleShops), this)
        val vm = AppViewModel(listVM, autoLoad = true, scope = this)
        advanceUntilIdle()

        // Then
        assertTrue(listVM.state is ShopListState.Success)
        assertEquals(sampleShops, (listVM.state as ShopListState.Success).shops)
    }

    @Test
    fun `onShopClick and onBack update screen`() = runTest {
        // Given
        val listVM = ShopListViewModel(FakeRepo())
        val vm = AppViewModel(listVM, autoLoad = false)

        // When
        vm.onShopClick(dummyShop)

        // Then
        assertTrue(vm.currentScreen is Screen.Detail)
        assertEquals(dummyShop, (vm.currentScreen as Screen.Detail).shop)
        vm.onBack()

        assertEquals(Screen.List, vm.currentScreen)
    }

    @Test
    fun `autoLoad false keeps state idle`() = runTest {
        // Given
        val listVM = ShopListViewModel(FakeRepo(sampleShops), this)
        val vm = AppViewModel(listVM, autoLoad = false, scope = this)

        // Then
        assertTrue(listVM.state is ShopListState.Idle)
    }
}