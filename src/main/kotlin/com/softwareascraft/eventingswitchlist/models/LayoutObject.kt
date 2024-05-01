package com.softwareascraft.eventingswitchlist.models

interface LayoutObject<T: LayoutDto> {
    fun id():String
    fun toDto():T
}