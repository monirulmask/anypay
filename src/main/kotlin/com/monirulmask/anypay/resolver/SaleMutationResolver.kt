package com.monirulmask.anypay.resolver

import com.monirulmask.anypay.domain.FinalSale
import com.monirulmask.anypay.domain.PaymentMethod
import com.monirulmask.anypay.domain.Sale
import com.monirulmask.anypay.service.SaleService
import graphql.kickstart.tools.GraphQLMutationResolver
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.math.RoundingMode
import java.time.Instant
import java.time.LocalDateTime
import kotlin.math.roundToInt

@Component
class SaleMutationResolver : GraphQLMutationResolver {
    @Autowired
    private lateinit var saleService: SaleService

    fun newSale(price: String, price_modifier: Float, payment_method: PaymentMethod, datetime: LocalDateTime): FinalSale {
        val dPrice = price.toDouble()
        val points: Int
        if (payment_method.equals(PaymentMethod.CASH) || payment_method.equals(PaymentMethod.CASH_ON_DELIVERY) || payment_method.equals(PaymentMethod.JCB)) {
            points = (dPrice * 0.05).roundToInt()
        } else if (payment_method.equals(PaymentMethod.VISA) || payment_method.equals(PaymentMethod.MASTERCARD)) {
            points = (dPrice * 0.03).roundToInt()
        } else if (payment_method.equals(PaymentMethod.AMEX)) {
            points = (dPrice * 0.02).roundToInt()
        } else {
            points = 0
        }
        val finalPrice: Double =  (dPrice * price_modifier).toBigDecimal().setScale(2, RoundingMode.UP).toDouble()

        val sale : Sale = Sale(
            price = price.toDouble(),
            priceModifier = price_modifier,
            paymentMethod = payment_method.toString(),
            dateTime = datetime,
            finalPrice = finalPrice,
            points = points
        )
        saleService.saveSale(sale)
        return FinalSale(finalPrice.toString(), points)
    }
}