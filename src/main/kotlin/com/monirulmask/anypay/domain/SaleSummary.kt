package com.monirulmask.anypay.domain

import java.time.LocalDateTime

data class SaleSummary(
    var datetime: LocalDateTime,
    var sales: String,
    var points: Int
)