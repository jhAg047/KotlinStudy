package he.dev.kotlinstudy

import he.dev.kotlinstudy.data.User
import io.ktor.client.call.body
import io.ktor.client.request.get

object UserRepo {
    suspend fun fetchUsers(): List<User> {
        val url = "https://615075ada706cd00179b745c.mockapi.io/users"
        // 아까 싱글톤으로 만든 객체 KtorClient에 접근하여 그 안에 있는 httpClient에 접근
        return KtorClient.httpClient.get(url).body()
    }


}