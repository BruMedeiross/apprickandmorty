package com.example.rickandmorty.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import androidx.lifecycle.ViewModelProvider

import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.rickandmorty.R
import com.example.rickandmorty.databinding.FragmentListBinding
import com.example.rickandmorty.model.Character
import com.example.rickandmorty.viewmodel.CharacterViewModel
import kotlinx.android.synthetic.main.fragment_list.*


class ListFragment : Fragment() {

    private lateinit var characterViewModel: CharacterViewModel
    private var _binding: FragmentListBinding? = null
    private val binding get()= _binding!!
    private val adapter = CharacterAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        characterViewModel = ViewModelProvider.NewInstanceFactory().create(CharacterViewModel::class.java)
        characterViewModel.init()

        characterList.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        characterList.adapter = adapter

        btn_filter.setOnClickListener {
           Toast.makeText(context, getString(R.string.filter_btn), Toast.LENGTH_SHORT).show()
        }

        searchView.setOnClickListener {
            Toast.makeText(context, getString(R.string.search_btn), Toast.LENGTH_SHORT).show()
        }

        initObserver()
        loadingVisibility(true)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initObserver(){
        characterViewModel.characterList.observe(viewLifecycleOwner, { list ->
            if (list.isNotEmpty()) {
                populateList(list)
                loadingVisibility(false)
            }
        })
    }

    private  fun populateList(list:List<Character>){
        adapter.update(list)
        adapter.notifyDataSetChanged()

    }
    private fun loadingVisibility(isLoading: Boolean){
       progressBar.visibility = if(isLoading) View.VISIBLE else View.GONE
    }



}

/*

lista de dados fake
private val listOfCharacter = arrayListOf(
    Character(
        id = 1,
        name = "Personagem",
        image = null
    ),
    Character(
        id = 0,
        name = "Personagem",
        image = null
    )
)

private  fun populateList(){
        characterList.apply {
            hasFixedSize()
            adapter = CharacterAdapter(listOfCharacter)
        }
    }
*/
