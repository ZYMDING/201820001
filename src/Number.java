public class Number {
    public static void main(String[] args) {
        int arr[][]=new int [42][42];
        int number=1;
        for(int i=0;i<=41;i++){
            if(i%2==0){
                for(int h=i,k=0;h>=0;h--,k++){
                    arr[h][k]=number++;
                }
            }
            else{
                for(int h=0,k=i;k>=0;h++,k--)
                    arr[h][k]=number++;
            }
        }
        System.out.println("第 20 行第 20 列的数是"+arr[19][19]);
    }
}