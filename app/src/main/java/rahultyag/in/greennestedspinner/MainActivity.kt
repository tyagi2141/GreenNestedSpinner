package rahultyag.`in`.greennestedspinner

import Country
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import gr.escsoft.michaelprimez.searchablespinner.SearchableSpinner
import gr.escsoft.michaelprimez.searchablespinner.interfaces.IStatusListener
import gr.escsoft.michaelprimez.searchablespinner.interfaces.OnItemSelectedListener
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import rahultyag.`in`.greennestedspinner.adapter.SimpleArrayListAdapter
import rahultyag.`in`.greennestedspinner.adapter.SimpleListAdapter
import java.util.*

class MainActivity : AppCompatActivity() {

    private var mSpinner_One: SearchableSpinner? = null
    private var mSpinner_One_Array_Adapter: SimpleArrayListAdapter? = null

    private var mSearchableSpinner1: SearchableSpinner? = null
   private var mSearchableSpinner2: SearchableSpinner? = null
    private var mSearchableSpinner3: SearchableSpinner? = null

    private var mSimpleListAdapter: SimpleListAdapter? = null
    private val mStrings = ArrayList<String>()
   private var country = ArrayList<String>()



    val mAPIClient by lazy {
        APIClient.create()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       // val toolbar: Toolbar = findViewById(R.id.toolbar) as Toolbar
        //setSupportActionBar(toolbar)




        initListValues()

  //=======================one =====================================================
        mSpinner_One_Array_Adapter = SimpleArrayListAdapter(this, mStrings)
      //  mSimpleListAdapter=SimpleListAdapter(this,country)
        mSpinner_One = findViewById(R.id.SearchableSpinner) as SearchableSpinner
        mSpinner_One!!.setAdapter(mSpinner_One_Array_Adapter)
        mSpinner_One!!.setOnItemSelectedListener(mOnItemSelectedListener)
        mSpinner_One!!.setStatusListener(object : IStatusListener {
            override fun spinnerIsOpening() {
                mSearchableSpinner1!!.hideEdit()
                mSearchableSpinner2!!.hideEdit()
            }

            override fun spinnerIsClosing() {}
        })

        mSearchableSpinner2 = findViewById(R.id.SearchableSpinner2) as SearchableSpinner
        mSearchableSpinner2!!.setAdapter(mSpinner_One_Array_Adapter)
        mSearchableSpinner2!!.setOnItemSelectedListener(mOnItemSelectedListener)
        mSearchableSpinner2!!.setStatusListener(object : IStatusListener {
            override fun spinnerIsOpening() {
                mSpinner_One!!.hideEdit()
                mSearchableSpinner1!!.hideEdit()
            }

            override fun spinnerIsClosing() {}
        })

        mSearchableSpinner3 = findViewById(R.id.SearchableSpinner3) as SearchableSpinner
        mSearchableSpinner3!!.setAdapter(mSpinner_One_Array_Adapter)
        mSearchableSpinner3!!.setOnItemSelectedListener(mOnItemSelectedListener)
        mSearchableSpinner3!!.setStatusListener(object : IStatusListener {
            override fun spinnerIsOpening() {
                mSpinner_One!!.hideEdit()
                mSearchableSpinner3!!.hideEdit()
            }

            override fun spinnerIsClosing() {}
        })



        //===============================================================================================


        mAPIClient.getData()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe {

                Log.e("responseData", it.responseData.area.toString() + "  \n =====  ")

               // country= it.responseData.country as ArrayList<Country>
                for (i in 0 until it.responseData.country.size) {
                    val item = it.responseData.country.get(i)
                    country.add(item.country)
                    // Your code here
                }
                Log.e("bdhvhdbfvdfv",country.toString());
                mSimpleListAdapter = SimpleListAdapter(this,country)
                mSearchableSpinner1 = findViewById(R.id.SearchableSpinner1) as SearchableSpinner
                mSearchableSpinner1!!.setAdapter(mSimpleListAdapter)

                mSearchableSpinner1!!.setOnItemSelectedListener(mOnItemSelectedListener)
                mSearchableSpinner1!!.setStatusListener(object : IStatusListener {
                    override fun spinnerIsOpening() {
                        mSpinner_One!!.hideEdit()
                        mSearchableSpinner2!!.hideEdit()
                    }

                    override fun spinnerIsClosing() {}
                })

            }
// ================================== two ========================================================================


    }


    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (!mSpinner_One!!.isInsideSearchEditText(event)) {
            mSpinner_One!!.hideEdit()
        }
        if (!mSearchableSpinner1!!.isInsideSearchEditText(event)) {
            mSearchableSpinner1!!.hideEdit()
        }
        if (!mSearchableSpinner2!!.isInsideSearchEditText(event)) {
            mSearchableSpinner2!!.hideEdit()
        }
        return super.onTouchEvent(event)
    }
    private val mOnItemSelectedListener: OnItemSelectedListener =
        object : OnItemSelectedListener {
            override fun onItemSelected(
                view: View,
                position: Int,
                id: Long
            ) {
               // Toast.makeText(this@MainActivity, "Item on position " + position + " : " + mSimpleListAdapter!!.getItem(position) + " Selected", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected() {
                Toast.makeText(this@MainActivity, "Nothing Selected", Toast.LENGTH_SHORT).show()
            }
        }

    private fun initListValues() {
        mStrings.add("Brigida Kurz")
        mStrings.add("Tracy Mckim")
        mStrings.add("Iesha Davids")
        mStrings.add("Ozella Provenza")
        mStrings.add("Florentina Carriere")
        mStrings.add("Geri Eiler")
        mStrings.add("Tammara Belgrave")
        mStrings.add("Ashton Ridinger")
        mStrings.add("Jodee Dawkins")
        mStrings.add("Florine Cruzan")
        mStrings.add("Latia Stead")
        mStrings.add("Kai Urbain")
        mStrings.add("Liza Chi")
        mStrings.add("Clayton Laprade")
        mStrings.add("Wilfredo Mooney")
        mStrings.add("Roseline Cain")
        mStrings.add("Chadwick Gauna")
        mStrings.add("Carmela Bourn")
        mStrings.add("Valeri Dedios")
        mStrings.add("Calista Mcneese")
        mStrings.add("Willard Cuccia")
        mStrings.add("Ngan Blakey")
        mStrings.add("Reina Medlen")
        mStrings.add("Fabian Steenbergen")
        mStrings.add("Edmond Pine")
        mStrings.add("Teri Quesada")
        mStrings.add("Vernetta Fulgham")
        mStrings.add("Winnifred Kiefer")
        mStrings.add("Chiquita Lichty")
        mStrings.add("Elna Stiltner")
        mStrings.add("Carly Landon")
        mStrings.add("Hans Morford")
        mStrings.add("Shawanna Kapoor")
        mStrings.add("Thomasina Naron")
        mStrings.add("Melba Massi")
        mStrings.add("Sal Mangano")
        mStrings.add("Mika Weitzel")
        mStrings.add("Phylis France")
        mStrings.add("Illa Winzer")
        mStrings.add("Kristofer Boyden")
        mStrings.add("Idalia Cryan")
        mStrings.add("Jenni Sousa")
        mStrings.add("Eda Forkey")
        mStrings.add("Birgit Rispoli")
        mStrings.add("Janiece Mcguffey")
        mStrings.add("Barton Busick")
        mStrings.add("Gerald Westerman")
        mStrings.add("Shalanda Baran")
        mStrings.add("Margherita Pazos")
        mStrings.add("Yuk Fitts")
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean { // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean { // Handle action bar item clicks here. The action bar will
// automatically handle clicks on the Home/Up button, so long
// as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId
        if (id == R.id.action_reset) {
            mSpinner_One!!.setSelectedItem(0)
            mSearchableSpinner1!!.setSelectedItem(0)
            mSearchableSpinner2!!.setSelectedItem(0)
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
