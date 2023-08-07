package com.example.twoholderadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.twoholderadapter.data.Const.HASIMAGE
import com.example.twoholderadapter.data.Const.NOIMAGE
import com.example.twoholderadapter.data.HasImage
import com.example.twoholderadapter.data.Landmark
import com.example.twoholderadapter.databinding.LandmarkWithImageBinding
import com.example.twoholderadapter.databinding.LandmarkWithoutImageBinding

class LandmarkAdapter(private var landmarks: ArrayList<Landmark>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == HASIMAGE) {
            val view =
                LandmarkWithImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            LandmarkWithImageViewHolder(view)
        } else {
            val view =
                LandmarkWithoutImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            LandmarkWithoutImageViewHolder(view)
        }
    }

    override fun getItemCount(): Int = landmarks.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == HASIMAGE){
            (holder as LandmarkWithImageViewHolder).bind(landmarks[position])
        } else{
            (holder as LandmarkWithoutImageViewHolder).bind(landmarks[position])
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (landmarks[position].hasImage == HasImage.TRUE) HASIMAGE else NOIMAGE
    }

    inner class LandmarkWithImageViewHolder(private val landmarkWithImage: LandmarkWithImageBinding) :
        RecyclerView.ViewHolder(landmarkWithImage.root) {
        fun bind(landmark: Landmark) {
            landmarkWithImage.landmarkImage.setImageResource(landmark.resource!!)
            landmarkWithImage.landmarkWithImageTitle.text = landmark.title
            landmarkWithImage.landmarkWithImageDesc.text = landmark.desc
        }
    }

    inner class LandmarkWithoutImageViewHolder(private val landmarkWithoutImage: LandmarkWithoutImageBinding) :
        RecyclerView.ViewHolder(landmarkWithoutImage.root) {
        fun bind(landmark: Landmark) {
            landmarkWithoutImage.landmarkTitle.text = landmark.title
            landmarkWithoutImage.landmarkDesc.text = landmark.desc
        }
    }

}