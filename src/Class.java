import java.io.*;
public class Class {
    String[] sNo=new String[10];
    String[] name=new String[10];
    double[][]grade =new double[5][3];
    double[] sum=new double[5];
    public static void main (String[] args)throws IOException{
        Class s =new Class();
        s.input();
        s.output();
    }
    void input() throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        boolean ir =true;
        while(ir) {
            try {
                for(int i=0;i<5;i++) {
                    System.out.print("请输入第"+(i+1)+"个学生的学号：");
                    sNo[i]=br.readLine();
                    System.out.print("请输入第"+(i+1)+"个学生姓名：");
                    name[i]=br.readLine();
                    for(int j=0;j<3;j++) {
                        System.out.print("请输入第"+(j+1)+"科成绩：");
                        grade[i][j]=Integer.parseInt(br.readLine());
                    }
                    System.out.println();
                    sum[i]=grade[i][0]+grade[i][1]+grade[i][2];
                }
                ir=false;
            }catch(NumberFormatException e) {
                System.out.println("请输入一个数字");
            }
        }
    }

    void output()throws IOException {
        FileWriter fw =new FileWriter("D://stud.txt");
        BufferedWriter bw=new BufferedWriter(fw);
        bw.write("学号 "+"姓名 "+"成绩 "+"成绩 "+"成绩 "+"平均成绩");
        bw.newLine();
        for(int i=0;i<5;i++) {
            bw.write(sNo[i]);
            bw.write(" "+name[i]);
            for(int j=0;j<3;j++) {
                bw.write(" "+grade[i][j]);
            }
            bw.write(" "+(sum[i]/3));
            bw.newLine();

        }
        bw.close();
    }
}
