package kapsapps.xyz.assignement_wipro

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kapsapps.xyz.assignement_wipro.adapters.FactsAdapter
import kapsapps.xyz.assignement_wipro.view_model.DataViewModal
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        facts_list.layoutManager = LinearLayoutManager(this,RecyclerView.VERTICAL,false)
        facts_list.setHasFixedSize(true)

        val adapter = FactsAdapter()
        facts_list.adapter = adapter
        val viewModel = ViewModelProviders.of(this)[DataViewModal::class.java]

        swipe_view.isRefreshing = true
        viewModel.getFactsList().observe( this, Observer {

            /*
            * removing empty title and description rows
            * */
            val rows = it.rows.filter {
                it.title != "" && it.description != ""
            }
            adapter.setData(rows.toMutableList())
            swipe_view.isRefreshing = false
        })

        swipe_view.setOnRefreshListener {
            swipe_view.isRefreshing = true
            viewModel.loadFactsData()
        }

    }

    override fun onResume() {
        super.onResume()
    }
}