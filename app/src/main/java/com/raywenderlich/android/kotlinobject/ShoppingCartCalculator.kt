package com.raywenderlich.android.kotlinobject

import com.raywenderlich.android.kotlinobject.ShoppingCart.products

class ShoppingCartCalculator {

  fun calculateTotalFromShoppingCart(): Int {
    val products: List<Product> = products

    var totalPriceCents = 0

    for (product in products) {
      totalPriceCents += product.priceCents
    }

    return totalPriceCents
  }
}