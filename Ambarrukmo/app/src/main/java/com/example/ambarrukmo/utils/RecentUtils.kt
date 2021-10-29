package co.id.codelabs.thesavia.utils

import android.annotation.SuppressLint
import android.content.Context
import android.text.Spanned
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.text.HtmlCompat
import com.example.ambarrukmo.api.AppConstants
import com.example.ambarrukmo.eventbus.DialogOnClose
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.*

object RecentUtils {

    fun fromHtml(html:String?): Spanned {
        if(!html.isNullOrEmpty()){

            return HtmlCompat.fromHtml(html,HtmlCompat.FROM_HTML_MODE_COMPACT)
        }

        return HtmlCompat.fromHtml("",HtmlCompat.FROM_HTML_MODE_COMPACT)
    }

    fun showToast(context:Context, message:String?){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    fun rupiahFormat(resource: Any?) : String {
        if(resource != null) {
            val price = resource.toString().toDouble()
            val localeID = Locale("in", "ID")
            val numberFormat = NumberFormat.getCurrencyInstance(localeID)
            val result = numberFormat.format(price.toInt()).toString()
            return result.replace("Rp", "Rp ").replace(",00","")
        }

        return "Rp 0"
    }
    fun changeDateFormat(initialDate: String?, previous: String?, toFormat: String?): String? {
        if (initialDate == null) {
            return ""
        }
        if (initialDate == "0000-00-00" || initialDate == "") {
            return ""
        }
        var convertedDate: String? = null
        @SuppressLint("SimpleDateFormat") val inputFormat: SimpleDateFormat =
            SimpleDateFormat(previous, AppConstants.locale)
        @SuppressLint("SimpleDateFormat") val outputFormat: SimpleDateFormat =
            SimpleDateFormat(toFormat, AppConstants.locale)
        val date: Date
        try {
            date = inputFormat.parse(initialDate)
            convertedDate = outputFormat.format(date)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return convertedDate + ""
    }

    fun showAlertDialogOneAction(context: Context,message: String?,dialogOnClose : DialogOnClose){
        val builder = AlertDialog.Builder(context)
        builder.setTitle("Message")
        builder.setMessage(message)
        builder.setPositiveButton("Close") { dialog, which ->
           dialogOnClose.onClose()
            dialog.dismiss()
        }
        builder.show()
    }

}