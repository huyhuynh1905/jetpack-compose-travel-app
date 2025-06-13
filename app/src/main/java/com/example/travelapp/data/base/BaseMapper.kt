package com.example.travelapp.data.base

abstract class BaseMapper<E,M> {
    abstract fun toEntity(model: M?) : E
    abstract fun toModel(entity: E?) : M
}