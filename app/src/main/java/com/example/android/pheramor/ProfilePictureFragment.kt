package com.example.android.pheramor

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_profile_picture.*
import java.io.IOException

class ProfilePictureFragment : BaseFragment() {

    private val FROM_IMAGE_GALLERY = 0
    private var profilePictureUri: Uri? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        layoutId = R.layout.fragment_profile_picture
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == FROM_IMAGE_GALLERY && resultCode == Activity.RESULT_OK) {
            profilePictureUri = data!!.data
            try {
                val profilePicture = MediaStore.Images.Media.getBitmap(activity!!.contentResolver, profilePictureUri)
                profile_picture_image_view.setImageBitmap(profilePicture)
                registrationService.profilePicture = profilePicture
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }

    override fun setup() {
        profile_picture_image_view.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            startActivityForResult(intent, FROM_IMAGE_GALLERY)
        }

        if (registrationService.profilePicture != null) {
            profile_picture_image_view.setImageBitmap(registrationService.profilePicture)
        }
    }

    override fun isValid(): Boolean {
        registrationService.registration.profilePictureUri = profilePictureUri
        return super.isValid()
    }

}
