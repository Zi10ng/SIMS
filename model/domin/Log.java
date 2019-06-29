package model.domin;

import java.util.Date;

/**
 * 日志内容： xx时间 xx 登录/查询/删除了？成绩
 * @author 王石博
 * @date 2019年6月6日11:22:04
 */
public class Log {

    private String date;
    private String name;
    private String operate;

    public Log(String date, String name, String operate) {
        this.date = date;
        this.name = name;
        this.operate = operate;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOperate() {
        return operate;
    }

    public void setOperate(String operate) {
        this.operate = operate;
    }
}
