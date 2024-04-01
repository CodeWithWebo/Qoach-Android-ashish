package com.medflyt.Utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.util.Log
import android.widget.Toast

class Common {

    companion object {

        fun toast(context: Context, message: String){
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        }


//        fun progressDialog(context: Context): Dialog{
//
//            val dialog: Dialog = Dialog(context)
//            dialog.setContentView(R.layout.dialog_progress)
//            dialog.setCancelable(false)
//
//            dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
//
//           return dialog
//        }


//        fun alertDialog(activity: Activity, message: String, isBack: Boolean): Dialog{
//
//            val binding: DialogAlertBinding = DialogAlertBinding.inflate(LayoutInflater.from(activity), null, false)
//
//            val dialog: Dialog = Dialog(activity)
//            dialog.setContentView(binding.root)
//            dialog.setCancelable(false)
//
//            dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
//
//            binding.tvMessage.setText(message)
//
//            binding.tvOk.setOnClickListener {
//
//                if (isBack) activity.finish()
//
//                dialog.dismiss()
//            }
//
//            dialog.show()
//
//           return dialog
//        }

        fun checkNetwork(context: Context): Boolean {
            val connectivityManager =
                context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            if (connectivityManager != null) {
                val capabilities =
                    connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
                if (capabilities != null) {
                    if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                        Log.i("Internet", "NetworkCapabilities.TRANSPORT_CELLULAR")
                        return true
                    } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                        Log.i("Internet", "NetworkCapabilities.TRANSPORT_WIFI")
                        return true
                    } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)) {
                        Log.i("Internet", "NetworkCapabilities.TRANSPORT_ETHERNET")
                        return true
                    }
                }
            }
            return false
        }

    }

}