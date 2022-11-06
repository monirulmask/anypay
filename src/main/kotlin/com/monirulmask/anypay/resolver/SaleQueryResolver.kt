package com.monirulmask.anypay.resolver

import com.monirulmask.anypay.domain.SaleSummary
import com.monirulmask.anypay.service.SaleService
import graphql.kickstart.tools.GraphQLQueryResolver
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.time.Instant
import java.time.LocalDateTime

@Component
class SaleQueryResolver : GraphQLQueryResolver {
    @Autowired
    private lateinit var saleService: SaleService

    fun sales(startDateTime: LocalDateTime, endDateTime: LocalDateTime): List<SaleSummary> {
        val salesList = saleService.findAllByDateRange(startDateTime, endDateTime)
        val salesGroupList = salesList.groupBy { it.dateTime }
        val saleSummary = salesGroupList.map { it ->
            val dateTime = it.key
            val totalPrice = it.value.sumOf { it.price }
            val totalPoint = it.value.sumOf { it.points }
            SaleSummary(dateTime, totalPrice.toString(), totalPoint)
        }
        return saleSummary
    }
}