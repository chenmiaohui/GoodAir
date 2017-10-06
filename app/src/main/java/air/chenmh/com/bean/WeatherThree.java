package air.chenmh.com.bean;

/**
 * 温湿度json
 * Created by 陈苗辉 on 2017/5/19.
 */
public class WeatherThree {


    /**
     * message : 成功
     * data : {"createTime":"2017-05-19 07:45:34","regionCode":"410100000","updateTime":"2017-05-19 06:00","cityName":"郑州","windDirect":"东南风","areaId":"101180101","feelST":"22.7","temperature":"23.1","windSpeed":"1.5","phenomena":"多云","humidity":"70.0","windPower":"微风","airPressure":"997.0","rain":"0.0"}
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
         * createTime : 2017-05-19 07:45:34
         * regionCode : 410100000
         * updateTime : 2017-05-19 06:00
         * cityName : 郑州
         * windDirect : 东南风
         * areaId : 101180101
         * feelST : 22.7
         * temperature : 23.1
         * windSpeed : 1.5
         * phenomena : 多云
         * humidity : 70.0
         * windPower : 微风
         * airPressure : 997.0
         * rain : 0.0
         */
        private String createTime;
        private String regionCode;
        private String updateTime;
        private String cityName;
        private String windDirect;
        private String areaId;
        private String feelST;
        private String temperature;
        private String windSpeed;
        private String phenomena;
        private String humidity;
        private String windPower;
        private String airPressure;
        private String rain;

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public void setRegionCode(String regionCode) {
            this.regionCode = regionCode;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public void setCityName(String cityName) {
            this.cityName = cityName;
        }

        public void setWindDirect(String windDirect) {
            this.windDirect = windDirect;
        }

        public void setAreaId(String areaId) {
            this.areaId = areaId;
        }

        public void setFeelST(String feelST) {
            this.feelST = feelST;
        }

        public void setTemperature(String temperature) {
            this.temperature = temperature;
        }

        public void setWindSpeed(String windSpeed) {
            this.windSpeed = windSpeed;
        }

        public void setPhenomena(String phenomena) {
            this.phenomena = phenomena;
        }

        public void setHumidity(String humidity) {
            this.humidity = humidity;
        }

        public void setWindPower(String windPower) {
            this.windPower = windPower;
        }

        public void setAirPressure(String airPressure) {
            this.airPressure = airPressure;
        }

        public void setRain(String rain) {
            this.rain = rain;
        }

        public String getCreateTime() {
            return createTime;
        }

        public String getRegionCode() {
            return regionCode;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public String getCityName() {
            return cityName;
        }

        public String getWindDirect() {
            return windDirect;
        }

        public String getAreaId() {
            return areaId;
        }

        public String getFeelST() {
            return feelST;
        }

        public String getTemperature() {
            return temperature;
        }

        public String getWindSpeed() {
            return windSpeed;
        }

        public String getPhenomena() {
            return phenomena;
        }

        public String getHumidity() {
            return humidity;
        }

        public String getWindPower() {
            return windPower;
        }

        public String getAirPressure() {
            return airPressure;
        }

        public String getRain() {
            return rain;
        }
    }
}
