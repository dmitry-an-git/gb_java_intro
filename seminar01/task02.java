package gb_java_intro.seminar01;

import javax.xml.transform.Templates;

// Дан массив nums = [1,3,2,4,3,5,3,3] и число val = 3. 
// Если в массиве есть числа, равные заданному, нужно перенести эти элементы в конец массива. 
// Таким образом, первые несколько (или все) элементов массива должны быть отличны от заданного, 
// а остальные - равны ему.
// решить нужно без использования дополнительного массива, а только перестановкой элементов.
// [1,2,4,5,3,3,3,3]

public class task02 {
    public static void main(String[] args) {
        int[] arr = new int[] {1,3,2,4,3,5,3,3,2};
        int val = 3;

        for (int i = 0; i < arr.length-1; i++) {
            
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] == val) {
                    arr[i] = arr[j];
                    arr[j] = val;
                }
            }
        }

        for (int item : arr) {
            System.out.printf("%d, ", item);
        }
            
        
    }

}

// faster !!!
// int [] arr = new int[]{1,3,3,2,4,3,5,3,3};
//         int val = 3;
//         int count = 0;

//         for (int i = 0; i < arr.length; i++)
//             if (arr[i] != 3) {
//                 arr[count++] = arr[i];
//             }
        
//         while (count < arr.length)
//             arr[count++] = 3;
//         for (int i : arr) {
//             System.out.println(i);
//         }