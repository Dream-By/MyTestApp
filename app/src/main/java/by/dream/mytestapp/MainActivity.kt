package by.dream.mytestapp

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import at.markushi.ui.CircleButton

class MainActivity : AppCompatActivity() {

    private lateinit var callButton : CircleButton
    private lateinit var callPoliceButton : CircleButton
    private lateinit var callMedicalButton : CircleButton
    private lateinit var callGaSButton : CircleButton
    private lateinit var callRailWayButton : CircleButton
    private lateinit var callBelPostButton : CircleButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        callButton = findViewById(R.id.Emergency)
        callPoliceButton = findViewById(R.id.Police)
        callMedicalButton = findViewById(R.id.Medical)
        callGaSButton = findViewById(R.id.GaS)
        callRailWayButton = findViewById(R.id.railway)
        callBelPostButton = findViewById(R.id.BelPost)

        callButton.setOnClickListener {
            if (isCallPermissionGranted()){
                callEmergencyNumber()
            } else {
                requestCallPermissions()
            }
        }


        callPoliceButton.setOnClickListener{
            if (isCallPermissionGranted()){
                callPoliceNumber()
            } else {
                requestCallPermissions()
            }
        }

        callMedicalButton.setOnClickListener{
            if (isCallPermissionGranted()){
                callMedicalNumber()
            } else {
                requestCallPermissions()
            }
        }


        callGaSButton.setOnClickListener{
            if (isCallPermissionGranted()){
                callGaSNumber()
            } else {
                requestCallPermissions()
            }
        }

        callRailWayButton.setOnClickListener{
            if (isCallPermissionGranted()){
                callRailWayNumber()
            } else {
                requestCallPermissions()
            }
        }

        callBelPostButton.setOnClickListener{
            if (isCallPermissionGranted()){
                callBelPostNumber()
            } else {
                requestCallPermissions()
            }
        }

    }

    private fun isCallPermissionGranted(): Boolean {
        return ContextCompat.checkSelfPermission(this,Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED
    }

    private fun requestCallPermissions() {
        ActivityCompat.requestPermissions(this,arrayOf(Manifest.permission.CALL_PHONE), REQUEST_CODE)
        }

    @SuppressLint("MissingPermission")
    private fun callEmergencyNumber() {
        val callUri = Uri.parse("tel://101")
        val callIntent = Intent(Intent.ACTION_CALL,callUri)
        startActivity(callIntent)
    }

    @SuppressLint("MissingPermission")
    private fun callPoliceNumber() {
        val callUri = Uri.parse("tel://102")
        val callIntent = Intent(Intent.ACTION_CALL,callUri)
        startActivity(callIntent)
    }

    @SuppressLint("MissingPermission")
    private fun callMedicalNumber() {
        val callUri = Uri.parse("tel://103")
        val callIntent = Intent(Intent.ACTION_CALL,callUri)
        startActivity(callIntent)
    }

    @SuppressLint("MissingPermission")
    private fun callGaSNumber() {
        val callUri = Uri.parse("tel://104")
        val callIntent = Intent(Intent.ACTION_CALL,callUri)
        startActivity(callIntent)
    }

    @SuppressLint("MissingPermission")
    private fun callRailWayNumber() {
        val callUri = Uri.parse("tel://105")
        val callIntent = Intent(Intent.ACTION_CALL,callUri)
        startActivity(callIntent)
    }

    @SuppressLint("MissingPermission")
    private fun callBelPostNumber() {
        val callUri = Uri.parse("tel://154")
        val callIntent = Intent(Intent.ACTION_CALL,callUri)
        startActivity(callIntent)
    }

    private companion object {
        private const val REQUEST_CODE = 100
    }
}
