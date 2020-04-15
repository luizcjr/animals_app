package com.luizcarlos.animalscomplete.view.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager

import com.luizcarlos.animalscomplete.R
import com.luizcarlos.animalscomplete.model.Animal
import com.luizcarlos.animalscomplete.view.adapter.AnimalAdapter
import com.luizcarlos.animalscomplete.viewmodel.ListViewModel
import kotlinx.android.synthetic.main.fragment_list.*

/**
 * A simple [Fragment] subclass.
 */
class ListFragment : Fragment() {

    private lateinit var viewModel: ListViewModel
    private val animalAdapter = AnimalAdapter(arrayListOf())

    private val animalListDataObserver = Observer<List<Animal>> { list ->
        list?.let {
            rvAnimals.visibility = View.VISIBLE
            animalAdapter.updateAnimalList(it)
        }
    }

    private val loadingLiveDataObserver = Observer<Boolean> { isLoading ->
        progressLoading.visibility = if (isLoading) View.VISIBLE else View.GONE
        if (isLoading) {
            rvAnimals.visibility = View.GONE
            tvError.visibility = View.GONE
        }
    }

    private val errorLiveDataObserver = Observer<Boolean> { isError ->
        tvError.visibility = if (isError) View.VISIBLE else View.GONE
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(ListViewModel::class.java)
        viewModel.animal.observe(this, animalListDataObserver)
        viewModel.loading.observe(this, loadingLiveDataObserver)
        viewModel.loadError.observe(this, errorLiveDataObserver)
        viewModel.refresh()

        rvAnimals.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = animalAdapter
        }

        refreshLayout.setOnRefreshListener {
            rvAnimals.visibility = View.GONE
            tvError.visibility = View.GONE
            progressLoading.visibility = View.VISIBLE
            viewModel.hardReset()
            refreshLayout.isRefreshing = false
        }
    }
}
