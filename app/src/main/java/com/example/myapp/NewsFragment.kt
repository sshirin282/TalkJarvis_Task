package com.example.myapp

import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.browser.customtabs.CustomTabsIntent
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONObject

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [NewsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NewsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerview)
        var adapter: Adapter
        val i: Int = 0
        val list: ArrayList<DataModel> = ArrayList<DataModel>()
        val url: String =
            "https://newsapi.org/v2/everything?domains=wsj.com&apiKey=c51b2fa9ac154d31a85b25f7a6f851f0"


            val stringRequest = object: StringRequest(Request.Method.GET, url,
            Response.Listener<String> { response ->
                Log.e("A", "Response is: " + response.substring(0,500))
                val ja: JSONObject = JSONObject(response)
                val jb: JSONArray =ja.getJSONArray("articles")


                for (i in 0 until jb.length()) {
                    val js: JSONObject = jb.getJSONObject(i)
                    val title:String=js.getString("title")
                    val description:String=js.getString("description")
                    val publishedAt:String=js.getString("publishedAt")
                    val urlToImage:String=js.getString("urlToImage")

                    val dataModel=DataModel()
                    dataModel.title=title
                    dataModel.description=description
                    dataModel.publishedAt=publishedAt
                    dataModel.urlToImage=urlToImage
                    list.add(dataModel)
                }
               adapter=Adapter(context!!,list)
                val layoutManager= LinearLayoutManager(context)
                recyclerView.layoutManager=layoutManager
                recyclerView.adapter=adapter
//                adapter= Adapter(context!!,list)
//            val layoutManager= LinearLayoutManager(context)
//            recyclerView.layoutManager=layoutManager
//            recyclerView.adapter=adapter


            },
            Response.ErrorListener {
                Log.e("error",it.toString())
            })
        {
            override fun getHeaders(): MutableMap<String, String> {
                val headers = HashMap<String, String>()
                    headers["User-Agent"] = "Mozilla/5.0"
                return headers
            }
        }

        val queue= Volley.newRequestQueue(context)
        queue.add(stringRequest)


    }




    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment NewsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            NewsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}