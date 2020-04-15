package com.luizcarlos.animalscomplete.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.luizcarlos.animalscomplete.R
import com.luizcarlos.animalscomplete.databinding.ItemAnimalBinding
import com.luizcarlos.animalscomplete.model.Animal
import com.luizcarlos.animalscomplete.view.fragments.ListFragmentDirections
import com.luizcarlos.animalscomplete.view.interfaces.AnimalClickListener

class AnimalAdapter(
    private val animals: ArrayList<Animal>
) :
    RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder>(), AnimalClickListener {
    override fun onClick(v: View) {
        for (animal in animals) {
            if (v.tag == animal.name) {
                val action = ListFragmentDirections.actionDetail(animal)
                Navigation.findNavController(v).navigate(action)
            }
        }

    }

    fun updateAnimalList(newAnimalList: List<Animal>) {
        animals.clear()
        animals.addAll(newAnimalList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<ItemAnimalBinding>(
            inflater,
            R.layout.item_animal,
            parent,
            false
        )
        return AnimalViewHolder(view)
    }

    override fun getItemCount() = animals.size

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        val itemAtual = animals[position]
        holder.view.animal = itemAtual
        holder.view.listener = this

//        holder.itemView.tvAnimalName.text = itemAtual.name
//        holder.itemView.ivAnimal.loadImage(itemAtual.imageUrl, getProgressDrawable(holder.itemView.context))
//        holder.itemView.animalLayout.setOnClickListener {
//            val action = ListFragmentDirections.actionDetail(itemAtual)
//            Navigation.findNavController(holder.itemView).navigate(action)
//        }
    }

    class AnimalViewHolder(var view: ItemAnimalBinding) : RecyclerView.ViewHolder(view.root)
}