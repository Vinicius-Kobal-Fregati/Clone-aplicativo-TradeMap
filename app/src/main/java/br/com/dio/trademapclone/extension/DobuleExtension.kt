package br.com.dio.trademapclone.extension

import java.text.NumberFormat
import java.util.*

fun Double?.formatarMoeda(): String = NumberFormat.getCurrencyInstance(Locale("pt", "BR")).format(this) ?: "R$ 0,00"
//Uma extensão que dado uma instância de double, teremos esse método que vai nos retornar o valor no modelo brasileiro.