package com.softwareascraft.eventingswitchlist.data

import org.springframework.data.mongodb.repository.MongoRepository

interface DataRepository<T>: MongoRepository<T,String>