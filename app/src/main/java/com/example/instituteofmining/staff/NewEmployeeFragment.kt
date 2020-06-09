package com.example.instituteofmining.staff

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.loader.content.CursorLoader
import com.bumptech.glide.Glide
import com.example.instituteofmining.R
import com.example.instituteofmining.adapter.employee.NewEmployeeAdapter
import com.example.instituteofmining.adapter.model.EmployeeModel
import com.example.instituteofmining.adapter.model.NewEmployeeModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import kotlinx.android.synthetic.main.fragment_new_employee.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.File
import java.util.*
import kotlin.collections.ArrayList

class NewEmployeeFragment : Fragment() {
    private lateinit var myDatabase: DatabaseReference
    private var filePath: Uri? = null
    private var firebaseStore: FirebaseStorage? = null
    private var storageReference: StorageReference? = null
    private val employee = "employee"
    val adapters = NewEmployeeAdapter()

    private val STORAGE_PERMISION_CODE: Int = 1
    private val IMAGE_PICK_CODE = 10

    private lateinit var list: EmployeeModel

    private var files = ArrayList<MultipartBody.Part>()
    private var names = ArrayList<String>()

    private lateinit var myUrlImage: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_new_employee, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()

        list = EmployeeModel(adapters.itemCount, "", "", "", "", "", "", "", "", "", "")

        employee_add_image.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (ContextCompat.checkSelfPermission(
                        context!!,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE
                    ) == PackageManager.PERMISSION_DENIED
                ) {
                    val permissions = arrayOf(
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.READ_EXTERNAL_STORAGE
                    )
                    requestPermissions(permissions, STORAGE_PERMISION_CODE)

                } else {
                    getMyFile()
                }
            } else {
                getMyFile()
            }

        }
    }

    fun init() {
        myDatabase = FirebaseDatabase.getInstance().getReference(employee)

        val adapters = NewEmployeeAdapter()
        adapters.add()
        new_employee_recycler.adapter = adapters

        new_employee_add_from.setOnClickListener {
            adapters.add()
        }

        counter_show.setOnClickListener {
            val id = myDatabase.key.toString()
            val name = new_employee_name.text.toString()
            val surname = new_employee_surname.text.toString()
            val age = new_employee_age.text.toString()
            val person = employee_add_image.drawable.toString()
            val education = new_employee_education.text.toString()
            val graduated = new_employee_graduated.text.toString()
            val experience = new_employee_experience.text.toString()
            val degree = new_employee_degree.text.toString()
            val title = new_employee_academic_title.text.toString()

            firebaseStore = FirebaseStorage.getInstance()
            storageReference = FirebaseStorage.getInstance().reference


            uploadImage()

            val myEmployee = NewEmployeeModel(
                id,
                filePath.toString(),
                name,
                surname,
                age,
                education,
                graduated,
                experience,
                degree,
                title,
                adapters.getBookingRoomModels()
            )
            myDatabase.push().setValue(myEmployee)
        }
    }

    private fun getMyFile() {
        val myFile = Intent(Intent.ACTION_PICK)
        myFile.type = "*/*"
        startActivityForResult(myFile, IMAGE_PICK_CODE)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int, permissions: Array<out String>, grantResults: IntArray
    ) {
        if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            getMyFile()
        } else {
            //permission from popup denied
            Toast.makeText(context, "Нет разрешений", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == Activity.RESULT_OK && requestCode == IMAGE_PICK_CODE) {
            if (data != null) {
                val uri = data.data!!
                val file = File(getPath(uri))
                val requestFile = file.asRequestBody("image/*".toMediaTypeOrNull())
                val photo = MultipartBody.Part.createFormData("File", file.name, requestFile)
                files.add(photo)
                names.add(photo.toString().substring(0, 15))

                this.filePath = uri

                Glide
                    .with(employee_add_image.context)
                    .load(uri.toString())
                    .centerCrop()
                    .into(employee_add_image);
            }
        }
    }

    private fun getPath(uri: Uri): String {
        val proj = arrayOf(MediaStore.Images.Media.DATA)
        val loader = CursorLoader(context!!, uri, proj, null, null, null)
        val cursor = loader.loadInBackground()
        val columnIndex = cursor!!.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
        cursor.moveToFirst()
        val res = cursor.getString(columnIndex)
        cursor.close()
        return res

    }

    private fun addUploadRecordToDb(uri: String) {
        val db = FirebaseFirestore.getInstance()

        val data = HashMap<String, Any>()
        data["imageUrl"] = uri

        db.collection("posts")
            .add(data)
            .addOnSuccessListener { documentReference ->
                Toast.makeText(context, "Saved to DB", Toast.LENGTH_LONG).show()
            }
            .addOnFailureListener { e ->
                Toast.makeText(context, "Error saving to DB", Toast.LENGTH_LONG).show()
            }
    }

    private fun uploadImage() {
        if (filePath != null) {
            val a = "uploads/" + UUID.randomUUID().toString()
            val bb =  storageReference?.child(a)
            storageReference?.child(a)!!.putFile(filePath!!)
                .addOnSuccessListener {

                        println()
                }.addOnCompleteListener { task ->
                    bb!!.downloadUrl.addOnSuccessListener {
                        println()
                    }
                }.addOnFailureListener {
                    println()
                }

        } else {
            Toast.makeText(context, "Please Upload an Image", Toast.LENGTH_SHORT).show()
        }
    }
}