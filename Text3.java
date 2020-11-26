import java.util.Random;
import java.util.Scanner;

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
    public int[] produceRandomExercise(){
        int symbol = (int)random.nextInt(2);
        if(symbol == 0){
            return produceAddexercise();
        }else {
            return  produceSubstactexercise();
        }
    }
    public Text3(){

    }
    public int[][] produceExercises () {              //生成习题
        int[] array = new int[3];
        for (int i = 0; i < 50; i++) {
            if (i == 0) {
                excercises[i] = produceRandomExercise();
            } else {
                for (int j = 0; j < i; j++) {
                    array = produceRandomExercise();
                    while (check(array, excercises[j])) {
                        array = produceRandomExercise();
                    }
                    excercises[j] = array;
                }
            }
        }
        return excercises;
    }

        //程序生成没有重复算式的习题
    public static boolean check(int[] a,int[] b) {

        if (((a[0] == b[0]) && a[1] == b[1]) && (a[2] == b[2])) {
            return true;
        } else if ((a[0] == b[1]) && (a[1] == b[0]) && (a[2] == 1) && (b[2] == 1)) {
            return true;
        } else {
            return false;
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
    public void produceResult(){                         //输出答案
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
        Text3 text3 = new Text3() ;
        text3.produceExercises();
        System.out.println("输入1输出习题，输入2输出答案，其他命令为无效指令");
        Scanner text = new Scanner(System.in);
        int order = text.nextInt();
        while(order == 1 || order == 2){
            if(order == 1){
                text3.outputExercises();
            }
            else if(order == 2){
                text3.produceResult();
            }
            else {
                System.out.println("输入指令无效");
            }
            order = text.nextInt();
        }

    }
}
