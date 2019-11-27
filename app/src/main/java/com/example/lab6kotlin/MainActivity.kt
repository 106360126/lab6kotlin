package com.example.lab6kotlin
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.cubee_list.*

class MainActivity : AppCompatActivity() {
    inner class Data {
        var photo: Int = 0
        var name: String? = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val transNameArray = arrayOf("腳踏車", "機車", "汽車", "巴士")
        val transPhotoIdArray =
            intArrayOf(R.drawable.trans1, R.drawable.trans2, R.drawable.trans3, R.drawable.trans4)

        val trandData = arrayOfNulls<Data>(transNameArray.size)
        for (i in transNameArray.indices) {
            trandData[i] = Data()
            trandData[i]!!.name = transNameArray[i]
            trandData[i]!!.photo = transPhotoIdArray[i]
        }

        val transAdapter = MyAdpter(trandData, R.layout.trans_list)
        
        spinner.adapter = transAdapter

        val messageArray = arrayOf("訊息1", "訊息2", "訊息3", "訊息4", "訊息5", "訊息6")

        val messageAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, messageArray)

        listView.adapter = messageAdapter

        val cubeeNameArray = arrayOf("哭哭", "發抖", "再見", "生氣", "昏倒", "竊笑", "很棒", "你好", "驚嚇", "大笑")
        val cubeePhotoIdArray = intArrayOf(
            R.drawable.cubee1,
            R.drawable.cubee2,
            R.drawable.cubee3,
            R.drawable.cubee4,
            R.drawable.cubee5,
            R.drawable.cubee6,
            R.drawable.cubee7,
            R.drawable.cubee8,
            R.drawable.cubee9,
            R.drawable.cubee10
        )
        val cubeeData = arrayOfNulls<Data>(cubeeNameArray.size)

        for (i in cubeeData.indices) {
            cubeeData[i] = Data()
            cubeeData[i]!!.name = cubeeNameArray[i]
            cubeeData[i]!!.photo = cubeePhotoIdArray[i]
        }

        val cubeeAdapter = MyAdpter(cubeeData, R.layout.cubee_list)

//        val gridView = findViewById(R.id.gridView)
        gridView.adapter = cubeeAdapter
        gridView.numColumns = 3
    }


    inner class MyAdpter(private val data: Array<Data?>, private val view: Int) :
        BaseAdapter() {
        override fun getCount(): Int {
            return data.size
        }

        override fun getItem(position: Int): Data? {
            return data[position]
        }

        override fun getItemId(position: Int): Long {
            return 0
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            var x = convertView

            x = layoutInflater.inflate(view, parent, false)
           val name = x.findViewById<TextView>(R.id.name)
            name.text = data[position]!!.name
               val imageview = x.findViewById<ImageView>(R.id.imageView)
            imageview.setImageResource(data[position]!!.photo)
            return x
        }

    }
}
