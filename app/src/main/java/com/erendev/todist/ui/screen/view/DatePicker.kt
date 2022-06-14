package com.erendev.todist.ui.screen.view

import android.app.DatePickerDialog
import android.content.Context
import android.widget.DatePicker
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.erendev.todist.R
import java.util.*

@Composable
fun DatePicker(
    onDismissRequest: () -> Unit,
    onDateChangedListener: (String) -> Unit
) {
    val mYear: Int
    val mMonth: Int
    val mDay: Int
    val now = Calendar.getInstance()
    mYear = now.get(Calendar.YEAR)
    mMonth = now.get(Calendar.MONTH)
    mDay = now.get(Calendar.DAY_OF_MONTH)
    now.time = Date()
    val datePickerDialog = DatePickerDialog(
        LocalContext.current,
        R.style.DialogTheme,
        { _: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
            val cal = Calendar.getInstance()
            cal.set(year, month, dayOfMonth)
            onDateChangedListener(
                String.format(Locale("tr", "TR"), "%02d", dayOfMonth) +
                    ".${String.format(Locale("tr", "TR"), "%02d", month + 1)}.$year")
        }, mYear, mMonth, mDay
    )
    datePickerDialog.show()
    datePickerDialog.setOnDismissListener {
        onDismissRequest()
    }

    datePickerDialog.setOnCancelListener {
        onDismissRequest()
    }
}