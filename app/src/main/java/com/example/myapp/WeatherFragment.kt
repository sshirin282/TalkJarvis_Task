package com.example.myapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
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
 * Use the [WeatherFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class WeatherFragment : Fragment(),Adapter.DataModelItemClicked {
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
        return inflater.inflate(R.layout.fragment_weather, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerview)
        var adapter: Adapter
        val i: Int = 0
        val list: ArrayList<DataModel> = ArrayList<DataModel>()
        val url: String =
            "http://api.openweathermap.org/data/2.5/weather?q=London&appid=b2eee560a9738f9ae1dd7dfe40ef3379"


        val stringRequest = object: StringRequest(
            Request.Method.GET, url,
            Response.Listener<String> { response ->
              //  Log.e("A", "Response is: " + response.substring(0,500))
                val ja: JSONObject = JSONObject(response)
//                val jb: JSONArray =ja.getJSONArray("articles")
                val title:String=ja.getString("timezone")
                val description:String=ja.getString("id")
                val publishedAt:String=ja.getString("name")
                val urlToImage:String=ja.getString("cod")
//                for (i in 0 until jb.length()) {
//                    val js: JSONObject = jb.getJSONObject(i)
//                    val title:String=js.getString("title")
//                    val description:String=js.getString("description")
//                    val publishedAt:String=js.getString("publishedAt")
//                    val urlToImage:String=js.getString("urlToImage")


                val dataModel=DataModel()
                dataModel.timezone=title
                dataModel.id=description
                dataModel.name=publishedAt
                dataModel.cod=urlToImage
                list.add(dataModel)
//
//                    val dataModel=DataModel()
//                    dataModel.title=title
//                    dataModel.description=description
//                    dataModel.publishedAt=publishedAt
//                    dataModel.urlToImage=urlToImage
//                    list.add(dataModel)
               // }
                adapter=Adapter(context!!,list,this)
                val layoutManager= LinearLayoutManager(context)
                recyclerView.layoutManager=layoutManager
                recyclerView.adapter=adapter
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
    override fun DataModelItemClicked(list: DataModel) {
        val intent= Intent(context,WeatherViewActivity::class.java)
        intent.putExtra("weather1",list.timezone)
        Log.e("title",list.timezone)
        intent.putExtra("weather2",list.id)
        Log.e("title",list.id)
        intent.putExtra("weather3",list.name)
        Log.e("title",list.name)
        intent.putExtra("weather4",list.cod)
        Log.e("title",list.cod)
        startActivity(intent)
    }
    }
