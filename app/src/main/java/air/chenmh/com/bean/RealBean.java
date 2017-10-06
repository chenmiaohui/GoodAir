package air.chenmh.com.bean;

/**
 * 实时数据的bean
 * Created by 陈苗辉 on 2017/5/11.
 */
public class RealBean {


    /**
     * message : 成功
     * data : {"regionCode":"410100000","aqiLevel":2,"so2":20,"coIAQI":0,"no2IAQI":45,"o3":61,"aqiLevelType":"良","regionName":"郑州市","pm10IAQI":97,"o3IAQI":19,"monitorTime":"2017-05-11 10:00:00","pollutant":"颗粒物(PM10)","co":0.986,"so2IAQI":6,"no2":91,"aqi":97,"pm10":144,"compositeValue":6.76,"pm25":51,"pm25IAQI":70}
     * code : 1111
     * type : 1
     */
    private String message;
    private DataEntity data;
    private String code;
    private String type;

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(DataEntity data) {
        this.data = data;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public DataEntity getData() {
        return data;
    }

    public String getCode() {
        return code;
    }

    public String getType() {
        return type;
    }

    public class DataEntity {
        /**
         * regionCode : 410100000
         * aqiLevel : 2
         * so2 : 20
         * coIAQI : 0
         * no2IAQI : 45
         * o3 : 61
         * aqiLevelType : 良
         * regionName : 郑州市
         * pm10IAQI : 97
         * o3IAQI : 19
         * monitorTime : 2017-05-11 10:00:00
         * pollutant : 颗粒物(PM10)
         * co : 0.986
         * so2IAQI : 6
         * no2 : 91
         * aqi : 97
         * pm10 : 144
         * compositeValue : 6.76
         * pm25 : 51
         * pm25IAQI : 70
         */
        private String regionCode;
        private int aqiLevel;
        private int so2;
        private int coIAQI;
        private int no2IAQI;
        private int o3;
        private String aqiLevelType;
        private String regionName;
        private int pm10IAQI;
        private int o3IAQI;
        private String monitorTime;
        private String pollutant;
        private double co;
        private int so2IAQI;
        private int no2;
        private int aqi;
        private int pm10;
        private double compositeValue;
        private int pm25;
        private int pm25IAQI;

        public void setRegionCode(String regionCode) {
            this.regionCode = regionCode;
        }

        public void setAqiLevel(int aqiLevel) {
            this.aqiLevel = aqiLevel;
        }

        public void setSo2(int so2) {
            this.so2 = so2;
        }

        public void setCoIAQI(int coIAQI) {
            this.coIAQI = coIAQI;
        }

        public void setNo2IAQI(int no2IAQI) {
            this.no2IAQI = no2IAQI;
        }

        public void setO3(int o3) {
            this.o3 = o3;
        }

        public void setAqiLevelType(String aqiLevelType) {
            this.aqiLevelType = aqiLevelType;
        }

        public void setRegionName(String regionName) {
            this.regionName = regionName;
        }

        public void setPm10IAQI(int pm10IAQI) {
            this.pm10IAQI = pm10IAQI;
        }

        public void setO3IAQI(int o3IAQI) {
            this.o3IAQI = o3IAQI;
        }

        public void setMonitorTime(String monitorTime) {
            this.monitorTime = monitorTime;
        }

        public void setPollutant(String pollutant) {
            this.pollutant = pollutant;
        }

        public void setCo(double co) {
            this.co = co;
        }

        public void setSo2IAQI(int so2IAQI) {
            this.so2IAQI = so2IAQI;
        }

        public void setNo2(int no2) {
            this.no2 = no2;
        }

        public void setAqi(int aqi) {
            this.aqi = aqi;
        }

        public void setPm10(int pm10) {
            this.pm10 = pm10;
        }

        public void setCompositeValue(double compositeValue) {
            this.compositeValue = compositeValue;
        }

        public void setPm25(int pm25) {
            this.pm25 = pm25;
        }

        public void setPm25IAQI(int pm25IAQI) {
            this.pm25IAQI = pm25IAQI;
        }

        public String getRegionCode() {
            return regionCode;
        }

        public int getAqiLevel() {
            return aqiLevel;
        }

        public int getSo2() {
            return so2;
        }

        public int getCoIAQI() {
            return coIAQI;
        }

        public int getNo2IAQI() {
            return no2IAQI;
        }

        public int getO3() {
            return o3;
        }

        public String getAqiLevelType() {
            return aqiLevelType;
        }

        public String getRegionName() {
            return regionName;
        }

        public int getPm10IAQI() {
            return pm10IAQI;
        }

        public int getO3IAQI() {
            return o3IAQI;
        }

        public String getMonitorTime() {
            return monitorTime;
        }

        public String getPollutant() {
            return pollutant;
        }

        public double getCo() {
            return co;
        }

        public int getSo2IAQI() {
            return so2IAQI;
        }

        public int getNo2() {
            return no2;
        }

        public int getAqi() {
            return aqi;
        }

        public int getPm10() {
            return pm10;
        }

        public double getCompositeValue() {
            return compositeValue;
        }

        public int getPm25() {
            return pm25;
        }

        public int getPm25IAQI() {
            return pm25IAQI;
        }
    }
}
