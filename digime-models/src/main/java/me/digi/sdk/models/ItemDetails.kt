package me.digi.sdk.models

interface ItemDetails {
    interface ContentItemDetails : ItemDetails {
        object Empty : ContentItemDetails
    }

    interface AccountDetails : ItemDetails {
        object Empty : AccountDetails
    }
}