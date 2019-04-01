package com.levy.search.geohash;

public class GeoHashDemo {

    private static final  double EARTH_RADIUS = 6371000;//赤道半径(单位m)

    /**
     * 转化为弧度(rad)
     * */
    private static double rad(double d)
    {
        return d * Math.PI / 180.0;
    }


    public static double GetDistance(double lon1,double lat1,double lon2, double lat2)
    {
        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);
        double a = radLat1 - radLat2;
        double b = rad(lon1) - rad(lon2);
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a/2),2)+Math.cos(radLat1)*Math.cos(radLat2)*Math.pow(Math.sin(b/2),2)));
        s = s * EARTH_RADIUS;
        s = Math.round(s * 10000) / 10000;
        return s;
    }

    public static void main(String []args){
        double lon1=109.0145193757;
        double lat1=34.236080797698;
        double lon2=108.9644583556;
        double lat2=34.286439088548;
        double dist;
        String geocode;

        dist= GetDistance(lon1, lat1, lon2, lat2);
        System.out.println("两点相距：" + dist + " 米");


        GeoHashGenerator generator = new GeoHashGenerator();
        generator.sethashLength(4);
        geocode= generator.getGeoHashBase32(lat1, lon1);
        System.out.println("当前位置编码：" + geocode);
        for (String str : generator.getGeoHashBase32For9(lat1, lon1)) {
            System.out.println("当前九宫格位置编码："+str);
        }

        geocode= generator.getGeoHashBase32(lat2, lon2);
        System.out.println("远方位置编码：" + geocode);

    }
}
