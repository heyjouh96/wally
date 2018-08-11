package com.example.jonathan.wally

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.EditText
import android.widget.TextView

import org.json.JSONArray
import org.json.JSONException

import java.io.IOException
import java.util.ArrayList

import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response

class _SearchWally : AppCompatActivity() {

    internal lateinit var recyclerView: RecyclerView
    internal lateinit var wally: SearchWallyResponse
    internal lateinit var txtCarregando: TextView
    internal lateinit var edtPesq: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_wally)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        recyclerView = findViewById(R.id.search_recycler)
        txtCarregando = findViewById(R.id.txtCarregando)
        edtPesq = findViewById(R.id.edtPesq)
    }

    fun wallySchedule(v: View) {
        val id = Integer.parseInt(v.tag.toString())
        val it = Intent(this, ScheduleWally::class.java)
        it.putExtra("id", id)
        startActivity(it)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    fun search(v: View) {

        recyclerView.visibility = View.INVISIBLE
        txtCarregando.text = "Carregando..."
        val filtro = edtPesq.text.toString()

        try {
            getWallyResponse(filtro)
        } catch (e: IOException) {
            e.printStackTrace()
        }

    }

    @Throws(IOException::class)
    private fun getWallyResponse(filtro: String) {
        val client = OkHttpClient()
        val request = Request.Builder()
                .url("http://www.fatecrl.edu.br/wallyAPI/wally/$filtro")
                .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                call.cancel()
            }

            @Throws(IOException::class)
            override fun onResponse(call: Call, response: Response) {
                val myResponse = response.body()!!.string()

                this@_SearchWally.runOnUiThread {
                    try {
                        val json = JSONArray(myResponse)
                        val wallyArr = ArrayList<SearchWallyResponse>()

                        for (i in 0 until json.length()) {
                            wally = SearchWallyResponse(json.getJSONObject(i).getString("nome"),
                                    json.getJSONObject(i).getString("apelido"),
                                    json.getJSONObject(i).getInt("id"))

                            wallyArr.add(wally)
                        }

                        recyclerView.adapter = SearchAdapter(wallyArr, this@_SearchWally)
                        val layoutManager = LinearLayoutManager(this@_SearchWally, LinearLayoutManager.VERTICAL, false)
                        recyclerView.layoutManager = layoutManager
                        recyclerView.visibility = View.VISIBLE
                        txtCarregando.text = ""

                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                }
            }
        })
    }


}
