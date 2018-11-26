package me.digi.sdk.models

sealed class ItemDetails {
    sealed class ContentItemDetails : ItemDetails() {
        object Empty : ContentItemDetails()
    }

    sealed class AccountDetails : ItemDetails() {
        object Empty : AccountDetails()
    }
}