package com.softwareascraft.eventingswitchlist.models

enum class CarType(val abbreviation: String, description: String) {
    Boxcar("XM", "Boxcar"),
    BeerBoxcar("XMB", "Beer Boxcar"),
    BulkHeadFlatCar("FB", "FlatBulkHead"),
    CementHopper("HM", "HopCmnt"),
    CenterBeam("FCB", "Center Beam"),
    CoalHopper("GCH", "HopCoal"),
    FlatCar("FC", "Flat Car"),
    FlatCarDepressed("FD", "Flatcar-Dep"),
    Gondola("GN", "Gondola"),
    GrainHopper("HTC", "HopGrain"),
    HiCube("XMO", "Box OvrHt"),
    Hop2Bay("HM", "Hop2Bay"),
    Hopper("HT", "Hopper"),
    TankCar("TC", "Tank Gas"),
    ThrallBoxcar("XPT", "Thrall Box"),
    TrailerFlatCar("FT", "FlatTrailer"),
    WoodChipGondola("GTS", "WoodChip Gon");

    companion object {
        fun getFromAAR(abbreviation: String):CarType {
            return entries.first { carType: CarType -> carType.abbreviation == abbreviation }
        }
    }
}