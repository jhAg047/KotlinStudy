package he.dev.kotlinstudy.layoutActivity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import he.dev.kotlinstudy.R
import he.dev.kotlinstudy.ui.theme.KotlinStudyTheme

class ArtActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent{
            KotlinStudyTheme {
                // 초기 화면 구성 함수
                ArtApp()
            }
        }
    }
}

@Preview
@Composable
fun ArtApp() {
    ComposeArtLayout(modifier = Modifier
        .fillMaxSize())
}

@Composable
fun ComposeArtLayout(modifier: Modifier = Modifier){
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = Color.White
    ) {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = modifier
                .fillMaxSize()
        ) {
            Image(
                painter = painterResource(R.drawable.lemon_tree),
                contentDescription = stringResource(R.string.lemon_tree),
                modifier = Modifier
                    .wrapContentSize()
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(text = stringResource(R.string.art_title))
                Text(text = stringResource(R.string.art_artist))
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Button(
                    onClick = { println() },
                    modifier = Modifier.weight(1f)
                ) {
                    Text(text = stringResource(R.string.pre))
                }
                Button(
                    onClick = { println() },
                    modifier = Modifier.weight(1f)
                ) {
                    Text(text = stringResource(R.string.next))
                }
            }
        }
    }
}

