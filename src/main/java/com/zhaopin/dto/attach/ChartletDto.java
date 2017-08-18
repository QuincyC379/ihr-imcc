package com.zhaopin.dto.attach;

/**
 * 自定义消息:贴图表情(type=3)
 * Created by SYJ on 2017/5/18.
 */
public class ChartletDto {

    private String catalog;//贴图所在文件夹的名称
    private String chartlet;//贴图文件的名称

    public String getCatalog() {
        return catalog;
    }

    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }

    public String getChartlet() {
        return chartlet;
    }

    public void setChartlet(String chartlet) {
        this.chartlet = chartlet;
    }

    @Override
    public String toString() {
        return "ChartletDto{" +
                "catalog='" + catalog + '\'' +
                ", chartlet='" + chartlet + '\'' +
                '}';
    }
}
