import java.util.Random;
public class Text3 {
    int[][] excercises = new int[50][3];
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
        int[][] AddExercises = new int[50][3];
        int[][] SubstactExercises = new int[50][3];
        for (int i = 0; i < 50; i++) {
            int symbol = (int)random.nextInt(2);
            if(symbol == 0){
                excercises[i] = produceAddexercise();
            } else {
                excercises[i] = produceSubstactexercise();
            }
        }
        //程序生成没有重复算式的习题
        for(int i = 0; i < 50; i ++){
            if(excercises[i][2] == 0){
                AddExercises[i] = excercises[i];
            }
            else {
                SubstactExercises[i] = excercises[i];
            }
        }
        for(int i = 0; i < 50; i ++){
            for(int j = 1; j < 50; j ++){
                while(((AddExercises[i][0] == AddExercises[j][0]) && (AddExercises[i][1] == AddExercises[j][1])) || ((AddExercises[i][0] == AddExercises[j][1]) && (AddExercises[i][1] == AddExercises[j][0]))){
                    AddExercises[i] = produceAddexercise();
                }
                while((SubstactExercises[i][0] == SubstactExercises[j][0]) && (SubstactExercises[i][1] == SubstactExercises[j][1])){
                    SubstactExercises[i] = produceSubstactexercise();
                }
            }
        }
        for(int i = 0; i < 50; i ++){
            if(AddExercises[i] != null){
                excercises[i] = AddExercises[i];
            }else {
                excercises[i] = SubstactExercises[i];
            }
        }
    }

    public void outputExercises(){                       //输出习题
        for(int i = 0;i < 50; i++){
            System.out.print((i+1) + ":\t");
            if (excercises[i][2] == 0){
                System.out.print(String.format("%2d + %2d = ", excercises[i][0], excercises[i][1])+'\t'+'\t');
            }else {
                System.out.print(String.format("%2d - %2d = ", excercises[i][0], excercises[i][1])+'\t'+'\t');
            }
            if((i+1) % 5 == 0)
                System.out.println();
        }
    }
    public void produceResult(){                         //输出结果
        int []result = new int[50];
        for (int i = 0; i < 50; i++){
            if (excercises[i][2] == 0){
                result[i] = excercises[i][0]+excercises[i][1];
            }else {
                result[i] = excercises[i][0]-excercises[i][1];
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
