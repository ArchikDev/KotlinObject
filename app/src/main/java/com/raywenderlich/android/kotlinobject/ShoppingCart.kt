package com.raywenderlich.android.kotlinobject

import java.lang.ref.WeakReference

object ShoppingCart {
  var products: List<Product> = emptyList()
    private set

  private var onCartChangedListener: WeakReference<OnCartChangedListener>? = null

  fun setOnCartChangedListener(listener: OnCartChangedListener) {
    onCartChangedListener = WeakReference(listener)
  }

  private fun notifyCartChanged() {
    onCartChangedListener?.get()?.onCartChanged()
  }

  fun addProduct(product: Product) {
    products = products + listOf(product)
    notifyCartChanged()
  }

  fun clear() {
    products = emptyList()
    notifyCartChanged()
  }

  interface OnCartChangedListener {
    fun onCartChanged()
  }

}

