package com.info.assignment.view.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.info.assignment.R
import com.info.assignment.model.Data
import com.info.assignment.utils.Utility
import com.info.assignment.view.adapter.DataAdapter
import com.info.assignment.viewmodel.DataViewModel

class DataListFragment : Fragment(), SwipeRefreshLayout.OnRefreshListener {

    private var mViewModel: DataViewModel? = null
    private var dataList = ArrayList<Data>()
    private var recyclerView: RecyclerView? = null
    private var dataAdapter: DataAdapter? = null
    private var swipeRefreshLayout: SwipeRefreshLayout? = null
    private var progressBar: ProgressBar?=null

    override fun onRefresh() {
        // Refreshing data in recyclerView on SwipeRefreshLayout
        loadListData()
    }

    companion object {
        // Creating instance of DataListFragment
        fun newInstance(): DataListFragment {
            return DataListFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.data_fragment, container, false)
        recyclerView = view.findViewById(R.id.recyclerView)
        progressBar = view.findViewById(R.id.progressBar)
        swipeRefreshLayout = view.findViewById(R.id.simpleSwipeRefreshLayout)
        swipeRefreshLayout?.isRefreshing = true
        swipeRefreshLayout!!.setOnRefreshListener(this)

        /*
        * Set List of rows in adapter
        * */
        dataAdapter = DataAdapter(dataList)
        recyclerView!!.layoutManager = LinearLayoutManager(context)
        recyclerView!!.adapter = dataAdapter
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        // display viewModel data into recyclerView
        loadListData()
    }

    private fun loadListData() {
        if (Utility.isOnline(activity!!)) {
            mViewModel = ViewModelProviders.of(this).get(DataViewModel::class.java)
            mViewModel!!.init()
            mViewModel!!.data!!.observe(this, androidx.lifecycle.Observer {

                //Set title in toolbar
                activity?.title = it.title

                //set list in RecyclerView from response i.e 'rows'
                dataAdapter?.notifyDataChanged(it.rows)
                progressBar?.visibility=View.GONE

            })
        } else {
            Utility.showToast(activity!!, getString(R.string.no_internet))
        }
        swipeRefreshLayout?.isRefreshing = false
    }
}