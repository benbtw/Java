public class Bricks {
    public String[][] map =
    {{"-","-","-","-","-"},
        {"-","-","-","-","-"},
        {"-","-","-","-","-"},
        {"-","-","-","-","-"},
        {"-","-","-","-","-"}};
    public Bricks() {
        for(int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++)
                System.out.print(map[i][j]);

            System.out.println();
        }
    }
}
