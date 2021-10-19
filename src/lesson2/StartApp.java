package lesson2;

public class StartApp {


    public static void main(String[] args) throws MyArrayDataException, MyArraySizeException {
    String[][] mass = new String[][]{{"1", "2", "3", "4"}, {"5", "6", "7", "8"}, {"9", "0", "10", "11"}, {"12", "13", "14", "15"}};
        System.out.println(massLength(mass));
        try {
            int sum = massData(mass);
            System.out.println(sum);
        } catch (MyArrayDataException e) {
        }

//    System.out.println("Sum = " + massData(mass));
    }

    public static String massLength(String[][] mass) throws MyArraySizeException {

            for (int i = 0; i <mass.length; i++){
                if (mass[i].length != 4) {
                    throw new MyArraySizeException();
                }
            }
        return "Mass ok";
    }

    public static int massData(String[][] mass) throws MyArrayDataException {
        int sum = 0;
        for (int i = 0; i < mass.length; i++) {
            for (int j = 0; j < mass[i].length; j++) {
                try {
                    sum = sum + Integer.parseInt(mass[i][j]);
//                    System.out.println(mass[i][j]);
                } catch (NumberFormatException e) {
                    System.out.println("Cause: " + e.getMessage());
                    System.out.println("In: \n x = " + (i + 1) + "\n y = " + (j + 1));  // +1 Это по координатной сетке
                    throw new MyArrayDataException(i,j);
                }
            }
        }return sum;
    }























    static void doExceptionCatch(){
        causeNumberFormatException();
    }
    static void causeNumberFormatException(){
//    System.out.println(parseInt("1e"));



    }





    static int parseInt(String value){
        try {
            return Integer.parseInt(value);
        }catch (NumberFormatException e){
            System.out.println("Cause: " + e.getMessage());
        }
        return 0;
    }
}
