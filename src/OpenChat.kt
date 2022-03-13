
class OpenChat {
    fun solution(record: Array<String>): Array<String> {
        val users = HashSet<User>()
        val messages = mutableListOf<Message>()
        for (row in record) {
            val user = User.of(row, users)
            users.add(user)
            if (user.action != Action.Change)
                messages.add(Message(user, user.action))
        }

        return messages
            .map { it.text!! }
            .toTypedArray()
    }
}

data class Message(
    val user: User,
    val action: Action
) {
    var text: String? = null
        get() = when (action) {
            Action.Enter -> "${user.name}님이 들어왔습니다."
            Action.Leave -> "${user.name}님이 나갔습니다."
            Action.Change -> null
        }
}

class User(
    var action: Action,
    val id: String,
    var name: String,
) {
    companion object {
        fun of(row: String, users: HashSet<User>): User {
            val split = row.split(" ")
            val action = Action.valueOf(split[0])
            val uid = split[1]

            return when (action) {
                Action.Enter -> {
                    val user = getUserOrNull(users, uid)

                    if (user == null) {
                        User(
                            action = action,
                            id = uid,
                            name = split[2],
                        )
                    } else {
                        changeStatus(user, action, split[2])
                        return user
                    }
                }
                Action.Change -> {
                    return getUserOrNull(users, uid).also { changeStatus(it, action, split[2]) }!!
                }
                Action.Leave -> {
                    return getUserOrNull(users, uid).also { changeStatus(it, action) }!!
                }
            }
        }

        private fun changeStatus(user: User?, action: Action, name: String? = null) {
            user?.action = action
            name?.let { user?.name = it }
        }

        private fun getUserOrNull(users: HashSet<User>, uid: String) =
            users.find { it.id == uid }
    }
}

enum class Action {
    Enter, Leave, Change;

}

fun main() {
    val openChat = OpenChat()
    val solution = openChat.solution(
        arrayOf(
            "Enter uid1234 Muzi",
            "Enter uid4567 Prodo",
            "Leave uid1234",
            "Enter uid1234 Prodo",
            "Change uid4567 Ryan"
        )
    )
    for (s in solution) {
        println(s)
    }
}
