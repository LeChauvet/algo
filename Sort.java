import java.util.Arrays;

class Sort {
    public void merge(int[] a, int p, int q, int r) {
        int[] tmp = new int[r-p+1];
        int i = p, j = q+1, k = 0;
        while(i <= q && j <= r) {
            if(a[i] < a[j]) {
                tmp[k++] = a[i++];
            } else {
                tmp[k++] = a[j++];
            }
        }
        while(i <= q) {
            tmp[k++] = a[i++];
        }
        while(j <= r) {
            tmp[k++] = a[j++];
        }
        // 将tmp中的数组拷贝回a[p...r]
        for (i = 0; i <= r-p; ++i) {
            a[p+i] = tmp[i];
        }
    }

    public void mergeSortInternal(int[] A, int p, int r) {
        if(p >= r) {
            return;
        }
        int q = (p + r) / 2;
        mergeSortInternal(A, p, q);
        mergeSortInternal(A, q + 1, r);
        merge(A, p, q, r);
    }

    public void mergeSort(int[] A) {
        mergeSortInternal(A, 0, A.length - 1);
    }

    public void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    public int partition(int[] A, int p, int r) {
        int pivot = A[r];
        int i = p;
        for (int j = p; j < r; j++) {
            if(A[j] < pivot) {
                swap(A, i, j);
                i++;
            }
        }
        swap(A, i, r);
        return i;
    }

    public void quickSortInternal(int[] A, int p, int r) {
        if(p>=r) return;
        int q = partition(A, p, r);
        quickSortInternal(A, p, q - 1);
        quickSortInternal(A, q + 1, r);
    }

    public void quickSort(int[] A) {
        quickSortInternal(A, 0, A.length - 1);
    }

    public void insertSort(int[] A) {
        int n = A.length;
        for (int i = 0; i < n-1; i++) {
            int j=i+1;
            int tmp = A[j];
            while(j>0 && tmp < A[j-1]) {
                A[j] = A[j-1];
                j--;
            }
            A[j] = tmp;
        }
    }

    public void bubbleSort(int[] A) {
        int n = A.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                if(A[i] > A[j]) {
                    swap(A, i, j);
                }
            }
        }
    }

    public void selectSort(int[] A) {
        int n = A.length;
        for (int i = 0; i < n-1; i++) {
            int min = Integer.MAX_VALUE;
            int k = -1;
            for (int j = i; j < n; j++) {
                if(A[j] < min) {
                    min = A[j];
                    k = j;
                }
            }
            swap(A, i, k);
        }
    }

    public static void main(String[] args) {
        int[] a = {2, 5, 7, 1, 3, 4, 8, 9};
        Sort sort = new Sort();

        // 归并排序，归并排序是一个稳定的排序算法。 
        // sort.mergeSort(a);

        // 快速排序，快速排序并不是一个稳定的排序算法。
        // sort.quickSort(a);

        // 插入排序，插入排序是稳定的排序算法
        // sort.insertSort(a);

        // 冒泡排序，冒泡排序是稳定的排序算法
        // sort.bubbleSort(a);

        // 选择排序，选择排序是一种不稳定的排序算法
        sort.selectSort(a);

        System.out.println(Arrays.toString(a));
    }
}
