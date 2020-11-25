import java.util.Random;
public class Text {
    String []excersices = new String[50];
    Random random = new Random();
    public String produceAddexercise(){                  //生成加法算式
        int left_random = (int)random.nextInt(101);
        int right_random = (int)random.nextInt(101);
        return left_random + "" + "+" + "" + right_random + "=";
    }
    public String produceSubstactexercise(){               //生成减法算式
        int left_random = (int)random.nextInt(101);
        int right_random = (int)random.nextInt(101);
        return left_random + "" + "-" + "" + right_random + "=";
    }

    public void produceExercises () {                    //生成习题
        for (int i = 0; i < 50; i++) {
            int number = (int) (Math.random() * 100);
            if(number >= 50){
                excersices[i] = produceAddexercise();
            }
            else{
                excersices[i] = produceSubstactexercise();
            }
        }
    }
    public void outputExercises(){                       //输出习题
        for(int i = 0;i < 50; i++){
            System.out.print("" + (i+1) + ":\t");
            System.out.print(excersices[i]+'\t'+'\t');
        }
    }

    public static void main(String[] args) {
        Text input=new Text();
        input.produceExercises();
        input.outputExercises();
    }
}
