public class 문자열압축 {
    public static void main(String[] args) {
        StringCompression stringCompression = new StringCompression();
        stringCompression.solution("ababcdcdababcdcd");
    }
}

class StringCompression {

    public void solution(String s) {
        int result = 0;
        String firstHalf = s.substring(0, s.length()/2);
        String lastHalf = s.substring(s.length()/2, s.length());

        if (firstHalf.equals(lastHalf)) {
            result = ("2"+firstHalf).length();
        }


    }
}