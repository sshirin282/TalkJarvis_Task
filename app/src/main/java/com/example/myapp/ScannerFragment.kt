package com.example.myapp

import android.app.Activity
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.budiyev.android.codescanner.CodeScanner
import com.budiyev.android.codescanner.CodeScannerView
import com.budiyev.android.codescanner.DecodeCallback
import kotlinx.android.synthetic.main.fragment_scanner.view.*
import me.dm7.barcodescanner.zbar.Result
import me.dm7.barcodescanner.zbar.ZBarScannerView
import java.util.jar.Manifest

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ScannerFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ScannerFragment : Fragment() {


//    companion object {
//
//        fun newInstance(): ScannerFragment {
//            return ScannerFragment()
//        }
//    }

//    private lateinit var mView: View
//
//    lateinit var scannerView: ZBarScannerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_scanner, container, false)
//        initializeQRCamera()
//        onClicks()
//        return mView.rootView
    }

//    private fun onClicks() {
//        mView.flashToggle.setOnClickListener {
//            if (mView.flashToggle.isSelected) {
//                offFlashLight()
//            } else {
//                onFlashLight()
//            }
//        }
//    }
//
//    private fun initializeQRCamera() {
//        scannerView = ZBarScannerView(context)
//        scannerView.setResultHandler(this)
//        scannerView.setBackgroundColor(ContextCompat.getColor(context!!, R.color.colorTranslucent))
//        scannerView.setBorderColor(ContextCompat.getColor(context!!, R.color.colorPrimaryDark))
//        scannerView.setLaserColor(ContextCompat.getColor(context!!, R.color.colorPrimaryDark))
//        scannerView.setBorderStrokeWidth(10)
//        scannerView.setSquareViewFinder(true)
//        scannerView.setupScanner()
//        scannerView.setAutoFocus(true)
//        startQRCamera()
//        mView.containerScanner.addView(scannerView)
//    }
//
//    private fun startQRCamera() {
//        scannerView.startCamera()
//    }
//    private fun onFlashLight() {
//        mView.flashToggle.isSelected = true
//        scannerView.flash = true
//    }
//
//    private fun offFlashLight() {
//        mView.flashToggle.isSelected = false
//        scannerView.flash = false
//    }
//
//    override fun onResume() {
//        super.onResume()
//        scannerView.setResultHandler(this)
//        scannerView.startCamera()
//    }
//
//    override fun onPause() {
//        super.onPause()
//        scannerView.stopCamera()
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        scannerView.stopCamera()
//    }
//


//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
////        if (context?.let {
////                ContextCompat.checkSelfPermission(
////                    it,
////                    android.Manifest.permission.CAMERA
////                )
////            }
////            == PackageManager.PERMISSION_DENIED)
////                ActivityCompat.requestPermissions(context as Activity,{android.Manifest.permission.CAMERA}){
////
////                }
////        // ActivityCompat.requestPermissions(con)
//
//
//        lateinit var codeScanner: CodeScanner
//        val scannerView = view.findViewById<CodeScannerView>(R.id.scanner_view)
//        val activity = requireActivity()
//        codeScanner = CodeScanner(activity, scannerView)
//        codeScanner.decodeCallback = DecodeCallback {
//            activity.runOnUiThread {
//                Toast.makeText(activity, it.text, Toast.LENGTH_LONG).show()
//            }
//        }
//        scannerView.setOnClickListener {
//            codeScanner.startPreview()
//        }
//        fun onResume() {
//            super.onResume()
//            codeScanner.startPreview()
//        }
//
//        fun onPause() {
//            codeScanner.releaseResources()
//            super.onPause()
//        }
//    }


//    override fun handleResult(rawResult: Result?) {
//        Toast.makeText(context!!,rawResult?.contents,Toast.LENGTH_LONG).show()
//        scannerView.resumeCameraPreview(this)
//    }
}