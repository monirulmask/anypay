package com.monirulmask.anypay.service

import com.monirulmask.anypay.domain.Sale
import java.time.LocalDateTime

interface SaleService {
    fun findAllByDateRange(startDateTime: LocalDateTime, endDateTime: LocalDateTime): List<Sale>
    fun saveSale(sale: Sale)
}