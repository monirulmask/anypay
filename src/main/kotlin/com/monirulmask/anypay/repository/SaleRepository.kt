package com.monirulmask.anypay.repository

import com.monirulmask.anypay.domain.Sale
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import java.time.LocalDateTime

interface SaleRepository: JpaRepository<Sale, Long> {

    @Query(value = "SELECT id, price, price_modifier, payment_method, date_trunc('hour',datetime) as datetime, final_price, points FROM kotlin_demo.sale where datetime >= :startDateTime and datetime <= :endDateTime", nativeQuery = true)
    fun findAllByDateRange(startDateTime: LocalDateTime, endDateTime: LocalDateTime): List<Sale>
}