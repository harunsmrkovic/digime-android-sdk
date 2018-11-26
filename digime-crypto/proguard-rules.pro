-keep class me.digi.sdk.crypto.** { *; }
#SpongyCastle related keep
#TODO: optimize to include only providers we use
-keep class org.spongycastle.jcajce.provider.**

# Apache Commons Compress unused dependencies
# https://commons.apache.org/proper/commons-compress/dependencies.html
-dontwarn com.github.luben.**
-dontwarn org.tukaani.**