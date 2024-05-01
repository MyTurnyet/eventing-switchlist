package com.softwareascraft.eventingswitchlist.data

import org.springframework.data.domain.Example
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.repository.query.FluentQuery
import java.util.*
import java.util.function.Function

class FakeRepository<T>:DataRepository<T> {
    override fun <S : T> save(entity: S & Any): S & Any {
        TODO("Not yet implemented")
    }

    override fun <S : T> saveAll(entities: MutableIterable<S>): MutableList<S> {
        TODO("Not yet implemented")
    }

    override fun findById(id: String): Optional<T> {
        TODO("Not yet implemented")
    }

    override fun existsById(id: String): Boolean {
        TODO("Not yet implemented")
    }

    override fun findAll(): MutableList<T> {
        TODO("Not yet implemented")
    }

    override fun findAll(sort: Sort): MutableList<T> {
        TODO("Not yet implemented")
    }

    override fun findAll(pageable: Pageable): Page<T> {
        TODO("Not yet implemented")
    }

    override fun findAllById(ids: MutableIterable<String>): MutableList<T> {
        TODO("Not yet implemented")
    }

    override fun count(): Long {
        TODO("Not yet implemented")
    }

    override fun deleteById(id: String) {
        TODO("Not yet implemented")
    }

    override fun deleteAllById(ids: MutableIterable<String>) {
        TODO("Not yet implemented")
    }

    override fun deleteAll() {
        TODO("Not yet implemented")
    }

    override fun <S : T> insert(entities: MutableIterable<S>): MutableList<S> {
        TODO("Not yet implemented")
    }

    override fun <S : T> insert(entity: S & Any): S & Any {
        TODO("Not yet implemented")
    }

    override fun <S : T, R : Any?> findBy(
        example: Example<S>,
        queryFunction: Function<FluentQuery.FetchableFluentQuery<S>, R>
    ): R & Any {
        TODO("Not yet implemented")
    }

    override fun <S : T> exists(example: Example<S>): Boolean {
        TODO("Not yet implemented")
    }

    override fun <S : T> findOne(example: Example<S>): Optional<S> {
        TODO("Not yet implemented")
    }

    override fun deleteAll(entities: MutableIterable<T>) {
        TODO("Not yet implemented")
    }

    override fun delete(entity: T & Any) {
        TODO("Not yet implemented")
    }

    override fun <S : T> count(example: Example<S>): Long {
        TODO("Not yet implemented")
    }

    override fun <S : T> findAll(example: Example<S>, pageable: Pageable): Page<S> {
        TODO("Not yet implemented")
    }

    override fun <S : T> findAll(example: Example<S>, sort: Sort): MutableList<S> {
        TODO("Not yet implemented")
    }

    override fun <S : T> findAll(example: Example<S>): MutableList<S> {
        TODO("Not yet implemented")
    }
}