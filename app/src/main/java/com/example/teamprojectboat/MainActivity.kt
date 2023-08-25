package com.example.teamprojectboat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.magnifier
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.teamprojectboat.ui.theme.TeamProjectBoatTheme
import kotlinx.coroutines.launch
import android.widget.GridView
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            TeamProjectBoatTheme {
                val calendarAdapter = CalendarAdapter(this)
                val navController = rememberNavController()
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavHost(navController = navController, startDestination = "DrawerHeader") {
                        composable("DrawerHeader") { DrawerHeader() }
                        composable("friendslist") { DrawrBody() }
                        composable("secondlist") { CalendarItem(day = 0) }
                        composable("thridlist") { CalendarGrid() }
                    }
                    }
                }

            }
        }
    }


@Composable
fun DrawerHeader() {
    Column() {
        var showDialog by remember { mutableStateOf(false) }
        Box(modifier = Modifier.fillMaxSize()) {

            Button(
                onClick = { showDialog = !showDialog }, modifier = Modifier.align(
                    Alignment.Center
                )
            ) {
                Text("예약사항 확인 해주세요")
            }
        }
        if (showDialog) {
            Dialog(onDismissRequest = { showDialog = false }) {
                Box(
                    Modifier
                        .clip(RectangleShape)
                        .fillMaxWidth()
                ) {
                    Column() {
                        Row(
                            Modifier
                                .fillMaxWidth()
                                .background(Color.White)
                                .padding(start = 8.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "1", color = Color.White
                            )
                        }
                        Row(
                            Modifier
                                .fillMaxWidth()
                                .background(Color.Blue)
                                .padding(start = 8.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "2", color = Color.White
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun DrawrBody() {
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(start = 8.dp),
    ) {
        Box() {
            Row {
                Text(
                    text = "시설물 예약하기\n" + "예약을 원하는 시설 아이콘을 클릭하세요",
                    modifier = Modifier.height(60.dp)
                )
            }
        }
        Box() {                              /// 메뉴창 시설물
            Row(
                modifier = Modifier.width(IntrinsicSize.Max),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "체육관,강당")
                }
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "잔디 운동장")
                }
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "교실")
                }
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "도서관")
                }

                Box() {
                    Row {
//Image(painter = , contentDescription = )
                    }
                }
            }
        }
    }
}

@Composable
fun CalendarItem(day: Int) {
    Box(
        modifier = Modifier
            .padding(4.dp)
            .background(Color.Gray)
            .size(60.dp)
            .clickable { /* 아이템을 클릭했을 때 처리할 로직 */ },
        contentAlignment = Alignment.Center
    ) {
        Text(text = day.toString(), color = Color.White)
    }
}

@Composable
fun CalendarGrid() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(7), // 7열로 그리드 아이템 배치 (한 주에 7일)
        modifier = Modifier.fillMaxSize()
    ) {
        // 이 부분은 각 주에 해당하는 그리드 아이템을 생성하게 됩니다.
        items(items = (1..31).toList().chunked(7)) { weekDays ->
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                for (day in weekDays) {
                    CalendarItem(day)
                }
            }
        }
    }
}





@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TeamProjectBoatTheme {
        DrawerHeader()
        DrawrBody()
        CalendarGrid()
    }
}