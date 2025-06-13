package com.example.travelapp.data.mapper

import com.example.travelapp.data.base.BaseMapper
import com.example.travelapp.data.local.entity.AccountEntity
import com.example.travelapp.domain.model.AccountModel

class AccountMapper : BaseMapper<AccountEntity, AccountModel>() {
    override fun toEntity(model: AccountModel?): AccountEntity {
        return  AccountEntity(
            id = model?.id?:0,
            name = model?.name?:"",
            phone = model?.phone?:"",
            email = model?.email?:"",
            avatarUrl = model?.avatarUrl?:""
        )
    }

    override fun toModel(entity: AccountEntity?): AccountModel {
        return AccountModel(
            id = entity?.id?:0,
            name = entity?.name?:"",
            phone = entity?.phone?:"",
            email = entity?.email?:"",
            avatarUrl = entity?.avatarUrl?:""
        )
    }
}