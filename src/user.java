import java.util.Scanner;
public class user {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        float score= in.nextFloat();           //输入一个成绩
        if(score>=0 && score<=100){
            if(score>=0 && score<60){
                System.out.println("不及格");   //【0-60）为不及格
            }
            else if(score>=60 && score<70){
                System.out.println("及格");    //【60-70）为及格
            }
            else if(score>=70 && score<80){
                System.out.println("中等");    //【70-80）为中等
            }
            else if(score>=80 && score<90){
                System.out.println("良好");    //【80-90）为良好
            }
            else {
                System.out.println("优秀");    //【90-100】为优秀
            }
        }
        else {
            System.out.println("输入成绩无效");     //输入成绩不在0-100之间无效
        }
    }

}
