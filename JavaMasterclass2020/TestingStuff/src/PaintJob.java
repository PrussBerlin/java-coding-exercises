public class PaintJob {

    public static int getBucketCount(double width, double heigth, double areaPerBucket, int extraBuckets) {

        if(width <= 0 || heigth <= 0 || areaPerBucket <= 0 || extraBuckets < 0) {
            return -1;
        } else {
            double area = width * heigth;
            return (int) Math.ceil((area / areaPerBucket) - extraBuckets);
        }
    }

    public static int getBucketCount(double width, double heigth, double areaPerBucket) {
        if(width <= 0 || heigth <= 0 || areaPerBucket <= 0) {
            return -1;
        } else {
            double area = width * heigth;
            return (int) Math.ceil((area / areaPerBucket));

        }

    }

    public static int getBucketCount(double area, double areaPerBucket) {
        if(area <= 0 || areaPerBucket <= 0) {
            return -1;
        } else {
            return (int) Math.ceil((area / areaPerBucket));

        }
    }

    public static void main(String[] args) {
        
//        System.out.println(getBucketCount(7.25, 4.3, 2.25, 3));
    }
}