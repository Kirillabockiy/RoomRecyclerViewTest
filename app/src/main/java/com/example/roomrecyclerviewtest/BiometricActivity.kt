package com.example.roomrecyclerviewtest


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.biometric.BiometricManager
import androidx.biometric.BiometricPrompt
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_biometric.*

class BiometricActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_biometric)


        val biometricManager = BiometricManager.from(this)

        when (biometricManager.canAuthenticate()) {
            BiometricManager.BIOMETRIC_SUCCESS ->
                Log.d("MY_APP_TAG", "App can authenticate using biometrics.")
            BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE ->
                Log.e("MY_APP_TAG", "No biometric features available on this device.")
            BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE ->
                Log.e("MY_APP_TAG", "Biometric features are currently unavailable.")
            BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED ->
                Log.e("MY_APP_TAG", "The user hasn't associated " +
                        "any biometric credentials with their account.")
        }



        if (biometricManager.canAuthenticate() == BiometricManager.BIOMETRIC_SUCCESS){
            Log.d("MainActivity","Device supports biometric auth")

            val executor = ContextCompat.getMainExecutor(this)

            val callback = object: BiometricPrompt.AuthenticationCallback() {
                override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
                    super.onAuthenticationError(errorCode, errString)
                    Log.d("MainActivity","$errorCode :: $errString")
                }

                override fun onAuthenticationFailed() {
                    super.onAuthenticationFailed()
                    Log.d("MainActivity","Authentication failed")
                }

                override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                    super.onAuthenticationSucceeded(result)

                    val intent: Intent = Intent(this@BiometricActivity, MainActivity::class.java)
                    startActivity(intent)
                }
            }

            val biometricPrompt = BiometricPrompt(this, executor, callback)
            val promptInfo = BiometricPrompt.PromptInfo.Builder()
                .setTitle("Вход в MyMoneyKeep")
                .setDeviceCredentialAllowed(true)
                .build()

            biometricPrompt.authenticate(promptInfo)

            btn_finger.setOnClickListener(View.OnClickListener {
                biometricPrompt.authenticate(promptInfo)

            })
        }

    }
}