/*
 * Copyright (c) 2009-2018 digi.me Limited. All rights reserved.
 */

package me.digi.sdk.core;

import android.os.Parcel;
import android.os.Parcelable;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import me.digi.sdk.core.entities.DataRequest;

public class CAContract implements Parcelable {

    @SerializedName("appId")
    public String appId;

    @SerializedName("contractId")
    public String contractId;

    @SerializedName("scope")
    @Nullable
    public DataRequest scope;

    public static final Parcelable.Creator<CAContract> CREATOR
            = new Parcelable.Creator<CAContract>() {
        public CAContract createFromParcel(Parcel newParcel) {
            return new CAContract(newParcel);
        }

        public CAContract[] newArray(int size) {
            return new CAContract[size];
        }
    };

    public CAContract(String contractId, String appId) {
        if (contractId == null || appId == null) {
            throw new IllegalArgumentException(
                    "Attempting to define CAContract with null ids.");
        }
        this.contractId = trim(contractId);
        this.appId = trim(appId);
    }

    private CAContract(Parcel newParcel) {
        contractId = newParcel.readString();
        appId = newParcel.readString();
        scope = (DataRequest)newParcel.readSerializable();
    }

    public void setScope(@Nullable DataRequest scope) {
        this.scope = scope;
    }

    public String getContractId() {
        return contractId;
    }

    public String getAppId() {
        return appId;
    }

    static String trim(String input) {
        if (input != null) {
            return input.trim();
        } else {
            return null;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeString(contractId);
        out.writeString(appId);
        out.writeSerializable(scope);
    }
}
