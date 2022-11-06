package com.monirulmask.anypay.service

import com.monirulmask.anypay.domain.Sale
import com.monirulmask.anypay.repository.SaleRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class SaleServiceImpl : SaleService {

    @Autowired
    private lateinit var saleRepository: SaleRepository
    override fun findAllByDateRange(startDateTime: LocalDateTime, endDateTime: LocalDateTime): List<Sale> {
        return saleRepository.findAllByDateRange(startDateTime, endDateTime)
    }

    override fun saveSale(sale: Sale) {
        saleRepository.save(sale)
    }
}