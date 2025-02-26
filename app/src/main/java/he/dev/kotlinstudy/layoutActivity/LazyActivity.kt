package he.dev.kotlinstudy.layoutActivity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class LazyActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyComposeUI()
        }
    }
}

@Composable
fun MyComposeUI() {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("LazyColumn with Cards", style = MaterialTheme.typography.headlineMedium)
        LazyColumnExample()
        Spacer(modifier = Modifier.height(16.dp))
        Text("LazyRow with Circular Items", style = MaterialTheme.typography.headlineMedium)
        LazyRowExample()
        Spacer(modifier = Modifier.height(16.dp))
        Text("Box with Nested Layout", style = MaterialTheme.typography.headlineMedium)
        BoxExample()
    }
}

@Composable
fun LazyColumnExample() {
    LazyColumn(modifier = Modifier.height(300.dp)) {
        items((1..10).toList()) { item ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                colors = CardDefaults.cardColors(containerColor = Color.LightGray)
            ) {
                Row(
                    modifier = Modifier.padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .background(Color.Blue)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Item $item")
                }
            }
        }
    }
}

@Composable
fun LazyRowExample() {
    LazyRow(modifier = Modifier.height(120.dp)) {
        items((1..10).toList()) { item ->
            Box(
                modifier = Modifier
                    .size(80.dp)
                    .padding(8.dp)
                    .background(Color.Cyan),
                contentAlignment = Alignment.Center
            ) {
                Text("$item", color = Color.White)
            }
        }
    }
}

@Composable
fun BoxExample() {
    Box(
        modifier = Modifier
            .size(200.dp)
            .background(Color.Magenta),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text("Centered Text", color = Color.White)
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = {}) {
                Text("Click Me")
            }
        }
    }
}
