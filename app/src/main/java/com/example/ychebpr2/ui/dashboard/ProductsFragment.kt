package com.example.ychebpr2.ui.dashboard

import Product
import adapters.ProductAdapter
import android.content.Context
import android.graphics.Rect
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import com.example.ychebpr2.databinding.FragmentProductsBinding


class ProductsFragment : Fragment() {

    private lateinit var binding: FragmentProductsBinding
    private lateinit var context: Context
    private lateinit var adapter: ProductAdapter
    private lateinit var products: List<Product>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentProductsBinding.inflate(inflater, container, false)
        context = this.requireContext()
        adapter = ProductAdapter.create(context)

        products = listOf(
            Product(1, "Попкорн"),
            Product(2, "Газированные напитки"),
            Product(3, "Начос с соусом"),
            Product(4, "Сладости"),
            Product(5, "Горячие закуски"),
            Product(6, "Мороженое"),
            Product(7, "Соки и смузи"),
            Product(8, "Энергетические напитки"),
            Product(9, "Чай и кофе"),
            Product(10, "Кинотеатральные сувениры"))

        binding.rvProducts.layoutManager = LinearLayoutManager(context)
        binding.rvProducts.adapter=adapter
        adapter.refreshProducts(products)



        val dashboardViewModel=ViewModelProvider(this).get(ProdcutsViewModel::class.java)
        return binding.root
    }
}

