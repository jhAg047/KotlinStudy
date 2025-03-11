package he.dev.kotlinstudy.layoutActivity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import he.dev.kotlinstudy.ui.theme.KotlinStudyTheme

class NavigationLayoutActivity : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KotlinStudyTheme {
                NavigationGraph()
            }
        }
    }
}

// 네비게이션 라우트 이넘 (값을 가지는 이넘)
enum class NAV_ROUTE(val routeName: String, val description:String, val btnColor: Color){
    MAIN("MAIN","메인 화면",Color(0xFFF44336)),
    LOGIN("LOGIN","로그인 화면",Color(0xFF673AB7)),
    REGISTER("REGISTER","회원가입 화면",Color(0xFF4CAF50)),
    USER_PROFILE("USER_PROFILE","유저 프로필 화면",Color(0xFF03A9F4)),
    SETTING("SETTING","설정 화면",Color(0xFF283593))
}

// 네비게이션 라우트 액션 클래스
class RouteAction(navHostController: NavHostController){

    // 특정 라우트로 이동
    val navTo: (NAV_ROUTE) -> Unit = {route ->
        navHostController.navigate(route.routeName)
    }

    // 뒤로가기 이동
    val goBack: () -> Unit = {
        navHostController.navigateUp()
    }
}


@Composable
fun NavigationGraph(startRoute: NAV_ROUTE = NAV_ROUTE.MAIN){

    // 네비게이션 컨트롤러
    val navController = rememberNavController()

    // 네비게이션 라우트 액션
    val routeAction = remember(navController) { RouteAction(navController) }

    // NavHost로 네비게이션 결정
    // 네비게이션 연결할 요소들을 설정
    NavHost(navController, startRoute.routeName) {

        // 라우트 이름 = 화면의 키
        composable(NAV_ROUTE.MAIN.routeName) {
            // 화면 = 값
            MainScreen(routeAction = routeAction)
        }

        composable(NAV_ROUTE.REGISTER.routeName) {
            RegisterScreen(routeAction = routeAction)
        }

        composable(NAV_ROUTE.LOGIN.routeName) {
            LoginScreen(routeAction = routeAction)
        }

        composable(NAV_ROUTE.USER_PROFILE.routeName) {
            UserProfileScreen(routeAction = routeAction)
        }

        composable(NAV_ROUTE.SETTING.routeName) {
            SettingScreen(routeAction = routeAction)
        }

    }
}

// 메인화면
@Composable
fun MainScreen(routeAction: RouteAction) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(Modifier.padding(16.dp)) {
//            NavButton(route = NAV_ROUTE.MAIN, routeAction = routeAction)
            NavButton(route = NAV_ROUTE.LOGIN, routeAction = routeAction)
            NavButton(route = NAV_ROUTE.REGISTER, routeAction = routeAction)
            NavButton(route = NAV_ROUTE.USER_PROFILE, routeAction = routeAction)
            NavButton(route = NAV_ROUTE.SETTING, routeAction = routeAction)
        }
    }
}

// 로그인 화면
@Composable
fun LoginScreen(routeAction: RouteAction){
    Surface(Modifier.fillMaxSize()) {
        Box(Modifier.padding(8.dp), Alignment.Center) {
            Text(text = "로그인 화면",
                style = TextStyle(Color.Black, 22.sp, FontWeight.Medium))
            // 뒤로가기 버튼
            Button(onClick = {routeAction.goBack},
                modifier = Modifier
                    .padding(16.dp)
                    .offset(y=100.dp)) {
                Text("뒤로가기")
            }
        }
    }
}

// 회원가입 화면
@Composable
fun RegisterScreen(routeAction: RouteAction){
    Surface(Modifier.fillMaxSize()) {
        Box(Modifier.padding(8.dp), Alignment.Center) {
            Text(text = "회원가입 화면",
                style = TextStyle(Color.Black, 22.sp, FontWeight.Medium))
            // 뒤로가기 버튼
            Button(onClick = {routeAction.goBack},
                modifier = Modifier
                    .padding(16.dp)
                    .offset(y=100.dp)) {
                Text("뒤로가기")
            }
        }
    }
}

// 유저 프로필 화면
@Composable
fun UserProfileScreen(routeAction: RouteAction){
    Surface(Modifier.fillMaxSize()) {
        Box(Modifier.padding(8.dp), Alignment.Center) {
            Text(text = "유저 프로필 화면",
                style = TextStyle(Color.Black, 22.sp, FontWeight.Medium))
            // 뒤로가기 버튼
            Button(onClick = {routeAction.goBack},
                modifier = Modifier
                    .padding(16.dp)
                    .offset(y=100.dp)) {
                Text("뒤로가기")
            }
        }
    }
}

// 환경설정 화면
@Composable
fun SettingScreen(routeAction: RouteAction){
    Surface(Modifier.fillMaxSize()) {
        Box(Modifier.padding(8.dp), Alignment.Center) {
            Text(text = "환경설정 화면",
                style = TextStyle(Color.Black, 22.sp, FontWeight.Medium))
            // 뒤로가기 버튼
            Button(onClick = {routeAction.goBack},
                modifier = Modifier
                    .padding(16.dp)
                    .offset(y=100.dp)) {
                Text("뒤로가기")
            }
        }
    }
}

// Column에 있는 네비게이션 버튼
@Composable
fun ColumnScope.NavButton(route:NAV_ROUTE,routeAction: RouteAction){
    Button(onClick = {
        routeAction.navTo(route)
    }, colors = ButtonDefaults.buttonColors(containerColor = route.btnColor),
        modifier = Modifier.weight(1f).padding(8.dp).fillMaxSize()) {
        Text(text = route.description,
            style = TextStyle(Color.White, 22.sp, FontWeight.Medium)
        )
    }
}