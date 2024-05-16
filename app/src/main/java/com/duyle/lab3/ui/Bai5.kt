package com.duyle.lab3.ui

import android.graphics.drawable.PaintDrawable
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.duyle.lab3.R

class Bai5 : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = {
                            Text(text = "Home")

                        },
                        navigationIcon = {
                            IconButton(onClick = { }) {
                                Icon(Icons.Filled.Menu,"")
                            }
                        },
                        colors = TopAppBarDefaults.topAppBarColors(
                            containerColor = Color("#252121".toColorInt()),
                            titleContentColor = MaterialTheme.colorScheme.onPrimary,
                            navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
                            actionIconContentColor = MaterialTheme.colorScheme.onSecondary
                        )
                    )
                }, content = {
                    GetLayout("Trang chu", it)
                })
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun GetLayout(
    title: String = "Trang chu",
    innerPadding: PaddingValues = PaddingValues(0.dp)
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = Color("#363232".toColorInt()))
            .padding(
                top = innerPadding.calculateTopPadding() + 10.dp,
                start = 10.dp,
                end = 10.dp,
                bottom = 10.dp
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp),

    ) {
//        GetTextTitle(title, innerPadding)
        GetRowItem(color = Color("#EB8B33".toColorInt()), R.drawable.ic_logo_paypal, "Paypal")

        GetRowItem(color = Color("#D93485".toColorInt()), R.drawable.ic_logo_momo, "Momo")

        GetRowItem(color = Color("#57BFF7".toColorInt()), R.drawable.ic_logo_zalopay, "Zalo Pay")


    }
}

@Composable
private fun GetRowItem(color: Color, idRes: Int = R.drawable.ic_logo_momo, title: String = "Paypal") {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = color, shape = RoundedCornerShape(12.dp))
            .height(70.dp)
            .padding(5.dp),
        verticalAlignment = Alignment.CenterVertically

    ) {
        Image(
            painter = painterResource(id = idRes), contentDescription = "",
            modifier = Modifier.size(60.dp)
        )

        Text(
            text = title,
            modifier = Modifier
                .weight(1f)
                .padding(10.dp, 0.dp, 0.dp, 0.dp),
            color = Color.White,
            fontSize = 20.sp
        )

        RadioButton(selected = false, onClick = {

        })
    }
}

@Composable
private fun GetTextTitle(
    title: String = "Trang chu",
    innerPadding: PaddingValues = PaddingValues(0.dp)
) {
    Text(
        text = title,
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxWidth(),
        fontSize = 30.sp,
        color = Color.Red,
        textAlign = TextAlign.Center
    )
}