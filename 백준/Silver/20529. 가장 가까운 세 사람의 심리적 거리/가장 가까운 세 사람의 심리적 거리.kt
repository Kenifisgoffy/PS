fun main() = with(System.`in`.bufferedReader()) {

    // mbti 거리재는 메서드
    fun dist(s1: String, s2: String): Int{
        var count = 0
        for (i in 0 until 4) {
            if (s1[i] != s2[i]) count++
        }
        return count
    }

    var t = readLine().toInt()
    while (t-- > 0) {
        val n = readLine().toInt()
        val mbti = readLine().split(" ")
        
        // 무조건 같은 MBTI가 3개가 생기는 경우
        if (n > 16*16) {
            println(0)
            continue
        }

        var min = Int.MAX_VALUE
        for (i in 0..<n-2) {
            for (j in i+1..<n-1) {
                for (l in j + 1..<n) {
                    min = Math.min(min, dist(mbti[i], mbti[j]) + dist(mbti[i], mbti[l]) + dist(mbti[j], mbti[l]))
                }
            }
        }
        println(min)
    }
}
