package com.sunasterisk.iflickr.utils

fun String.createAvatarUrl(iconFarm: String?, iconServer: String?, nsId: String?) = StringBuilder()
    .append("http://farm")
    .append(iconFarm)
    .append(".staticflickr.com/")
    .append(iconServer)
    .append("/buddyicons/")
    .append(nsId)
    .append(".jpg")
    .toString()

fun String.createPhotoUrl(farmId: String?, serverId: String?, photoId: String?, secret: String?) =
    StringBuilder()
        .append("https://farm")
        .append(farmId)
        .append(".staticflickr.com/")
        .append(serverId)
        .append("/")
        .append(photoId)
        .append("_")
        .append(secret)
        .append(".jpg")
        .toString()
