package air.chenmh.com.bean;

/**
 * 登录的bean
 * Created by 陈苗辉 on 2017/4/25.
 */
public class LoginBean {


    /**
     * message : 成功
     * data : {"theme":"isDefault","uri":"views/server/frame/index.html"}
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
         * theme : isDefault
         * uri : views/server/frame/index.html
         */
        private String theme;
        private String uri;

        public void setTheme(String theme) {
            this.theme = theme;
        }

        public void setUri(String uri) {
            this.uri = uri;
        }

        public String getTheme() {
            return theme;
        }

        public String getUri() {
            return uri;
        }
    }
}
