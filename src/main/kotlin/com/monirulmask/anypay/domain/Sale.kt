package com.monirulmask.anypay.domain

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "sale", schema="kotlin_demo")
data class Sale(
    @Id
    @Column(name = "id", columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    @Column(name = "price")
    var price: Double,
    @Column(name = "price_modifier")
    var priceModifier: Float,
    @Column(name = "payment_method")
    var paymentMethod: String,
    @Column(name = "datetime")
    var dateTime: LocalDateTime,
    @Column(name = "final_price")
    var finalPrice: Double,
    @Column(name = "points")
    var points: Int
)

enum class PaymentMethod {
    VISA,
    JCB,
    CASH,
    CASH_ON_DELIVERY,
    AMEX,
    MASTERCARD
}