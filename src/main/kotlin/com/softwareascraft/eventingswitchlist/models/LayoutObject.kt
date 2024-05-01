package com.softwareascraft.eventingswitchlist.models

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id

abstract class LayoutObject(@Id val id: ObjectId = ObjectId())