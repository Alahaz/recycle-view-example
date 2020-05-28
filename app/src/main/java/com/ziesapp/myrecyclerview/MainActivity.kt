package com.ziesapp.myrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvPahlawan: RecyclerView
    private var list: ArrayList<Pahlawan> = arrayListOf()
    private var title: String = "Mode List"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setActionBarTitle(title)

        rvPahlawan = findViewById(R.id.rv_pahlawan)
        rvPahlawan.setHasFixedSize(true)

        list.addAll(DataPahlawan.listData)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvPahlawan.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListHeroAdapter(list)
        rvPahlawan.adapter = listHeroAdapter

        listHeroAdapter.setOnItemClickCallBack(object :ListHeroAdapter.OnItemClickCallBack{
            override fun onItemClicked(data:Pahlawan){
                showSelectedPahlawan(data)
            }
        })
    }

    private fun showRecyclerGrid() {
        rvPahlawan.layoutManager = GridLayoutManager(this, 2)
        val gridHeroAdapter = GridHeroAdapter(list)
        rvPahlawan.adapter = gridHeroAdapter

        gridHeroAdapter.setOnItemClickCallBack(object:GridHeroAdapter.OnItemClickCallback{
            override fun onItemClicked(data: Pahlawan) {
                showSelectedPahlawan(data)
            }
        })
    }

    private fun showCardView() {
        rvPahlawan.layoutManager = LinearLayoutManager(this)
        val cardViewHeroAdapter = CardViewHeroAdapter(list)
        rvPahlawan.adapter = cardViewHeroAdapter
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.action_list -> {
                showRecyclerList()
                title = "Mode List"
            }

            R.id.action_grid -> {
                showRecyclerGrid()
                title = "Mode Grid"
            }
            R.id.action_cardview -> {
                showCardView()
                title = "Mode Card View"
            }
        }
        setActionBarTitle(title)
    }

    private fun setActionBarTitle(title: String) {
        if (supportActionBar != null) {
            (supportActionBar as ActionBar).title = title
        }
    }

    private fun showSelectedPahlawan(pahlawan: Pahlawan){
        Toast.makeText(this, "Kamu memilih "+pahlawan.nama,Toast.LENGTH_SHORT).show()
    }

}
