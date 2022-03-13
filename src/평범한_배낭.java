public class 평범한_배낭 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        final int STUFF_SIZE = sc.nextInt();
//        final int LIMIT_WEIGHT = sc.nextInt();

//        Stuff[] stuffs = new Stuff[STUFF_SIZE];
        Stuff[] stuffs = new Stuff[4];

//        for (int i=0; i<STUFF_SIZE; i++) {
//            int weight = sc.nextInt();
//            int value = sc.nextInt();
//
//            stuffs[i] = new Stuff(weight, value);
//        }

        stuffs[0] = new Stuff(6, 13);
        stuffs[1] = new Stuff(4, 8);
        stuffs[2] = new Stuff(4, 6);
        stuffs[3] = new Stuff(5, 12);

        Stuff.getBestValue(stuffs);
    }
}

class Bag {
    static int LIMIT_WEIGHT = 10;
}

class Stuff {
    private int weight;
    private int value;

    public Stuff(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

    public static void getBestValue(Stuff[] stuffs) {
        //가능한 조합을 만든다.
        //조합을 만들면서 Best 조합이 있다면 조합의 가치를 비교한다.
        //가치가 더 높고, 무게도 LIMIT보다 낮다면 Best 조합으로 변경한다.
        calculate(stuffs, 0);
    }

    private static int calculate(Stuff[] stuffs, int firstIndex) {
        int first = firstIndex;
        int second = first + 1;

        for (int i = first; i < stuffs.length; i++) {
            for (int j = second; j < stuffs.length; j++) {
                System.out.println(i + " " + j);
            }
        }
        System.out.println();


        if (second == stuffs.length)
            return 0;
        else
            return calculate(stuffs, second);
    }
}