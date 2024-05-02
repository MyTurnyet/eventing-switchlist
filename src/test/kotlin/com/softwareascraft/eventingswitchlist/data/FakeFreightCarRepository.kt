package com.softwareascraft.eventingswitchlist.data

import com.softwareascraft.eventingswitchlist.models.FreightCar
import org.springframework.data.domain.Example
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.repository.query.FluentQuery
import java.util.*
import java.util.function.Function

class FakeFreightCarRepository:FreightCarMongoRepository {
    override fun <S : FreightCar?> save(entity: S & Any): S & Any {
        TODO("Not yet implemented")
    }

    override fun <S : FreightCar?> saveAll(entities: MutableIterable<S>): MutableList<S> {
        TODO("Not yet implemented")
    }

    override fun findById(id: String): Optional<FreightCar> {
        TODO("Not yet implemented")
    }

    override fun existsById(id: String): Boolean {
        TODO("Not yet implemented")
    }

    override fun <S : FreightCar?> findAll(example: Example<S>): MutableList<S> {
        TODO("Not yet implemented")
    }

    override fun <S : FreightCar?> findAll(example: Example<S>, sort: Sort): MutableList<S> {
        TODO("Not yet implemented")
    }

    override fun findAll(): MutableList<FreightCar> {
        TODO("Not yet implemented")
    }

    override fun findAll(sort: Sort): MutableList<FreightCar> {
        TODO("Not yet implemented")
    }

    override fun findAll(pageable: Pageable): Page<FreightCar> {
        TODO("Not yet implemented")
    }

    override fun <S : FreightCar?> findAll(example: Example<S>, pageable: Pageable): Page<S> {
        TODO("Not yet implemented")
    }

    override fun findAllById(ids: MutableIterable<String>): MutableList<FreightCar> {
        TODO("Not yet implemented")
    }

    override fun count(): Long {
        TODO("Not yet implemented")
    }

    override fun <S : FreightCar?> count(example: Example<S>): Long {
        TODO("Not yet implemented")
    }

    override fun deleteById(id: String) {
        TODO("Not yet implemented")
    }

    override fun delete(entity: FreightCar) {
        TODO("Not yet implemented")
    }

    override fun deleteAllById(ids: MutableIterable<String>) {
        TODO("Not yet implemented")
    }

    override fun deleteAll(entities: MutableIterable<FreightCar>) {
        TODO("Not yet implemented")
    }

    override fun deleteAll() {
        TODO("Not yet implemented")
    }

    override fun <S : FreightCar?> findOne(example: Example<S>): Optional<S> {
        TODO("Not yet implemented")
    }

    override fun <S : FreightCar?> exists(example: Example<S>): Boolean {
        TODO("Not yet implemented")
    }

    override fun <S : FreightCar?, R : Any?> findBy(
        example: Example<S>,
        queryFunction: Function<FluentQuery.FetchableFluentQuery<S>, R>
    ): R & Any {
        TODO("Not yet implemented")
    }

    override fun <S : FreightCar?> insert(entity: S & Any): S & Any {
        TODO("Not yet implemented")
    }

    override fun <S : FreightCar?> insert(entities: MutableIterable<S>): MutableList<S> {
        TODO("Not yet implemented")
    }
}