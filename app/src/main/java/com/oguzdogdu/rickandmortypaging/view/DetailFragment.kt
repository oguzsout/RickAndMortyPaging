package com.oguzdogdu.rickandmortypaging.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import coil.load
import coil.transform.RoundedCornersTransformation
import com.oguzdogdu.rickandmortypaging.databinding.FragmentDetailBinding


class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null

    private val binding get() = _binding!!

    private val args: DetailFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        detailComponent()
    }

    private fun detailComponent() {
        val character = args.uuid

        binding.txtIdCharacter.text = character.id.toString()
        binding.txtStatus.text = character.status
        binding.txtSpecie.text = character.species
        binding.txtGender.text = character.gender
        binding.txtName.text = character.name
        binding.imgCharacter.load(character.image) {
            crossfade(true)
            crossfade(1000)
            transformations(RoundedCornersTransformation(10f))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}