package rahultyag.`in`.greennestedspinner.adapter

import android.content.Context
import android.graphics.Color
import android.text.TextUtils
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.amulyakhare.textdrawable.TextDrawable
import com.amulyakhare.textdrawable.util.ColorGenerator
import gr.escsoft.michaelprimez.searchablespinner.interfaces.ISpinnerSelectedView
import gr.escsoft.michaelprimez.searchablespinner.tools.UITools
import rahultyag.`in`.greennestedspinner.R
import java.util.*


class SimpleArrayListAdapter(
    private val mContext: Context,
    strings: ArrayList<String>
) :
    ArrayAdapter<String?>(mContext, R.layout.view_list_item), Filterable,
    ISpinnerSelectedView {
    private val mBackupStrings: ArrayList<String>
    private var mStrings: ArrayList<String>?
    private val mStringFilter =
        StringFilter()

    override fun getCount(): Int {
        return if (mStrings == null) 0 else mStrings!!.size + 1
    }

    override fun getItem(position: Int): String? {
        return if (mStrings != null && position > 0) mStrings!![position - 1] else null
    }

    override fun getItemId(position: Int): Long {
        return if (mStrings == null && position > 0) mStrings!![position]
            .hashCode().toLong() else -1
    }

    override fun getView(
        position: Int,
        convertView: View?,
        parent: ViewGroup
    ): View {
        var view: View? = null
        if (position == 0) {
            view = noSelectionView
        } else {
            view = View.inflate(mContext, R.layout.view_list_item, null)
            val letters =
                view.findViewById<View>(R.id.ImgVw_Letters) as ImageView
            val dispalyName =
                view.findViewById<View>(R.id.TxtVw_DisplayName) as TextView
            letters.setImageDrawable(getTextDrawable(mStrings!![position - 1]))
            dispalyName.text = mStrings!![position - 1]
        }
        return view!!
    }

    override fun getSelectedView(position: Int): View {
        var view: View? = null
        if (position == 0) {
            view = noSelectionView
        } else {
            view = View.inflate(mContext, R.layout.view_list_item, null)
            val letters =
                view.findViewById<View>(R.id.ImgVw_Letters) as ImageView
            val dispalyName =
                view.findViewById<View>(R.id.TxtVw_DisplayName) as TextView
            letters.setImageDrawable(getTextDrawable(mStrings!![position - 1]))
            dispalyName.text = mStrings!![position - 1]
        }
        return view!!
    }

    override fun getNoSelectionView(): View {
        return View.inflate(mContext, R.layout.view_list_no_selection_item, null)
    }

    private fun getTextDrawable(displayName: String): TextDrawable? {
        var drawable: TextDrawable? = null
        drawable = if (!TextUtils.isEmpty(displayName)) {
            val color2 = ColorGenerator.MATERIAL.getColor(displayName)
            TextDrawable.builder()
                .beginConfig()
                .width(UITools.dpToPx(mContext, 32F))
                .height(UITools.dpToPx(mContext, 32F))
                .textColor(Color.WHITE)
                .toUpperCase()
                .endConfig()
                .round()
                .build(displayName.substring(0, 1), color2)
        } else {
            TextDrawable.builder()
                .beginConfig()
                .width(UITools.dpToPx(mContext, 32F))
                .height(UITools.dpToPx(mContext, 32F))
                .endConfig()
                .round()
                .build("?", Color.GRAY)
        }
        return drawable
    }

    override fun getFilter(): Filter {
        return mStringFilter
    }

    inner class StringFilter : Filter() {
        override fun performFiltering(constraint: CharSequence): FilterResults {
            val filterResults = FilterResults()
            if (TextUtils.isEmpty(constraint)) {
                filterResults.count = mBackupStrings.size
                filterResults.values = mBackupStrings
                return filterResults
            }
            val filterStrings =
                ArrayList<String>()
            for (text in mBackupStrings) {
                if (text.toLowerCase().contains(constraint)) {
                    filterStrings.add(text)
                }
            }
            filterResults.count = filterStrings.size
            filterResults.values = filterStrings
            return filterResults
        }

        override fun publishResults(
            constraint: CharSequence,
            results: FilterResults
        ) {
            mStrings = results.values as ArrayList<String>
            notifyDataSetChanged()
        }
    }

    private inner class ItemView {
        var mImageView: ImageView? = null
        var mTextView: TextView? = null
    }

    enum class ItemViewType {
        ITEM, NO_SELECTION_ITEM
    }

    init {
        mStrings = strings
        mBackupStrings = strings
    }
}
