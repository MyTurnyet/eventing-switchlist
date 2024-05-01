package com.softwareascraft.eventingswitchlist.data

import com.softwareascraft.eventingswitchlist.models.LayoutObject
import org.springframework.data.mongodb.repository.MongoRepository

interface DataRepository<T : LayoutObject> : MongoRepository<T, String>