package com.example.teamprojectboat

import android.icu.text.CaseMap.Title
import android.media.Image
import androidx.compose.ui.graphics.vector.ImageVector
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import java.time.MonthDay

data class MenuItem(
     val id: String,
     val title: String,
     val contentDescription: String,
     val icon: ImageVector,
     var day: MonthDay
)

class CalendarAdapter(private val context: Context) : BaseAdapter() {

     override fun getCount(): Int {
          // 총 날짜 수 반환
          return 31
     }

     override fun getItem(position: Int): Any {
          // 해당 날짜의 정보 반환
          return "예약 가능" // 예시로 "예약 가능" 문자열 반환
     }

     override fun getItemId(position: Int): Long {
          return position.toLong()
     }

     override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
          // 각 날짜의 표시를 구현하는 부분
          // 예약 가능/불가능한 날짜에 따라 적절한 뷰 반환
          // 여기서는 예시로 간단한 TextView 반환
          val textView = TextView(context)
          textView.text = getItem(position) as String
          return textView
     }
}

