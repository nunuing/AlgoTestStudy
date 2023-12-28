public class L278 {
    public int firstBadVersion(int n) {
        int str = 1;
        int end = n;
        int mid = 0;

        while(str < end){
            mid = str + (end - str) / 2;

            if(isBadVersion(mid)){
                end = mid;
            }
            else{
                str = mid + 1;
            }
        }

        return str;
    }

    private boolean isBadVersion(int mid) {
        return true;
    }
}
