package com.softwareascraft.eventingswitchlist.data

import com.softwareascraft.eventingswitchlist.models.FreightCar
import org.springframework.data.mongodb.repository.MongoRepository

interface FreightCarMongoRepository : MongoRepository<FreightCar, String>