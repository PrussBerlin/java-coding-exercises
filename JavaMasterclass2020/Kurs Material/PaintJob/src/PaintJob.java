public class PaintJob {

    public static int getBucketCount(double width, double height, double areaPerBucket, int extraBuckets) {

        if(width <= 0 || height <= 0 || areaPerBucket <= 0 || extraBuckets < 0) {

            return -1;
        } else {
            double area = width * height;
            double bucketCount = Math.ceil(area/areaPerBucket);
            bucketCount -= extraBuckets;
            return (int) bucketCount;

        }
    }

    public static int getBucketCount(double width, double height, double areaPerBucket) {

        if(width <= 0 || height <= 0 || areaPerBucket <= 0) {

            return -1;
        } else {
            double area = width * height;
            double bucketCount = Math.ceil(area/areaPerBucket);
            return (int) bucketCount;
        }
    }

    public static int getBucketCount(double area, double areaPerBucket) {

        if (areaPerBucket <= 0 || area <= 0) {

            return -1;
        } else {

            double bucketCount = Math.ceil(area / areaPerBucket);
            return (int) bucketCount;
        }
    }


        public static void main(String[] args) {

        System.out.println(getBucketCount(3.4, 1.5));
    }
}
