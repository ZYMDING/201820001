import java.util.Random;
public class Text2 {
    int[][] excersices = new int[50][3];
    Random random = new Random();
    public int[] produceAddexercise(){                   //生成加法算式
        int []AddExercise =new int[3];
        AddExercise[2] = 0;
        do {
            AddExercise[0] = (int)random.nextInt(101);
            AddExercise[1] = (int)random.nextInt(101);
        } while (AddExercise[0] + AddExercise[1] > 100);
        return AddExercise;
    }
    public int[] produceSubstactexercise(){               //生成减法算式
        int []SubstactExercise = new int[3];
        SubstactExercise[2] = 1;
        do {
            SubstactExercise[0] = (int)random.nextInt(101);
            SubstactExercise[1] = (int)random.nextInt(101);
        } while (SubstactExercise[0] - SubstactExercise[1] < 0);
        return SubstactExercise;
    }

    public void produceExercises () {              //生成习题
        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            int number = (int)random.nextInt(2);
            if(number == 0){
                excersices[i] = produceAddexercise();
            } else {
                excersices[i] = produceSubstactexercise();
            }
        }
    }

    public void outputExercises(){                       //输出习题
        for(int i = 0;i < 50; i++){
            System.out.print((i+1) + ":\t");
            if (excersices[i][2] == 0){
                System.out.print(String.format("%2d + %2d = ", excersices[i][0], excersices[i][1])+'\t'+'\t');
            }else {
                System.out.print(String.format("%2d - %2d = ", excersices[i][0], excersices[i][1])+'\t'+'\t');
            }
            if((i+1) % 5 == 0)
                System.out.println();
        }
    }
    public void produceResult(){                         //输出结果
        int []result = new int[50];
        for (int i = 0; i < 50; i++){
            if (excersices[i][2] == 0){
                result[i] = excersices[i][0]+excersices[i][1];
            }else {
                result[i] = excersices[i][0]-excersices[i][1];
            }
        }
        for (int i = 0; i < 50; i ++){
            System.out.print(String.format("%2d : %3d ", (i + 1), result[i])+'\t'+'\t');
            if((i+1) % 5 == 0)
                System.out.println();
        }
    }

    public static void main(String[] args) {
        Text2 text2 = new Text2();
        text2.produceExercises();
        text2.outputExercises();
        text2.produceResult();
    }
}
