package com.softwareascraft.eventingswitchlist.models

interface LayoutObject<T: LayoutDto> {
    fun Id():String
    fun toDto():T
}